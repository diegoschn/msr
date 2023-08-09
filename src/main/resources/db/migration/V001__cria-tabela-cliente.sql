CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table cliente(
	id uuid DEFAULT uuid_generate_v4(),
	nome varchar(60) not null,
	email varchar(60) not null,
	telefone varchar(11),

	primary key (id)
);