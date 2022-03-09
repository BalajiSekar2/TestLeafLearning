package week3.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week3ClassRoom {

	public static void main(String[] args) {
		
		//findStartsWith();
		//findVowels();
		findListDuplicate();
		findNumberofTimesDuplicate();
	}
	
	public static void findListDuplicate() {
		
		List<String> list = new ArrayList<>(); 
		list.add("Adam");
		list.add("Ben");
		list.add("Zara");
		list.add("Adam");
		list.add("Charlie");
		list.add("James");
		list.add("Ben");

		Collections.sort(list);
		int counter;
		
		for(int i=0;i<list.size();i++) {
			counter=0;
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).equals(list.get(j))) {
					counter=counter+1;
				}
			}
			
			i=i+counter;
			if(counter>0) {
				System.out.println("Duplicate:"+list.get(i));
			}
		}
	}
	
	public static void findNumberofTimesDuplicate() {
		
		List<String> list = new ArrayList<>(); 
		list.add("Adam");
		list.add("Ben");
		list.add("Zara");
		list.add("Adam");
		list.add("Charlie");
		list.add("James");
		list.add("Ben");
		list.add("Adam");
		list.add("George");
		list.add("Adam");
		
		Collections.sort(list);
		int counter;
		
		for(int i=0;i<list.size();i++) {
			counter=0;
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).equals(list.get(j))) {
					counter=counter+1;
				}
			}
			i=i+counter;
			System.out.println(list.get(i)+" is present "+(counter+1)+" in list");
		}
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
