package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private String nomeComando;
	private IO io;
	
	public ComandoNonValido(IO io, String comando) {
		this.io = io;
		this.nomeComando = comando;
	}
	
	public ComandoNonValido(String comando) {
		this.nomeComando = comando;
	}
	
	@Override
	public void esegui(Partita partita) {
		if(this.nomeComando!=null)
			this.io.mostraMessaggio("Comando sconosciuto!");
	}

	@Override
	public void setParametro(String parametro) {
	}

}
