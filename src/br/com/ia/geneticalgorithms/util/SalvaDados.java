package br.com.ia.geneticalgorithms.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SalvaDados {

	public void salvar(String experimento) throws Exception {

		File file = new File("/", experimento + ".txt");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(experimento);

		} catch (Exception ex) {
			throw new Exception();
		} finally {
			if (oos != null) {
				try {
					oos.flush();
					oos.close();
				} catch (IOException ex) {
					throw new IOException();
				}
			}
		}
	}

}
