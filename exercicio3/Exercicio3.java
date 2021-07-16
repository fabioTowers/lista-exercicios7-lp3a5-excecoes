package exercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*3. Elabore um programa Java para um PDV (ponto de venda), no programa o pedido 
deverá conter informações dos itens do pedido e do cliente, outras podem ser 
acrescentadas. O programa deverá possuir no mínimo 3 classes e mais a classe
principal para criação dos objetos. Deve-se executar o tratamento de exceção para 
entrada de dados, também para avisar produtos sem estoque, assim como utilizar 
programação funcional no desenvolvimento do sistema.*/

public class Exercicio3 {

	public static void main(String[] args) {
		
		// Cadastrar produto e quantidade
		String product;
		Integer quantity = 0;
		
		// Entrada de dados
		Scanner in = new Scanner(System.in);
		
		// Nome do produto
		System.out.print("Cadastre um produto: ");
		product = in.next();
		
		// Quantidade disponível
		System.out.print("\nQuantidade de " + product + ": ");
		
		// Dados devem ser numéricos
		try {
			quantity = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Entrada de dados inválida!");
		}
		
		// Instância do estoque
		Storage storage = new Storage();
		
		// Cadastro do produto e quantidade no estoque
		storage.registerProduct(new Product(product, quantity));
		
		// Exibir estoque
		storage.showStorage();
		
		/*Ambos clientes possuem pedido do mesmo produto na mesma quantidade (o total disponível)*/
		Client bob = new Client("Bob", new PurchaseOrder(product, quantity));
		Client ana = new Client("Ana", new PurchaseOrder(product, quantity));
		
		try {
			// Compra a quantidade disponível e zera o estoque
			storage.purchase(bob);
			storage.showStorage();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Não há estoque suficiente!");
		}
		
		try {
			// Tenta comprar, mas o estoque já está sem saldo
			storage.purchase(ana);
			storage.showStorage();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Não há estoque suficiente!");
		}
		
		in.close();
	}

}
