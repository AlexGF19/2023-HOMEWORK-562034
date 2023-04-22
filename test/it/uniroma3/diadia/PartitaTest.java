package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	private Partita partita;
	
	
	@BeforeEach
	void setup() {
		this.partita = new Partita();
	}

	

	@Test
	void testVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testVinta2() {
		this.partita.setStanzaCorrente(null);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	void testVinta3() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	void testIsFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita2() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	void testIsFinita3() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
}
