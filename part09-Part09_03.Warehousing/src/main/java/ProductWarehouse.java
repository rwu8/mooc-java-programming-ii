public class ProductWarehouse extends Warehouse {
	private String productName;

	public ProductWarehouse(String productName, double capacity) {
		super(capacity);
		this.productName = productName;
	}

	public String getName() {
		return this.productName;
	}

	public void setName(String newName) {
		this.productName = newName;
	}

	public String toString() {
		// Juice: balance = 64.5, space left 123.5
		return this.productName + ": balance = " + super.getBalance() + ", space left " + super.howMuchSpaceLeft();
	}
}
