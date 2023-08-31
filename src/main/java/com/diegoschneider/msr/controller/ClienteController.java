package com.diegoschneider.msr.controller;

import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.model.dto.ClienteDto;
import com.diegoschneider.msr.repository.ClienteRepository;
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
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDto> listar(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscar(@PathVariable UUID id){
        return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/listarNomes")
    public ResponseEntity<List<ClienteDto>> buscarPorNome(@RequestParam String nome){
        return new ResponseEntity<>(clienteService.findByNome(nome), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create(@Valid @RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ClienteDto> update(@RequestBody Cliente cliente, @PathVariable UUID id){
//        return new ResponseEntity<>(clienteService.update(cliente, id), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable UUID id){
        clienteService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
