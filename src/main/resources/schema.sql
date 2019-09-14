create table user_details(
user_id varchar2(50) primary key,
password varchar2(50) not null,
name varchar2(50) default null,
city varchar2(50) default null,
email varchar2(50) default null,
phone_number varchar2(50) default null
);