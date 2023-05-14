package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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


	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}
	
	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(labirinto);
		this.io = io;
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
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita); 
		if (this.partita.vinta())
			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");
		return this.partita.isFinita();

	}


	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		LabirintoBuilder l = new LabirintoBuilder();
		l.addStanzaVincente("Biblioteca");
		l.addStanzaIniziale("Atrio");
		l.addAttrezzo("osso", 1);
		l.addAttrezzo("chiave", 2);
		l.addStanza("Aula N11");
		l.addStanza("Aula N10");
		l.addAttrezzo("lanterna", 3);
		l.addStanza("Laboratorio Campus");
		l.addStanzaMagica("Magica");
		l.addStanzaBloccata("Bloccata", "chiave", "ovest");
		l.addStanzaBuia("Buia", "lanterna");
		l.addAdiacenza("Atrio", "Biblioteca", "nord");
		l.addAdiacenza("Atrio", "Aula N11", "est");
		l.addAdiacenza("Atrio", "Laboratorio Campus", "ovest");
		l.addAdiacenza("Atrio", "Aula N10", "sud");
		l.addAdiacenza("Aula N11", "Laboratorio Campus", "est");
		l.addAdiacenza("Aula N11", "Atrio", "ovest");
		l.addAdiacenza("Aula N10", "Atrio", "nord");
		l.addAdiacenza("Aula N10", "Aula N11", "est");
		l.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest");
		l.addAdiacenza("Aula N10", "Bloccata", "sud");
		l.addAdiacenza("Laboratorio Campus", "Atrio", "est");
		l.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest");
		l.addAdiacenza("Biblioteca", "Atrio", "sud");
		l.addAdiacenza("Bloccata", "Aula N10", "nord");
		l.addAdiacenza("Bloccata", "Buia", "est");
		l.addAdiacenza("Bloccata", "Magica", "ovest");
		l.addAdiacenza("Magica", "Bloccata", "est");
		l.addAdiacenza("Buia", "Bloccata", "ovest");
		
		DiaDia gioco = new DiaDia(l.getLabirinto(), io);
		gioco.gioca();
	}


}