package br.com.tcs.sge.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.tcs.sge.model.Local;

public class LocalDto {
	
	private Long id;
	private String cidade;
	private String uf;
	private String endereco;
	private String bairro;
	private Integer numero;
	private String cep;
	private boolean ativo;
	
	
	public static List<LocalDto> parse(List<Local>locais){
		List<LocalDto>lista = new ArrayList<LocalDto>();
		
		locais.forEach(local -> { lista.add( parse(local));});
		return lista;
	}
	
	public static LocalDto parse(Local local) {
		LocalDto dto = new LocalDto();
		dto.setAtivo(local.isAtivo());
		dto.setBairro(local.getBairro());
		dto.setCep(local.getCep());
		dto.setCidade(local.getCidade().getNome());
		dto.setEndereco(local.getEndereco());
		dto.setId(local.getId());
		dto.setNumero(local.getNumero());
		dto.setUf(local.getCidade().getUf());
		return dto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
