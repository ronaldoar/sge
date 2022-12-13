package br.com.tcs.sge.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tcs.sge.controller.dto.LoginDto;
import br.com.tcs.sge.model.Admin;
import br.com.tcs.sge.service.AdminService;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AdminService service;
	
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
	public String login(@ModelAttribute("dto") LoginDto dto, RedirectAttributes redirAttrs){
		
		try {
			Optional<Admin> admin = service.login(dto.getUsername(), dto.getPassword());
			
			if(admin.isEmpty()) {
				redirAttrs.addFlashAttribute("message", "Acesso Negado!");
				return "redirect:/index";
				
			}else {
				return "dashboard";
			}
			
		}catch(Exception ex) {
			redirAttrs.addFlashAttribute("message", "Ocorreu um erro no sistema. Tente mais tarde.");
			return "redirect:/index";
		}
	}
}
