
public class ParkingSlot {
    private int floorNumber;
    private int slotNumber;
    private boolean occupied;

    public ParkingSlot(int floorNumber, int slotNumber) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.occupied = false;
    }

    public void parkVehicle() {
        occupied = true;
    }

    public void releaseSlot() {
        occupied = false;
    }

    public void displayDetails() {
        System.out.println("Floor: " + floorNumber);
        System.out.println("Slot: " + slotNumber);
        System.out.println("Occupied: " + occupied);
    }

    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(1, 101);
        slot.displayDetails();

        slot.parkVehicle();
        System.out.println("After parking:");
        slot.displayDetails();

        slot.releaseSlot();
        System.out.println("After release:");
        slot.displayDetails();
    }
}
