package br.com.agoravai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="PARTICIPANTES")
public class Participante {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private int numero;
	
	public Participante() {
		
	}
	
	public Participante(String nome, int numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
