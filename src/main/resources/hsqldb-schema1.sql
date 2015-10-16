drop schema schema1 if exists cascade;
create schema schema1;
create table schema1.name (id int not null, name varchar(50) not null);