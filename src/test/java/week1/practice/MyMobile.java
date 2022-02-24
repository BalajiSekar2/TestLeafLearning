package week1.practice;

import java.util.Arrays;

public class MyMobile {

	public static void main(String[] args) {


		// Create a Object for another class and calling its methods using objects
		Mobile obj = new Mobile(); 
		obj.makeCall(); 
		obj.sendMsg();

		// Program to find the Odd and Even numbers in a given range 
		int n=10;
		for(int i=1;i<=n;i++) { 
			if(i%2==0) { 
				System.out.println(i +" is a Even Number"); 
			}else { 
				System.out.println(i+ " is a Odd Number"); 
			} 
		}

		// Factorial of a Number
		int num = 5;
		long res = 1;
		for (int i = 1; i <= num; i++) {
			res = res * i;
		}
		System.out.println("Factorial of Number " + num + " is " + res);

		
		// Arrays Sort
		int[] values= {10,20,30,70,50,90,40};
		Arrays.sort(values);
		
		// To find the Second highest values in a Array
		System.out.println(values[values.length-2]);
		
	}

}
