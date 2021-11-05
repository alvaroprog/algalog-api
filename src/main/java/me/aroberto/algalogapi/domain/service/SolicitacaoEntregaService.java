package me.aroberto.algalogapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import me.aroberto.algalogapi.domain.model.Cliente;
import me.aroberto.algalogapi.domain.model.Entrega;
import me.aroberto.algalogapi.domain.model.StatusEntrega;
import me.aroberto.algalogapi.domain.repository.EntregaRepository;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregaRepository;
	private ClienteService clienteService;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		return entregaRepository.save(entrega);
	}
}
