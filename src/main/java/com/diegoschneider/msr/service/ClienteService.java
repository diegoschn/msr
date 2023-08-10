package com.diegoschneider.msr.service;

import com.diegoschneider.msr.model.Cliente;

import java.util.List;
import java.util.UUID;


public interface ClienteService {

    Cliente create(Cliente cliente);

    Cliente findById(UUID id);

    Cliente update(Cliente cliente, UUID id);

    void remove(UUID clienteId);

    List<Cliente> findByNome(String nome);

    List<Cliente> findAll();
}
