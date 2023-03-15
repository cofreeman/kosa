package week2.day3.practice.work;

public class AirPlane extends Plane{
    public AirPlane() {
    }

    public AirPlane(String planeName, int fuelSize) {
        super(planeName, fuelSize);
    }

    @Override
    public void flight(int distance) {
        setFuelSize(getFuelSize() - distance * 3);
    }

}
