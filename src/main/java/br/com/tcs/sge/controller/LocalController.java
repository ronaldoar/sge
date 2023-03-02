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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tcs.sge.controller.dto.CategoriaDto;
import br.com.tcs.sge.controller.dto.ContatoDto;
import br.com.tcs.sge.controller.dto.LocalDto;
import br.com.tcs.sge.service.LocalService;

@Controller
@RequestMapping("/local")
public class LocalController {
	private static final Logger logger = LoggerFactory.getLogger(LocalController.class);
	
	@Autowired
	private LocalService localService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		try {
			List<LocalDto>todos = LocalDto.parse(localService.buscarTodos());
			String gson = new Gson().toJson(todos);
			return new ResponseEntity<>(gson, HttpStatus.OK);
			
		}catch(Exception ex) {
			logger.error("[LOCAL-LISTAR-TODOS]: "+ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/consultar/{id}")
	public ModelAndView consultar(@PathVariable Long id) {
		
		try {
			 String local    = new Gson().toJson(LocalDto.parse(localService.buscarPorId(id)));		 			 
			 ModelAndView modelAndView = new ModelAndView();	
			 modelAndView.addObject("local", local);
			 modelAndView.setViewName("locais/local");
			 return modelAndView;
			
		}catch(Exception ex) {
			 logger.error("[LOCAL-LISTAR-TODOS]: "+ex.getMessage());
			 ModelAndView modelAndView = new ModelAndView();	
			 modelAndView.setViewName("locais/local");
			 return modelAndView;
		}
	}
}
