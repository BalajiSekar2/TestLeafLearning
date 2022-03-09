package week3.assignment;

public class Assignment4Overloading {

	public static void main(String[] args) {

		//Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber
		getStudentInfo(12345);
		getStudentInfo(12345,"Balaji");
		getStudentInfo(12345,"Bala","Test@email.com",9500123456l);
		
	}
	
	public static void getStudentInfo(int studentID) {
		System.out.println("Student ID::"+studentID);
	}
	
	public static void getStudentInfo(int studentID, String Name) {
		System.out.println("Student ID::"+studentID+ " Name::"+Name);
	}
	
	public static void getStudentInfo(int studentID, String Name, String email, long phoneNumber) {
		System.out.println("Student ID::"+studentID+ " Name::"+Name+" Email::"+email+ " Phone Number::"+phoneNumber);
	}

}
