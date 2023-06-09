package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String chiave;
	private String direzioneBloccata;
	
	public StanzaBloccata(String nome, String chiave, String direzioneBloccata) {
		super(nome);
		this.chiave=chiave;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata) && !(this.hasAttrezzo(chiave)))
			return this;
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String s = "\nNon puoi andare verso " + this.direzioneBloccata + ", la porta è bloccata!\n";
		String ss = "Ti serve posare :*" + this.chiave + "* per poterla aprire.";
		return super.getDescrizione() + s + ss ;
	}
}
