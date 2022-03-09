package week3.assignment;

import java.util.Arrays;

public class Assignment5Anagram {

	public static void main(String[] args) {
		anagram();
	}
	
	public static void anagram() {
		
//		 *Declare a String String text1 = "stops";
//		 *Declare another StringString text2 = "potss"; 
//		 * a) Check length of the strings are same then (Use A Condition)
//		 * b) Convert both Strings in to characters
//		 * c) Sort Both the arrays
//		 * d) Check both the arrays has same value
		
		String text1="stops";
		String text2="potss";
		
		if(text1.length()==text2.length()) {
			char[] arr1=text1.toCharArray();
			char[] arr2=text2.toCharArray();
				
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			if(Arrays.equals(arr1, arr2)) {
				System.out.println("Both the Strings are Anagram");
			}else {
				System.out.println("Both the Strings are not Anagram");
			}
			
		}else {
			System.out.println("Length of both the Strings are not same");
		}


	}

}
