package practice.book;

import java.util.Scanner;

public class Ch6_ex20_Account {

	private String accountNum;
	private String owner;
	private int balance;
	
	public Ch6_ex20_Account(){
		
		accountNum = null;
		balance = 0;
		owner = null;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void genAccount() {
		
		System.out.println("\n\t계좌를 생성합니다. ");
		
		System.out.print("\n\t계좌 번호를 입력하세요 (예 : 000-000) : ");
		accountNum = scan.nextLine();
		
		System.out.print("\n\t계좌주를 입력하세요 (예 : 홍길동) : ");
		owner = scan.nextLine();
		
		System.out.print("\n\t초기 입금액을 입력하세요 (예 : 1000원) : ");
		balance = scan.nextInt();
		
		System.out.println("\n\n\t짝짝짝! 계좌가 생성되었습니다. ");
	}
	
}
