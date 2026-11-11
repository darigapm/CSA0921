import java.util.Arrays;

/**
 * Basic jagged-array parking facility.
 * Empty slots contain null. Floor and slot indexes are zero-based.
 */
public class ParkingFacility {
    private final String[][] slots;

    public ParkingFacility(int[] slotsPerFloor) {
        if (slotsPerFloor == null || slotsPerFloor.length == 0) {
            throw new IllegalArgumentException("At least one floor is required");
        }
        slots = new String[slotsPerFloor.length][];
        for (int f = 0; f < slotsPerFloor.length; f++) {
            if (slotsPerFloor[f] < 0) {
                throw new IllegalArgumentException("Slot count cannot be negative");
            }
            slots[f] = new String[slotsPerFloor[f]];
        }
    }

    public int[] allocate(String vehicleNo) {
        if (vehicleNo == null || vehicleNo.trim().isEmpty()) {
            return null;
        }
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = vehicleNo;
                    return new int[] { f, s };
                }
            }
        }
        return null;
    }

    public boolean release(int floor, int slot) {
        if (floor < 0 || floor >= slots.length) return false;
        if (slot < 0 || slot >= slots[floor].length) return false;
        if (slots[floor][slot] == null) return false;
        slots[floor][slot] = null;
        return true;
    }

    public boolean isOccupied(int floor, int slot) {
        if (floor < 0 || floor >= slots.length) return false;
        if (slot < 0 || slot >= slots[floor].length) return false;
        return slots[floor][slot] != null;
    }

    public void printSlots() {
        for (int f = 0; f < slots.length; f++) {
            System.out.println("Floor " + f + ": " + Arrays.toString(slots[f]));
        }
    }

    // Standalone demo. If your worksheet supplies main(), preserve that main().
    public static void main(String[] args) {
        ParkingFacility pf = new ParkingFacility(new int[] {2, 1});
        System.out.println(Arrays.toString(pf.allocate("TN01A1")));
        System.out.println(Arrays.toString(pf.allocate("TN02B2")));
        System.out.println(Arrays.toString(pf.allocate("TN03C3")));
        System.out.println(pf.allocate("TN04D4"));
        System.out.println(pf.release(0, 1) + " " + pf.release(0, 1) + " " + pf.release(9, 0));
        System.out.println(Arrays.toString(pf.allocate("TN04D4")));
    }
}
