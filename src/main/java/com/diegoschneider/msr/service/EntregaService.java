package com.diegoschneider.msr.service;

import com.diegoschneider.msr.model.Entrega;

import java.util.List;
import java.util.UUID;

public interface EntregaService {

    Entrega create(Entrega entrega);

    List<Entrega> findAll();

    Entrega search(UUID id);
}
