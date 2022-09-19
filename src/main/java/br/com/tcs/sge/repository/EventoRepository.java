package br.com.tcs.sge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcs.sge.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	
	
}
