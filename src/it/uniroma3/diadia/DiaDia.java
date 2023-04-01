package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		while (!processaIstruzione(this.io.leggiRiga()));
	}


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		String nomeComando = comandoDaEseguire.getNome();

		if (nomeComando==null)
			return false;
		if (nomeComando.equals("fine")) {
			this.fine(); 
			return true;
		} else if (nomeComando.equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (nomeComando.equals("aiuto"))
			this.aiuto();
		else if (nomeComando.equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if	(nomeComando.equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}


	/**
	 * Comando "prendi"
	 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			this.io.mostraMessaggio("Cosa vuoi prendere ?");
		else {
			int numeroAttrezzi=this.partita.getStanzaCorrente().getNumeroAttrezzi();
			if(numeroAttrezzi==0) 
				this.io.mostraMessaggio("La stanza è vuota.");
			else {	
				if(this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
					Attrezzo[] attrezzi=this.partita.getStanzaCorrente().getAttrezzi();
					int i=0;
					while((!(attrezzi[i].getNome().equals(nomeAttrezzo)))&&(i<numeroAttrezzi))
						i++;
					this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzi[i]);
					this.partita.getStanzaCorrente().removeAttrezzo(attrezzi[i]);
					this.io.mostraMessaggio("Hai raccolto :"+ nomeAttrezzo);
				}
				else {
					this.io.mostraMessaggio("\"" + nomeAttrezzo + "\" non è presente in questa stanza!");
				}
			}
			this.io.mostraMessaggio(this.partita.getStanzaCorrente().toString());
		}
	}

	/**
	 * Comando"posa"
	 */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null)
			this.io.mostraMessaggio("Cosa vuoi posare ?");
		else {
			if(this.partita.getGiocatore().getBorsa().isEmpty())
				this.io.mostraMessaggio("La borsa è vuota");
			else {
				Attrezzo attrezzo=this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				if(attrezzo==null)
					this.io.mostraMessaggio("Non hai questo attrezzo nella borsa!");
				else {
					this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
					this.io.mostraMessaggio("Hai posato :" + nomeAttrezzo);
				}	
			}
			this.io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}