import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

//코드 설명은 LottoProgram4에 저장

public class LottoProgram5 {

	public static void main(String[] args) throws IOException {
	
		Scanner scan = new Scanner(System.in);
		
		//컬렉팅 하기 위한 변수들과 함께 저장소 변수 선언
		int [][] lottos = new int[10][6]; 
		int current = -1; 
		
		end:
		while(true)
		{	
			int menu=0; 
			System.out.println("\n\t\t=============로또 메뉴===============");
			System.out.println("\n\t\t1. 번호 목록 ");
			System.out.println("\t\t2. 번호 읽기 ");
			System.out.println("\t\t3. 번호 저장 ");
			System.out.println("\t\t4. 종료 ");
			System.out.print("\n\t\t메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			
			switch(menu)
			{
				case 1:
				{
					stop:
					while(true)
					{
						System.out.println("\n\t\t=============로또 목록===============\n");
						
						// 목록 출력 코드를 작성 (저장되어 있는 번호 출력)
						
						if(current==-1)
							System.out.println("\t\t\t  저장된 번호가 없습니다!");
						
						for(int i=0; i<current+1; i++)
						{
							int[] lotto = lottos[i]; 
							System.out.printf("\t\t\t%d  :  %d  %d  %d  %d  %d  %d\n", i+1,lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
						}
						
						System.out.println("\n\t\t====================================\n");
						System.out.println("\t\t1. 번호 생성 ");
						System.out.println("\t\t2. 번호 입력 ");
						System.out.println("\t\t3. 상위 메뉴로 이동 ");
						System.out.print("\n\t\t메뉴를 선택하세요 : ");
						int submenu = scan.nextInt();
						
						switch(submenu)
						{
							case 1: 
							{
								
								Random rand = new Random();
								int[] lotto = new int[6]; 
								
								/*for(int i=0; i<6; i++)
									lotto[i] = rand.nextInt();   // 랜덤값 6개 받기 
*/			
								//숙제 : 중복 검사 입력 (무한루프에 빠지지 않도록 구현)
								
								int check = 0;
								
								do
								{
									check = 0;
									
									for(int i=0; i<6; i++)	
										lotto[i] = rand.nextInt(45)+1; // 1~45까지 숫자 중 랜덤으로 뽑기
									
									for(int i=0; i<6; i++)	
										for(int j=i+1; j<6; j++)
												if(lotto[i]== lotto[j])
													check++;

								}while(check!=0);
								
								//정렬하기
								int temp;
								
								for(int j=0; j<5; j++)                                    
									for(int i=0; i<5-j; i++)                          
									{
										if( lotto[i]>lotto[i+1])
										{
											temp = lotto[i];
											lotto[i] = lotto[i+1];
											lotto[i+1] = temp;
										}
									}
								
								// 랜덤으로 뽑힌 번호 출력
								System.out.print("\n\t\t\t");
								
								for(int i=0; i<6; i++)
									System.out.printf("%d  ", lotto[i]);
		
								System.out.println();
								
								++current;
								
								//lotto에 있는 값을 lottos로 옮기는 작업
								
								for(int i=0; i<6; i++)
									lottos[current][i]=lotto[i]; 
							}
								break;
							
							case 2:
								break;
							
							case 3:
								break stop; // while문을 벗어남
						}
					}
				}
					break;
			
				case 2:
					
					FileInputStream fis = new FileInputStream("res/lotto/lottos.txt");
					
					current = -1; 
					
					int count = fis.read(); // read를 통해 header에서 6개씩 숫자가 몇 개 있는지 읽어옴
					
					for(int n=0; n<count; n++) // 10개 다 차지 않았는데 10번 돌릴 이유 없기 때문에 count 사용
					{
						
						int[] lotto = lottos[n]; 
			
						for(int i=0; i<6; i++)
							lotto[i] = fis.read(); // 값을 읽어와 배열에 저장
					
						current++;
					}
					fis.close();
					
					System.out.println("\n\t\t데이터 읽기가 완료되었습니다.");
					break;
					
				case 3: 
					// 숫자로 저장할 때
					// "32434567" -> 16 Byte 필요 (문자형)
					// 32434567 -> 4 Byte 필요 (정수형)
					// 꼭 문자로 저장해야 하는게 아니라면 숫자로 저장하는 것이 공간의 효율성을 높일 수 있다.
					// 바이너리(숫자)로 읽고 저장하자
					
					FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt");
					fos.write(current+1);
					for(int n=0; n<current+1; n++)
					{
						int[] lotto = lottos[n]; 
						for(int i=0; i<6; i++)
							fos.write(lotto[i]);	
					}
					fos.close();
					
					
					/*FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt"); 
					PrintStream fout = new PrintStream(fos); 
						
					for(int i=0; i<current+1; i++)
					{
						int[] lotto = lottos[i]; 
						fout.printf("\t%d  %d  %d  %d  %d  %d\r\n", lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
					} 
					
					fout.close();
					fos.close();*/
					
					System.out.println("\n\t\t저장 완료했습니다.");
					
					break;
					
				case 4:
					System.out.println("\n\t\t로또 프로그램을 종료합니다.");
					break end;
			}
			
		}
	}
}

