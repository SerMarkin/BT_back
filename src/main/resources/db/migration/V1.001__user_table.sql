create schema if not exists bartrip;

drop table if exists bartrip.users;
CREATE TABLE bartrip.users
(
    id serial not null,
    name character varying(255) null,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    status character varying(255) NOT NULL,
    created_date timestamp without time zone NOT NULL,
    created_by character varying(255) NOT NULL,
    updated_date timestamp without time zone NOT NULL,
    updated_by character varying(255) NOT NULL,
    CONSTRAINT users_unique UNIQUE(email)
);