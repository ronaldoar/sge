package br.com.tcs.sge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import br.com.tcs.sge.controller.dto.EventoDto;
import br.com.tcs.sge.service.EventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {
	private static final Logger logger = LoggerFactory.getLogger(EventoController.class);
	
	@Autowired
	private EventoService eventoservice;
	
	@GetMapping("/eventos")
	public ResponseEntity<?> listar(){
		try {
			List<EventoDto> todos = EventoDto.parse(eventoservice.buscarTodos());
			String gson = new Gson().toJson(todos);
			return new ResponseEntity<>(gson, HttpStatus.OK);
			
		}catch(Exception ex) {
			logger.error("[EVENTO-LISTAR-TODOS]: "+ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
