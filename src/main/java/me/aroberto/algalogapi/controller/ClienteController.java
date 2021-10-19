package me.aroberto.algalogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.aroberto.algalogapi.domain.model.Cliente;
import me.aroberto.algalogapi.domain.repository.ClienteRepository;

@RestController
public class ClienteController {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteController(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}

	public ClienteController() {
		this(null);
	}

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
}
