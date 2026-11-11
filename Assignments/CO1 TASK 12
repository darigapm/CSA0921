
abstract class Vehicle {
    protected String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public abstract double calculateFee(int hours, int entryHour);
}

class EBike extends Vehicle {
    public EBike(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int hours, int entryHour) {
        return 20.0;
    }
}

class DeliveryVan extends Vehicle {
    public DeliveryVan(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int hours, int entryHour) {
        double normalFee = hours * 30.0;
        boolean daytime = entryHour >= 9 && entryHour < 17;
        return daytime ? normalFee * 2 : normalFee;
    }
}

class VisitorPass {
    private final String passId;
    private final int validDay;

    public VisitorPass(String passId, int validDay) {
        this.passId = passId;
        this.validDay = validDay;
    }

    public boolean isValid(int currentDay) {
        return currentDay == validDay;
    }

    public String getPassId() {
        return passId;
    }
}

class ParkingFloor {
    private final boolean[] occupied;

    public ParkingFloor(int capacity) {
        occupied = new boolean[capacity];
    }

    public int allocateSlot() {
        for (int i = 0; i < occupied.length; i++) {
            if (!occupied[i]) {
                occupied[i] = true;
                return i;
            }
        }
        return -1;
    }

    public int getCapacity() {
        return occupied.length;
    }
}

public class DesignChallenge {
    public static void main(String[] args) {
        ParkingFloor[] floors = {
            new ParkingFloor(10),
            new ParkingFloor(15),
            new ParkingFloor(20),
            new ParkingFloor(12),
            new ParkingFloor(8)
        };

        System.out.println("Parking floors: " + floors.length);

        for (int i = 0; i < floors.length; i++) {
            System.out.println(
                "Floor " + (i + 1)
                + " capacity: " + floors[i].getCapacity()
            );
        }

        Vehicle bike = new EBike("EB01");
        Vehicle van = new DeliveryVan("DV01");

        System.out.println(
            "EBike fee: Rs " + bike.calculateFee(3, 10));

        System.out.println(
            "DeliveryVan fee: Rs " + van.calculateFee(3, 10));

        VisitorPass pass = new VisitorPass("VP001", 22);
        System.out.println("Visitor pass valid: " + pass.isValid(22));
    }
}
