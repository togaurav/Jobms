DELIMITER $$
DROP PROCEDURE IF EXISTS `proc_job_price_compute` $$
CREATE
    PROCEDURE `proc_job_price_compute`(IN jobname VARCHAR(30),OUT price DECIMAL(4,2))

    BEGIN
	DECLARE	jobstd_price		DECIMAL(4,2) DEFAULT 0;
	DECLARE	careerarea_price	DECIMAL(4,2) DEFAULT 0;
	DECLARE	company_score		DECIMAL(4,2) DEFAULT 0;
	DECLARE	city_salary_score	DECIMAL(4,2) DEFAULT 0;
	DECLARE jobprice_jobname	DECIMAL(4,2) DEFAULT 0;
	DECLARE jobprice_servicelen	DECIMAL(4,2) DEFAULT 0;
	DECLARE jobprice_salary		DECIMAL(4,2) DEFAULT 0;
	DECLARE job_salary		INT;
	DECLARE service_len		INT;

	SELECT (CASE tca.tag 
			WHEN 'physical' THEN tc.price_physical 
			WHEN 'admin' THEN tc.price_admin 
			WHEN 'service' THEN tc.price_service 
			WHEN 'skill' THEN tc.price_skill 
			WHEN 'professional' THEN tc.price_professional 
			WHEN 'mechanical' THEN tc.price_mechanical 
			WHEN 'electronic' THEN tc.price_electronic 
			WHEN 'sale' THEN tc.price_sale ELSE 0 
			END) ,
	       (CASE tjr.job_service_len 
			WHEN 0 THEN tca.price_0 
			WHEN 1 THEN tca.price_1 
			WHEN 2 THEN tca.price_2 
			WHEN 3 THEN tca.price_3 
			WHEN 4 THEN tca.price_4 
			WHEN 5 THEN tca.price_5 
			WHEN 6 THEN tca.price_6 
			WHEN 8 THEN tca.price_8 
			WHEN 10 THEN tca.price_10 
			END),
		tjs.price,tjr.job_service_len,tcs.salary_score,tjr.job_salary 
		INTO company_score,city_salary_score,jobstd_price,service_len,city_salary_score,job_salary
	FROM  tb_jobrecord  tjr
	LEFT JOIN td_jobstd	tjs ON tjr.jobstd_id=tjs.jobstd_id
	LEFT JOIN tb_company tc ON tjr.company_id=tc.id
	LEFT JOIN td_careerarea tca ON tjr.careerarea_id=tca.id
	LEFT JOIN td_city_salary tcs ON tjr.city_id=tcs.id
	WHERE tjr.job_name=jobname;
	
	SET jobprice_jobname=jobstd_price*company_score;
	SET jobprice_servicelen=careerarea_price*company_score;
	SET jobprice_salary=job_salary/city_salary_score;
	
	IF jobprice_servicelen=0 AND jobprice_salary>0 THEN 
		SET price=0.4*jobprice_jobname+0.6*jobprice_salary;
	ELSEIF jobprice_servicelen>0 AND jobprice_salary=0 THEN 
		SET price=0.4*jobprice_jobname+0.6*jobprice_servicelen;
	ELSEIF jobprice_servicelen=0 AND jobprice_salary=0 THEN
		SET price=1*jobprice_jobname;
	ELSE 
		SET price=0.2*jobprice_jobname+ 0.4*jobprice_jobname+0.4*jobprice_servicelen;
	END IF;
	
    END$$
DELIMITER ;