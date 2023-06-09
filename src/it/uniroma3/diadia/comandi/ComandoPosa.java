package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	
	public ComandoPosa() {}

	public ComandoPosa(IO io) {
		this.io=io;	}

	@Override
	public void esegui(Partita partita) {
		if(this.parametro==null)
			this.io.mostraMessaggio("Cosa vuoi posare ?");
		else {
			if(partita.getGiocatore().getBorsa().isEmpty())
				this.io.mostraMessaggio("La borsa è vuota");
			else {
				Attrezzo attrezzo=partita.getGiocatore().getBorsa().removeAttrezzo(this.parametro);
				if(attrezzo==null)
					this.io.mostraMessaggio("Non hai questo attrezzo nella borsa!");
				else {
					partita.getStanzaCorrente().addAttrezzo(attrezzo);
					this.io.mostraMessaggio("Hai posato: " + this.parametro);
				}	
			}
			this.io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}
	}

}
