package br.com.ia.geneticalgorithms.entity;

import java.util.Random;

import br.com.ia.geneticalgorithms.algorithms.Algoritimo;

public class Individuo {

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
}
