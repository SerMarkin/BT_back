create schema if not exists bartrip;
GRANT USAGE ON SCHEMA bartrip TO bartrip_user;


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

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA bartrip TO bartrip_user;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA bartrip TO bartrip_user;