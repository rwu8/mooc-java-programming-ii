import java.util.Objects;

public class Item {
	private String product;
	private int qty;
	private int unitPrice;

	public Item(String product, int qty, int unitPrice) {
		this.product=product;
		this.qty=qty;
		this.unitPrice=unitPrice;
	}

	public int price() {
		return this.unitPrice*getQty();
	}

	public String getProduct() {
		return product;
	}

	public int getQty() {
		return qty;
	}

	public void increaseQuantity() {
		this.qty++;
	}

	public String toString() {
		return this.product + ": " + this.qty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return Objects.equals(product, item.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product);
	}
}
