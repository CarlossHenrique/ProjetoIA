package br.com.ia.geneticalgorithms.entity;

import java.util.ArrayList;
import java.util.Comparator;

public class Populacao implements Comparable<Individuo> {

	private ArrayList<Individuo> individuos;

	public Populacao(ArrayList<Individuo> individuos) {
	}

	@SuppressWarnings("unchecked")
	public void ordenaPopulacao() {
		getIndividuos().sort((Comparator<? super Individuo>) individuos);
	}

	public ArrayList<Individuo> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(ArrayList<Individuo> individuos) {
		this.individuos = individuos;
	}

	@Override
	public int compareTo(Individuo individuos) {
		return individuos.getFitness();
	}
}