package Day6;

//Thread class to print numbers from 1 to 100
public class PrintNumbers extends Thread {

 @Override
 public void run() {
     for (int i = 1; i <= 100; i++) {
         System.out.println("Number: " + i);
         try {
             Thread.sleep(50); // Optional: slows down the output for readability
         } catch (InterruptedException e) {
             System.out.println("Thread interrupted.");
         }
     }
 }

 // Main method to run the thread
 public static void main(String[] args) {
	 PrintNumbers thread = new PrintNumbers();
     thread.start(); // Start the thread, calls run()
 }
}
