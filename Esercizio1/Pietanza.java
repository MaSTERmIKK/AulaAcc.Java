package Mattina.Esercizio1;

import java.util.ArrayList;
import java.util.Arrays;

public class Pietanza {
	
	private String nome;
	private double prezzo;
	private ArrayList<String> ingredienti = new ArrayList<String>();
	

	public Pietanza(String nome,double prezzo,String[] ingredienti) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.ingredienti = new ArrayList<>(Arrays.asList(ingredienti));
	}
	
	
	public ArrayList<String> getIngredienti() {
		return this.ingredienti;
	}
	
	
	@Override
	public String toString() {
		return nome + " | " + prezzo;
	}


	public String getNome() {
		return nome;
	}


	public double getPrezzo() {
		// TODO Auto-generated method stub
		return prezzo;
	}
}
