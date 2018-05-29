package br.com.ia.geneticalgorithms.algorithms;

import br.com.ia.geneticalgorithms.entity.Populacao;

public class Geneticalgorithms {

    public void executar(String frase, double taxaDeCrossover, double taxaDeMutacao) {

        Algoritimo.setSolucao(frase);
        Algoritimo.setCaracteres("!,.:;?·¡„√‚¬ı’Ù‘Û”ÈÍ… ÌQWERTYUIOPASDFGHJKL«ZXCVBNMqwertyuiopasdfghjklÁzxcvbnm1234567890 ");
        Algoritimo.setTaxaDeCrossover(taxaDeCrossover);
        Algoritimo.setTaxaDeMutacao(taxaDeMutacao);
        boolean eltismo = true;
        int tamPop = 100;
        int numMaxGeracoes = 10000;
        int numGenes = Algoritimo.getSolucao().length();

        Populacao populacao = new Populacao(numGenes, tamPop);

        boolean temSolucao = false;
        int geracao = 0;

        System.out.println("Iniciando..: "+Algoritimo.getSolucao().length());
        
        while (!temSolucao && geracao < numMaxGeracoes) {
            geracao++;

            populacao = Algoritimo.novaGeracao(populacao, eltismo);

            System.out.println("GeraÁ„o " + geracao + " | Aptid„o: " + populacao.getIndivduo(0).getAptidao() + " | Melhor: " + populacao.getIndivduo(0).getGenes());
            
            temSolucao = populacao.temSolocao(Algoritimo.getSolucao());
        }

        if (geracao == numMaxGeracoes) {
            System.out.println("N˙mero Maximo de GeraÁıes | " + populacao.getIndivduo(0).getGenes() + " " + populacao.getIndivduo(0).getAptidao());
        }

        if (temSolucao) {
            System.out.println("Encontrado resultado na geraÁ„o " + geracao + " | " + populacao.getIndivduo(0).getGenes() + " (Aptid„o: " + populacao.getIndivduo(0).getAptidao() + ")");
        }
    }
}