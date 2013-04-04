package com.ganshar.ability.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;

public class AbilityDaoImpl extends GenericDaoImpl<Ability,Long> implements AbilityDao {

	@Override
	public Ability getAbilityById(Long abilityId) {
		return this.findById(abilityId);
	}

	@Override
	public List<Ability> findAbilityList() {
		String hql="from Ability";
		return this.findByHql(hql, new Object[]{});
	}

	@Override
	public List<Ability> findAbilityListByName(String abilityName) {
		String hql="from Ability where name like ?";
		List<Ability> result=this.findByHql(hql, new String[]{"%"+abilityName+"%"});
		return result;
	}

	@Override
	public Ability getAbilityByName(String abilityName) {
		Ability ability=null;
		String hql="from Ability where name= ?";
		List<Ability> result=this.findByHql(hql, new String[]{abilityName});
		if(result!=null&&result.size()>0){
			ability=result.get(0);
		}
		
		return ability;
	}

	@Override
	public List<Ability> findFirstLevelAbilitys() {
		String hql="from Ability where substring(path,3,8)='000000'";
		List<Ability> result=this.findByHql(hql, new String[]{});
		return result;
	}

	@Override
	public List<Ability> findSecondLevelAbilitys(String path) {
		String hql="from Ability where substring(path,1,2)=? and substring(path,3,8)<>'000000' and substring(path,5,8)='0000'";
		List<Ability> result=this.findByHql(hql, new String[]{path.substring(0, 2)});
		return result;
	}

	@Override
	public List<Ability> findThirdLevelAbilitys(String path) {
		String hql="from Ability where substring(path,1,4)=? and  substring(path,5,8)<>'0000' and substring(path,7,8)='00'";
		List<Ability> result=this.findByHql(hql, new String[]{path.substring(0, 4)});
		return result;
	}

	@Override
	public List<Ability> findForthLevelAbilitys(String path) {
		String hql="from Ability where substring(path,1,6)=? and  substring(path,7,8)<>'00' ";
		List<Ability> result=this.findByHql(hql, new String[]{path.substring(0, 6)});
		return result;
	}

	@Override
	public void addAbility(String abilityname, String parentPath, Integer level) {
		if(level==1){
			Integer maxid=1;
			String hql="select max(substring(path,1,2)+0) from Ability";
			List result=this.findByHql(hql, new Object[]{});
			if(result!=null&&result.size()>0){
				Integer obj=(Integer)result.get(0);
				maxid+=obj;
			}
			Ability ability=new Ability();
			ability.setName(abilityname);
			ability.setPath(maxid+"000000");
			this.saveEntity(ability);
		}else if(level==2){
			Integer maxid=1;
			String hql="select max(substring(path,1,4)+0) from Ability where substring(path,1,2)=?";
			List result=this.findByHql(hql, new Object[]{parentPath.substring(0,2)});
			if(result!=null&&result.size()>0){
				if(result.get(0)!=null){
					Integer obj=(Integer)result.get(0);
					maxid+=obj;
				}
			}
			Ability ability=new Ability();
			ability.setName(abilityname);
			ability.setPath(maxid+"0000");
			this.saveEntity(ability);
		}else if(level==3){
			Integer maxid=1;
			String hql="select max(substring(path,1,6)+0) from Ability where substring(path,1,4)=?";
			List result=this.findByHql(hql, new Object[]{parentPath.substring(0,4)});
			if(result!=null&&result.size()>0){
				if(result.get(0)!=null){
					Integer obj=(Integer)result.get(0);
					maxid+=obj;
				}
			}
			Ability ability=new Ability();
			ability.setName(abilityname);
			ability.setPath(maxid+"00");
			this.saveEntity(ability);
		}else if(level==4){
			Integer maxid=1;
			String hql="select max(substring(path,1,8)+0) from Ability where substring(path,1,6)=?";
			List result=this.findByHql(hql, new Object[]{parentPath.substring(0,6)});
			if(result!=null&&result.size()>0){
				if(result.get(0)!=null){
					Integer obj=(Integer)result.get(0);
					maxid+=obj;
				}
			}
			Ability ability=new Ability();
			ability.setName(abilityname);
			ability.setPath(maxid+"");
			this.saveEntity(ability);
		}
	}

	@Override
	public void deleteAbility(String path) {
		String hql="from Ability where path= ?";
		List<Ability> result=this.findByHql(hql, new String[]{path});
		if(result!=null&&result.size()>0){
			Ability ability=result.get(0);
			if(ability!=null)
				this.delete(ability);
		}
	}

}
