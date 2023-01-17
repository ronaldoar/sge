package br.com.tcs.sge.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.sge.model.Evento;

public class EventoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDto local;
	private LocalDateTime dtCadastro;
	private LocalDateTime dtUltAlt;
	private LocalDateTime dtIniEvento;
	private LocalDateTime dtFimEvento;
	private boolean ativo;
	
	public static List<EventoDto> parse(List<Evento> eventos){
		List<EventoDto>lista=  new ArrayList<EventoDto>();
		
		eventos.forEach(e -> {lista.add( parse(e) ); });
		return lista;		
	}
	
	public static EventoDto parse (Evento evento) {
		EventoDto e = new EventoDto();
		e.setId(evento.getId());
		e.setAtivo(evento.isAtivo());
		e.setDescricao(evento.getDescricao());
		e.setDtCadastro(evento.getDtCadastro());
		e.setDtUltAlt(evento.getDtUltAlt());
		e.setDtIniEvento(evento.getDtIniEvento());
		e.setDtFimEvento(evento.getDtFimEvento());	
		LocalDto l = new LocalDto();
		l.setAtivo(evento.getLocal().isAtivo());
		l.setBairro(evento.getLocal().getBairro());
		l.setCep(evento.getLocal().getCep());
		l.setCidade(evento.getLocal().getCidade().getNome());
		l.setEndereco(evento.getLocal().getEndereco());
		l.setNumero(evento.getLocal().getNumero());
		l.setUf(evento.getLocal().getCidade().getUf());
		l.setId(evento.getLocal().getId());
		e.setLocal(l);
		e.setTitulo(evento.getTitulo());
		return e;		
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

	public LocalDto getLocal() {
		return local;
	}

	public void setLocal(LocalDto local) {
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

	public LocalDateTime getDtIniEvento() {
		return dtIniEvento;
	}

	public void setDtIniEvento(LocalDateTime dtIniEvento) {
		this.dtIniEvento = dtIniEvento;
	}

	public LocalDateTime getDtFimEvento() {
		return dtFimEvento;
	}

	public void setDtFimEvento(LocalDateTime dtFimEvento) {
		this.dtFimEvento = dtFimEvento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}
