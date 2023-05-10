package homeEsercizi;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import homeEsercizi.threads.Esercizio2Thread;

public class Esercizio2 {

	public static void main(String[] args) {
		Logger console = LoggerFactory.getLogger(Esercizio2.class);
		Random generatore = new Random();

		int[] arrayNumeri = new int[3000];
		int[] firstArrayNumeri = new int[1000];
		int[] secondArrayNumeri = new int[1000];
		int[] thirdArrayNumeri = new int[1000];

		for (int i = 0; i < arrayNumeri.length; i++) {
			int d = 1 + generatore.nextInt(100);
			arrayNumeri[i] = d;
		}
		int index1 = 0;
		int index2 = 0;

		for (int i = 0; i < arrayNumeri.length; i++) {
			if (i < 1000) {
				firstArrayNumeri[i] = arrayNumeri[i];
			} else if (i >= 1000 && i < 2000) {

				secondArrayNumeri[index1] = arrayNumeri[i];
				index1++;
			} else {

				thirdArrayNumeri[index2] = arrayNumeri[i];
				index2++;
			}
		}

		Esercizio2Thread first = new Esercizio2Thread(firstArrayNumeri);
		Esercizio2Thread second = new Esercizio2Thread(secondArrayNumeri);
		Esercizio2Thread third = new Esercizio2Thread(thirdArrayNumeri);

		first.start();
		second.start();
		third.start();

		try {
			first.join();
			second.join();
			third.join();
		} catch (InterruptedException e) {
			console.error(e.getMessage());
		}

		int risultatoComplessivo = first.getRisultato() + second.getRisultato() + third.getRisultato();

		console.info("array: " + Arrays.toString(arrayNumeri));
		System.out.println();
		System.out.println(
				"*****************************************************************************************************");
		System.out.println();
		console.info("primo array: " + Arrays.toString(firstArrayNumeri));
		System.out.println();
		console.info("primo risultato: " + first.getRisultato());
		System.out.println();
		System.out.println(
				"*****************************************************************************************************");
		System.out.println();
		console.info("secondo array: " + Arrays.toString(secondArrayNumeri));
		System.out.println();
		console.info("secondo risultato: " + second.getRisultato());
		System.out.println();
		System.out.println(
				"*****************************************************************************************************");
		System.out.println();
		console.info("terzo array: " + Arrays.toString(thirdArrayNumeri));
		System.out.println();
		console.info("terzo risultato: " + third.getRisultato());
		System.out.println();
		System.out.println(
				"*****************************************************************************************************");
		System.out.println();
		console.info("totale: " + risultatoComplessivo);
	}

}
