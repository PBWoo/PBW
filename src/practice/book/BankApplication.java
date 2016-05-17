package practice.book;

import java.util.Scanner;

public class BankApplication {
	
	private static Account[] accounts = new Account[100];
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean run = true;
		while(run) {
			
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\t\t\t\t\t계좌 관리 프로그램");		
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("\n\t1.계좌생성  │  2.계좌목록  │  3.예금  │  4.출금  │  5.종료");
			System.out.println("\n-----------------------------------------------------------");

			System.out.print("\n\t원하시는 메뉴를 입력하세요(1-5) : ");
			int menu = scan.nextInt();
			System.out.println("\n\n-----------------------------------------------------------");
			
			switch(menu)
			{
			case 1: // 계좌생성
				createAccount();
				break;
				
			case 2: // 계좌목록
				accountList();
				break;
				
			case 3: // 예금
				deposit();
				break;
				
			case 4: // 출금
				withdraw();
				break;
				
			case 5: // 종료
				System.out.println("\n\t계좌관리 프로그램을 종료합니다.");
				run = false;
				
			default :
				System.out.println("\n\t잘못 입력하셨습니다. 다시 입력해주세요.");	
			}
		}
		
		

	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		
	}

	private static void deposit() {
		
/*		System.out.println("\n\t예금 메뉴를 선택하셨습니다. ");
		
		System.out.print("\n\t계좌 번호를 입력하세요 (예 : 000-000) : ");
		String ano = scan.nextLine();
		
		System.out.print("\n\t예금액을 입력하세요 (예 : 1000) : ");
		int money = scan.nextInt();
		
		Account account = findAccount(ano);
		
		if(account == null) {
			System.out.println("\n\t결과 : 계좌가 없습니다.");
			return;
		}
		account.setBalance(account.getBalance() + money);*/
		
	}

	private static void accountList() {
		
		System.out.println("\n\t계좌 목록을 불러옵니다.");
		
		for(int i=0; i<accounts.length; i++){
			Account account = accounts[i];
			
			if(account != null) {
				System.out.print(account.getAno());
				System.out.print("\t");
				
				System.out.print(account.getOwner());
				System.out.print("\t");
				
				System.out.print(account.getBalance());
				System.out.println();
			}
		}	
	}

	private static void createAccount() {
		
		System.out.println("\n\t계좌를 생성합니다. ");
		
		System.out.print("\n\t계좌 번호를 입력하세요 (예 : 000-000) : ");
		String ano = scan.nextLine();
		
		System.out.print("\n\t계좌주를 입력하세요 (예 : 홍길동) : ");
		String owner = scan.nextLine();
		
		System.out.print("\n\t초기 입금액을 입력하세요 (예 : 1000원) : ");
		int balance = scan.nextInt();
		
		Account newAccount = new Account(ano, owner, balance);
		
		for(int i=0; i<accounts.length; i++) {
			if(accounts[i] == null) {
				accounts[i] = newAccount;
				
				System.out.println("\n\n\t짝짝짝! 계좌가 생성되었습니다. ");
				break;
			}
		}
	}
}
