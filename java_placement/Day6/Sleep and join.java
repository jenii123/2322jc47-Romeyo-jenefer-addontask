package Day6;

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread A: " + i);
                Thread.sleep(500);  // Sleep for 500 ms
            }
        } catch (InterruptedException e) {
            System.out.println("Thread A interrupted");
        }
    }
}

class ThreadB extends Thread {
    private Thread threadToJoin;

    public ThreadB(Thread threadToJoin) {
        this.threadToJoin = threadToJoin;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread B waiting for Thread A to finish...");
            threadToJoin.join();  // Wait for Thread A to complete
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread B: " + i);
                Thread.sleep(300);  // Sleep for 300 ms
            }
        } catch (InterruptedException e) {
            System.out.println("Thread B interrupted");
        }
    }
}

public class SleepAndJoin {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB(threadA);

        threadA.start();
        threadB.start();
    }
}
