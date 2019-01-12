package modelo;

import java.time.LocalTime;

import util.Util;

public class Grade {
	
	String uf;
	String descricao;
	LocalTime inicio;
	LocalTime fim;
	
	public Grade() {
	}
	
	public Grade(String[] valores) {
		this.setUf(valores[1]);
		this.setDescricao(valores[2]);
		this.setInicio(Util.retornarHorarioProgramacao(valores[3]));
		this.setFim(Util.retornarHorarioProgramacao(valores[4]));
	}
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}
	public LocalTime getFim() {
		return fim;
	}
	public void setFim(LocalTime fim) {
		this.fim = fim;
	}

}
