package com.diegoschneider.msr.model;

import com.diegoschneider.msr.model.enums.StatusEntrega;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private BigDecimal taxa;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;

    @Embedded
    private Destinatario destinatario;

    @ManyToOne
    private Cliente cliente;
}
