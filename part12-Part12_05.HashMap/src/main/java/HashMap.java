import java.util.ArrayList;
import java.util.List;

public class HashMap<K,V> {
	private List<Pair<K, V>>[] values;
	private int firstFreeIndex;

	public HashMap() {
		this.values = new List[32];
		this.firstFreeIndex = 0;
	}

	public V get(K key) {
		int hashValue = Math.abs(key.hashCode() % this.values.length);
		if (this.values[hashValue] == null) {
			return null;
		}

		List<Pair<K, V>> valuesAtIndex = this.values[hashValue];

		for (int i = 0; i < valuesAtIndex.size(); i++) {
			if (valuesAtIndex.get(i).getKey().equals(key)) {
				return valuesAtIndex.get(i).getValue();
			}
		}

		return null;
	}

	public void add(K key, V value) {
		List<Pair<K,V>> valuesAtIndex = getListBasedOnKey(key);
		int index = getIndexOfKey(valuesAtIndex, key);
		if (index < 0) {
			valuesAtIndex.add(new Pair<>(key, value));
			this.firstFreeIndex++;
		} else {
			valuesAtIndex.get(index).setValue(value);
		}
	}

	private List<Pair<K, V>> getListBasedOnKey(K key) {
		int hashValue = Math.abs(key.hashCode() % this.values.length);
		if (this.values[hashValue] == null) {
			this.values[hashValue] = new ArrayList<>();
		}

		return this.values[hashValue];
	}

	private int getIndexOfKey(List<Pair<K, V>> myList, K key) {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getKey().equals(key)) {
				return i;
			}
		}

		return -1;
	}

	private void grow() {
		List<Pair<K,V>>[] newArray = new List[this.values.length * 2];

		for (int i = 0; i < this.values.length; i++) {
			copy(newArray, i);
		}

		this.values = newArray;
	}

	private void copy(List<Pair<K,V>>[] newArray, int fromIdx) {
		for (int i = 0; i < this.values[fromIdx].size(); i++) {
			Pair<K, V> value = this.values[fromIdx].get(i);

			int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
			if (newArray[hashValue] == null) {
				newArray[hashValue] = new ArrayList<>();
			}

			newArray[hashValue].add(value);
		}
	}

	private V remove(K key) {
		List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);

		if (valuesAtIndex.size() == 0) {
			return null;
		}

		int index = getIndexOfKey(valuesAtIndex, key);
		if (index < 0) {
			return null;
		}

		Pair<K, V> pair = valuesAtIndex.get(index);
		valuesAtIndex.remove(pair);
		return pair.getValue();
	}
}
