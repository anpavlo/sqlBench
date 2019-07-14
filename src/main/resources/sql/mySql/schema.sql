drop table if exists test_table;
create table test_table1(
  id int not null auto_increment,
  login varchar(255),
  password varchar(255),
  PRIMARY KEY (`id`)
);