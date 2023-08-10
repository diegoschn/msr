package com.diegoschneider.msr.repository;

import com.diegoschneider.msr.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    List<Cliente> findByNomeContaining(String nome);

    Optional<Cliente> findByEmail(String email);
}
