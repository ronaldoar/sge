package br.com.tcs.sge.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.sge.model.Contato;

public class ContatoDto {
	
	private Long id;
	private String nome;
	private Long telefone;
	private String email;
	private String categoria;
	private Long categoriaId;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private boolean ativo;
	
	public static List<ContatoDto> parse(List<Contato> contatos){
		List<ContatoDto>lista = new ArrayList<ContatoDto>();
		
		contatos.forEach(c -> { lista.add( parse(c) ); });
		return lista;
	}
	
	public static ContatoDto parse(Contato contato) {
		ContatoDto c = new ContatoDto();
		c.setAtivo(contato.isAtivo());
		c.setCategoria(contato.getCategoria().getNome());
		c.setCategoriaId(contato.getCategoria().getId());
		c.setDtCadastro(contato.getDtCadastro());
		c.setDtUltAlt(contato.getDtUltAlt());
		c.setId(contato.getId());
		c.setNome(contato.getNome());
		c.setTelefone(contato.getTelefone());
		c.setEmail(contato.getEmail());
		return c;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public LocalDateTime getDtUltAlt() {
		return dtUltAlt;
	}
	public void setDtUltAlt(LocalDateTime dtUltAlt) {
		this.dtUltAlt = dtUltAlt;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
