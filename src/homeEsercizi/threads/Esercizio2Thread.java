package homeEsercizi.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio2Thread extends Thread {
	Logger console = LoggerFactory.getLogger(Esercizio2Thread.class);

	private int[] numeriArray;
	private int risultato = 0;

	public Esercizio2Thread(int[] numeri) {
		this.numeriArray = numeri;
	}

	public int[] getNumeriArray() {
		return numeriArray;
	}

	public void setNumeriArray(int[] numeriArray) {
		this.numeriArray = numeriArray;
	}

	public int getRisultato() {
		return risultato;
	}

	public void setRisultato(int risultato) {
		this.risultato = risultato;
	}

	@Override
	public void run() {
		for (int i = 0; i < getNumeriArray().length; i++) {
			setRisultato(getRisultato() + getNumeriArray()[i]);
		}
	}
}
