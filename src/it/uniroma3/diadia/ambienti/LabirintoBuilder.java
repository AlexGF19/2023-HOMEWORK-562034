package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder  {
	
	private Labirinto labirirnto;
	private Stanza stanzaCorrente;
	private Map<String, Stanza> stanze;
	
	public LabirintoBuilder() {
		this.labirirnto = new Labirinto();
		this.stanzaCorrente = null;
		this.stanze = new HashMap<String, Stanza>();
	}
	
	public Labirinto getLabirinto() {
		return this.labirirnto;
	}
	
	public void addStanza(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.stanzaCorrente = s;
		this.stanze.put(nomeStanza, s);
	}
	
	public void addStanzaMagica(String nomeStanza) {
		Stanza s = new StanzaMagica(nomeStanza);
		this.stanzaCorrente = s;
		this.stanze.put(nomeStanza, s);
	}
	
	public void addStanzaBloccata(String nomeStanza, String chiave, String direzione) {
		Stanza s = new StanzaBloccata(nomeStanza, chiave, direzione);
		this.stanzaCorrente = s;
		this.stanze.put(nomeStanza, s);
	}
	
	public void addStanzaBuia(String nomeStanza, String attrezzo) {
		Stanza s = new StanzaBuia(nomeStanza, attrezzo);
		this.stanzaCorrente = s;
		this.stanze.put(nomeStanza, s);
	}
	
	public void addStanzaVincente(String vincente) {
		Stanza s = new Stanza(vincente);
		this.labirirnto.setStanzaVincente(s);
		this.stanzaCorrente = s;
		this.stanze.put(vincente, s);
	}
	
	public void addStanzaIniziale(String iniziale) {
		Stanza s = new Stanza(iniziale);
		this.labirirnto.setStanzaIniziale(s);
		this.stanzaCorrente = s;
		this.stanze.put(iniziale, s);
	}
	
	public void addAdiacenza(String stanza1, String stanza2, String direzione) {
		Stanza s1 = this.stanze.get(stanza1);
		Stanza s2 = this.stanze.get(stanza2);
		if(s1!=null && s2!=null) 
			s1.impostaStanzaAdiacente(direzione, s2);
	}
	
	public void addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
		if(this.stanzaCorrente!=null)
			this.stanzaCorrente.addAttrezzo(a);
	}
}
