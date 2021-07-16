package exercicio2;

/*2. Utilizando try with resource, crie dois arquivos .txt, um com seu nome e outro com 
o seu sobrenome e elabore um programa que leia os dois arquivos e imprima o 
nome completo.*/

import java.io.BufferedReader;
import java.io.FileReader;

public class Exercicio2 {
	
	private static String path = "C:\\Users\\fabio\\Desktop\\";

	public static void main(String[] args) {
		
		try ( BufferedReader nome = new BufferedReader(new FileReader(path+"nome.txt")); BufferedReader sobrenome = new BufferedReader(new FileReader(path+"sobrenome.txt")); ){
			
			String linha = nome.readLine() + " ";
			while (true) {
				if (linha != null) {
					System.out.print(linha);
				} else
					break;
				linha = sobrenome.readLine();
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}
	}

}
