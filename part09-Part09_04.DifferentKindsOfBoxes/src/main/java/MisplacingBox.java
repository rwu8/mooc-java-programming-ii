import java.util.ArrayList;

public class MisplacingBox extends Box {
	private ArrayList<Item> items;

	public MisplacingBox() {
		this.items = new ArrayList<>();
	}

	public void add(Item item) {
		items.add(item);
	}

	public boolean isInBox(Item item) {
		return false;
	};
}
