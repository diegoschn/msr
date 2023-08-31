package com.diegoschneider.msr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private UUID id;
    private String nome;
    private String telefone;
    private String email;

    public ClienteDto(String nome){
        this.nome = nome;
    }
}
