package br.com.ia.geneticalgorithms.main;
import java.util.Scanner;
import br.com.ia.geneticalgorithms.algorithms.Geneticalgorithms;

public class Principal {

	// não estou criar uma variavél para a cadeia de caracteres sem dar 
	//um erro, por isso as cadeias tem que ser alteradas manualmente

	public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);	

	System.out.println("Taxa de croosover:");
	
	double taxaDeCrossover=in.nextDouble();
	
	System.out.println("Taxa de mutação:");
	
	double taxaDeMutacao=in.nextDouble();

		
	Geneticalgorithms ga = new Geneticalgorithms();	
	
	
	if(taxaDeCrossover>0&&taxaDeCrossover<=1&& taxaDeMutacao>0&&taxaDeMutacao<=1){
	
		// o primeiro parametro representa a cadeia de caracteres.
		ga.executar("o pelo do pé de pedro é preto", taxaDeCrossover,taxaDeMutacao);
	
	
	}
	
	in.close();
	}



}
