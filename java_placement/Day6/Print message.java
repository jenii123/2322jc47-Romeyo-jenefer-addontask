package day6;

//First class implementing Runnable
class MessagePrinter1 implements Runnable {
 @Override
 public void run() {
     for(int i = 1; i <= 5; i++) {
         System.out.println("Message from Printer1 - Count: " + i);
         try {
             Thread.sleep(100);
         } catch (InterruptedException e) {
             System.out.println("Printer1 interrupted");
         }
     }
 }
}

//Second class implementing Runnable
class MessagePrinter2 implements Runnable {
 @Override
 public void run() {
     for(int i = 1; i <= 5; i++) {
         System.out.println("Message from Printer2 - Count: " + i);
         try {
             Thread.sleep(150);
         } catch (InterruptedException e) {
             System.out.println("Printer2 interrupted");
         }
     }
 }
}

public class PrintMessage {
 public static void main(String[] args) {
     // Create Runnable instances
     Runnable printer1 = new MessagePrinter1();
     Runnable printer2 = new MessagePrinter2();

     // Create Threads passing Runnable objects
     Thread thread1 = new Thread(printer1);
     Thread thread2 = new Thread(printer2);

     // Start the threads
     thread1.start();
     thread2.start();
 }
}
