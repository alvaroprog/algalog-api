package me.aroberto.algalogapi.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import me.aroberto.algalogapi.domain.exception.NegocioException;
import me.aroberto.algalogapi.domain.model.Cliente;
import me.aroberto.algalogapi.domain.repository.ClienteRepository;

@AllArgsConstructor
@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId).orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
}
