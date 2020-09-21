import java.util.ArrayList;

public class Herd implements Movable {
	private ArrayList<Movable> herd;

	public Herd() {
		this.herd = new ArrayList<>();
	}

	public String toString() {
		String value = "";

		for (Movable organism: herd) {
			value += organism.toString();
			value += "\n";
		}
		return value;
	};

	public void addToHerd(Movable movable) {
		this.herd.add(movable);
	}

	public void move(int dx, int dy) {
		for (Movable organism: herd) {
			organism.move(dx, dy);
		}
	}
}
