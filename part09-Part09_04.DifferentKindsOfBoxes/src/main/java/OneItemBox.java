import java.util.ArrayList;

public class OneItemBox extends Box {
	private int capacity;
	private ArrayList<Item> items;

	public OneItemBox() {
		this.capacity = 1;
		this.items = new ArrayList<>();
	}

	public void add(Item item) {
		if (this.capacity > 0) {
			this.capacity -= 1;
			items.add(item);
		}
	}

	public boolean isInBox(Item item) {
		for (Item it: items) {
			if (it.equals(item)) {
				return true;
			}
		}
		return false;
	};
}
