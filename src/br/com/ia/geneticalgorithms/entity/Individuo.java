package br.com.ia.geneticalgorithms.entity;

import br.com.ia.geneticalgorithms.funcao.Fun;
import br.com.ia.geneticalgorithms.util.ValorDados;

public class Individuo {

	private double[] cromossomo;
	private int fitness;
	private int idade;
	private Fun funcao;

	public Individuo(Fun funcao) {
		this.funcao = funcao;
		inicializarChromossomo();
		inicializarFitness();
		idade = 0;
	}

	private void inicializarChromossomo() {
		for (int i = 0; i < cromossomo.length; i++) {
			cromossomo[i] = ValorDados.inicialValue(this.funcao);
		}
	}

	private void inicializarFitness() {
		for (double d : cromossomo) {
			fitness += Math.pow(d, 2);
		}
	}

	public double[] getChromosome() {
		return cromossomo;
	}

	public void setChromosome(double[] chromosome) {
		this.cromossomo = chromosome;
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