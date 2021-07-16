package exercicio3;

public class PurchaseOrder {
	private String productDescription;
	private Integer quantity;
	
	public PurchaseOrder(String productDescription, Integer quantity) {
		super();
		this.productDescription = productDescription;
		this.quantity = quantity;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
