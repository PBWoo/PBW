package practice.book;

import java.util.Scanner;

public class Ch6_ex20_BankApplication {

	private static String inputaccountNum; // 사용자가 기존 계좌를 찾을 때 입력하는 계좌번호 
	
	private static int money;
	private static int index;
	private static int current;
	private static int end;
	private static Ch6_ex20_Account[] accounts;
	
	static{
		money = 0;
		index = -1;
		current = -1;
		end = 0;
		accounts = new Ch6_ex20_Account[100];
	}
	
	public static void main(String[] args) {
		
		endProgram :
		while(true)
		{
			Ch6_ex20_Account account = new Ch6_ex20_Account();
			
			switch(inputMainMenu())
			{
			case 1: // 계좌생성
				account.genAccount();
				add(account);
				break;
				
			case 2: // 계좌목록
				listAccount();
				break;
				
			case 3: // 예금
				saveMoney();
				break;
				
			case 4: // 출금
				withdrawMoney();
				break;
				
			case 5: // 종료
				System.out.println("\n\t계좌관리 프로그램을 종료합니다.");
				break endProgram;
				
			default :
				System.out.println("\n\t잘못 입력하셨습니다. 다시 입력해주세요.");	
			}
		}

	}

	private static int inputMainMenu() {

		Scanner scan = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------");
		System.out.println("\n\t\t\t\t\t계좌 관리 프로그램");		
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("\n\t1.계좌생성  │  2.계좌목록  │  3.예금  │  4.출금  │  5.종료");
		System.out.println("\n-----------------------------------------------------------");

		System.out.print("\n\t원하시는 메뉴를 입력하세요(1-5) : ");
		int menu = scan.nextInt();
		System.out.println("\n\n-----------------------------------------------------------");
		
		return menu;
	}	
	
	public static void add(Ch6_ex20_Account account){
		
		current += 1;
		
		accounts[current] = account;
		
	}
	
	public static void listAccount() {

		System.out.println("\n\t계좌 목록을 불러옵니다.");
		
		for(int i=0; i<current+1; i++){
			System.out.printf("\n\t%s\t%s\t%d", accounts[i].getAccountNum(), accounts[i].getOwner(), accounts[i].getBalance());
			System.out.println();
		}
	}
	
	public static void withdrawMoney() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t출금 메뉴를 선택하셨습니다. ");
		
		System.out.print("\n\t계좌 번호를 입력하세요 (예 : 000-000) : ");
		inputaccountNum = scan.nextLine();
		
		if(findAccount()==1)
			return;
		
		System.out.printf("\n\t현재 고객님 계좌의 잔액은 %d 원 입니다. ", accounts[index].getBalance());
		
		System.out.print("\n\t출금액을 입력하세요 (예 : 1000) : ");
		money = scan.nextInt();
		
		withdrawing();
		
		System.out.printf("\n\t%s 고객님의 계좌에서 %d 원이 출금 되었습니다. 이용해주셔서 감사합니다.", accounts[index].getOwner(), money);
		
		System.out.println();
	}
	
	private static void withdrawing() {
		
		int temp;
		
		temp = accounts[index].getBalance();
		
		temp -= money;
		
		accounts[index].setBalance(temp);
		
	}

	public static void saveMoney() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t예금 메뉴를 선택하셨습니다. ");
		
		System.out.print("\n\t계좌 번호를 입력하세요 (예 : 000-000) : ");
		inputaccountNum = scan.nextLine();
		
		if(findAccount()==1)
			return;
		
		System.out.print("\n\t예금액을 입력하세요 (예 : 1000) : ");
		money = scan.nextInt();
		
		saving(); // 계좌 잔액에 예금액 추가
		
		System.out.printf("\n\t%s 고객님의 계좌에 %d 원이 예금 되었습니다. 이용해주셔서 감사합니다.", accounts[index].getOwner(), money);
		
		System.out.println();
	}

	private static int findAccount() {
		
		end = 0;
		
		for(int i=0; i<current+1; i++)
			if(inputaccountNum.equals(accounts[i].getAccountNum())) {
				index =  i;
				System.out.printf("\n\t%s 고객님의 계좌입니다.\n", accounts[i].getOwner());
				return 0;
			}	
		System.out.println("\n\t존재하지 않는 계좌번호 입니다. 계좌를 생성해주세요.");	
		end = 1;

		return end;
	}
	
	private static void saving() {
		
		int temp;
		
		temp = accounts[index].getBalance();
		
		temp += money;
		
		accounts[index].setBalance(temp);
	}

}
