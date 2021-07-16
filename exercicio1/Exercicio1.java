package exercicio1;

/*1. Utilizando throw, throws, try, catch e finally, crie uma classe que contenha um
m�todo para capturar as exce��es e imprima as mensagens por meio do tratamento
das exce��es ArithmeticException e NumberFormatException: 

	a) Na classe principal solicite a digita��o de dois n�meros pelo usu�rio;
	
	b) Se o valor digitado for negativo, apresente a mensagem �Erro: argumento 
negativo�;

	c) Se o valor digitado for maior que 1000 apresente a mensagem �Erro: digite um 
valor menor que 1000�;

	d) Simule a divis�o dos 2 valores e trate a exce��o ArithmeticException, para 
quando o denominador for 0;

	e) Crie um bloco catch que capture qualquer outra poss�vel exce��o de modo 
gen�rico diferente das solicitadas utilizando a classe Exception;

	f) Use Finally para imprimir uma mensagem de fim de execu��o: �Finalizada a
execu��o�. */

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		Integer numA;
		Integer numB;

		Scanner in = new Scanner(System.in);

		try {
			System.out.print("Digite o primeiro n�mero: ");
			numA = in.nextInt();
			if(numA < 0)
				throw new IllegalArgumentException("Erro: argumento negativo");
			else if (numA > 1000)
				throw new IllegalArgumentException("Erro: digite um valor menor que 1000");
			
			System.out.print("Digite o segundo n�mero: ");
			numB = in.nextInt();
			if(numB < 0)
				throw new IllegalArgumentException("Erro: argumento negativo");
			else if (numB > 1000)
				throw new IllegalArgumentException("Erro: digite um valor menor que 1000");
			
			divisao(numA, numB);
			
		} catch (ArithmeticException e) {
			System.out.println("Erro: n�o � poss�vel dividir por zero.");
		} catch (Exception e) {
			System.out.println("Entrada inv�lida");
		} finally {
			in.close();
			System.out.println("Finalizada a execu��o");
		}

		in.close();
	}
	
	public static float divisao(int numerador, int denominador) throws ArithmeticException{
		return numerador / denominador;
	}

}
