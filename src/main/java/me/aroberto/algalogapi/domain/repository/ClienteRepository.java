package me.aroberto.algalogapi.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.aroberto.algalogapi.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);

	Optional<Cliente> findById(Long id);

	Optional<Cliente> findByEmail(String email);
}
