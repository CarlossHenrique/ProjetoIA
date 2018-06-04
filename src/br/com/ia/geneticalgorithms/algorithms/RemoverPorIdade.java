package br.com.ia.geneticalgorithms.algorithms;

import java.util.List;
import br.com.ia.geneticalgorithms.entity.Individuo;

public class RemoverPorIdade {
	
	
	private int ageParameter;
	private List<Individuo> indivudals;
	
	public List<Individuo> removeOlderIndividuals(){
		indivudals.removeIf(x -> x.getidade() == ageParameter);
		return indivudals;
	}

}
