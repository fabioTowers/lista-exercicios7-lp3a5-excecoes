package exercicio1;

/*1. Utilizando throw, throws, try, catch e finally, crie uma classe que contenha um
método para capturar as exceções e imprima as mensagens por meio do tratamento
das exceções ArithmeticException e NumberFormatException: 

	a) Na classe principal solicite a digitação de dois números pelo usuário;
	
	b) Se o valor digitado for negativo, apresente a mensagem “Erro: argumento 
negativo”;

	c) Se o valor digitado for maior que 1000 apresente a mensagem “Erro: digite um 
valor menor que 1000”;

	d) Simule a divisão dos 2 valores e trate a exceção ArithmeticException, para 
quando o denominador for 0;

	e) Crie um bloco catch que capture qualquer outra possível exceção de modo 
genérico diferente das solicitadas utilizando a classe Exception;

	f) Use Finally para imprimir uma mensagem de fim de execução: “Finalizada a
execução”. */

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		Integer numA;
		Integer numB;

		Scanner in = new Scanner(System.in);

		try {
			System.out.print("Digite o primeiro número: ");
			numA = in.nextInt();
			if(numA < 0)
				throw new IllegalArgumentException("Erro: argumento negativo");
			else if (numA > 1000)
				throw new IllegalArgumentException("Erro: digite um valor menor que 1000");
			
			System.out.print("Digite o segundo número: ");
			numB = in.nextInt();
			if(numB < 0)
				throw new IllegalArgumentException("Erro: argumento negativo");
			else if (numB > 1000)
				throw new IllegalArgumentException("Erro: digite um valor menor que 1000");
			
			divisao(numA, numB);
			
		} catch (ArithmeticException e) {
			System.out.println("Erro: não é possível dividir por zero.");
		} catch (Exception e) {
			System.out.println("Entrada inválida");
		} finally {
			in.close();
			System.out.println("Finalizada a execução");
		}

		in.close();
	}
	
	public static float divisao(int numerador, int denominador) throws ArithmeticException{
		return numerador / denominador;
	}

}
