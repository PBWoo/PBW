import java.util.Scanner;

public class GugudanProgram {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int inputdan = 0;
		int num1, num2;
		
		ggdan :
		while(true)
		{
			System.out.println("\n┌─────────────────────┐");
			System.out.println("│                   곱셈 프로그램                    │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 구구단 전체 출력");
			System.out.println("\t2. 원하는 단 출력");
			System.out.println("\t3. 곱셈 계산기");
			System.out.println("\t4. 종료");
			
			System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
			menu = scan.nextInt();
			
			switch(menu)
			{
				case 1 :
				{
					System.out.println("┌─────────────────────┐");
					System.out.println("│                   구구단 전체 보기                   │");
					System.out.println("└─────────────────────┘");
					
					for(int dan=2; dan<10; dan++)
					{
						System.out.println("\t\t===== " + dan + "단 =====\n");
						
						for(int i=1; i<10; i++)
							System.out.println("\t\t  " + dan + " X " + i + " = " + dan*i);
						
						System.out.println();
					}
				}
				break;
				
				case 2 :
				{
					System.out.println("\n┌─────────────────────┐");
					System.out.println("│                선택한 구구단 보기                   │");
					System.out.println("└─────────────────────┘");
					
					while(true)
					{
						System.out.print("\n\t원하는 단을 입력하세요(2~9) : ");
						inputdan = scan.nextInt();
						System.out.println("\n");
						
						if(!(1<inputdan && inputdan<10))
							System.out.println("\n\t잘못 입력하셨습니다.\n");
						else 
							break;
					}
					
					System.out.println("\t\t===== " + inputdan + "단 =====\n");
					
					for(int i=1; i<10; i++)
						System.out.println("\t\t   " + inputdan + " X " + i + " = " + inputdan*i + "\n");
				}
				break;
				
				case 3 :
				{
					System.out.println("\n┌─────────────────────┐");
					System.out.println("│                        곱셈 계산기                      │");
					System.out.println("└─────────────────────┘");
					
					while(true)
					{
						System.out.print("\n\t곱셈을 원하는 두 수를 입력하세요. \n\t( a sp b / 메인메뉴 : 0 ) : ");
						num1 = scan.nextInt();
						
							if(num1==0)
								break;
						
						num2 = scan.nextInt();
						System.out.println("\n");
						
						System.out.printf("\t%d" + " X " + "%d" + " = " + "%d\n", num1, num2, num1*num2);
					}
				}
				break;
				
				case 4 :
				{
					System.out.println("\n\t구구단 프로그램을 종료합니다.");
					break ggdan;
				}
				
				default :
					System.out.println("\n\t잘못 입력하셨습니다.\n");
			}
			
		}

	}

}
