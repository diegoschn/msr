CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table users(
	id uuid DEFAULT uuid_generate_v4(),
	login TEXT not null unique,
	password TEXT not null,
	role smallint not null,

	primary key (id)
);