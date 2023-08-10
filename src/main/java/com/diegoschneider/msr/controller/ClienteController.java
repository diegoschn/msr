package com.diegoschneider.msr.controller;

import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.repository.ClienteRespository;
import com.diegoschneider.msr.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable UUID id){
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/listarNomes")
    public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome){
        return new ResponseEntity<>(clienteService.findByNome(nome), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable UUID id){
        return new ResponseEntity<>(clienteService.update(cliente, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable UUID id){
        clienteService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
