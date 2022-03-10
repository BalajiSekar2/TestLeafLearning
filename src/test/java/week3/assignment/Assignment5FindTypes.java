package week3.assignment;

public class Assignment5FindTypes {

	public static void main(String[] args) {
		
		Assignment5FindTypes obj = new Assignment5FindTypes();
		obj.findTypes();
		
	}
	
	public void findTypes() {
		
//		a) Convert the String to character array
//		b) Traverse through each character (using loop)
//		c) Find if the given character is what type using (if)
//				i)  Character.isLetter
//				ii) Character.isDigit
//				iii)Character.isSpaceChar
//				iv) else -> consider as special character
		
		String test = "$$ Welcome to 2nd Class of Automation $$ 12 ";
		int  letter = 0, space = 0, num = 0, specialChar = 0;

		char[] arr = test.toCharArray();
		System.out.println(arr);
		
		for(char x:arr) {
			if(Character.isDigit(x)) {
				num=num+1;
			}else if(Character.isLetter(x)){
				letter = letter+1;
			}else if(Character.isSpaceChar(x)) {
				space=space+1;
			}else {
				specialChar=specialChar+1;
			}
		}
		
		System.out.println("Letter: " + letter);
		System.out.println("Space: " + space);
		System.out.println("Number: " + num);
		System.out.println("SpecialCharcter: " + specialChar);
		
	}
	
}
