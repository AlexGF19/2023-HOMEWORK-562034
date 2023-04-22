package it.uniroma3.diadia.ambienti;



public class StanzaBuia extends Stanza{
	
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoLuminoso=attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoLuminoso))
			return super.getDescrizione();
		return "qui c'è buio pesto,\nTi serve qualcosa per illuminare la stanza!";
	}
}
