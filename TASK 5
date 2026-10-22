public class ParkingTicket {
    private static int nextTicketId = 1000;
    private final int ticketId;
    private final String registrationNumber;

    public ParkingTicket(String registrationNumber) {
        this.ticketId = ++nextTicketId;
        this.registrationNumber = registrationNumber;
    }

    public void displayTicket() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Vehicle: " + registrationNumber);
    }

    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket("TN01A1");
        ParkingTicket t2 = new ParkingTicket("TN02B2");

        t1.displayTicket();
        t2.displayTicket();
    }
}
