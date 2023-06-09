package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	Partita partita;
	ComandoVai cvai;

	@BeforeEach
	 void setUp() {
		LabirintoBuilder l = new LabirintoBuilder();
		l.addStanzaVincente("Biblioteca");
		l.addStanzaIniziale("Atrio");
		l.addStanza("Aula N11");
		l.addStanza("Aula N10");
		l.addStanza("Laboratorio Campus");
		l.addAdiacenza("Atrio", "Biblioteca", "nord");
		l.addAdiacenza("Atrio", "Aula N11", "est");
		l.addAdiacenza("Atrio", "Laboratorio Campus", "ovest");
		l.addAdiacenza("Atrio", "Aula N10", "sud");
		this.partita = new Partita(l.getLabirinto());
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
