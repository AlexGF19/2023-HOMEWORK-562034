package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanzaBuia;
	private Attrezzo lanterna;
	
	@BeforeEach
	void setUp() {
		stanzaBuia = new StanzaBuia("stanzaBuia", "lanterna");
		lanterna = new Attrezzo("lanterna", 3);
	}

	@Test
	void testGetDescrizioneSenzaLanterna() {
		String s = "qui c'è buio pesto,\nTi serve qualcosa per illuminare la stanza!";
		assertEquals(s, stanzaBuia.getDescrizione());
	}

	@Test
	void testGetDescrizioneConLanterna() {
		String s = "qui c'è buio pesto,\nTi serve qualcosa per illuminare la stanza!";
		stanzaBuia.addAttrezzo(lanterna);
		assertNotEquals(s, stanzaBuia.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConAttrezzoQualunque() {
		String s = "qui c'è buio pesto,\nTi serve qualcosa per illuminare la stanza!";
		Attrezzo qualunque = new Attrezzo("qualunque", 1);
		stanzaBuia.addAttrezzo(qualunque);
		assertEquals(s, stanzaBuia.getDescrizione());
	}
}
