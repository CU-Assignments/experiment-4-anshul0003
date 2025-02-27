import java.util.ArrayList;
import java.util.List;

// TicketBookingSystem class to manage seat bookings
class TicketBookingSystem {
    private final List<Integer> availableSeats;

    public TicketBookingSystem(int totalSeats) {
        availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }

    // Synchronized method to book a seat
    public synchronized boolean bookSeat(String customerType) {
        if (!availableSeats.isEmpty()) {
            int seatNumber = availableSeats.remove(0);
            System.out.println(customerType + " booked seat number: " + seatNumber);
            return true;
        } else {
            System.out.println(customerType + " tried to book, but no seats available.");
            return false;
        }
    }
}

// BookingThread class to represent a user trying to book a ticket
class BookingThread extends Thread {
    private final TicketBookingSystem bookingSystem;
    private final String customerType;

    public BookingThread(TicketBookingSystem bookingSystem, String customerType, int priority) {
        this.bookingSystem = bookingSystem;
        this.customerType = customerType;
        setPriority(priority); // Setting thread priority
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(customerType);
    }
}

// Main class to simulate the ticket booking process
public class TicketBookingApp {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5); // 5 available seats

        // Creating threads for VIP and Regular customers
        BookingThread vip1 = new BookingThread(bookingSystem, "VIP Customer 1", Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(bookingSystem, "VIP Customer 2", Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(bookingSystem, "Regular Customer 1", Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(bookingSystem, "Regular Customer 2", Thread.NORM_PRIORITY);
        BookingThread regular3 = new BookingThread(bookingSystem, "Regular Customer 3", Thread.NORM_PRIORITY);
        BookingThread regular4 = new BookingThread(bookingSystem, "Regular Customer 4", Thread.NORM_PRIORITY);

        // Start all threads
        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
        regular4.start();
    }
}
