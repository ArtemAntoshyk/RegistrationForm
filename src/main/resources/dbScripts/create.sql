create database accounts;

create table users(
                       id serial primary key ,
                       name varchar,
                       age int,
                       email varchar,
                       password varchar(32) not null

);

