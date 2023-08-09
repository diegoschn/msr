package com.diegoschneider.msr.controller;

import com.diegoschneider.msr.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TesteController {

    @GetMapping
    public List<Cliente> getEntity(){
        return List.of(Cliente.
                builder()
                .id(UUID.randomUUID())
                .nome("Diego Schneider")
                .email("email@email.com")
                .telefone("12321312312")
                .build());
    }
}
