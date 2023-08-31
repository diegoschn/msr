package com.diegoschneider.msr.repository;

import com.diegoschneider.msr.model.Cliente;
import com.diegoschneider.msr.model.dto.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    @Query("SELECT new com.diegoschneider.msr.model.dto.ClienteDto (c.id, c.nome, c.telefone, c.email) FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<ClienteDto> findByNomeLike(@Param("nome") String nome);

//    List<ClienteDto> findByNomeContaining(String nome);

    @Query("SELECT new com.diegoschneider.msr.model.dto.ClienteDto (c.email) FROM Cliente c WHERE c.email LIKE %:email%")
    Optional<ClienteDto> findByEmail(@Param("email") String email);
}
