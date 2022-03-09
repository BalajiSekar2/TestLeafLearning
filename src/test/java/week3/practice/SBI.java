package week3.practice;

public class SBI implements RBI {

	@Override
	public void OpenAccount() {
		System.out.println("Open Account");
	}

	@Override
	public void provideDebitCard() {
		System.out.println("Provide Debit Card");
	}

	
	public void provideCreditCard() {
		System.out.println("Provide Credit Card");
	}
}
