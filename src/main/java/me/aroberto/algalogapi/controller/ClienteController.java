package me.aroberto.algalogapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.aroberto.algalogapi.domain.exception.NegocioException;
import me.aroberto.algalogapi.domain.model.Cliente;
import me.aroberto.algalogapi.domain.repository.ClienteRepository;
import me.aroberto.algalogapi.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteRepository clienteRepository;
	private final ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteRepository clienteRepository, ClienteService clienteService) {
		this.clienteRepository = clienteRepository;
		this.clienteService = clienteService;
	}

	public ClienteController() {
		this(null, null);
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

		// return clienteRepository.findById(clienteId)
//				.map(cliente -> ResponseEntity.ok(cliente))
//				.orElse(ResponseEntity.notFound().build());

//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
//		return clienteRepository.save(cliente);
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		return clienteService.salvar(cliente);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
//		cliente = clienteRepository.save(cliente);
		cliente = clienteService.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		clienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
}
