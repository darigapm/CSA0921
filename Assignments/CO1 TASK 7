import java.util.Objects;

class ParkedVehicle {
    private final String registrationNumber;

    public ParkedVehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber.toUpperCase();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ParkedVehicle)) return false;

        ParkedVehicle vehicle = (ParkedVehicle) other;
        return registrationNumber.equals(vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }

    @Override
    public String toString() {
        return "ParkedVehicle{registrationNumber='"
                + registrationNumber + "'}";
    }
}

public class ObjectMethodsDemo {
    public static void main(String[] args) {
        ParkedVehicle v1 = new ParkedVehicle("tn01a1");
        ParkedVehicle v2 = new ParkedVehicle("TN01A1");

        System.out.println(v1);
        System.out.println("Equal: " + v1.equals(v2));
        System.out.println("Same hash: "
                + (v1.hashCode() == v2.hashCode()));
    }
}
