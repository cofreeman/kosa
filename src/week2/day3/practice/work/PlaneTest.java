package week2.day3.practice.work;

public class PlaneTest {
    public static void main(String[] args) {
        Plane[] planes = new Plane[2];
        Plane airPlane = new AirPlane("L747", 1000);
        Plane cargoPlane = new CargoPlane("C40", 1000);

        planes[0] = airPlane;
        planes[1] = cargoPlane;
        printInfo(planes);

        for (Plane p: planes) {
            p.flight(100);
        }
        printInfo(planes);

        for (Plane p: planes) {
            p.reFuel(200);
        }
        printInfo(planes);
    }

    public static void printInfo(Plane[] list){
        System.out.println("Plane   fuelSize");
        System.out.println("-------------");
        for (Plane p:list) {
            System.out.println(p.getPlaneName() + "  " + p.getFuelSize());
        }
        System.out.println();
    }
}
