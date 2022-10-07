package br.com.tcs.sge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcs.sge.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	
	
}
