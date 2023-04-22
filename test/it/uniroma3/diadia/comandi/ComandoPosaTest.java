package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	Partita partita;
	Attrezzo attrezzo;
	Stanza stanza;
	ComandoPosa cposa;
	

	@BeforeEach
	 void setUp() {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.stanza = new Stanza("stanza");
		this.cposa = new ComandoPosa(new IOConsole());
		this.partita.setStanzaCorrente(stanza);
	}
	
	@Test
	void testEseguiRimuoviAttrezzoPresenteNellaBorsa() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		cposa.setParametro("attrezzo");
		cposa.esegui(partita);
		assertTrue(this.stanza.hasAttrezzo("attrezzo"));
		assertTrue(this.partita.getGiocatore().getBorsa().isEmpty()); //solo se la borsa è inizialmente vuota
	}
	
	@Test
	void testEseguiRimuoviAttrezzoNonEsistente() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		cposa.setParametro("attrezzoNonEsistente");
		cposa.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("attrezzoNonEsistente"));
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty());
	}
	

	@Test
	void testEseguiNull() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		cposa.setParametro(null);
		cposa.esegui(partita);
		assertFalse(this.stanza.hasAttrezzo("attrezzo"));
		assertFalse(this.partita.getGiocatore().getBorsa().isEmpty()); //solo se la borsa è inizialmente vuota
	}
}
