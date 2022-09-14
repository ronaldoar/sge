package br.com.tcs.sge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.tcs.sge.controller.dto.LoginDto;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@ModelAttribute("dto")
	public LoginDto newPerson() {
	    return new LoginDto();
	}
	
	
	@GetMapping("/index")
	public String loginView() {
		logger.info("[LOGIN-VIEW] efetuando requisicao da tela de login.");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("dto") LoginDto dto){
		
		if(dto.getUsername().equals("sge") & dto.getPassword().equals("sge")) {
			return "/dashboard";
			
		}else {
			dto.setMsg("Acesso negado!");
			return "/login";
		}
	}
}
