package exercicio3;

import java.util.ArrayList;
import java.util.Optional;

public class Storage {
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void registerProduct (Product newProduct) {
		products.add(newProduct);
	}
	
	public void removeProduct (Product product) {
		products.remove(product);
	}
	
	// Exibe todos os produtos em estoque e quantidades
	public void showStorage() {
		products.stream().forEach(p -> System.out.println("[" + p.getAvailableQuantity() + "] Produto: " + p.getDescription()));
	}
	
	// Efetua a compra relacionada ao pedido de compra do cliente 
	public void purchase(Client client) {
		
		/*Quantidade de produtos que correspondem ao produto no pedido do cliente E que 
		 * possuem quantidade maior ou igual à solicitada no pedido de compra do cliente
		 * */
		Long quantity = products.stream()
				.filter(
							p -> (p.getAvailableQuantity() >= client.getPurchase().getQuantity() && p.getDescription().equalsIgnoreCase(client.getPurchase().getProductDescription())) 
						)
				.count();
		
		// Se não há nenhum produto que satisfaça as condições lança a exceção
		if(quantity <= 0)
			throw new IndexOutOfBoundsException("Não há produtos na quantidade adequada.");
		
		// Encontra na lista o produto que corresponde ao do pedido do cliente
		Optional<Product> match = products.stream()
				.filter(p -> p.getDescription().equalsIgnoreCase(client.getPurchase().getProductDescription()))
				.findFirst();
		
		// Desconta no estoque os produtos comprados pelo cliente
		products.get(products.indexOf(match.get())).setAvailableQuantity(match.get().getAvailableQuantity() - client.getPurchase().getQuantity());
		
		// Limpa o pedido do cliente
		client.getPurchase().setQuantity(0);
		client.getPurchase().setProductDescription("");
	}
}
