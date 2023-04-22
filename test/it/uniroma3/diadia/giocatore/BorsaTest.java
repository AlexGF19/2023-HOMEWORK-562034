package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	
	@BeforeEach
	void setUp() {
		this.borsa=new Borsa();
		this.attrezzo=new Attrezzo("attrezzo", 0);
		this.attrezzoPesante=new Attrezzo("attrezzoPesante", 11);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(this.borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	void testAddAttrezzoConPesoMaggioreDiPesoMax() {
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}
	
	@Test
	void testAddAttrezzoTroppiAttrezziPerLaBorsa() {
		for(int i=0; i<10; i++)
			this.borsa.addAttrezzo(attrezzo);
		assertFalse(this.borsa.addAttrezzo(attrezzo));
	}

	@Test
	void testGetAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzoPesante);
		assertEquals(attrezzo,this.borsa.getAttrezzo("attrezzo"));
	}
	
	@Test
	void testGetAttrezzoNull() {
		assertNull(this.borsa.getAttrezzo("attrezzo"));
	}
	
	@Test
	void testIsEmpty() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	void testIsEmptyFalse() {
		this.borsa.addAttrezzo(attrezzo);
		assertFalse(this.borsa.isEmpty());
	}

	
	@Test
	void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals("attrezzo", this.borsa.removeAttrezzo("attrezzo").getNome());
	}
	
	@Test
	void testRemoveAttrezzoNull() {
		assertNull(this.borsa.removeAttrezzo("attrezzo"));
	}
}
