package com.ganshar.ability.model;

import java.util.Date;


/**
 * TbAbility entity. @author MyEclipse Persistence Tools
 */

public class Ability  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Long parentId;
     private Integer type;
     private Integer level;
     private String tag;
     private String abilityDesc;
     private Date addTime;
     private Date updateTime;


    // Constructors

    /** default constructor */
    public Ability() {
    }

	/** minimal constructor */
    public Ability(String name, Long parentId, Integer type, Integer level, Date addTime, Date updateTime) {
        this.name = name;
        this.parentId = parentId;
        this.type = type;
        this.level = level;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }
    
    /** full constructor */
    public Ability(String name, Long parentId, Integer type, Integer level, String tag, String abilityDesc, Date addTime, Date updateTime) {
        this.name = name;
        this.parentId = parentId;
        this.type = type;
        this.level = level;
        this.tag = tag;
        this.abilityDesc = abilityDesc;
        this.addTime = addTime;
        this.updateTime = updateTime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return this.parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return this.level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTag() {
        return this.tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAbilityDesc() {
        return this.abilityDesc;
    }
    
    public void setAbilityDesc(String abilityDesc) {
        this.abilityDesc = abilityDesc;
    }

    public Date getAddTime() {
        return this.addTime;
    }
    
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
   

}