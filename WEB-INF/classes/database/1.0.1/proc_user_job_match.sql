DELIMITER $$
DROP PROCEDURE IF EXISTS `proc_user_job_match` $$
CREATE
    PROCEDURE `proc_user_job_match`(IN userid INT,IN tar_job_name VARCHAR(30),OUT match_degree DECIMAL(4,2))

    BEGIN
	DECLARE	user_price		DECIMAL(4,2) DEFAULT 0;
	DECLARE tar_job_price		DECIMAL(4,2) DEFAULT 0;
	DECLARE last_jobstd_id		INT;
	DECLARE tar_jobstd_id		INT;
	DECLARE tar_jobstd_correl	DECIMAL(4,2) DEFAULT 0;
	DECLARE last_careerarea_id	INT;
	DECLARE tar_careerarea_id	INT;
	DECLARE tar_careerarea_name	VARCHAR(30);
	DECLARE tmp_match_degree		DECIMAL(4,2) DEFAULT 0;
	
	SELECT tj.jobstd_id,tj.careerarea_id,tj.price,tca.name
	INTO tar_jobstd_id,tar_careerarea_id,tar_job_price,tar_careerarea_name
	FROM tb_jobrecord tj
	LEFT JOIN td_careerarea tca ON tca.id=tj.careerarea_id 
	WHERE tj.job_name=tar_job_name;
	
	SELECT tuf.last_careerarea_id,tuf.last_jobstd_id
	INTO last_careerarea_id,last_jobstd_id
	FROM tb_user_forjob tuf
	WHERE tuf.user_id=userid;
	
	CALL proc_user_price_compute(userid,tar_careerarea_name,user_price);
	
	SET tmp_match_degree=1-ABS(user_price-tar_job_price)/tar_job_price;
	

	IF last_careerarea_id=tar_careerarea_id THEN 
		SELECT tjc.correl 
		INTO	tar_jobstd_correl
		FROM td_jobstd_correl tjc
		WHERE tjc.careerarea_id=last_careerarea_id
		AND tjc.cur_jobstd_id=last_jobstd_id
		AND tjc.tar_jobstd_id=tar_jobstd_id;
		
		SET match_degree=tmp_match_degree*tar_jobstd_correl;
	ELSE
		SET match_degree=tmp_match_degree;
	END IF;
	
	
    END$$
DELIMITER ;