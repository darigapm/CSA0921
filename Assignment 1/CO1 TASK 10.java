public class EncapsulationDemo {
    private String registrationNumber;
    private Integer parkingHours;

    public EncapsulationDemo(
            String registrationNumber, Integer parkingHours) {
        this.registrationNumber = registrationNumber;
        this.parkingHours = parkingHours;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Integer getParkingHours() {
        return parkingHours;
    }

    public Double calculateFee() {
        return parkingHours.doubleValue() * 30.0;
    }

    public static void main(String[] args) {
        EncapsulationDemo vehicle =
                new EncapsulationDemo("TN02B2", 3);

        System.out.println(
                "Registration: "
                + vehicle.getRegistrationNumber());

        System.out.println(
                "Hours: " + vehicle.getParkingHours());

        System.out.println(
                "Fee: Rs " + vehicle.calculateFee());
    }
}
