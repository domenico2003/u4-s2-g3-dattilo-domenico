package homeEsercizi;

import homeEsercizi.threads.Esercizio1Thread;

public class Esercizio1 {

	public static void main(String[] args) {
		Thread first = new Esercizio1Thread("*");
		Thread second = new Esercizio1Thread("#");

		first.setName("FIRST");
		second.setName("SECOND");

		first.start();
		second.start();
	}

}
