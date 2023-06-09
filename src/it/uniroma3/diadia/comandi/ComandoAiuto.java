package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta", "interagisci", "regala"};
	
	public ComandoAiuto() {}
	
	public ComandoAiuto(IO io) {
		this.io=io;	}

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
	}


}
