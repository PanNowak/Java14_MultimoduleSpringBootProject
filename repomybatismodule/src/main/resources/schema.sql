drop table if exists EMPLOYEES;

create table employees
(
    ID         numeric primary key auto_increment,
    FIRST_NAME varchar,
    LAST_NAME  varchar,
    STREET     varchar,
    CITY       varchar
);
