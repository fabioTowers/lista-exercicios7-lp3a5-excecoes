package exercicio3;

public class Product {
	private String description;
	private Integer availableQuantity;
	
	public Product(String description, Integer availableQuantity) {
		super();
		this.description = description;
		this.availableQuantity = availableQuantity;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
}
