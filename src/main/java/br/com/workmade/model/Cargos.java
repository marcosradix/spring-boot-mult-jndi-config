package br.com.workmade.model;

public class Cargos {
	private int id;
	private String nome;
	private int idDepartamentoFk;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdDepartamentoFk() {
		return idDepartamentoFk;
	}
	public void setIdDepartamentoFk(int idDepartamentoFk) {
		this.idDepartamentoFk = idDepartamentoFk;
	}

	

	

}
