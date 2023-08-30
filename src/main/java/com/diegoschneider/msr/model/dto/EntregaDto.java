package com.diegoschneider.msr.model.dto;

import com.diegoschneider.msr.model.enums.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
public class EntregaDto {

    private UUID id;
    private String nomeCliente;
    private DestinatarioDto destinatario;

    private BigDecimal taxa;
    private StatusEntrega statusEntrega;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
