package practice.book;

public class Ch6_ex19_AccountExample {

	public static void main(String[] args) {
		
		Ch6_ex19_Account account = new Ch6_ex19_Account();
		
		account.setBalance(10000);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());
		
		account.setBalance(-100);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());
		
		account.setBalance(2000000);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());
		
		account.setBalance(300000);
		System.out.println("ÇöÀç ÀÜ°í : " + account.getBalance());

	}

}
