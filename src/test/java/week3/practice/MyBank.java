package week3.practice;

public class MyBank {

	public static void main(String[] args) {

		SBI objSBI = new SBI();
		objSBI.OpenAccount();
		objSBI.provideDebitCard();
		objSBI.provideCreditCard();
		
		RBI objRBI = new SBI();
		objRBI.OpenAccount();
		objRBI.provideDebitCard();
		
	}

}
