package com.diegoschneider.msr.model;

import com.diegoschneider.msr.model.enums.StatusEntrega;
import com.diegoschneider.msr.validation.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
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

    @NotNull
    private BigDecimal taxa;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;

    @Embedded
    @Valid
    @NotNull
    private Destinatario destinatario;

    @Valid
    @NotNull
    @ManyToOne
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    private Cliente cliente;
}
