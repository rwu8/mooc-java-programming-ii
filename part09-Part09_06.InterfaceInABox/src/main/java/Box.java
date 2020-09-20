import java.util.ArrayList;

public class Box implements Packable {
	private double capacity;
	private ArrayList<Packable> items;

	public Box(double capacity) {
		this.capacity=capacity;
		items = new ArrayList<>();
	}


	public void add(Packable item) {
		if (this.capacity >= item.weight()) {
			items.add(item);
			this.capacity -= item.weight();
		}
	}

	public double weight() {
		double weight = 0;
		for (Packable item: items) {
			weight += item.weight();
		}
		return weight;
	}

	@Override
	public String toString() {
		// Box: 6 items, total weight 4.0 kg
		return "Box: " + items.size() + " items, total weight " + weight() + " kg";
	}
}
