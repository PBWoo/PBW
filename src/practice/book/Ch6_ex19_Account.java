package practice.book;

public class Ch6_ex19_Account {

	private int balance;
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000; // 바로 초기화 가능
	
/*	static{
		MIN_BALANCE = 0;
		MAX_BALANCE = 1000000;
	}*/

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		
		if(MIN_BALANCE<=balance && balance<=MAX_BALANCE)
			this.balance = balance;
		else
			return;
	}
	
	
}
