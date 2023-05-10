package homeEsercizi;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {

	private static File file = new File("registroPresenze.txt");

	public static void main(String[] args) {
		Logger console = LoggerFactory.getLogger(RegistroPresenze.class);

		Scanner in = new Scanner(System.in);

		System.out.println("aggiungi dipendente");
		System.out.println("inserisci il nome");
		String nome = in.nextLine();
		System.out.println("inserisci il numero di presenze ");
		int presenze = in.nextInt();
		in.nextLine();
		writeFile(nome, presenze);

		System.out.println("lista dei dipendenti: ");
		console.info(readFile().toString());

		in.close();
	}

	public static void writeFile(String nome, int giorniPresenze) {

		String dipendente = nome + "@" + giorniPresenze + "#";
		try {
			FileUtils.writeStringToFile(file, dipendente, "UTF-8", true);
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

	public static Map<String, String> readFile() {
		Map<String, String> registro = new HashMap<>();
		String fileLettura = null;
		if (file.exists()) {

			try {
				fileLettura = FileUtils.readFileToString(file, "UTF-8");
			} catch (IOException e) {

				e.printStackTrace();
			}
			String[] dipendenti = fileLettura.split("#");
			for (String dipendente : dipendenti) {
				String[] dipendenteArray = dipendente.split("@");
				registro.put(dipendenteArray[0], dipendenteArray[1]);
			}
		}
		return registro;

	}
}
