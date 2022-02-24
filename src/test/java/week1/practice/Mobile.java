package week1.practice;

public class Mobile {

	public static void main(String[] args) {
		Mobile objMobile = new Mobile();
		
		objMobile.makeCall();
		objMobile.sendMsg();
	}
	
	public void makeCall() {
		System.out.println("MakeCall");
	}
	
	public void sendMsg() {
		System.out.println("SendMessage");
	}

}
