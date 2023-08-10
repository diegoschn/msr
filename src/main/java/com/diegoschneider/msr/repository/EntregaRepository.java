package com.diegoschneider.msr.repository;

import com.diegoschneider.msr.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregaRepository extends JpaRepository<Entrega, UUID> {
}
