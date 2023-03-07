package it.polito.tdp.Lab01.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	private List<String> elencoParole;
		
	public Parole() {
		elencoParole = new LinkedList();
	}
	
	public void addParola(String p) {
		elencoParole.add(p);
	}
	
	public void deleteParola(String p) {
		elencoParole.remove(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(elencoParole);
		return elencoParole;
	}
	
	public void reset() {
		elencoParole.clear();
	}
	

}