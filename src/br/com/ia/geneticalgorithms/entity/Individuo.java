package br.com.ia.geneticalgorithms.entity;

import br.com.ia.geneticalgorithms.funcao.Funcoes;
import br.com.ia.geneticalgorithms.util.ValorDados;

public class Individuo {

	private double[] cromossomo;
	private int fitness;
	private int idade;
	private Funcoes funcao;

	public Individuo(Funcoes funcao) {
	
		this.cromossomo = new double[20];
		this.funcao = funcao;
		iniciarCromossomo();
		iniciarFitness();
		idade = 0;
		
	}
	
	public Individuo(Individuo individuo) {
				setValorIndividuo(individuo);
				normaliarCromossomo();
	}
	

		
	private void setValorIndividuo(Individuo individuo) {
		this.cromossomo = individuo.cromossomo;
		this.fitness = individuo.fitness;
		this.idade = individuo.idade;
		this.funcao = individuo.funcao;		
	}
	
		
	private void iniciarCromossomo() {
		for (int i = 0; i < cromossomo.length; i++) {
			cromossomo[i] = ValorDados.inicialValue(funcao);
		}
	}

	private void iniciarFitness() {
		for (double d : cromossomo) {
			fitness += Math.pow( d, 2);
		}
	}

	private void normaliarCromossomo() {
		for (int i = 0; i < cromossomo.length; i++) {
			cromossomo[i] = ValorDados.normalizar(cromossomo[i], funcao);
		}
	}
	
	
	public double[] getCromossomo() {
		return cromossomo;
	}

	public void setCromossomo(double[] cromossomo) {
		this.cromossomo = cromossomo;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public int getidade() {
		return idade;
	}

	public void setidade(int idade) {
		this.idade = idade;
	}
}