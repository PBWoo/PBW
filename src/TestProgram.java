import java.util.Scanner;

public class TestProgram {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int menu = 0;
		int start = 0;
		int end = 0;
		int menu2 = 0;
		int count = 0;
		
		here :
		while(true)
		{
			System.out.println("┌─────────────────────┐");
			System.out.println("│               합을 구하는 프로그램                 │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 값 입력");
			System.out.println("\t2. 결과 보기");
			System.out.println("\t3. 도움말");
			System.out.println("\t4. 종료");
			System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
			
			menu = scan.nextInt();
			System.out.println("\n");
			
			switch(menu) {
			
					case 1: {
						System.out.println("\n┌─────────────────────┐");
						System.out.println("│                       값  입력                            │");
						System.out.println("└─────────────────────┘");
						
						out :
						while(true)
						{
							System.out.print("\n\t(시작값 sp 끝값) : ");
							
							start = scan.nextInt();
							end = scan.nextInt();
							System.out.println("\n");
				
							smallout :
							while(true)
							{
								System.out.print("\t상위 메뉴로 이동 (yes-1/재입력-2) : ");
								menu2 = scan.nextInt();
							
								if(menu2==1)
									break out;
								else if(menu2==2)
								{
									System.out.println("\t다시 입력해주세요.");
									break smallout;
								}
								else
									System.out.println("\t잘못 입력하셨습니다.");
							}
						}		
					}
					break;
					
					case 2: {
						
						int sum=0;
						
						/*
						for(int i=start; i<=end; i++ )
							sum += i;
						*/
						count = end - start + 1;
						sum = (count*(start+end))/2;
						
						System.out.println("\n┌─────────────────────┐");
						System.out.println("│                       결과  보기                         │");
						System.out.println("└─────────────────────┘");
						System.out.printf("\t[%d] 부터 [%d] 까지의 합은 [%d] 입니다.\n\n", start, end, sum);
						
						while(true)
						{
							System.out.print("\t상위 메뉴로 이동 (yes-1) : ");
							menu2 = scan.nextInt();
							
								if(menu2 != 1)
									System.out.println("\t잘못 입력하셨습니다.");
								else
									break;
						}
					}
					break;
					
					case 3:
						System.out.println("\t도움말입니다.\n");
						break;
						
					case 4:
						System.out.println("\t종료합니다.\n");
						break here;
						
					default :
						System.out.println("\t잘못 입력하셨습니다.\n");
				} // switch문 종료
				
			} // while문 종료
		
		}

	}

