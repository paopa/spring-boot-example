insert into test (name, age)
select ('david_'|| random()), random() from generate_series(1,10);