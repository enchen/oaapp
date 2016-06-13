--oa数据库初始化脚本

--创建数据库用户
create user oa with password 'oapass'
--创建数据库
create database oa WITH ENCODING='UTF8'  owner=oa

--使用数据库
use testdb
--创建表
create table test(
test_id integer  PRIMARY KEY,
name varchar(120) not null  ,
number int4 not null,
start_time timestamp not null ,
end_time timestamp not null ,
create_time timestamp not null default current_timestamp 
)

--设置起始自增id值
--方法1：绑定序列 select setval('testdb_testdb_id_seq',1000,false);
--方法2：创建独立序列
create sequence test_test_id_seq increment by 1  minvalue 1000  no maxvalue start with 1000;     
--将序列绑定到属性
alter table test alter column test_id set default nextval('test_test_id_seq');

--创建用户表
create table users
(
id integer primary key,--用户id
name varchar(20),--用户名
role_id integer,--角色id
pass varchar(20) default '123',--密码
is_admin integer default 0--管理员位
);
--为自增user表id创建序列
create sequence user_id_seq increment by 1  minvalue 1000  no maxvalue start with 1000;  
--将序列绑定到指定位置
alter table users alter column id set default nextval('user_id_seq');


--创建项目表
create table project
(
project_id integer primary key,--工程id
project_name varchar(40),--工程名
start_time timestamp,--项目开始时间
plan_end_time timestamp,--项目计划完成时间
end_time timestamp,--计划完成时间
project_content varchar(400),--项目说明
state integer,--项目状态 0：进行中，1：完成，2：暂停，3:冻结，4重新打开
create_time timestamp default current_timestamp--项目创建时间
);

--为自增project表project_id创建序列
create sequence project_project_id_seq increment by 1  minvalue 1000  no maxvalue start with 1000;  
--将序列绑定到指定位置
alter table project alter column project_id set default nextval('project_project_id_seq');



--创建检查点表
create table check_point
(
project_id integer,--项目id
describle varchar(120),--检查点描述，预期
plan_end_time timestamp,--预期完成时间
state integer--检查点状态0：正常，1：完成，2：暂停，3：冻结
)

--创建任务表
create table task
(
task_id integer primary key,--任务id
project_id integer,--项目id
user_id integer,--当前任务用户id
task_name varchar(100),
task_content varchar(400),
plan_end_time timestamp,--预期完成时间
end_time timestamp,--实际完成时间
plan_use_time integer,--预期花费时间
use_time integer,--实际花费时间
create_time timestamp default current_timestamp,--任务创建时间
state integer--任务状态
);
create sequence task_task_id_seq increment by 1 minvalue 1000 no maxvalue start with 1000;
alter table task alter column task_id set default nextval('task_task_id_seq');



--创建项目人员表
create table project_person
(
project_id integer,--项目id
user_id integer,--人员id
create_time timestamp default current_timestamp,--创建时间
position integer--项目职位
)


--创建新闻表
create table news
(
from_user integer,--行为主体 UserId
to_user integer,--接受方
news_id integer,--项目或者任务id
operate integer,--操作0新建，1完成，2重新打开，3提交评估，4挂起/暂停，5冻结
news_content varchar(100),--项目或者任务名称
type integer,--类型0,项目，1任务
create_time timestamp default current_timestamp--创建时间
)


--补充修改
--task表结构修改，增加名字，内容字段
--alter table task add task_name varchar(100);
--alter table task add task_content varchar(400);
