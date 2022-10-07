package br.com.tcs.sge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import br.com.tcs.sge.model.Categoria;
import br.com.tcs.sge.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping("/listar")
	public String listar() {
		List<Categoria>categorias = service.listar();
		String array = new Gson().toJson(categorias, Categoria[].class);
		return array;
	}
}
