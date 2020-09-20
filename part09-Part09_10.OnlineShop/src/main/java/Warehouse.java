import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Warehouse {
	private Map<String, Integer> inventoryPrice;
	private Map<String, Integer> inventoryQuantity;

	public Warehouse() {
		this.inventoryPrice = new HashMap<>();
		this.inventoryQuantity = new HashMap<>();
	}

	public void addProduct(String product, int price, int stock) {
		inventoryPrice.put(product, price);
		inventoryQuantity.put(product, stock);
	}

	public int price(String product) {
		if (inventoryPrice.containsKey(product)) {
			return inventoryPrice.get(product);
		}
		return -99;
	}

	public int stock(String product) {
		if (inventoryQuantity.containsKey(product)) {
			return inventoryQuantity.get(product);
		}
		return 0;
	}

	public boolean take(String product) {
		if (inventoryQuantity.containsKey(product) && inventoryQuantity.get(product) > 0) {
			inventoryQuantity.put(product, inventoryQuantity.get(product)-1);
			return true;
		}
		return false;
	}

	public Set<String> products() {
		Set<String> set = new HashSet<>();
		for (Object item : inventoryQuantity.keySet()) {
			set.add((String) item);
		}

		return set;
	}
}
