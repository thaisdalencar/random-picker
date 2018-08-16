package br.com.agoravai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agoravai.model.Participante;
import br.com.agoravai.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository repository;

	public Iterable<Participante> obterTodos() {
		Iterable<Participante> participantes = repository.findAll();
		return participantes;
	}
	
	public void salvar(Participante novoParticipante) {
		repository.save(novoParticipante);
	}
	
}
