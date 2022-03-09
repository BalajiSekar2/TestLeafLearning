package week3.assignment;

public class Assignment5Palindrome {

	public static void main(String[] args) {
		palindrome("madam");
	}
	
	public static void palindrome(String val) {
	
//		 * a) Declare A String value as"madam"
//		 * b) Declare another String rev value as ""
//		 * c) Iterate over the String in reverse order
//		 * d) Add the char into rev
//		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		
		String rev="";
		
		for(int i=val.length();i>=1;i--) {
			char cha = val.charAt(i-1);
			rev=rev+cha;
		}
		
		if(val.equalsIgnoreCase(rev)) {
			System.out.println("Given word "+val+" is a Palindrome");
		}else {
			System.out.println("Given word "+val+" is not a Palindrome");
		}
		
	}

}
