package day3;

public class overloading {

    public void sum(int a, int b) {

        int result = a + b;

        System.out.println("Sum of integers: " + result);

    }

 

    public void sum(double a, double b) {

        double result = a + b;

        System.out.println("Sum of doubles: " + result);

    }



    public static void main(String[] args) {

        overloading demo = new overloading();



        demo.sum(10, 20);

        demo.sum(10.5, 20.5);

    }

}