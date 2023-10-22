

drop table if exists bartrip.bars;
drop table if exists bartrip.location_bar;
drop table if exists bartrip.location;
CREATE TABLE bartrip.bars
(
    id serial not null,
    name character varying(255) not null,
    description character varying(255) NULL,
    is_enable boolean NOT NULL default False,
    is_deleted boolean NOT NULL default false,
    name_location character varying(255) NULL,
    latitude double precision NOT null,
    longitude double precision NOT NULL,
    created_date timestamp without time zone NOT NULL,
    created_by character varying(255) NOT NULL,
    updated_date timestamp without time zone NOT NULL,
    updated_by character varying(255) NOT NULL,
    CONSTRAINT bars_unique UNIQUE(id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA bartrip TO bartrip_user;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA bartrip TO bartrip_user;
