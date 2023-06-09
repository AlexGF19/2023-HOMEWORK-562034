package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	protected IO io;
	protected String parametro;

	/**
	 * set parametro del comando
	 */
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}
	
	public void setIO(IO io) {
		this.io=io;
	}
	
	
	public abstract void esegui(Partita partita);
}
