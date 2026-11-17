abstract class ParkingVehicle {
    protected String registrationNumber;

    public ParkingVehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public abstract double calculateFee(int hours);
}

interface Chargeable {
    void charge();
}

class ElectricVehicle extends ParkingVehicle
        implements Chargeable {

    public ElectricVehicle(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public double calculateFee(int hours) {
        return hours * 40.0;
    }

    @Override
    public void charge() {
        System.out.println("Charging " + registrationNumber);
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        ParkingVehicle vehicle =
                new ElectricVehicle("TN03C3");

        System.out.println(
                "Fee: Rs " + vehicle.calculateFee(2));

        ((Chargeable) vehicle).charge();
    }
}
