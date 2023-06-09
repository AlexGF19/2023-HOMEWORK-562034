package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	public ComandoNonValido() {
	}
	
	public ComandoNonValido(String comando) {
		this.parametro = comando;
	}
	
	public ComandoNonValido(IO io) {
		this.io=io;	}

	@Override
	public void esegui(Partita partita) {
		if(this.parametro!=null)
			this.io.mostraMessaggio("Comando sconosciuto!");
	}

}
