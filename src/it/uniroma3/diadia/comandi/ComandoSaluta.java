package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	
	private static final String MES_NESSUNO_DA_SALUTARE = "Chi dovrei Salutare? Non c'è nessuno!";
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			this.io.mostraMessaggio(personaggio.saluta());
		}
		else this.io.mostraMessaggio(MES_NESSUNO_DA_SALUTARE);
	}

}
