import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
	private int capacity;
	private ArrayList<Item> items;

	public BoxWithMaxWeight(int capacity) {
		this.capacity = capacity;
		this.items = new ArrayList<>();
	}

	public void add(Item item) {
		if (this.capacity >= item.getWeight()) {
			this.capacity -= item.getWeight();
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
