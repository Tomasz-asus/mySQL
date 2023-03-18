drop table if exists motorcycle;
drop table if exists motorcycle_seq;

create table motorcycle (
                      id bigint not null,
                      name varchar(255),
                      producent varchar(255),
                      type varchar(255),
                      primary key (id)
) engine=InnoDB;

create table motorcycle_seq (
    next_val bigint
) engine=InnoDB;

insert into motorcycle_seq values ( 1 );
