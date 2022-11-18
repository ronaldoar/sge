package br.com.tcs.sge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.sge.model.Evento;
import br.com.tcs.sge.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repository;
		
	public List<Evento> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<Evento> buscarPorId(Long id) {
		return repository.findById(id);
	}

}
