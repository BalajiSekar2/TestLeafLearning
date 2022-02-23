package week1.day2.assignment;

public class MissingElementsInArray {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,7,8};
		
		for(int i=1;i<=arr.length;i++) {
			if(i==arr[i-1]) {
			}else {
				System.out.println("Missing Element::" +i);
				break;
			}
		}
		
	}

}
