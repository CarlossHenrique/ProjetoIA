package br.com.ia.geneticalgorithms.util;

import java.util.Random;
import br.com.ia.geneticalgorithms.funcao.Funcoes;

public class ValorDados {

	public static double normalizar(double value, Funcoes f) {
		return f.minimoInicial() + 
				(value * (f.maximoIncial() - f.minimoInicial()));
	
	}
	
	public static double inicialValue(Funcoes f) {
		Random r = new Random();
		double value = r.nextDouble();
		return normalizar(value, f);
	}

		
	
	
}
