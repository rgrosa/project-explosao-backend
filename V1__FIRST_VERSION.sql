create table IF NOT EXISTS USERS (
    ID              bigint generated by default as identity,
    USERNAME        varchar(128),
    PASSWORD        varchar(128)
);


insert into USERS(ID, USERNAME, PASSWORD) values (1,'admin','dc80cd536dbc129e1bd12d76dfbe0d994bbd18c8a0445e4f');


create table IF NOT EXISTS CLASSROOM (
    ID                    bigint generated by default as identity,
    CLASSROOM_NAME        varchar(128),
    WEEK_DAY              integer,
    CLASSROOM_TIME        varchar(32),
    PROFESSOR_NAME        varchar(128),
    UPDATED_AT            date
);

create table IF NOT EXISTS STUDENT (
    ID                      bigint generated by default as identity,
    NAME                    varchar(128),
    PHONE_LIST              varchar(128),
    GUARDIAN_NAME           varchar(128),
    GUARDIAN_SIGNATURE      binary large object,
    CPF                     varchar(32),
    REGISTRATION            varchar(32),
    BIRTHDAY                date,
    UPDATED_AT              date
);

create table IF NOT EXISTS STUDENT_CLASSROOM (
    ID                      bigint generated by default as identity,
    CLASSROOM_ID            bigint,
    STUDENT_ID              bigint,
    STATUS                  boolean,
    LAST_PAYMENT_ID         bigint,
    UPDATED_AT              date
);

create table IF NOT EXISTS PAYMENT (
    ID                      bigint generated by default as identity,
    STUDENT_CLASSROOM_ID    bigint,
    PAYMENT_VALUE                   double precision,
    PAYMENT_AT              date,
    UPDATED_AT              date
);