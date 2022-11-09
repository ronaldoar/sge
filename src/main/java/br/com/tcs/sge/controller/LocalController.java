package br.com.tcs.sge.controller;

import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tcs.sge.controller.dto.LocalDto;
import br.com.tcs.sge.service.LocalService;

@Controller
@RequestMapping("/local")
public class LocalController {
	private static final Logger logger = LoggerFactory.getLogger(LocalController.class);
	
	@Autowired
	private LocalService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		try {
			List<LocalDto>todos = LocalDto.parse(service.buscarTodos());
			String gson = new Gson().toJson(todos);
			return new ResponseEntity<>(gson, HttpStatus.OK);
			
		}catch(Exception ex) {
			logger.error("[LOCAL-LISTAR-TODOS]: "+ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
