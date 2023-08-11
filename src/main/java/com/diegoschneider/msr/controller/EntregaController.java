package com.diegoschneider.msr.controller;

import com.diegoschneider.msr.model.Entrega;
import com.diegoschneider.msr.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entregas")
@AllArgsConstructor
public class EntregaController {

    private EntregaService entregaService;

    @PostMapping
    public ResponseEntity<Entrega> create(@Valid @RequestBody Entrega entrega){
        return new ResponseEntity<>(entregaService.create(entrega), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Entrega>> findAll(){
        return new ResponseEntity<>(entregaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> findById(@PathVariable UUID id){
        return new ResponseEntity<>(entregaService.search(id), HttpStatus.OK);
    }


}
