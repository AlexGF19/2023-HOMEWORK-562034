package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	private IO io;
	private String nomeComando = null;
	private String parametro = null;
	
	public FabbricaDiComandiFisarmonica(IO io) {
		this.io = io;
	}
	
		
	public String getNomeComando() {
		return nomeComando;
	}


	public String getParametro() {
		return parametro;
	}



	@Override
	public AbstractComando costruisciComando(String istruzione) {
		
		Scanner scannerDiParole = new Scanner(istruzione);
		
		AbstractComando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale param.

		if (nomeComando == null) 
			comando = new ComandoNonValido(nomeComando);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(this.io);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(this.io);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(this.io);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(this.io);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(this.io);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(this.io);
		else { comando = new ComandoNonValido(this.io);
				comando.setParametro(nomeComando);
			}
		comando.setParametro(parametro);

		return comando;
	}
	
}
