package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	Partita partita;
	ComandoVai cvai;

	@BeforeEach
	 void setUp() {
		this.partita = new Partita();
		this.cvai = new ComandoVai(new IOConsole());
	}
	
	@Test
	void testEseguiNord() {
		Stanza stanza= partita.getStanzaCorrente().getStanzaAdiacente("nord");
		cvai.setParametro("nord");
		cvai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiEst() {
		Stanza stanza= partita.getStanzaCorrente().getStanzaAdiacente("est");
		cvai.setParametro("est");
		cvai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiSud() {
		Stanza stanza= partita.getStanzaCorrente().getStanzaAdiacente("sud");
		cvai.setParametro("sud");
		cvai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiOvest() {
		Stanza stanza= partita.getStanzaCorrente().getStanzaAdiacente("ovest");
		cvai.setParametro("ovest");
		cvai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiNessunaDirezione() {
		Stanza stanza= partita.getStanzaCorrente();
		cvai.setParametro("");
		cvai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}
	
	@Test
	void testEseguiDirezioneInesistente() {
		Stanza stanza= partita.getStanzaCorrente();
		cvai.setParametro("direzioneInesistente");
		cvai.esegui(partita);
		assertEquals(stanza, this.partita.getStanzaCorrente());
	}


}
