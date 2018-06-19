package br.com.ia.geneticalgorithms.algorithms;

import java.util.ArrayList;
import java.util.Random;

import br.com.ia.geneticalgorithms.entity.Individuo;

public class Algoritimo {

	
	public static ArrayList<Individuo> crossover(ArrayList<Individuo> individuos) {

		Random r = new Random();

		int pontoCorte1 = r.nextInt((individuos.get(r.nextInt(21)).getCromossomo().length / 2) - 2) + 1;
		int pontoCorte2 = r.nextInt((individuos.get(r.nextInt(21)).getCromossomo().length / 2) - 2)
				+ individuos.get(r.nextInt(21)).getCromossomo().length / 2;

		ArrayList<Individuo> filhos = new ArrayList<>();

		for (int i = 0; i < individuos.size(); i++) {

			filhos.add(individuos.get(i));
		}

		filhos.subList(pontoCorte1, pontoCorte2);

		return filhos;
	}

	

}
