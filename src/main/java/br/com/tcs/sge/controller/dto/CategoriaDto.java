package br.com.tcs.sge.controller.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.sge.model.Categoria;


	public class CategoriaDto implements Serializable {
		private static final long serialVersionUID = 1L;
	
		private Long id;
		private String nome;
		private LocalDateTime dtCadastro;
		private LocalDateTime dtUltAlt;
		private boolean ativo;
		
		
		public static List<CategoriaDto> parse(List<Categoria>categorias){
			List<CategoriaDto>list = new ArrayList<CategoriaDto>();
			
			categorias.forEach(c -> {
				list.add(parse(c));
			});
			return list;
		}
		
		public static CategoriaDto parse(Categoria categoria) {
			CategoriaDto dto = new CategoriaDto();
			dto.setAtivo(categoria.isAtivo());
			dto.setDtCadastro(categoria.getDtCadastro());
			dto.setDtUltAlt(categoria.getDtUltAlt());
			dto.setId(categoria.getId());
			dto.setNome(categoria.getNome());
			return dto;
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
