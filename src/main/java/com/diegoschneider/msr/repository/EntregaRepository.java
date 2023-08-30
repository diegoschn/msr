package com.diegoschneider.msr.repository;

import com.diegoschneider.msr.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.UUID;

public interface EntregaRepository extends JpaRepository<Entrega, UUID> {

//    <S extends T> S save(S entity);
}
