import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;

    public VehicleRegistry() {
        this.registry = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.registry.containsKey(licensePlate)) {
            return false;
        } else {
        	this.registry.put(licensePlate, owner);
        	return true;
		}
    }

    public String get(LicensePlate licensePlate) {
        if (this.registry.containsKey(licensePlate)) {
            return this.registry.get(licensePlate);
        } else {
        	return null;
		}
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.registry.containsKey(licensePlate)) {
            this.registry.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates() {
        for (LicensePlate licensePlate : this.registry.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();

        for (String owner: this.registry.values()) {
            if (!owners.contains(owner)) {
            	owners.add(owner);
			}
        }

        for (String owner: owners) {
			System.out.println(owner);
		}
    }
}
