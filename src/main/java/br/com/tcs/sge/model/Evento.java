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
@Table(name="TB_EVENTO")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_EVENTO", nullable=false)
	private Long id;
	
	@Column(name="DS_TITULO", length=50, nullable=false)
	private String titulo;

	@Column(name="DS_DESCRICAO", length=50, nullable=false)
	private String descricao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_LOCAL", nullable=false)
	private Local local;
	
	@Column(name="DT_CADASTRO", nullable=false)
	private LocalDateTime dtCadastro;

	@Column(name="DT_ULT_ALT", nullable=false)
	private LocalDateTime dtUltAlt;

	@Column(name="FL_ATIVO", nullable=false)
	private boolean ativo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CD_ADMIN", nullable=false)
	private Admin admin;
	
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", local=" + local
				+ ", dtCadastro=" + dtCadastro + ", dtUltAlt=" + dtUltAlt + ", ativo=" + ativo + "]";
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
		Evento other = (Evento) obj;
		return Objects.equals(id, other.id);
	}
	
}
