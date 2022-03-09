package week3.assignment;

import java.util.Arrays;

public class Assignment5CharOccurance {

	public static void main(String[] args) {
		charOccurence();
	}
	
	public static void charOccurence() {
		
		// Check number of occurrences of a char (eg 'e') in a String
		//String str = "welcome to chennai";
		// declare and initialize a variable count to store the number of occurrences
		// convert the string into char array
		//get the length of the array
		// traverse from 0 till the array length 
		// Check the char array has the particular char in it 
		// if is has increment the count
		// print the count out of the loop
		
		String str = "welcome to chennai";
		int count;
		
		char[] strarray = str.toCharArray();
		Arrays.sort(strarray);
		
		for(int i=0;i<=strarray.length-1;i++) {
			count=0;
			for(int j=i+1;j<=strarray.length-1;j++) {
				if(strarray[i]==strarray[j]) {
					count=count+1;
				}
			}
			System.out.println(strarray[i]+" is present "+(count+1)+" times in the String ");
			i=i+count;
		}
		
	}

}
