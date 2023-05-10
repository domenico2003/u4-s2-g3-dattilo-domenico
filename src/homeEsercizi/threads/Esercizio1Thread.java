package homeEsercizi.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio1Thread extends Thread {
	Logger console = LoggerFactory.getLogger(Esercizio1Thread.class);
	private String simbolo;

	public Esercizio1Thread(String s) {
		this.simbolo = s;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			console.info(getSimbolo());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//
				console.error(e.getMessage());
			}
		}

	}

	public String getSimbolo() {
		return simbolo;
	}

}
