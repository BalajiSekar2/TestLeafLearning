package week3.assignment;

public class Assignment1Desktop extends Assignment1Computer{

	public static void main(String[] args) {
		
		//create above 2 class and call all your class methods into the Desktop using single inheritance.
		Assignment1Desktop obj = new Assignment1Desktop();
		obj.computerModel();
		obj.desktopSize();
	}
	
	public void desktopSize() {
		System.out.println("Desktop Size method in Desktop Class");
	}
}
