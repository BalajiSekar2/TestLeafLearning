package week1.assignment;

public class Calculator {
	
	public int add(int num1, int num2, int num3) {
		int sum = num1+num2+num3;
		return sum;		
	}
	
	public int sub(int num1, int num2) {
		int finalVal = num1-num2;
		return finalVal;		
	}
	
	public double mul(double num1, double num2) {
		double finalVal = num1*num2;
		return finalVal;		
	}
	
	public float divide(float num1, float num2) {
		float finalVal = num1/num2;
		return finalVal;		
	}	

}
