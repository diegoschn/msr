CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table entrega(
    id uuid DEFAULT uuid_generate_v4(),
    cliente_id UUID,
    taxa decimal(10,2) not null,
    status_entrega varchar(20) not null,
    data_pedido timestamp not null,
    data_finalizacao timestamp,
    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(255) not null,
    destinatario_numero varchar(30) not null,
    destinatario_complemento varchar(60),
    destinatario_bairro varchar(30) not null,
    PRIMARY KEY (id)
);

alter table entrega
   add constraint FK_ENTREGA_REFERENCE_CLIENTE foreign key (cliente_id)
      references cliente (id)
      on delete restrict on update restrict;