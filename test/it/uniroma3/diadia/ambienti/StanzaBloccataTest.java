package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata stanzaBloccata;
	private Attrezzo chiave;
	private Stanza destinazione;
	
	@BeforeEach
	void setUp() {
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", "chiave", "nord");
		destinazione = new Stanza("destinazione");
		stanzaBloccata.impostaStanzaAdiacente("nord", destinazione);
		chiave = new Attrezzo("chiave", 1);
	}
	
	
	@Test
	void testGetStanzaAdiacenteSenzaChiave() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacenteConChiave() {
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(destinazione, stanzaBloccata.getStanzaAdiacente("nord"));
	}
}
