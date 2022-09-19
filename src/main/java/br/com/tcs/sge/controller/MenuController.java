package br.com.tcs.sge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@GetMapping(value="/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping(value="/contatos")
	public String contatos() {
		return "contatos/listar";
	}

	@GetMapping(value="/locais")
	public String locais() {
		return "locais/listar";
	}

	@GetMapping(value="/configuracoes")
	public String configuracoes() {
		return "/configuracoes/parametros";
	}

	@GetMapping(value="/evento/cadastrar")
	public String evento() {
		return "/eventos/cadastrar";
	}
}
