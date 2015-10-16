drop schema schema2 if exists cascade;
create schema schema2;
create table schema2.name (id int not null, name varchar(50) not null);