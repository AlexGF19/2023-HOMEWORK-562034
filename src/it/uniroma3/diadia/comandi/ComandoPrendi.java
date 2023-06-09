package it.uniroma3.diadia.comandi;


import java.util.HashMap;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	public ComandoPrendi() {}

	public ComandoPrendi(IO io) {
		this.io=io;	}

	@Override
	public void esegui(Partita partita) {
		if(parametro==null)
			this.io.mostraMessaggio("Cosa vuoi prendere ?");
		else {
			int numeroAttrezzi=partita.getStanzaCorrente().getNumeroAttrezzi();
			if(numeroAttrezzi==0) 
				this.io.mostraMessaggio("La stanza è vuota.");
			else {	
				if(partita.getStanzaCorrente().hasAttrezzo(parametro)) {
					Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzi().get(parametro);
					partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
					partita.getStanzaCorrente().removeAttrezzo(attrezzo);
					this.io.mostraMessaggio("Hai raccolto :"+ parametro);
				}
				else {
					this.io.mostraMessaggio("\"" + parametro + "\" non è presente in questa stanza!");
				}
			}
			this.io.mostraMessaggio(partita.getStanzaCorrente().toString());
		}
	}


}
