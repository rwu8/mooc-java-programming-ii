
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object o) {
        // if the object references the same location
        if (this == o) return true;

        // if the object is not a LicensePlate instance
        if (!(o instanceof LicensePlate)) return false;

        LicensePlate that = (LicensePlate) o;
        return Objects.equals(liNumber, that.liNumber) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liNumber, country);
    }
}
