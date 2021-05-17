create database BigDataDB;
set hive.cli.print.current.db=true;
create table input (subject1 String, subject2 String, subject3 String, subject4 String) ROW FORMAT DELIMITED FIELDS TERMINATED BY ' ';
LOAD DATA LOCAL INPATH 'input.txt' INTO TABLE input;
select * from input;
