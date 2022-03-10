package week3.assignment;

public class Assignment5ReverseEvenWords {

	public static void main(String[] args) {
		
		Assignment5ReverseEvenWords obj = new Assignment5ReverseEvenWords();
		obj.ReverseEvenWords();
		
	}

	public void ReverseEvenWords() {
		
//		Build a logic to reverse the even position words (output: I ma a erawtfos tester)
//		Declare the input as Follow String test = "I am a software tester"; 
//		a) 	split the words and have it in an array
//		b) 	Traverse through each word (using loop)
//		c) 	find the odd index within the loop (use mod operator)
//		d)	split the words and have it in an array
//		e)	print the even position words in reverse order using another loop (nested loop)
//		f) 	Convert words to character array if the position is even else print the word as it is(concatenate space at the end).
		 
		String test = "I am a software tester";
		String newTest = "";
		String[] arr = test.split(" ");	
		
		for(int i=1;i<=arr.length;i++) {
			if(i%2==0) {
				String val="";
				char[] x = arr[i-1].toCharArray();
				for(int j=(x.length-1);j>=0;j--) {
					val = val + x[j];
				}
				//System.out.println(val);
				newTest = newTest+" "+val;
			}else {
				newTest = newTest+ " " +arr[i-1];
			}
		}
		
		System.out.println(newTest);
		
	}
	
}
