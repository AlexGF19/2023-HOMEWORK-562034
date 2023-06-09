package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando{

	private static final String MESSAGGIO_REGALA_A_CHI ="A chi dovrei regalarlo? Non c'è nessuno!";
	private static final String MESSAGGIO_PARAMETRO_NULL ="Cosa vuoi regalare ?" + "/n Devi speccificare un attrezzo che hai nella borsa.";
	private static final String MESSAGGIO_ATTREZZO_MANCANTE ="Non hai questo attrezzo nella borsa!";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			if(this.parametro!=null) {
				Attrezzo attrezzo = partita.getGiocatore().getBorsa().removeAttrezzo(parametro);
				if(attrezzo==null) 
					this.io.mostraMessaggio(MESSAGGIO_ATTREZZO_MANCANTE);
				else
					this.io.mostraMessaggio(personaggio.riceviRegalo(attrezzo, partita));
			}
			else {
				this.io.mostraMessaggio(MESSAGGIO_PARAMETRO_NULL);
			}
		}
		else
			this.io.mostraMessaggio(MESSAGGIO_REGALA_A_CHI);
	}

}
