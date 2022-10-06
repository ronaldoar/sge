package br.com.tcs.sge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tcs.sge.model.Admin;
import br.com.tcs.sge.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	public List<Admin> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<Admin> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Optional<Admin> login(String email, String password) {
		return repository.login(email, password, true);
	}
}
