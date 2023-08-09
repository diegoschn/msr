package com.diegoschneider.msr.repository;

import com.diegoschneider.msr.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteRespository extends JpaRepository<Cliente, UUID> {

    List<Cliente> findByNomeContaining(String nome);
}
