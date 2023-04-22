package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo; 
	private IO io;
	
	public ComandoPrendi(IO io) {
		this.io = io;
	}

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null)
			this.io.mostraMessaggio("Cosa vuoi prendere ?");
		else {
			int numeroAttrezzi=partita.getStanzaCorrente().getNumeroAttrezzi();
			if(numeroAttrezzi==0) 
				this.io.mostraMessaggio("La stanza è vuota.");
			else {	
				if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
					Attrezzo[] attrezzi=partita.getStanzaCorrente().getAttrezzi();
					int i=0;
					while((!(attrezzi[i].getNome().equals(nomeAttrezzo)))&&(i<numeroAttrezzi))
						i++;
					partita.getGiocatore().getBorsa().addAttrezzo(attrezzi[i]);
					partita.getStanzaCorrente().removeAttrezzo(attrezzi[i]);
					this.io.mostraMessaggio("Hai raccolto :"+ nomeAttrezzo);
				}
				else {
					this.io.mostraMessaggio("\"" + nomeAttrezzo + "\" non è presente in questa stanza!");
				}
			}
			this.io.mostraMessaggio(partita.getStanzaCorrente().toString());
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

}
