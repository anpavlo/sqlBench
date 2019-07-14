drop table if exists test_table1;
drop sequence if exists test_table1_id_seq;

create sequence test_table1_id_seq;
create table test_table1(
  id int not null primary key default nextval('test_table1_id_seq'),
  login varchar(255) not null,
  password varchar(255)
);