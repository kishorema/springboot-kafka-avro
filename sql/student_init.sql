create database student_db;

create table public.student
(
    id          varchar(36) not null
        constraint student_id_pk
            primary key,
    roll_number integer     not null,
    first_name  varchar(50) not null,
    last_name   varchar(50) not null,
    class_name  varchar(50) not null
);

alter table public.student
    owner to postgres;

create table public.contact
(
    email_id      varchar(50) not null,
    mobile_number varchar(10) not null,
    contact_id    varchar(36) not null
        constraint contact_id_pk
            primary key
        constraint contact_student_id_fk
            references public.student,
    constraint contact_uk
        unique (mobile_number, email_id)
);

alter table public.contact
    owner to postgres;

create table public.score
(
    score_id varchar(36) not null
        constraint score_student_id_fk
            references public.student,
    subject  varchar(25) not null,
    marks    integer     not null,
    constraint score_uk
        unique (score_id, subject, marks)
);

alter table public.score
    owner to postgres;

