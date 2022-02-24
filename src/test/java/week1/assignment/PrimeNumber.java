package week1.assignment;

public class PrimeNumber {

	public static void main(String[] args) {

		int number = 11;
		boolean flag = false;

		for(int i=2;i<number;i++) {
			if(number%i==0) {
				flag = true;
				break;
			}
		}
		
		if(flag==true) {
			System.out.println("Given number is not a Prime Number:: "+number);
		}else {
			System.out.println("Given number is a Prime Number:: "+number);
		}	

	}

}
