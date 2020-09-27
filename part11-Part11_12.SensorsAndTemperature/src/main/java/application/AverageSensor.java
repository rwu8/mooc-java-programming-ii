package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor sensor: sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor: sensors) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("Wrong!");
        }
        int avg = this.sensors.stream().map(s -> s.read()).reduce(0, (prev, curr) -> prev + curr) / this.sensors.size();
        this.readings.add(avg);
        return avg;
    }

    public List<Integer> readings() {
         return this.readings;
    }
}
