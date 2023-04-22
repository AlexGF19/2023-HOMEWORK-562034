package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Attrezzo osso;
	private Attrezzo lanterna;
	
	@BeforeEach
	void setup() {
		this.vuota = new Stanza("vuota");
		this.osso = new Attrezzo("osso", 1);
		this.lanterna= new Attrezzo("lanterna", 3);
	}
	

	@Test
	void testHasAttrezzo() {
		assertFalse(this.vuota.hasAttrezzo("osso"));
	}
	
	@Test
	void testHasAttrezzo2() {
		this.vuota.addAttrezzo(osso);
		assertTrue(this.vuota.hasAttrezzo("osso"));
	}

	@Test
	void testHasAttrezzo3() {
		this.vuota.addAttrezzo(osso);
		assertFalse(this.vuota.hasAttrezzo("lanterna"));
	}
	
	@Test
	void testHasAttrezzo4() {
		this.vuota.addAttrezzo(osso);
		this.vuota.addAttrezzo(lanterna);
		assertTrue(this.vuota.hasAttrezzo("lanterna"));
	}
	
	@Test
	void testHasAttrezzo5() {
		this.vuota.addAttrezzo(osso);
		this.vuota.addAttrezzo(lanterna);
		assertFalse(this.vuota.hasAttrezzo("abc"));
	}
	
	@Test
	void testAddAttrezzo() {
		assertTrue(this.vuota.addAttrezzo(osso));
	}
	
	@Test
	void testAddAttrezzo2() {
		for(int i=0; i<10; i++)
			this.vuota.addAttrezzo(osso);
		assertFalse(this.vuota.addAttrezzo(osso));
	}
	
	@Test
	void testAddAttrezzo3() {
		this.vuota.addAttrezzo(lanterna);
		assertTrue(this.vuota.addAttrezzo(osso));
	}
	
	@Test
	void testRemoveAttrezzo() {
		this.vuota.addAttrezzo(osso);
		assertTrue(this.vuota.removeAttrezzo(osso));
	}
	
	@Test
	void testRemoveAttrezzo2() {
		assertFalse(this.vuota.removeAttrezzo(osso));
	}
	
	@Test
	void testRemoveAttrezzo3() {
		this.vuota.addAttrezzo(osso);
		assertFalse(this.vuota.removeAttrezzo(lanterna));
	}
	
	@Test
	void testRemoveAttrezzo4() {
		this.vuota.addAttrezzo(osso);
		this.vuota.removeAttrezzo(lanterna);
		assertFalse(this.vuota.removeAttrezzo(lanterna));
	}
	
	@Test
	void testRemoveAttrezzo5() {
		this.vuota.addAttrezzo(osso);
		this.vuota.removeAttrezzo(lanterna);
		assertFalse(this.vuota.removeAttrezzo(null));
	}
	

}
