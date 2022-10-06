package br.com.tcs.sge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tcs.sge.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query("SELECT a FROM Admin a WHERE a.email = ?1 AND a.password = ?2 AND a.ativo = ?3")
	Optional<Admin> login(String email, String password, boolean ativo);
	
}
