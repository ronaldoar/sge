package br.com.tcs.sge.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="TB_LOCAL")
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_LOCAL", nullable=false)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_CIDADE", nullable=false)
	private Cidade cidade;
	
	@Column(name="DS_ENDERECO", length=50, nullable=false)
	private String endereco;

	@Column(name="DS_BAIRRO", length=50, nullable=false)
	private String bairro;

	@Column(name="NR_NUMERO", length=5, nullable=false)
	private Integer numero;

	@Column(name="DS_CEP", length=50, nullable=false)
	private String cep;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
		Local other = (Local) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", cidade=" + cidade + ", endereco=" + endereco + ", bairro=" + bairro + ", numero="
				+ numero + ", cep=" + cep + ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", ativo=" + ativo
				+ "]";
	}

}
