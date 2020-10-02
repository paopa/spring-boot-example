drop table if exists test;
create table if not exists test
(
    id   serial not null,
    name text,
    age int
);