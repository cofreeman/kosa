package week2.day3.practice.mobile;

public class Ltab extends Mobile{
    public Ltab() {
    }

    public Ltab(String mobileName, int batterySize, String osType) {
        super(mobileName, batterySize, osType);
    }

    @Override
    public void operate(int time) {
        setBatterySize(this.getBatterySize() - time * 10);
    }

    @Override
    public void charge(int time) {
        setBatterySize(this.getBatterySize() + time * 10);
    }
}
