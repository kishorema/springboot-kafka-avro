create table public.contact
(
    email_id      varchar(50) not null,
    mobile_number varchar(10) not null,
    id            integer     not null
        constraint contact_id_pk
            primary key,
    constraint contact_uk
        unique (mobile_number, email_id)
);

alter table public.contact
    owner to postgres;

create table public.student
(
    id          varchar(36) not null
        constraint student_id_pk
            primary key,
    roll_number integer     not null,
    first_name  varchar(50) not null,
    last_name   varchar(50) not null,
    class_name  varchar(50) not null,
    contact_id  integer     not null
        constraint student_contact_id_fk
            references public.contact
);

alter table public.student
    owner to postgres;

create table public.score
(
    id         integer     not null
        constraint score_id_pk
            primary key,
    student_id varchar(36) not null
        constraint score_student_id_fk
            references public.student,
    subject    varchar(25) not null,
    marks      integer     not null,
    constraint score_uk
        unique (student_id, subject, marks)
);

alter table public.score
    owner to postgres;


create sequence public.score_seq as integer;
create sequence public.contact_seq as integer;


