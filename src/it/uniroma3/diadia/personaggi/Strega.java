package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	private static final String MESSAGGIO_POSITIVO = "Mi stai simpatico, ti mandero' nella stanza adiacente con più attrezzi!";
	private static final String MESSAGGIO_NEGATIVO = "Senza neanche salutare!!!, ti mandero' nella stanza adiacente con meno attrezzi!";
	private static final String MESSAGGIO_REGALO= "AHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAAHAHA";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		
		List<Stanza> l = new ArrayList<Stanza>( partita.getStanzaCorrente().getStanzeAdiacenti().values());
		Stanza stanza = l.get(0);
		
		if(this.haSalutato()) {
			for(Stanza s : l) {
				if(s.getNumeroAttrezzi()>stanza.getNumeroAttrezzi())
					stanza=s;
			}
			return MESSAGGIO_POSITIVO;
		}
		else {
			for(Stanza s : l) {
				if(s.getNumeroAttrezzi()<stanza.getNumeroAttrezzi())
					stanza=s;
			}
			return MESSAGGIO_NEGATIVO;
		}
	}



	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_REGALO;
	}
	
	
}
