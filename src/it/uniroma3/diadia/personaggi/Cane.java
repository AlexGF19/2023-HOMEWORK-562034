package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	public static final int DANNO_MORSO_CANE = 4;
	public static final String MESSAGGIO_MORSO = "Woff...WOFF..WOFF" + "/n Sei stato morso e hai perso " + DANNO_MORSO_CANE + " cfu!";
	public static final String MESSAGGIO_CIBO_PREFERITO = "*E' il suo cibo preferito :)*";
	
	private String ciboPreferito;
	
	public Cane(String nome, String presentaz, String ciboPreferito) {
		super(nome, presentaz);
		this.ciboPreferito= ciboPreferito; 	
	}

	@Override
	public String agisci(Partita partita) {
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu-DANNO_MORSO_CANE);
		return MESSAGGIO_MORSO;
	}



	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome()==this.ciboPreferito)
			return MESSAGGIO_CIBO_PREFERITO;
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		return "Woff...!";
	}

}
