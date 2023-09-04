package com.diegoschneider.msr.service.impl;

import com.diegoschneider.msr.exception.ClienteNaoEncontradoException;
import com.diegoschneider.msr.exception.NegocioException;
import com.diegoschneider.msr.mapper.MapperUtil;
import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.model.dto.ClienteDto;
import com.diegoschneider.msr.repository.ClienteRepository;
import com.diegoschneider.msr.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;


    @Override
    public ClienteDto create(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        clienteRepository.save(cliente);
        return MapperUtil.toModel(cliente, ClienteDto.class);
    }

    @Override
    public ClienteDto findById(UUID id) {
        return clienteRepository.findById(id)
                .map(cliente -> MapperUtil.toModel(cliente, ClienteDto.class))
                .orElseThrow(() -> new ClienteNaoEncontradoException(
                        String.format("Cliente não encontrado", id)));
    }

    //TODO: Corrigir método, pois ao enviar objeto cliente para o método create, o mesmo da erro 500 na transação
    @Override
    public ClienteDto update(Cliente cliente, UUID id) {
        clienteRepository.findById(id)
                .orElseThrow(()-> new ClienteNaoEncontradoException(String.format("Cliente não encontrado")));
        cliente.setId(id);
        return create(cliente);
    }

    @Override
    public void remove(UUID clienteId) {
        Cliente clienteSearch = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNaoEncontradoException(String.format("Cliente não encontrado: id: %s", clienteId)));

        clienteRepository.deleteById(clienteSearch.getId());
    }

    @Override
    public List<ClienteDto> findByNome(String nome) {
        return MapperUtil.toList(clienteRepository.findByNomeLike(nome), ClienteDto.class);
    }

    @Override
    public List<ClienteDto> findAll() {
        return MapperUtil.toList(clienteRepository.findAll(), ClienteDto.class);
    }
}
