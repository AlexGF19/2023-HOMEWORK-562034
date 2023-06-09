package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	public ComandoGuarda() {}
	
	public ComandoGuarda(IO io) {
		this.io=io;	}

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		this.io.mostraMessaggio("Cfu:" + partita.getGiocatore().getCfu());
	}

}
