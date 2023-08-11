package com.diegoschneider.msr.service.impl;

import com.diegoschneider.msr.exception.ClienteNaoEncontradoException;
import com.diegoschneider.msr.exception.NegocioException;
import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.model.Entrega;
import com.diegoschneider.msr.model.enums.StatusEntrega;
import com.diegoschneider.msr.repository.ClienteRepository;
import com.diegoschneider.msr.repository.EntregaRepository;
import com.diegoschneider.msr.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EntregaServiceImpl implements EntregaService {

    private EntregaRepository entregaRepository;

    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Entrega create(Entrega entrega) {

        Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
                .orElseThrow(() -> new ClienteNaoEncontradoException(String.format("Não existe cliente com id: %s",
                        entrega.getCliente().getId())));
        entrega.setCliente(cliente);
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }

    @Override
    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }

    @Override
    public Entrega search(UUID id) {
        return entregaRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Entrega não localizada"));
    }
}
