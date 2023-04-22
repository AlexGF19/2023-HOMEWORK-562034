package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanza;


	@BeforeEach
	void setUp() {
		this.labirinto= new Labirinto();
	}

	@Test
	void testSetStanzaVincente() {
		this.labirinto.setStanzaIniziale(this.stanza);
		assertEquals(this.stanza, this.labirinto.getStanzaIniziale());
	}

	@Test
	void testSetStanzaIniziale() {
		this.labirinto.setStanzaVincente(stanza);
		assertEquals(this.stanza, this.labirinto.getStanzaVincente());
	}

}
