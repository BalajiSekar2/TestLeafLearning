package week3.practice;

public class Week3ClassRoom {

	public static void main(String[] args) {
		
		findStartsWith();
		findVowels();
		
	}
	
	public static void findVowels() {
		
		int counter=0;
		String text2 = "Education";
		String[] vowel= new String[] {"a","e","i","o","u"};
		
		for(int i=0;i<vowel.length;i++) {
			if(text2.toLowerCase().contains(vowel[i])) {
				counter=counter+1;
			}
		}
		System.out.println("Number of Vowels Present::"+counter);
		
	}
	
	public static void findStartsWith() {
		
		String text1 = "Testleaf is located in Teynampet and above a taccovell";
		
		String[] word = text1.split(" ");
		for(String x:word) {
			if(x.toUpperCase().startsWith("T")) {
				System.out.println(x);
			}
		}
	}

}
