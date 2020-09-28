public class List<Type> {
	private Type[] values;
	private int firstFreeIndex;

	public List() {
		this.values = (Type[]) new Object[10];
		this.firstFreeIndex = 0;
	}

	public void add(Type value) {
		if (this.firstFreeIndex == this.values.length) {
			grow();
		}

		this.values[this.firstFreeIndex] = value;
		this.firstFreeIndex++;
	}

	private void grow() {
		int newSize = this.values.length + this.values.length / 2;
		Type[] newValuesList = (Type[]) new Object[newSize];
		for (int i = 0; i < this.values.length; i++) {
			newValuesList[i] = values[i];
		}
		this.values = newValuesList;
	}

	public boolean contains(Type value) {
		return indexOfValue(value) >= 0;
	}

	public void remove(Type value) {
		int indexOfValue = indexOfValue(value);
		if (indexOfValue < 0) {
			return;
		}

		shiftValuesLeft(indexOfValue);
		this.firstFreeIndex--;
	}

	public int indexOfValue(Type value) {
		for (int i = 0; i < this.values.length; i++) {
			if (this.values[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public void shiftValuesLeft(int fromIndex) {
		for (int i = fromIndex; i < this.values.length; i++) {
			this.values[i] = this.values[i + 1];
		}
	}

	public int size() {
		return this.firstFreeIndex;
	}
}
