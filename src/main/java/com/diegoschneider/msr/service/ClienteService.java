package com.diegoschneider.msr.service;

import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.model.dto.ClienteDto;

import java.util.List;
import java.util.UUID;


public interface ClienteService {

    ClienteDto create(Cliente cliente);

    ClienteDto findById(UUID id);

    ClienteDto update(Cliente cliente, UUID id);

    void remove(UUID clienteId);

    List<ClienteDto> findByNome(String nome);

    List<ClienteDto> findAll();
}
