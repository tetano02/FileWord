package it.unibs.fp.massaia;

public class Ingrediente {

	private String nome;
	private int calorie;
	
	
	public Ingrediente(String nome, int calorie) {
		this.nome=nome;
		this.calorie=calorie;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCalorie() {
		return calorie;
	}
	
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	
}
