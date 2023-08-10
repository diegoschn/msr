package com.diegoschneider.msr.service.impl;

import com.diegoschneider.msr.exception.ClienteNaoEncontradoException;
import com.diegoschneider.msr.exception.NegocioException;
import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.repository.ClienteRespository;
import com.diegoschneider.msr.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRespository clienteRespository;

    public ClienteServiceImpl(ClienteRespository clienteRespository){
        this.clienteRespository = clienteRespository;
    }

    @Override
    public Cliente create(Cliente cliente) {
        boolean emailEmUso = clienteRespository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
        }
        return clienteRespository.save(cliente);
    }

    @Override
    public Cliente findById(UUID id) {
        return clienteRespository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(
                        String.format("Cliente não encontrado", id)));
    }

    @Override
    public Cliente update(Cliente cliente, UUID id) {
        clienteRespository.findById(id)
                .orElseThrow(()-> new ClienteNaoEncontradoException(String.format("Cliente não encontrado")));

        cliente.setId(id);
        return create(cliente);
    }

    @Override
    public void remove(UUID clienteId) {
        Cliente clienteSearch = clienteRespository.findById(clienteId)
                .orElseThrow(() -> new ClienteNaoEncontradoException(String.format("Cliente não encontrado: id: %s", clienteId)));

        clienteRespository.deleteById(clienteSearch.getId());
    }

    @Override
    public List<Cliente> findByNome(String nome) {
        return clienteRespository.findByNomeContaining(nome);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRespository.findAll();
    }
}
