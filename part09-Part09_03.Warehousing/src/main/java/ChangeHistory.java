import java.util.ArrayList;

public class ChangeHistory {
	private ArrayList<Double> changeHistory;

	public ChangeHistory() {
		this.changeHistory = new ArrayList<>();
	}

	public void add(double status) {
		this.changeHistory.add(status);
	}

	public void clear() {
		this.changeHistory.clear();
	}

	public String toString() {
		return changeHistory.toString();
	}

	public double maxValue() {
		if (this.changeHistory.size() == 0) {
			return 0;
		}

		double maxChange = 0;

		for (Double item : changeHistory) {
			if (item > maxChange) {
				maxChange = item;
			}
		}

		return maxChange;
	}

	public double minValue() {
		if (this.changeHistory.size() == 0) {
			return 0;
		}

		double minChange = 10000000;

		for (Double item : changeHistory) {
			if (item < minChange) {
				minChange = item;
			}
		}

		return minChange;
	}

	public double average() {
		if (this.changeHistory.size() == 0) {
			return 0;
		}

		double total = 0;

		for (Double item : changeHistory) {
			total += item;
		}

		return (double) total / this.changeHistory.size();
	}
}
