package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	Partita partita;
	Attrezzo attrezzo;
	Stanza stanza;
	ComandoPrendi cprendi;
	

	@BeforeEach
	 void setUp() {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.stanza = new Stanza("stanza");
		this.cprendi = new ComandoPrendi(new IOConsole());
		this.partita.setStanzaCorrente(stanza);
		this.stanza.addAttrezzo(attrezzo);
	}
	
	@Test
	void testEsegui() {
		this.cprendi.setParametro("attrezzo");
		this.cprendi.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty()); //solo se la borsa è inizialmente vuota
		assertFalse(this.stanza.hasAttrezzo("attrezzo"));
	}

	@Test
	void testEseguiAttrezzoNonEsistente() {
		this.cprendi.setParametro("attrezzoNonEsistente");
		this.cprendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty()); //solo se la borsa è inizialmente vuota
		assertTrue(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testEseguiNull() {
		this.cprendi.setParametro(null);
		this.cprendi.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty()); //solo se la borsa è inizialmente vuota
		assertTrue(this.stanza.hasAttrezzo("attrezzo"));
	}
}
