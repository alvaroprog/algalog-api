package me.aroberto.algalogapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.aroberto.algalogapi.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Alvaro Augusto Roberto");
		cliente1.setEmail("alvaro.prog@gmail.com");
		cliente1.setTelefone("(19) 98922-8225");

		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Juliana Caroline Pertilli Roberto");
		cliente2.setEmail("juliana.pertilli@gmail.com");
		cliente2.setTelefone("(19) 99244-0844");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
