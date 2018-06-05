package br.com.ia.geneticalgorithms.funcao;

public class Esfera implements Funcoes {

	@Override
	public int maximoIncial() {
		return 100;
	}

	@Override
	public int minimoInicial() {
		return 50;
	}

	@Override
	public int execucaoMaxima() {
		return 100;
	}

	@Override
	public int execucaoMinima() {
		return -100;
	}

}
