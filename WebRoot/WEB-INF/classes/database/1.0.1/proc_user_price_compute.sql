DELIMITER $$
DROP PROCEDURE IF EXISTS `proc_user_price_compute` $$
CREATE
    PROCEDURE `proc_user_price_compute`(IN userid INT,IN tar_careerarea_name VARCHAR(30),OUT price DECIMAL(4,2))

    BEGIN
	DECLARE	top_careerarea_price	DECIMAL(4,2) DEFAULT 0;
	DECLARE service_len		INT;
	DECLARE tar_careerarea_id	INT;
	DECLARE top_careerarea_id	INT;	
	DECLARE school_score		DECIMAL(4,2) DEFAULT 0;
	DECLARE educate_score		DECIMAL(4,2) DEFAULT 0;
	DECLARE top_careerarea_correl	DECIMAL(4,2) DEFAULT 0;
	DECLARE last_jobname		VARCHAR(30);
	DECLARE last_job_price		DECIMAL(4,2) DEFAULT 0;	
	DECLARE user_servicelen_avg	DECIMAL(2,1) DEFAULT 0;
	DECLARE servicelen_avg_price	DECIMAL(4,2) DEFAULT 0;
	
	SELECT tuj.service_len,tuj.last_job INTO service_len,last_jobname
	FROM tb_user_forjob tuj	
	WHERE tuj.user_id=userid;
	
	SELECT tca.id INTO tar_careerarea_id
	FROM td_careerarea tca
	WHERE tca.name=tar_careerarea_name;
	
	IF service_len=0 THEN 
	
		SELECT tss.score,tes.score,tmc.careerarea_id,tca.price_0,tcac.correl_0 
 		INTO school_score,educate_score,top_careerarea_id,top_careerarea_price,top_careerarea_correl
		FROM tb_user_forjob tuj 
		LEFT JOIN td_school_score tss ON tss.id=tuj.school_id
		LEFT JOIN td_educate_score tes ON tes.id=tuj.top_education_id
		LEFT JOIN td_major_careerarea tmc ON tmc.id=tuj.top_major_id
		LEFT JOIN td_careerarea tca ON tca.id=tuj.last_careerarea_id
		LEFT JOIN td_careerarea_correl tcac ON tcac.cur_careerarea_id=tmc.id
		WHERE tcac.tar_careerarea_id=tar_careerarea_id 
			AND  tuj.user_id=userid;
		
		SET price=top_careerarea_price*top_careerarea_correl*school_score*educate_score;
	ELSE
		
		CALL proc_job_price_compute(last_jobname,last_job_price);
		
		SELECT (CASE tmp.servicelen 
			WHEN 0 THEN SUM(tmp.servicelen*tcac.correl_0)
			WHEN 1 THEN SUM(tmp.servicelen*tcac.correl_1)
			WHEN 2 THEN SUM(tmp.servicelen*tcac.correl_2)
			WHEN 3 THEN SUM(tmp.servicelen*tcac.correl_3)
			WHEN 4 THEN SUM(tmp.servicelen*tcac.correl_4)
			WHEN 5 THEN SUM(tmp.servicelen*tcac.correl_5)
			WHEN 6 THEN SUM(tmp.servicelen*tcac.correl_6)
			WHEN 8 THEN SUM(tmp.servicelen*tcac.correl_8)
			WHEN 10 THEN SUM(tmp.servicelen*tcac.correl_10)			
			END) INTO user_servicelen_avg
		FROM 
		(SELECT SUM(tuex.service_len) servicelen,tuex.careerarea_id
		FROM tb_user_experience tuex
		WHERE tuex.user_id=userid
		GROUP BY tuex.careerarea_id) tmp,
		td_careerarea_correl tcac
		WHERE tmp.careerarea_id=tcac.cur_careerarea_id
		AND tcac.tar_careerarea_id=tar_careerarea_id;
		
		
		IF user_servicelen_avg=1 THEN
			SELECT price_1 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>1 AND user_servicelen_avg<2 THEN
			SELECT price_1+(price_2-price_1)*(user_servicelen_avg-1) INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=2 THEN
			SELECT price_2 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>2 AND user_servicelen_avg<3 THEN
			SELECT price_2+(price_3-price_2)*(user_servicelen_avg-2) INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=3 THEN
			SELECT price_3 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>3 AND user_servicelen_avg<4 THEN
			SELECT price_3+(price_4-price_3)*(user_servicelen_avg-3) INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=4 THEN
			SELECT price_4 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>4 AND user_servicelen_avg<5 THEN
			SELECT price_4+(price_5-price_4)*(user_servicelen_avg-4) INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=5 THEN
			SELECT price_5 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>5 AND user_servicelen_avg<6 THEN
			SELECT price_5+(price_6-price_5)*(user_servicelen_avg-5) INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=6 THEN
			SELECT price_6 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>6 AND user_servicelen_avg<8 THEN
			SELECT price_6+((price_8-price_6)*(user_servicelen_avg-6))/2 INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=8 THEN
			SELECT price_8 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF	user_servicelen_avg>8 AND user_servicelen_avg<10 THEN
			SELECT price_8+((price_10-price_8)*(user_servicelen_avg-8))/2 INTO servicelen_avg_price
			FROM td_careerarea WHERE id=tar_careerarea_id;
		ELSEIF user_servicelen_avg=10 THEN
			SELECT price_10 INTO servicelen_avg_price 
			FROM td_careerarea WHERE id=tar_careerarea_id;
			
		END IF;
		
		IF last_job_price=0 THEN
			SET price=servicelen_avg_price;
		ELSE
			SET price=0.6*last_job_price+0.4*servicelen_avg_price;
		END IF;
		
	END IF;
	
    END$$
DELIMITER ;