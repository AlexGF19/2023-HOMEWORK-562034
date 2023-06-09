package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	public ComandoVai() {}

	public ComandoVai(IO io) {
		this.io=io;
	}

	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;

		if(this.parametro==null) {
			this.io.mostraMessaggio("Dove vuoi andare ?");
			this.io.mostraMessaggio("Devi specificare una direzione.");
			return;
		}
		try {
			prossimaStanza= stanzaCorrente.getStanzaAdiacente(this.parametro);
			if(prossimaStanza==null) {
				this.io.mostraMessaggio("direzione inesistente.");
				return;
			}
		}catch(IllegalArgumentException e) {
			this.io.mostraMessaggio("direzione inesistente.");
		}
		if(prossimaStanza!=null) {
			partita.setStanzaCorrente(prossimaStanza);
			this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);	
		}
	}

}
