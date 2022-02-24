package week1.assignment;

import java.util.Arrays;

public class FindDuplicatesInArray {

	public static void main(String[] args) {

		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20,14,15,15,15,11};
		int count;

		Arrays.sort(arr);

		for(int i=0;i<arr.length;i++) {
			count =0;
			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					count=count+1;					
				}
			}
			if(count>0) {
				i=i+count;
				System.out.println(arr[i]+" is present "+(count+1)+ " times in the array");
			}
		}

	}
}
