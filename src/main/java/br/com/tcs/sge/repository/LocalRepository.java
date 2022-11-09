package br.com.tcs.sge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcs.sge.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {

}
