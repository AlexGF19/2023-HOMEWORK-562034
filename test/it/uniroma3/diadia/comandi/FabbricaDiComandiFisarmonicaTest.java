package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabrica;
	
	@BeforeEach
	void setUp() {
		this.fabrica = new FabbricaDiComandiFisarmonica(new IOConsole());
	}
	@Test
	void testCostruisciComando() {
		this.fabrica.costruisciComando("vai sud");
		assertEquals("vai", this.fabrica.getNomeComando());
		assertEquals("sud", this.fabrica.getParametro());
	}

	@Test
	void testCostruisciComandoParametroNull() {
		this.fabrica.costruisciComando("vai");
		assertEquals("vai", this.fabrica.getNomeComando());
		assertNull(this.fabrica.getParametro());
	}
	
	@Test
	void testCostruisciComandoComandoEParametroNull() {
		this.fabrica.costruisciComando("");
		assertNull(this.fabrica.getNomeComando());
		assertNull(this.fabrica.getParametro());
	}
}
