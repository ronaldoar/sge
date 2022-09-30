package br.com.tcs.sge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.sge.model.Contato;
import br.com.tcs.sge.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<Contato> buscarPorId(Long id) {
		return repository.findById(id);
	}
}
