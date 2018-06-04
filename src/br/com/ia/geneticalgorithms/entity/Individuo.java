package br.com.ia.geneticalgorithms.entity;

import java.util.Random;
import br.com.ia.geneticalgorithms.algorithms.Algoritimo;
import br.com.ia.geneticalgorithms.função.Fun;
import br.com.ia.geneticalgorithms.util.ValorDados;

public class Individuo {

	
	private double[] chromosome;
	private double fitness;
	private int idade;
	private Fun function;
    private String genes = "";
    private int aptidao = 0;

    public Individuo(int numGenes) {
        genes = "";
        Random r = new Random();
        
        String caracteres = Algoritimo.getCaracteres();
        
        for (int i = 0; i < numGenes; i++) {
            genes += caracteres.charAt(r.nextInt(caracteres.length()));
        }
        
        geraAptidao();        
    }

    public Individuo(String genes) {    
        this.genes = genes;
        
        Random r = new Random();
        if (r.nextDouble() <= Algoritimo.getTaxaDeMutacao()) {
            String caracteres = Algoritimo.getCaracteres();
            String geneNovo="";
            int posAleatoria = r.nextInt(genes.length());
            for (int i = 0; i < genes.length(); i++) {
                if (i==posAleatoria){
                    geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
                }else{
                    geneNovo += genes.charAt(i);
                }
                
            }
            this.genes = geneNovo;   
        }
        geraAptidao();
    }
    
    
    public Individuo(Fun function, double[] array) {
		this.chromosome = new double[20];
		this.function = function;
		inicializarChromossomo();
		inicializarFitness();
		idade = 0;
		chromosome = array;
	}
    
	private void inicializarChromossomo() {
		for (int i = 0; i < chromosome.length; i++) {
			chromosome[i] = ValorDados.inicialValue(this.function);			
		}	
	}

	
	private void inicializarFitness() {
		for(double d : chromosome) {
			fitness += Math.pow(d, 2);
		}		
	}

    private void geraAptidao() {
        String solucao = Algoritimo.getSolucao();
        for (int i = 0; i < solucao.length(); i++) {
            if (solucao.charAt(i) == genes.charAt(i)) {
                aptidao++;
            }
        }
    }

    public int getAptidao() {
        return aptidao;
    }

    public String getGenes() {
        return genes;
    }

	public double[] getChromosome() {
		return chromosome;
	}

	public void setChromosome(double[] chromosome) {
		this.chromosome = chromosome;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public int getidade() {
		return idade;
	}

	public void setidade(int idade) {
		this.idade = idade;
	}

	
	public void setGenes(String genes) {
		this.genes = genes;
	}

	public void setAptidao(int aptidao) {
		this.aptidao = aptidao;
	}
    
    
}
