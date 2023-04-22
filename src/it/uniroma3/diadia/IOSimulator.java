package it.uniroma3.diadia;

import java.util.Scanner;

public class IOSimulator implements IO {
	private String[] istruzioni;
	int i;
	private String[] risposte;
	private int numeroRisposte;
	
	
	public IOSimulator(String[] istruzioni) {
		this.istruzioni = istruzioni;
		this.i = 0;
		this.risposte = new String[this.istruzioni.length*2];
		this.numeroRisposte = 0;
	}

	public String[] getRisposte() {
		return this.risposte;
	}
	
	public int getNumeroRisposte() {
		return this.numeroRisposte;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.risposte[numeroRisposte] = messaggio;
		this.numeroRisposte++;
	}
	

	@Override
	public String leggiRiga() {
		return this.istruzioni[this.i++];
	}
}
