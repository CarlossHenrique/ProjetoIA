package br.com.ia.geneticalgorithms.funcao;

import br.com.ia.geneticalgorithms.entity.Individuo;

public class Frac {

	private Individuo individuo;
	private double parte;
	
	public Frac(Individuo individuo) {
		this.individuo = individuo;
	}
	
	
	@Override
	public String toString() {
		return "Fitness: " + individuo.getFitness() + "\n"
				+ "Por��o: " + parte +"%";
	}

    public Individuo getindividuo() {
        return individuo;
    }

    public void setindividuo(Individuo individuo) {
        this.individuo = individuo;
    }

    public double getparte() {
        return parte;
    }

    public void setparte(double parte) {
        this.parte = parte;
    }


	
}
