--liquibase formatted sql

--changeset anton:create-notification-task

create table notification_task
(
     id      bigint generated by default as identity
           primary key,
       text    varchar(255),
       time    timestamp,
       user_id bigint
           constraint user_id_fk
               references users,
       number  bigint
);

create index notification_task_time_idx on notification_task(time);

alter table notification_task
    owner to "myUser";