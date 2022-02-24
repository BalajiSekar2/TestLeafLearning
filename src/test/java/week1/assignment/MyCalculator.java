package week1.assignment;

public class MyCalculator {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		
		// Add
		int sum = cal.add(15,3,22);
		System.out.println("Sum of three numbers is "+sum);
		
		// Sub
		int subVal = cal.sub(55,25);
		System.out.println("Difference of two numbers is "+subVal);
		
		// Multiply
		double mulVal = cal.mul(2454d,11d);
		System.out.println("Multiplication of  numbers is "+mulVal);
		
		// Divide
		float divVal = cal.divide(102.5f,2.5f );
		System.out.println("Division of two numbers is "+divVal);
		
	}

}
