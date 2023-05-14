package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private StanzaMagica stanza;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() {
		stanza = new StanzaMagica("stanzaMagica");
		attrezzo = new Attrezzo("attrezzo", 1);
	}

	@Test
	void testAddAttrezzo() {
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo("attrezzo"));
	}
	
	@Test
	void testAddAttrezzoSuperaSogliaMagica() {
		int i;
		for(i=0; i<stanza.SOGLIA_MAGICA_DEFAULT; i++) {
			stanza.addAttrezzo(attrezzo);
		}
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.getAttrezzi().containsKey("ozzertta"));
		assertTrue(stanza.getAttrezzi().containsKey("attrezzo"));
	}
}
