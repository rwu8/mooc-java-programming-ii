package FlightControl.domain;

public class Airplane {
    public String id;
    public int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return id + " (" + capacity +
                " capacity)";
    }
}
