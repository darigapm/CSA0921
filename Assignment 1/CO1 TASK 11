import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

interface Chargeable {
    void charge();
}

abstract class Vehicle {
    private final String registrationNumber;

    protected Vehicle(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty())
            throw new IllegalArgumentException("Registration number is required");
        this.registrationNumber = registrationNumber.trim().toUpperCase();
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public abstract double calculateFee(long minutes, LocalDateTime entry, LocalDateTime exit);

    @Override public boolean equals(Object obj) {
        return obj instanceof Vehicle &&
            registrationNumber.equals(((Vehicle)obj).registrationNumber);
    }
    @Override public int hashCode() { return Objects.hash(registrationNumber); }
    @Override public String toString() { return getClass().getSimpleName() + "[" + registrationNumber + "]"; }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String r) { super(r); }
    public double calculateFee(long minutes, LocalDateTime entry, LocalDateTime exit) {
        return Math.max(1, (minutes + 59) / 60) * 15.0;
    }
}
class Car extends Vehicle {
    Car(String r) { super(r); }
    public double calculateFee(long minutes, LocalDateTime entry, LocalDateTime exit) {
        return Math.max(1, (minutes + 59) / 60) * 30.0;
    }
}
class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String r) { super(r); }
    public double calculateFee(long minutes, LocalDateTime entry, LocalDateTime exit) {
        return Math.max(1, (minutes + 59) / 60) * 70.0;
    }
    public void charge() { System.out.println("Charging " + getRegistrationNumber()); }
}
class EBike extends Vehicle {
    private final double flatFee;
    EBike(String r, double flatFee) { super(r); if (flatFee < 0) throw new IllegalArgumentException(); this.flatFee = flatFee; }
    public double calculateFee(long minutes, LocalDateTime entry, LocalDateTime exit) { return flatFee; }
}
class DeliveryVan extends Vehicle {
    DeliveryVan(String r) { super(r); }
    public double calculateFee(long minutes, LocalDateTime entry, LocalDateTime exit) {
        double base = Math.max(1, (minutes + 59) / 60) * 50.0;
        // Double the fee if any portion of the stay overlaps 09:00–17:00.
        LocalDateTime cursor = entry;
        while (cursor.isBefore(exit)) {
            LocalDateTime nextHour = cursor.plusMinutes(1);
            LocalTime time = cursor.toLocalTime();
            if (!time.isBefore(LocalTime.of(9, 0)) && time.isBefore(LocalTime.of(17, 0))) {
                return base * 2.0;
            }
            cursor = nextHour;
        }
        return base;
    }
}
class ParkingPass {
    private final String holderId;
    private final LocalDateTime validFrom;
    private final LocalDateTime validUntil;
    ParkingPass(String holderId, LocalDateTime validFrom, LocalDateTime validUntil) {
        this.holderId = Objects.requireNonNull(holderId);
        this.validFrom = Objects.requireNonNull(validFrom);
        this.validUntil = Objects.requireNonNull(validUntil);
        if (validUntil.isBefore(validFrom)) throw new IllegalArgumentException("Invalid pass interval");
    }
    boolean isValidAt(LocalDateTime time) {
        return !time.isBefore(validFrom) && !time.isAfter(validUntil);
    }
    String getHolderId() { return holderId; }
}
class MonthlyPass extends ParkingPass {
    MonthlyPass(String holder, LocalDateTime from, LocalDateTime until) { super(holder, from, until); }
}
class OneDayPass extends ParkingPass {
    OneDayPass(String holder, LocalDateTime dayStart) { super(holder, dayStart, dayStart.plusDays(1)); }
}
class ParkingTicket {
    private static final AtomicLong COUNTER = new AtomicLong(1000);
    private final long id = COUNTER.incrementAndGet();
    private final Vehicle vehicle;
    private final int floor;
    private final int slot;
    private final LocalDateTime entryTime;
    ParkingTicket(Vehicle vehicle, int floor, int slot, LocalDateTime entryTime) {
        this.vehicle = vehicle; this.floor = floor; this.slot = slot; this.entryTime = entryTime;
    }
    long getId() { return id; }
    Vehicle getVehicle() { return vehicle; }
    int getFloor() { return floor; }
    int getSlot() { return slot; }
    LocalDateTime getEntryTime() { return entryTime; }
}
class ParkingFacility {
    private final Vehicle[][] slots;
    private final Map<String, ParkingTicket> active = new HashMap<>();
    ParkingFacility(int[] capacities) {
        slots = new Vehicle[capacities.length][];
        for (int i = 0; i < capacities.length; i++) {
            if (capacities[i] < 0) throw new IllegalArgumentException("Negative capacity");
            slots[i] = new Vehicle[capacities[i]];
        }
    }
    ParkingTicket park(Vehicle vehicle, LocalDateTime entry) {
        String reg = vehicle.getRegistrationNumber();
        if (active.containsKey(reg)) throw new IllegalArgumentException("Vehicle already parked");
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = vehicle;
                    ParkingTicket ticket = new ParkingTicket(vehicle, f, s, entry);
                    active.put(reg, ticket);
                    return ticket;
                }
            }
        }
        throw new IllegalStateException("Parking facility is full");
    }
    double exit(String registration, LocalDateTime exit, ParkingPass pass) {
        String reg = registration.trim().toUpperCase();
        ParkingTicket ticket = active.get(reg);
        if (ticket == null) throw new IllegalArgumentException("No active ticket");
        if (exit.isBefore(ticket.getEntryTime())) throw new IllegalArgumentException("Exit precedes entry");
        long minutes = Duration.between(ticket.getEntryTime(), exit).toMinutes();
        double fee = (pass != null && pass.isValidAt(exit)) ? 0.0 :
            ticket.getVehicle().calculateFee(minutes, ticket.getEntryTime(), exit);
        slots[ticket.getFloor()][ticket.getSlot()] = null;
        active.remove(reg);
        return fee;
    }
    int activeCount() { return active.size(); }
}
public class Main {
    public static void main(String[] args) {
        int[] capacities = {2, 3, 2, 4, 3};
        ParkingFacility facility = new ParkingFacility(capacities);
        LocalDateTime entry = LocalDateTime.of(2026, 10, 22, 10, 0);
        LocalDateTime exit = entry.plusMinutes(90);
        ParkingTicket ticket = facility.park(new Car("TN02B2"), entry);
        System.out.println("Ticket: " + ticket.getId());
        System.out.println("Slot: floor " + ticket.getFloor() + ", slot " + ticket.getSlot());
        System.out.println("Fee: Rs " + facility.exit("TN02B2", exit, null));
        System.out.println("Active tickets: " + facility.activeCount());
        ParkingTicket ebike = facility.park(new EBike("TN04E4", 20.0), exit);
        System.out.println("E-bike ticket: " + ebike.getId());
        System.out.println("E-bike fee: Rs " + facility.exit("TN04E4", exit.plusHours(4), null));
    }
}
