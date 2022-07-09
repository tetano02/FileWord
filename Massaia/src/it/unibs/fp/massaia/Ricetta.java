package it.unibs.fp.massaia;

import java.util.ArrayList;

public class Ricetta {
	
	private String nome;
	private ArrayList<String> descrizione=new ArrayList<String>();
	private ArrayList<Ingrediente> listaIngredienti=new ArrayList<Ingrediente>();
	private int calorieTotali;
	
	public Ricetta(String nome,ArrayList<String> descrizione,ArrayList<Ingrediente> listaIngredienti) {
		this.nome=nome;
		this.descrizione=descrizione;
		this.listaIngredienti=listaIngredienti;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<String> getDescrizione() {
		return descrizione;
	}
	
	public void aggiungiDescrizione(String descrizione) {
		this.descrizione.add(descrizione);
	}
	
	public ArrayList<Ingrediente> getListaIngredienti() {
		return listaIngredienti;
	}
	
	public void aggiungiIngrediente(Ingrediente ingrediente) {
		this.listaIngredienti.add(ingrediente);
	}
	
	

	public int getCalorieTotali() {
		return calorieTotali;
	}

	public void calcolaCalorieTotali() {
		this.calorieTotali=0;
		for(int i=0;i<listaIngredienti.size();i++)
			this.calorieTotali+=this.listaIngredienti.get(i).getCalorie();
	}

}
