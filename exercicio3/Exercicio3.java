package exercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*3. Elabore um programa Java para um PDV (ponto de venda), no programa o pedido 
dever� conter informa��es dos itens do pedido e do cliente, outras podem ser 
acrescentadas. O programa dever� possuir no m�nimo 3 classes e mais a classe
principal para cria��o dos objetos. Deve-se executar o tratamento de exce��o para 
entrada de dados, tamb�m para avisar produtos sem estoque, assim como utilizar 
programa��o funcional no desenvolvimento do sistema.*/

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
		
		// Quantidade dispon�vel
		System.out.print("\nQuantidade de " + product + ": ");
		
		// Dados devem ser num�ricos
		try {
			quantity = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Entrada de dados inv�lida!");
		}
		
		// Inst�ncia do estoque
		Storage storage = new Storage();
		
		// Cadastro do produto e quantidade no estoque
		storage.registerProduct(new Product(product, quantity));
		
		// Exibir estoque
		storage.showStorage();
		
		/*Ambos clientes possuem pedido do mesmo produto na mesma quantidade (o total dispon�vel)*/
		Client bob = new Client("Bob", new PurchaseOrder(product, quantity));
		Client ana = new Client("Ana", new PurchaseOrder(product, quantity));
		
		try {
			// Compra a quantidade dispon�vel e zera o estoque
			storage.purchase(bob);
			storage.showStorage();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("N�o h� estoque suficiente!");
		}
		
		try {
			// Tenta comprar, mas o estoque j� est� sem saldo
			storage.purchase(ana);
			storage.showStorage();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("N�o h� estoque suficiente!");
		}
		
		in.close();
	}

}
