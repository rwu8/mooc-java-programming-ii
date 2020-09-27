package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
        private boolean isOn;
        private int value;

        public TemperatureSensor() {
            this.isOn = false;
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn() {
            this.isOn = true;
        }

        public void setOff() {
            this.isOn = false;
        }

        public int read() {
            if (isOn) {
                return new Random().nextInt(61) - 30;
            } else {
                throw new IllegalStateException("Illegal state!");
            }
        }

}
