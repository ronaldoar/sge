package br.com.tcs.sge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.sge.model.Local;
import br.com.tcs.sge.repository.LocalRepository;

@Service
public class LocalService {
	
	@Autowired
	private LocalRepository repository;
	
	public List<Local> buscarTodos(){
		return repository.findAll();
	}
}
