package exercicio3;

public class Client {
	private String name;
	private PurchaseOrder purchase;
	
	public Client(String name, PurchaseOrder purchase) {
		super();
		this.name = name;
		this.purchase = purchase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PurchaseOrder getPurchase() {
		return purchase;
	}

	public void setPurchase(PurchaseOrder purchase) {
		this.purchase = purchase;
	}
}
