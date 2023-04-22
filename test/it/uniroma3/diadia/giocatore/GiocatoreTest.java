package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	private Giocatore giocatore;
	private Borsa borsa;
	
	@BeforeEach
	void setUp() {
		giocatore= new Giocatore();
		}

	@Test
	void testSetCfu() {
		this.giocatore.setCfu(10);
		assertEquals(10, this.giocatore.getCfu());
	}

	@Test
	void testSetBorsa() {
		this.giocatore.setBorsa(borsa);
		assertEquals(borsa, this.giocatore.getBorsa());
	}

}
