
--数据库第四阶段设计
--车辆出场主和车辆入场可以直接连成一个表，users中卡号做主键
--已经是第五次，第六次更改了
--已经是第七次更改了 
--第八次
--第九次  级联操作
--用户信息表   
--数据库的小更改

 
--1、password改为string
--
--2、时间改为datetime
--3、parkid改为默认递增
create table users
(  
	cardid int primary key ,
	name nvarchar(20) not null,
	password nvarchar(20),
	cardtype nvarchar(20),
	userstype nvarchar(20),
	carid int,
	tel int,
	overage int
)




--车位信息表
create table sit_infor
(  
	stationid int primary key,
	stationtype nvarchar(20) not null
)



--停车卡收费表
create table charger
(  
	cardtype nvarchar(6),
	stationtype nvarchar(20) not null,
	charge int,
	primary key (cardtype,stationtype)
)



--park
create table park
(
	cardid int foreign key references users(cardid),	
	stationid int foreign key references sit_infor(stationid),
	parkid int primary key identity(1,1),
	startpark datetime,
	stationtype nvarchar(20),
	endpark datetime,
	sumpark int,
	fee int
)	
