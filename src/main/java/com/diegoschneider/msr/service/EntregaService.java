package com.diegoschneider.msr.service;

import com.diegoschneider.msr.model.Entrega;
import com.diegoschneider.msr.model.dto.EntregaDto;

import java.util.List;
import java.util.UUID;

public interface EntregaService {

    EntregaDto create(Entrega entrega);

    List<EntregaDto> findAll();

    EntregaDto search(UUID id);
}
