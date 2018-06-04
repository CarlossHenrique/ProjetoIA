package br.com.ia.geneticalgorithms.util;

import java.util.Random;

import br.com.ia.geneticalgorithms.funcao.Fun;

public class ValorDados {

	public static double inicialValue(Fun f) {
		Random r = new Random();
		double value = r.nextDouble();
		return normalizar(value, f);
	}

	private static double normalizar(double value, Fun f) {
		return f.initialMin() + 
				(value * (f.initialMax() - f.initialMin()));
	}	
	
	
}
