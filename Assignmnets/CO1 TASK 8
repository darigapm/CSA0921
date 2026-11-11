import java.util.Objects;

abstract class Vehicle {
    private final String registrationNumber;

    protected Vehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number is required");
        }
        this.registrationNumber = registrationNumber.trim().toUpperCase();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public abstract double calculateFee(int minutes);

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Vehicle)) return false;
        Vehicle that = (Vehicle) other;
        return registrationNumber.equals(that.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}

class TwoWheeler extends Vehicle {
    public TwoWheeler(String reg) { super(reg); }

    @Override
    public double calculateFee(int minutes) {
        return startedHours(minutes) * 15.0;
    }

    private long startedHours(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Minutes cannot be negative");
        return (minutes + 59L) / 60L;
    }
}

class Car extends Vehicle {
    public Car(String reg) { super(reg); }

    @Override
    public double calculateFee(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Minutes cannot be negative");
        return ((minutes + 59L) / 60L) * 30.0;
    }
}

interface Chargeable {
    void charge();
}

class ElectricCar extends Vehicle implements Chargeable {
    public ElectricCar(String reg) { super(reg); }

    @Override
    public double calculateFee(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Minutes cannot be negative");
        return ((minutes + 59L) / 60L) * 70.0;
    }

    @Override
    public void charge() {
        System.out.println("Charging " + getRegistrationNumber());
    }
}

public class FeeDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new TwoWheeler("TN01A1"),
            new Car("TN02B2"),
            new ElectricCar("TN03C3")
        };
        int[] minutes = {120, 180, 180};
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].getClass().getSimpleName() + " "
                + vehicles[i].getRegistrationNumber() + " -> Rs "
                + vehicles[i].calculateFee(minutes[i]));
        }
        System.out.println(new Car("TN02B2").equals(new ElectricCar("TN02B2")));
    }
}
