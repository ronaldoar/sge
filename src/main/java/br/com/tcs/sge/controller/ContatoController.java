package br.com.tcs.sge.controller;

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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.tcs.sge.controller.dto.CategoriaDto;
import br.com.tcs.sge.controller.dto.ContatoDto;
import br.com.tcs.sge.model.Categoria;
import br.com.tcs.sge.service.CategoriaService;
import br.com.tcs.sge.service.ContatoService;

@Controller
@RequestMapping("/contato")
public class ContatoController {
	private static final Logger logger = LoggerFactory.getLogger(ContatoController.class);
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		try {
			String gson = new Gson().toJson(ContatoDto.parse(contatoService.buscarTodos()));
			return new ResponseEntity<>(gson, HttpStatus.OK);
			
		}catch(Exception ex) {
			logger.error("[CONTATO-LISTAR-TODOS]: "+ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/consultar/{id}")
	public ModelAndView consultar(@PathVariable Long id) {
		
		try {
			 String contato    = new Gson().toJson(ContatoDto.parse(contatoService.buscarPorId(id).get()));
			 String categorias = new Gson().toJson(CategoriaDto.parse(categoriaService.listar()));
			 
			 ModelAndView modelAndView = new ModelAndView();	
			 modelAndView.addObject("contato", contato);
			 modelAndView.addObject("categorias", categorias);
			 modelAndView.setViewName("contatos/contato");
			 return modelAndView;
			
		}catch(Exception ex) {
			 logger.error("[CONTATO-LISTAR-TODOS]: "+ex.getMessage());
			 ModelAndView modelAndView = new ModelAndView();	
			 modelAndView.setViewName("contatos/contato");
			 return modelAndView;
		}
	}
}
