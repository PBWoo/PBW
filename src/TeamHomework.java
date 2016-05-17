import java.util.Scanner;

public class TeamHomework {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		char small;
		int big;
		
		Alpha :
		while(true)
		{
			System.out.println("\n\t\t┌─────────────────────┐");
			System.out.println("\t\t│          특수한 알파벳 정렬 프로그램           │");
			System.out.println("\t\t└─────────────────────┘");
			System.out.println("\n\t 소문자를 입력받아 대문자로 변환 후 입력받은 문자부터 Z까지, \n\t 다시 그 문자까지 출력하는 프로그램 입니다.");
			System.out.println("\n\t1. 시작");
			System.out.println("\t2. 종료");
			
			System.out.print("\n\t원하는 메뉴를 입력하세요 : ");
			menu = scan.nextInt();
			System.out.println();
			
			switch(menu)
			{
				case 1:
				{
					while(true)
					{
						System.out.print("\n\t소문자를 입력하세요 : ");
						small = scan.next().charAt(0); //charAt(0) : 입력받은 문자열(string)에서 0번째 문자(처음 문자)를 +연산이 가능하도록 char형으로 변환
					
						if('a'<=small && small<='z')
							break;
						
						System.out.println("\n\t잘못 입력하셨습니다.");
					}
					
					big = (small-('z'-'Z'));
					
					System.out.println("\n\t입력하신 소문자는 " + small + " 입니다.");
					System.out.printf("\n\t대문자로는 %c 입니다.", big);
					System.out.println("\n\n\t< 정 렬 >\n"); 
					
					int cnt = 'Z'-big+1;
					
					cnt *= 2;
					
					for(int i=0; i<cnt; i++)
					{
						if(i != 0 && i%(cnt/2)==0)
							continue;
						
						System.out.printf("%c", (i<cnt/2) ? (big + i) : ('Z'- i%(cnt/2)));
					}
					System.out.println();
				}
				break;
				
				case 2:
					System.out.println("\t프로그램을 종료합니다.");
					
					break Alpha;
				
				default :
					System.out.println("\t잘못 입력하셨습니다.");
			}
			
		}
	}

}
