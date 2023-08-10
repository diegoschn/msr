package com.diegoschneider.msr.controller;

import com.diegoschneider.msr.model.Entrega;
import com.diegoschneider.msr.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
@AllArgsConstructor
public class EntregaController {

    private EntregaService entregaService;



    @PostMapping
    public ResponseEntity<Entrega> create(@RequestBody Entrega entrega){
        return new ResponseEntity<>(entregaService.create(entrega), HttpStatus.CREATED);
    }
}
