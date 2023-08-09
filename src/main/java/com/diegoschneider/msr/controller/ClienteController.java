package com.diegoschneider.msr.controller;

import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRespository clienteRespository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRespository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable UUID id){
        return clienteRespository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listarNomes")
    public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome){
        return new ResponseEntity<>(clienteRespository.findByNomeContaining(nome), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteRespository.save(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable UUID id){
        if(!clienteRespository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else{
            cliente.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(clienteRespository.save(cliente));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable UUID id){
        if(!clienteRespository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clienteRespository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
