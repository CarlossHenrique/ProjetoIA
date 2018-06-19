package br.com.ia.geneticalgorithms.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.ia.geneticalgorithms.entity.Individuo;

public class CrossOver {

	private Random r;
	private List<Individuo> Individuos;

	public CrossOver(List<Individuo> Individuos) { 
		r = new Random();
		this.Individuos = Individuos;
	}


	public List<Individuo> crossingIndividuos(){
		int crossOverIndex = r.nextInt(Individuos.size());
		List<Individuo> aux = new ArrayList<>();

		for (int i = 0; i < Individuos.size(); i++) {
			if(i != crossOverIndex){
				Individuo[] ind = 
						crossing(Individuos.get(i), Individuos.get(crossOverIndex)); 
				aux.add(ind[0]);
				aux.add(ind[1]);
				crossOverIndex = r.nextInt(Individuos.size());
			}else{
				i--;
				crossOverIndex = r.nextInt(Individuos.size());
			}
		}

		aux.forEach(x -> Individuos.add(x));

		return Individuos;
	}

	private Individuo[] crossing(Individuo Individuo1, Individuo Individuo2) {
		int length = Individuo1.getCromossomo().length;
		int cutOff = r.nextInt(length);

		Individuo[] aux = {new Individuo(Individuo1), new Individuo(Individuo2)};
		double[] chromosome1 = Individuo1.getCromossomo();
		double[] chromosome2 = Individuo2.getCromossomo();

		chromosome1 =
				crossingArray(cutOff, Individuo1.getCromossomo(), 
						Individuo2.getCromossomo());
		chromosome2 = 
				crossingArray(cutOff, Individuo2.getCromossomo(), 
						Individuo1.getCromossomo());

		aux[0].setCromossomo(chromosome1);
		aux[1].setCromossomo(chromosome2);

		return aux;
	}


	private double[] crossingArray(int cutOff, double[] chromosome1, double[] chromosome2) {
		double[] aux = new double[chromosome1.length];

		for (int i = 0; i < aux.length; i++) {
			if(i < cutOff){
				aux[i] = chromosome1[i];
			}else{
				aux[i] = chromosome2[i];
			}
		}
		return aux;
	}
}