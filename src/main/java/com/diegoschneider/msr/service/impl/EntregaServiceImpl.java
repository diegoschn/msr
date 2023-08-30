package com.diegoschneider.msr.service.impl;

import com.diegoschneider.msr.exception.ClienteNaoEncontradoException;
import com.diegoschneider.msr.mapper.EntregaMapper;
import com.diegoschneider.msr.mapper.MapperUtil;
import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.model.Entrega;
import com.diegoschneider.msr.model.dto.EntregaDto;
import com.diegoschneider.msr.model.enums.StatusEntrega;
import com.diegoschneider.msr.repository.ClienteRepository;
import com.diegoschneider.msr.repository.EntregaRepository;
import com.diegoschneider.msr.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EntregaServiceImpl implements EntregaService {

    private EntregaRepository entregaRepository;

    private ClienteRepository clienteRepository;


    @Override
    @Transactional
    public EntregaDto create(Entrega entrega) {

        Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
                .orElseThrow(() -> new ClienteNaoEncontradoException(String.format("Não existe cliente com id: %s",
                        entrega.getCliente().getId())));
        entrega.setCliente(cliente);
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return MapperUtil.toModel(entregaRepository.save(entrega), EntregaDto.class);
    }

    @Override
    public List<EntregaDto> findAll() {
        return MapperUtil.toList(entregaRepository.findAll(), EntregaDto.class);
    }

    @Override
    public EntregaDto search(UUID id) {
        return entregaRepository.findById(id)
                .map(entrega -> MapperUtil.toModel(entrega, EntregaDto.class))
                    .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado"));
    }
}
