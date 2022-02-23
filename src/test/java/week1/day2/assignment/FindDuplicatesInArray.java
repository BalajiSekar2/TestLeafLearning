package week1.day2.assignment;

public class FindDuplicatesInArray {

	public static void main(String[] args) {

		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20,14,15,15};
		int count;
		
		for(int i=0;i<arr.length;i++) {
			count =0;
			// Loop to iterate the 1 array element with all other elements
			for(int j=i;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					count=count+1;					
				}
			}
			if(count>1) {
				System.out.println(arr[i]+" is present "+count+ " times in the array");
			}
		}
		
	}

}
