package week3.assignment;

public class Assignment2Student extends Assignment2Department{

	public static void main(String[] args) {
		
		// Example of Multilevel Inheritance
		// create above 3 class and call all your class methods into the Student using multilevel inheritance.
		
		Assignment2Student s= new Assignment2Student();
		s.college();
		s.collegeCode();
		s.collegeRank();
		
		s.deptName();
		
		s.studentName();
		s.studentDept();
		s.studentId();
		
	}
	
	public void studentName() {
		System.out.println("Student Name Method in Student Class");
	}
	
	public void studentDept() {
		System.out.println("Student Department Method in Student Class");
	}
	
	public void studentId() {
		System.out.println("Student ID Method in Student Class");
	}	

}
