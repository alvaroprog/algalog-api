package me.aroberto.algalogapi.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problema {

	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;

	public static class Campo {
		private final String nome;
		private final String mensagem;

		public Campo(String nome, String mensagem) {
			this.nome = nome;
			this.mensagem = mensagem;
		}

		public String getNome() {
			return nome;
		}

		public String getMensagem() {
			return mensagem;
		}

	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
}
