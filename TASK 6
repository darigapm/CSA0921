class Vehicle {
    protected String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void displayDetails() {
        System.out.println("Registration: " + registrationNumber);
    }
}

class Car extends Vehicle {
    public Car(String registrationNumber) {
        super(registrationNumber);
    }

    public void openTrunk() {
        System.out.println("Car trunk opened");
    }
}

class TwoWheeler extends Vehicle {
    public TwoWheeler(String registrationNumber) {
        super(registrationNumber);
    }

    public void useStand() {
        System.out.println("Two-wheeler stand used");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Car car = new Car("TN02B2");
        TwoWheeler bike = new TwoWheeler("TN01A1");

        car.displayDetails();
        car.openTrunk();

        bike.displayDetails();
        bike.useStand();
    }
}
