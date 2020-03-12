-- 初始化TABLE
DROP TABLE IF EXISTS book;

CREATE TABLE book (
  bookid serial PRIMARY KEY ,
  name varchar(255) DEFAULT NULL,
  author varchar(255) DEFAULT NULL
);
