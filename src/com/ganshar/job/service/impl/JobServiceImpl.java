package com.ganshar.job.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.job.dao.JobAbilityDao;
import com.ganshar.job.dao.JobDao;
import com.ganshar.job.dao.MajorAbilityDao;
import com.ganshar.job.model.Job;
import com.ganshar.job.model.JobAbility;
import com.ganshar.job.model.MajorAbility;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.JobService;
import com.ganshar.job.web.vo.JobVO;
import com.ganshar.resume.dao.UserWorkExpDao;

public class JobServiceImpl implements JobService {
	
	private JobDao jobDao;
	private JobAbilityDao jobAbilityDao;
	private MajorAbilityDao majorAbilityDao;
	private AbilityDao abilityDao;
	private UserWorkExpDao userWorkExpDao;
	
	public JobDao getJobDao() {
		return jobDao;
	}


	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}


	public UserWorkExpDao getUserWorkExpDao() {
		return userWorkExpDao;
	}


	public void setUserWorkExpDao(UserWorkExpDao userWorkExpDao) {
		this.userWorkExpDao = userWorkExpDao;
	}


	@Override
	public Job getJobById(Long jobId) {
		return this.jobDao.findJobById(jobId);
	}

	@Override
	public void addJob(JobVO jobvo) {
		Job job=new Job();
		BeanUtils.copyProperties(jobvo, job);
		job.setAddTime(new Date());
		job.setJobName(jobvo.getJobName_widget());
		job.setUpdateTime(new Date());
		job=this.jobDao.add(job);
		if(job.getJobId()>0){
			List<JobAbility> jobAbilityList=new ArrayList<JobAbility>();
			if(jobvo.getSkill_1_widget()!=null&&jobvo.getSkill_1_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_1_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_1()>0?jobvo.getSkillratio_1():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_2_widget()!=null&&jobvo.getSkill_2_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_2_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_2()>0?jobvo.getSkillratio_2():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_3_widget()!=null&&jobvo.getSkill_3_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_3_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_3()>0?jobvo.getSkillratio_3():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_4_widget()!=null&&jobvo.getSkill_4_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_4_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_4()>0?jobvo.getSkillratio_4():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_5_widget()!=null&&jobvo.getSkill_5_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_5_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_5()>0?jobvo.getSkillratio_5():0.2);
					jobAbilityList.add(ja);
				}
			}
			this.addJobAbility(jobAbilityList, job.getJobId());
		}
	}


	@Override
	public void updateJob(JobVO jobvo) {
		Job job=this.jobDao.findJobById(jobvo.getJobId());
		if(job!=null){
			jobvo.setAddTime(job.getAddTime());
			jobvo.setUpdateTime(new Date());
			BeanUtils.copyProperties(jobvo, job);
			if(jobvo.getJobNameNew()!=null&&jobvo.getJobNameNew().length()>1){
				job.setJobName(jobvo.getJobNameNew());
			}
			this.jobDao.update(job);
			List<JobAbility> jobAbilityList=new ArrayList<JobAbility>();
			if(jobvo.getSkill_1_widget()!=null&&jobvo.getSkill_1_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_1_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_1()>0?jobvo.getSkillratio_1():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_2_widget()!=null&&jobvo.getSkill_2_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_2_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_2()>0?jobvo.getSkillratio_2():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_3_widget()!=null&&jobvo.getSkill_3_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_3_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_3()>0?jobvo.getSkillratio_3():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_4_widget()!=null&&jobvo.getSkill_4_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_4_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_4()>0?jobvo.getSkillratio_4():0.2);
					jobAbilityList.add(ja);
				}
			}
			if(jobvo.getSkill_5_widget()!=null&&jobvo.getSkill_5_widget().trim().length()>0){
				JobAbility ja=new JobAbility();
				Ability ability=this.abilityDao.getAbilityByName(jobvo.getSkill_5_widget());
				if(ability!=null){
					ja.setAbilityId(ability.getId());
					ja.setJobId(job.getJobId());
					ja.setAbilityRatio(jobvo.getSkillratio_5()>0?jobvo.getSkillratio_5():0.2);
					jobAbilityList.add(ja);
				}
			}
			this.addJobAbility(jobAbilityList, job.getJobId());
		}
	}


	@Override
	public void deleteJob(Long jobId) {
		this.jobDao.delete(jobId);
	}


	@Override
	public List<JobAbility> findJobAbilityList(Long jobId) {
		return this.jobAbilityDao.findJobAbilityList(jobId);
	}


	@Override
	public List<Map> findJobAbilityMapList(Long jobId) {
		return this.jobAbilityDao.findJobAbilityMapList(jobId);
	}


	@Override
	public void addJobAbility(List<JobAbility> jobAbilityList,Long jobId) {
		if(jobAbilityList!=null&&jobAbilityList.size()>0){
			this.jobAbilityDao.deleteJobAbilitys(jobId);
			for(JobAbility jobAbility:jobAbilityList){
				this.jobAbilityDao.addJobAbility(jobAbility);
			}
		}
	}


	@Override
	public Job findJobByName(String jobName) {
		return this.jobDao.findJobByName(jobName);
	}


	@Override
	public JobVO findJobVOByName(String jobName) {
		Job job=this.jobDao.findJobByName(jobName);
		JobVO jobVO=new JobVO();
		if(job!=null){
			List<JobAbility> jobabilityList=this.jobAbilityDao.findJobAbilityList(job.getJobId());
			BeanUtils.copyProperties(job, jobVO);
			if(jobabilityList!=null&&jobabilityList.size()>0){
				JobAbility jobability=jobabilityList.get(0);
				Ability ability=this.abilityDao.getAbilityById(jobability.getAbilityId());
				if(ability!=null){
					jobVO.setSkill_1(ability.getName());
					jobVO.setSkillratio_1(jobability.getAbilityRatio());
				}
				if(jobabilityList.size()>1){
					jobability=jobabilityList.get(1);
					ability=this.abilityDao.getAbilityById(jobability.getAbilityId());
					if(ability!=null){
						jobVO.setSkill_2(ability.getName());
						jobVO.setSkillratio_2(jobability.getAbilityRatio());
					}
				}
				if(jobabilityList.size()>2){
					jobability=jobabilityList.get(2);
					ability=this.abilityDao.getAbilityById(jobability.getAbilityId());
					if(ability!=null){
						jobVO.setSkill_3(ability.getName());
						jobVO.setSkillratio_3(jobability.getAbilityRatio());
					}
				}
				if(jobabilityList.size()>3){
					jobability=jobabilityList.get(3);
					ability=this.abilityDao.getAbilityById(jobability.getAbilityId());
					if(ability!=null){
						jobVO.setSkill_4(ability.getName());
						jobVO.setSkillratio_4(jobability.getAbilityRatio());
					}
				}
				if(jobabilityList.size()>4){
					jobability=jobabilityList.get(4);
					ability=this.abilityDao.getAbilityById(jobability.getAbilityId());
					if(ability!=null){
						jobVO.setSkill_5(ability.getName());
						jobVO.setSkillratio_5(jobability.getAbilityRatio());
					}
				}
			}
		}
		return jobVO;
	}


	@Override
	public List<Job> findJobListByName(String jobName) {
		return this.jobDao.findJobListByName(jobName);
	}


	@Override
	public List<MajorAbility> findMajorAbilityList(Integer majorId) {
		return this.majorAbilityDao.getMajorAbilityList(majorId);
	}


	@Override
	public List<Map> findMajorAbilityMapList(Integer majorId) {
		return this.majorAbilityDao.findMajorAbilityMapList(majorId);
	}


	public JobAbilityDao getJobAbilityDao() {
		return jobAbilityDao;
	}


	public void setJobAbilityDao(JobAbilityDao jobAbilityDao) {
		this.jobAbilityDao = jobAbilityDao;
	}


	public MajorAbilityDao getMajorAbilityDao() {
		return majorAbilityDao;
	}


	public void setMajorAbilityDao(MajorAbilityDao majorAbilityDao) {
		this.majorAbilityDao = majorAbilityDao;
	}


	public AbilityDao getAbilityDao() {
		return abilityDao;
	}


	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}


	@Override
	public List<Opportunity> findRecommendOpps(Long userId) {
		List<Opportunity> result=new ArrayList<Opportunity>();
		String jobname=this.userWorkExpDao.findCurrJobnameByUserId(userId);
		if(jobname!=null){
			result=this.jobDao.findRecommendOpps(jobname);
		}
		return result;
	}
	
}
