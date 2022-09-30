package br.com.tcs.sge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.Gson;

import br.com.tcs.sge.controller.dto.ContatoDto;
import br.com.tcs.sge.service.ContatoService;

@Controller
public class ContatoController {
	private static final Logger logger = LoggerFactory.getLogger(ContatoController.class);
	
	@Autowired
	private ContatoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		try {
			String gson = new Gson().toJson(ContatoDto.parse(service.buscarTodos()));
			return new ResponseEntity<>(gson, HttpStatus.OK);
			
		}catch(Exception ex) {
			logger.error("[CONTATO-LISTAR-TODOS]: "+ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/consultar/{id}")
	public String contato(@PathVariable Long id) {
		return "contatos/contato";
	}
}