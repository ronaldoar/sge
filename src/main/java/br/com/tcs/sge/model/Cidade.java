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
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="TB_CIDADE", uniqueConstraints={@UniqueConstraint(columnNames = {"DS_NOME","DS_UF"})})
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_CIDADE", nullable=false)
	private Long id;
	
	@Column(name="DS_NOME", length=50, nullable=false)
	private String nome;

	@Column(name="DS_UF", length=50, nullable=false)
	private String uf;

	@Column(name="DT_CADASTRO", nullable=false)
	private LocalDateTime dtCadastro;

	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;

	@Column(name="FL_ATIVO", nullable=false)
	private boolean ativo;
	
	@PreUpdate
    public void preUpdate() {
		dtUltAlt = LocalDateTime.now();
    }
     
    @PrePersist
    public void prePersist() {
    	dtUltAlt =   LocalDateTime.now();
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		return Objects.hash(nome, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(uf, other.uf);
	}
}
