package br.com.tcs.sge.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="TB_CATEGORIA")
	public class Categoria implements Serializable {
		private static final long serialVersionUID = 1L;
		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="CD_CATEGORIA", nullable = false)
		private Long id;
		
		@Column(name="DS_CATEGORIA", length = 100, nullable = false)
		private String nome;
		
		@Column(name="DT_CADASTRO", nullable=false)
		private LocalDateTime dtCadastro;

		@Column(name="DT_ULT_ALT", nullable=false)
		private LocalDateTime dtUltAlt;
		
		@Column(name="FL_ATIVO", nullable = false)
		private boolean ativo;
		
		@PreUpdate
	    public void preUpdate() {
			dtUltAlt = LocalDateTime.now();
	    }
	     
	    @PrePersist
	    public void prePersist() {
	    	dtUltAlt   = LocalDateTime.now();
	    	dtCadastro = LocalDateTime.now();
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
		
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Categoria other = (Categoria) obj;
			return Objects.equals(id, other.id);
		}
}
