package Day6;

class TicketCounter {
    private int totalSeats = 10;

    // Synchronized method to avoid race conditions
    public synchronized void bookTicket(String user, int numberOfSeats) {
        System.out.println(user + " is trying to book " + numberOfSeats + " seat(s)...");

        // Simulate processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Booking interrupted for " + user);
        }

        if (numberOfSeats <= totalSeats) {
            totalSeats -= numberOfSeats;
            System.out.println(user + " successfully booked " + numberOfSeats + " seat(s).");
        } else {
            System.out.println(" Not enough seats for " + user + ". Remaining: " + totalSeats);
        }

        System.out.println(" Remaining Seats: " + totalSeats + "\n");
    }
}

// Thread class representing a user
class BookingThread extends Thread {
    private TicketCounter counter;
    private String userName;
    private int seatsToBook;

    public BookingThread(TicketCounter counter, String userName, int seatsToBook) {
        this.counter = counter;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        counter.bookTicket(userName, seatsToBook);
    }
}

// Main class
public class TicketBooking {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Simulate multiple users booking tickets simultaneously
        BookingThread user1 = new BookingThread(counter, "Priya", 4);
        BookingThread user2 = new BookingThread(counter, "Rith", 3);
        BookingThread user3 = new BookingThread(counter, "Sam", 5);
        BookingThread user4 = new BookingThread(counter, "Mohan", 2);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
