/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012-12-15 12:01:52                          */
/*==============================================================*/


drop table if exists tb_company;

drop table if exists tb_jobrecord;

drop table if exists tb_user_experience;

drop table if exists tb_user_forJob;

drop table if exists td_careerarea;

drop table if exists td_careerarea_correl;

drop table if exists td_city_salary;

drop table if exists td_educate_score;

drop table if exists td_jobstd;

drop table if exists td_jobstd_correl;

drop table if exists td_major_careerarea;

drop table if exists td_school_score;

/*==============================================================*/
/* Table: tb_company                                            */
/*==============================================================*/
create table tb_company
(
   id                   int(20) not null,
   name                 varchar(50),
   staffnum             int(6),
   type                 varchar(20),
   url                  varchar(100),
   contact              varchar(20),
   phone                varchar(30),
   field                varchar(50),
   field_id             int(4),
   city_name            varchar(20),
   city_id              int(4),
   price_physical       decimal(4,2),
   price_admin          decimal(4,2),
   price_service        decimal(4,2),
   price_skill          decimal(4,2),
   price_professional   decimal(4,2),
   price_mechanical     decimal(4,2),
   price_electronic     decimal(4,2),
   price_sale           decimal(4,2),
   primary key (id)
);

alter table tb_company comment '公司信息表';

/*==============================================================*/
/* Table: tb_jobrecord                                          */
/*==============================================================*/
create table tb_jobrecord
(
   job_id               int(20) not null,
   job_name             varchar(30),
   jobstd_id            int(10),
   careerarea_id        int(4),
   company_id           int(20),
   city_id              int(10),
   job_service_len      int(4),
   job_salary           int(8),
   price                decimal(4,2),
   primary key (job_id)
);

alter table tb_jobrecord comment '职位信息表';

/*==============================================================*/
/* Table: tb_user_experience                                    */
/*==============================================================*/
create table tb_user_experience
(
   id                   int(20) not null,
   user_id              int(20),
   job_name             varchar(30),
   jobstd_id            int(10),
   careerarea_id        int(4),
   service_len          int(2),
   job_salary           int(8),
   company_name         varchar(50),
   company_id           int(20),
   onduty_date          date,
   leave_date           date,
   is_last_job          int(2),
   primary key (id)
);

alter table tb_user_experience comment '个人工作经历表';

/*==============================================================*/
/* Table: tb_user_forJob                                        */
/*==============================================================*/
create table tb_user_forJob
(
   user_id              int(20) not null,
   user_name            varchar(40),
   user_age             int(2),
   user_gender          varchar(4),
   school_name          varchar(30),
   school_id            int(10),
   top_education        varchar(10),
   top_education_id     int(4),
   top_major            varchar(30),
   top_major_id         int(10),
   service_len          int(4),
   last_job             varchar(30),
   last_job_id          int(20),
   last_jobstd_id       int(10),
   last_careerarea_id   int(4),
   last_job_salary      int(8),
   last_job_company     varchar(50),
   last_job_company_id  int(20),
   price                decimal(4,2),
   primary key (user_id)
);

alter table tb_user_forJob comment '个人求职表';

/*==============================================================*/
/* Table: td_careerarea                                         */
/*==============================================================*/
create table td_careerarea
(
   id                   int(4) not null,
   name                 varchar(30),
   tag                  varchar(10),
   price_0              decimal(4,2),
   price_1              decimal(4,2),
   price_2              decimal(4,2),
   price_3              decimal(4,2),
   price_4              decimal(4,2),
   price_5              decimal(4,2),
   price_6              decimal(4,2),
   price_8              decimal(4,2),
   price_10             decimal(4,2),
   primary key (id)
);

alter table td_careerarea comment '职业领域表';

/*==============================================================*/
/* Table: td_careerarea_correl                                  */
/*==============================================================*/
create table td_careerarea_correl
(
   id                   int(10) not null,
   cur_careerarea_id    int(4),
   tar_careerarea_id    int(4),
   correl_0             char(10),
   correl_1             decimal(4,2),
   correl_2             decimal(4,2),
   correl_3             decimal(4,2),
   correl_4             decimal(4,2),
   correl_5             decimal(4,2),
   correl_6             decimal(4,2),
   correl_8             decimal(4,2),
   correl_10            decimal(4,2),
   primary key (id)
);

alter table td_careerarea_correl comment '职业领域相关度表';

/*==============================================================*/
/* Table: td_city_salary                                        */
/*==============================================================*/
create table td_city_salary
(
   id                   int(4) not null,
   area_name            varchar(30),
   salary_score         decimal(5,2) comment '地区标准工资与职业层级比值',
   primary key (id)
);

alter table td_city_salary comment '地区工资系数表';

/*==============================================================*/
/* Table: td_educate_score                                      */
/*==============================================================*/
create table td_educate_score
(
   id                   int(4) not null,
   education_name       varchar(10),
   score                decimal(4,2),
   primary key (id)
);

alter table td_educate_score comment '学历系数表';

/*==============================================================*/
/* Table: td_jobstd                                             */
/*==============================================================*/
create table td_jobstd
(
   jobstd_id            int(10) not null,
   jobstd_name          varchar(30),
   careerarea_id        int(4),
   price                decimal(4,2),
   primary key (jobstd_id)
);

alter table td_jobstd comment '标准职位表';

/*==============================================================*/
/* Table: td_jobstd_correl                                      */
/*==============================================================*/
create table td_jobstd_correl
(
   id                   int(20),
   careerarea_id        int(4),
   cur_jobstd_name      varchar(30),
   cur_jobstd_id        char(10),
   tar_jobstd_name      varchar(30),
   tar_jobstd_id        int(10),
   correl               decimal(4,2)
);

alter table td_jobstd_correl comment '标准职位相关度表';

/*==============================================================*/
/* Table: td_major_careerarea                                   */
/*==============================================================*/
create table td_major_careerarea
(
   id                   int(4) not null,
   mjor_name            varchar(30),
   careerarea_id        int(4),
   primary key (id)
);

alter table td_major_careerarea comment '专业与职业领域关联表';

/*==============================================================*/
/* Table: td_school_score                                       */
/*==============================================================*/
create table td_school_score
(
   id                   int(10) not null,
   school_name          varchar(50),
   school_level         varchar(10),
   score                decimal(4,2),
   primary key (id)
);

alter table td_school_score comment '学校系数表';

