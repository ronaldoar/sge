package br.com.tcs.sge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.sge.repository.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repository;

}
