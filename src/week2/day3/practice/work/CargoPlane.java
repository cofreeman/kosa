package week2.day3.practice.work;

public class CargoPlane extends Plane{
    public CargoPlane() {
    }

    public CargoPlane(String planeName, int fuelSize) {
        super(planeName, fuelSize);
    }

    @Override
    public void flight(int distance) {
        setFuelSize(getFuelSize() - 5 * distance);
    }
}
