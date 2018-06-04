package br.com.ia.geneticalgorithms.algorithms;
import br.com.ia.geneticalgorithms.entity.Individuo;
import br.com.ia.geneticalgorithms.função.Frac;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Roleta {
	
	private double tamanho;
	private List<Individuo> list;
	private List<Frac> fractions;
	private Random random;
	private double partition;
	
	
	private void setFractions(List<Individuo> individuals) {
		individuals
		.stream()
		.forEach(x -> fractions.add(new Frac(x)));

		setPartitionValues();
	}	
	
	private void setPartitionValues() {
		fractions
		.stream()
		.map(x -> {
			double operation = (partition * x.getindividuo().getFitness())/tamanho;
			x.setparte(operation);
			return x;
		})
		.forEach(x -> x.getClass());

		revertPartitionValues();
	}

	private void revertPartitionValues() {
		Object[] aux  = 
				fractions.stream()
				.mapToDouble(x -> x.getparte())
				.boxed()
				.sorted((x1, x2) -> Double.compare(x2, x1))
				.collect(Collectors.toList())
				.toArray();
				
		

		double d;

		for (int i = 0; i < aux.length; i++) {
			d = Double.parseDouble(String.valueOf(aux[i]));
			fractions.get(i).setparte(d);
		}		
	}
	
	private void removeOfRoulette(List<Frac> aux, int i) {
		Frac f = fractions.remove(i);
		fractions = new ArrayList<>();
		list.remove(f.getindividuo());
		aux.add(f);
		setLists(list);
	}	
	
	private void setLists(List<Individuo> list) {
		this.list = list;
		this.tamanho = list.stream()
				.mapToDouble(x -> x.getFitness()).sum();
		setFractions(list);
	}
	
	
	public Roleta(List<Individuo> list) {
		this.fractions = new ArrayList<Frac>();
		this.random = new Random();
		this.partition = 100;

		list = list
				.stream()
				.sorted((x1, x2) -> Double.compare(x1.getFitness(), x2.getFitness()))
				.collect(Collectors.toList());
		setLists(list);
	}
	
	
	
	public List<Individuo> rodar() {
		List<Frac> aux = new ArrayList<Frac>();
		double s = 0;
		double r = 100 * this.random.nextDouble();

		for (int i = 0; i < list.size(); i++) {
			s += fractions.get(i).getparte();
			if(s >= r) {
				removeOfRoulette(aux, i);
				i = -1;
				r = 100 * this.random.nextDouble();
				s = 0;
			}
		}

		aux
		.stream()
		.forEach(x -> list.add(x.getindividuo()));

		return list;
	}
	

}
