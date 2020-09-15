import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
	private HashMap<String, ArrayList<String>> storageFacility;

	public StorageFacility() {
		this.storageFacility = new HashMap<>();
	}

	public void add(String unit, String item) {
		this.storageFacility.putIfAbsent(unit, new ArrayList<>());
		this.storageFacility.get(unit).add(item);
	}

	public ArrayList<String> contents(String storageUnit) {
		ArrayList<String> item = this.storageFacility.get(storageUnit);

		if (item == null) {
			ArrayList<String> empty = new ArrayList<>();
			return empty;
		}

		return item;
	}

	public void remove(String storageUnit, String item) {
		this.storageFacility.get(storageUnit).remove(item);
		if (this.storageFacility.get(storageUnit).size() == 0) {
			this.storageFacility.remove(storageUnit);
		}
	}

	public ArrayList<String> storageUnits() {
		ArrayList<String> storage = new ArrayList<>();

		for (String unit : this.storageFacility.keySet()) {
			storage.add(unit);
		}

		return storage;
	}
}
