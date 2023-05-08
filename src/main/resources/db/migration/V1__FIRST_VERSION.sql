create table IF NOT EXISTS USERS (
    ID              bigint generated by default as identity,
    USERNAME        varchar(128),
    PASSWORD        varchar(128)
);


insert into USERS(ID, USERNAME, PASSWORD) values (1,'admin','c110089b496ffcd8bcf1b55d469d0234676cb2f41d5768c4');


create table IF NOT EXISTS CLASSROOM (
    ID                    bigint generated by default as identity,
    CLASSROOM_NAME        varchar(128),
    WEEK_DAY              integer,
    CLASSROOM_TIME        varchar(8),
    CLASSROOM_END_TIME    varchar(8),
    PROFESSOR_NAME        varchar(128),
    STATUS                boolean,
    UPDATED_AT            date,
    INSERTED_AT           date
);

create table IF NOT EXISTS STUDENT (
    ID                      bigint generated by default as identity,
    NAME                    varchar(128),
    PHONE_NUMBER            varchar(32),
    GUARDIAN_PHONE_NUMBER   varchar(32),
    GUARDIAN_NAME           varchar(128),
    GUARDIAN_SIGNATURE      binary large object,
    CPF                     varchar(32),
    RG                      varchar(32),
    REGISTRATION            varchar(32),
    ADDRESS                 varchar(128),
    CITY                    varchar(128),
    NEIGHBORHOOD            varchar(128),
    STUDENT_NOTES           varchar(512),
    BIRTHDAY                date,
    UPDATED_AT              date,
    INSERTED_AT             date
);

create table IF NOT EXISTS STUDENT_CLASSROOM (
    ID                      bigint generated by default as identity,
    CLASSROOM_ID            bigint,
    STUDENT_ID              bigint,
    STATUS                  boolean,
    LAST_PAYMENT_ID         bigint,
    IS_PAYMENT_DUE          boolean,
    UPDATED_AT              date,
    INSERTED_AT             date
);

create table IF NOT EXISTS PAYMENT (
    ID                      bigint generated by default as identity,
    STUDENT_ID              bigint,
    PAYMENT_VALUE           double precision,
    MONTH_ID                bigint,
    PAYMENT_AT              date
);