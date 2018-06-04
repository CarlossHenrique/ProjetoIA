package br.com.ia.geneticalgorithms.funcao;

public class Esfera implements Fun {

	@Override
	public int initialMax() {
		return 100;
	}

	@Override
	public int initialMin() {
		return 50;
	}

	@Override
	public int executionMax() {
		return 100;
	}

	@Override
	public int executionMin() {
		return -100;
	}

}
