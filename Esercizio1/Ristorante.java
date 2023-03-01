package Mattina.Esercizio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ristorante {
	
	private ArrayList<Pietanza> listaPietanze; ;
	private double  contoAperto = 0;
	
	public Ristorante() {
		this.listaPietanze = new ArrayList<Pietanza>();
	}
	
	
	public Ristorante(ArrayList<Pietanza> listaPietanze) {
		this.listaPietanze = listaPietanze;
	}
	
	
	public void ordina(int index) {
		if (index < listaPietanze.size()) {
			System.out.println("Hai ordinato"+ this.listaPietanze.get(index).getNome());
			this.contoAperto +=  this.listaPietanze.get(index).getPrezzo();	
		}
	}
	
	
	public void visualizza(int index) {
		System.out.println(listaPietanze.get(index).getIngredienti());
	}
	
	
	public void aggiungiPietanza(Pietanza pietanza) {
		this.listaPietanze.add(pietanza);
	}
	
	public double getContoAperto() {
		return contoAperto;
	}
	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for(int i=0 ; i<this.listaPietanze.size();i++) {
			result.append((i+1)+") "+listaPietanze.get(i)+"\n");
		}
		return result.toString();
	}
	
}
