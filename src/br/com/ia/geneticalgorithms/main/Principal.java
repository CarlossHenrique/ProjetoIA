package br.com.ia.geneticalgorithms.main;
import java.util.Scanner;
import br.com.ia.geneticalgorithms.algorithms.Geneticalgorithms;

public class Principal {


	public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);	

	System.out.println("Digite a cadeia de caracteres:");
	
	String caract = in.nextLine();
	
	System.out.println("Taxa de croosover:");
	
	double taxaDeCrossover=in.nextDouble();
	
	System.out.println("Taxa de mutação:");
	
	double taxaDeMutacao=in.nextDouble();

		
	Geneticalgorithms ga = new Geneticalgorithms();	
	
	
	if(taxaDeCrossover>0&&taxaDeCrossover<=1&& taxaDeMutacao>0&&taxaDeMutacao<=1){
	
		ga.executar(caract, taxaDeCrossover,taxaDeMutacao);
	
	
	}
	
	in.close();
	}



}
