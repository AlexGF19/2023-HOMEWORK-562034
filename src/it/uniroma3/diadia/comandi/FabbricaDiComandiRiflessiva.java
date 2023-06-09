package it.uniroma3.diadia.comandi;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	private IO io;

	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;
	}



	@Override
	public AbstractComando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null; 
		String parametro = null;
		AbstractComando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro

		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
			nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
			nomeClasse += nomeComando.substring(1);
			
			comando = (AbstractComando)Class.forName(nomeClasse).getDeclaredConstructor().newInstance();
			comando.setIO(this.io);
			comando.setParametro(parametro);
		}
		catch (Exception e) { 
			comando = new ComandoNonValido();
			this.io.mostraMessaggio("Comando inesistente");
			this.io.mostraMessaggio(e.getMessage());
		}
		return comando;
	} 
}