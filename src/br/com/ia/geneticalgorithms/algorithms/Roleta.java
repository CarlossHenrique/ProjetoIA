package br.com.ia.geneticalgorithms.algorithms;

import br.com.ia.geneticalgorithms.entity.Individuo;
import br.com.ia.geneticalgorithms.funcao.Frac;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Roleta {

	private double tamanho;
	private List<Individuo> lista;
	private List<Frac> fracao;
	private Random random;
	private double parte;

	private void setfracao(List<Individuo> individuals) {
		individuals.stream().forEach(x -> fracao.add(new Frac(x)));

		setparteValues();
	}

	private void setparteValues() {
		fracao.stream().map(x -> {
			double operation = (parte * x.getindividuo().getFitness()) / tamanho;
			x.setparte(operation);
			return x;
		}).forEach(x -> x.getClass());

		revertparteValues();
	}

	private void revertparteValues() {
		Object[] aux = fracao.stream().mapToDouble(x -> x.getparte()).boxed().sorted((x1, x2) -> Double.compare(x2, x1))
				.collect(Collectors.toList()).toArray();

		double d;

		for (int i = 0; i < aux.length; i++) {
			d = Double.parseDouble(String.valueOf(aux[i]));
			fracao.get(i).setparte(d);
		}
	}

	private void removeOfRoulette(List<Frac> aux, int i) {
		Frac f = fracao.remove(i);
		fracao = new ArrayList<>();
		lista.remove(f.getindividuo());
		aux.add(f);
		setLists(lista);
	}

	private void setLists(List<Individuo> list) {
		this.lista = list;
		this.tamanho = list.stream().mapToDouble(x -> x.getFitness()).sum();
		setfracao(list);
	}

	public Roleta(List<Individuo> lista) {
		this.fracao = new ArrayList<Frac>();
		this.random = new Random();
		this.parte = 100;

		lista = lista.stream().sorted((x1, x2) -> Double.compare(x1.getFitness(), x2.getFitness()))
				.collect(Collectors.toList());
		setLists(lista);
	}

	public List<Individuo> rodar() {
		List<Frac> aux = new ArrayList<Frac>();
		double s = 0;
		double r = 100 * this.random.nextDouble();

		for (int i = 0; i < lista.size(); i++) {
			s += fracao.get(i).getparte();
			if (s >= r) {
				removeOfRoulette(aux, i);
				i = -1;
				r = 100 * this.random.nextDouble();
				s = 0;
			}
		}

		aux.stream().forEach(x -> lista.add(x.getindividuo()));

		return lista;
	}
}