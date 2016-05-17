import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram8 {

	public static void main(String[] args) throws IOException  {
	
		Scanner scan = new Scanner(System.in);
		
		int menu =0;
		int current = -1;
		int[][] lottos = new int[10][6];
		
		endLotto:
		while(true)
		{
			System.out.println("\n\t\t=============로또 메뉴===============");
			System.out.println("\n\t\t1. 번호 목록 ");
			System.out.println("\t\t2. 번호 읽기 ");
			System.out.println("\t\t3. 번호 저장 ");
			System.out.println("\t\t4. 종료 ");
			System.out.print("\n\t\t메뉴를 선택하세요 : ");
			menu = scan.nextInt();
		
			
			switch(menu)
			{
				case 1: // 번호 목록(1. 번호 생성 / 2. 번호 입력 / 3. 상위 메뉴로 이동) 으로 세부 메뉴 나눔

					// 저장되어있는 숫자 목록 불러오기
					
					endmenu1 :
					while(true)
					{	
						System.out.println("\n\t\t=============로또 목록===============\n");
						
						if(current==-1)
							System.out.println("\t\t\t저장된 로또 번호가 없습니다!");
						
						for(int i=0; i<current+1; i++)
						{
							int[] lotto = lottos[i];
							System.out.printf("\t\t%d : %d  %d  %d  %d  %d  %d\n", i+1,lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
						}
						System.out.println("\n\t\t====================================\n");
						System.out.println("\t\t1. 번호 생성 ");
						System.out.println("\t\t2. 번호 입력 ");
						System.out.println("\t\t3. 상위 메뉴로 이동 ");
						System.out.print("\n\t\t메뉴를 선택하세요 : ");
						int submenu = scan.nextInt();
						
						switch(submenu)
						{
							case 1: // 로또 번호 랜덤 생성
								
								// 번호 6개 생성
								
								Random rand = new Random();
								int[] lotto = new int[6];

								// 중복 검사
								
								int check = 0;
								
								do{
									check = 0;
									
									for(int i=0; i<6; i++)
										lotto[i] = rand.nextInt(45)+1;
									
									for(int i=0; i<6; i++)
										for(int j=i+1; j<6; j++)
											if(lotto[i]==lotto[j])
												check+=1;            // 중복된 값이 있으면 check+1
											
								}while(check!=0);
								
								// 정렬
								
								int temp;
								
								for(int i=0; i<6; i++)
									for(int j=i+1; j<6; j++)
										if(lotto[i]>lotto[j])
										{
											temp = lotto[i];
											lotto[i]=lotto[j];
											lotto[j]=temp;
										}
								
								// 정렬된 숫자 출력
								
								System.out.printf("\n\t\t");
								
								for(int i=0; i<6; i++)
									System.out.printf("%d  ", lotto[i]);
								
								System.out.println();
								
								current++;
								
							// 임시배열 lotto에 있던 6개의 숫자를 lottos에 옮긴다. 
								
								for(int i=0; i<6; i++)
									lottos[current][i] = lotto[i];
								
							break;
								
							case 2: // 번호 입력
								
								break;
								
							case 3: // 상위메뉴로 이동
								System.out.println("\n\t\t메인 메뉴로 돌아갑니다.\n");
								break endmenu1;
							
							default : // 1,2,3 이외의 메뉴번호를 입력했을 경우
								System.out.println("\n\t\t잘못입력하셨습니다. 다시 입력해주세요. ");
								break endmenu1;
						}
					}
					break;
					
				case 2: // 번호 읽기 ( 이전에 저장했던 번호를 불러옴)

					current = -1;
					
					FileInputStream fis = new FileInputStream("res/lotto/lottos.txt");
					
					int count = fis.read();
					
					for(int n=0; n<count; n++)
					{
						int[] lotto = lottos[n];
						
						for(int i=0; i<6; i++)
							lotto[i]=fis.read();
						
						current++;
					}
					fis.close();
					
					System.out.println("\n\t\t데이터 읽기를 완료했습니다.");
					
					break;
					
				case 3: // 번호 저장 ( 파일에 생성한 번호를 저장함)
					
					FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt");
					
					fos.write(current+1);
					
					for(int n=0; n<current+1; n++)
					{
						int[] lotto = lottos[n];
						
						for(int i=0; i<6; i++)
							fos.write(lotto[i]);
					}
					fos.close();
					
					System.out.println("\n\t\t데이터 저장을 완료했습니다.");
					break;
					 
				case 4: // 프로그램 종료
					System.out.println("\n\t\t로또 프로그램을 종료합니다.");
					break endLotto;
					
				default : // 1,2,3,4 이외의 메뉴번호를 입력한 경우
					System.out.println("\n\t\t잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
}

