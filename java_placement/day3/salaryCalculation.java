package day3;


public class salarycalculation {

	

	void sal(int amt) {

			int total=1000;

				System.out.println("your  full salary"+" "+total);			

	}

	void sal(int amt, int hour) {

	 int totalpart=amt*hour;

	 System.out.println("total parttime"+"  "+totalpart);

		

		

}

	void sal(int amt,int hour,int bonus) {

		int totalfree=(amt*hour)+bonus;

		System.out.println("total for freelancers"+"  "+totalfree);

	}



	public static void main(String[] args) {

		salarycalculation in=new salarycalculation();

		in.sal(1000);

		

	}