package week1.assignment;

public class ConvertNegativeNumtoPositive {

	public static void main(String[] args) {
		int num =-50;
		
		if(num<0) {
			System.out.println("The given number "+ num +" is converted to "+Math.abs(num));
		}else {
			System.out.println("Given number is a Positive Number:: "+num);
		}
	}

}
