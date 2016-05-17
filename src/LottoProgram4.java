import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


// 코드 설명 포함
public class LottoProgram4 {

	public static void main(String[] args) throws IOException {
	
		//내가 뽑은 번호 저장
		//확률이 높은 번호 3개 뽑기 (시간 된다면 구현해보기)
		
		//자동 선택 / 수동 선택(필수)
	
		Scanner scan = new Scanner(System.in);
		
		//컬렉팅 하기 위한 변수들과 함께 저장소 변수 선언
		int [][] lottos = new int[10][6]; //6개씩의 번호를 10개 생성
		int current = -1; 
		
		// current  : 마지막에 저장한 데이터의 위치가 어딘지를 의미
		// -1이란 저장된 데이터가 없는 index를 의미 
		// 0으로 초기화하게 되면 데이터를 저장하기 전부터 이미 0의 위치에 데이터를 저장했다는 의미가 되므로 관습처럼 -1로 초기화하여 쓴다.
		// 0으로 초기화하고 싶다면 변수명을 next로 바꿔줘야 흐름상 의미상 맞다. (그냥 -1로 쓰자)
		
		end:
		while(true)
		{	
			int menu=0; //menu는 반복될 때마다 값이 바뀌어도 되니까 (초기화 안해도 되니까) while문 안에 둔다.
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
						int submenu = 0;
						
						System.out.println("\n\t\t=============로또 목록===============\n");
						
						// 목록 출력 코드를 작성 (저장되어 있는 번호 출력)
						
						if(current==-1)
							System.out.println("\t\t\t  저장된 번호가 없습니다!");
						
						/* 예시
						1 : 11 14 39 28 27 13
						2 : 23 28 29 43 12 11
						3 : 11 14 39 28 27 13
						...
						*/
						
						/* 1번 방법 (차수가 높은 배열일수록 복잡해진다.)
						for(int i=0; i<current+1; i++)
							System.out.printf("%d : %d\t%d\t%d\t%d\t%d\t%d\n", i+1,lottos[i][0],lottos[i][1],lottos[i][2],lottos[i][3],lottos[i][4],lottos[i][5]);
						*/
						
						//2번 방법 (차수에 상관없이 간단하다.)
						for(int i=0; i<current+1; i++)
						{
							int[] lotto = lottos[i]; 
							
							//숫자 6개씩 10개의 이차 배열을 짤라서 한 행씩 참조한다. (값의 주소를 나타낼 뿐 값이 들어있는 공간이 아니다.)
							//기본 자료형이 명시되지 않은 배열은 위치일뿐 lotto[i]는 6개씩 번호가 저장된 배열 하나(한 행)의 주소를 의미한다.
							//lotto[i][j]는 한 행안에서 j개씩 i개 각각의 공간을 의미 - lotto[i] 이렇게 자르면 i개의 한행의 주소(위치)를 의미
							
							System.out.printf("\t\t\t%d  :  %d  %d  %d  %d  %d  %d\n", i+1,lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
						}
						
						System.out.println("\n\t\t====================================\n");
						System.out.println("\t\t1. 번호 생성 ");
						System.out.println("\t\t2. 번호 입력 ");
						System.out.println("\t\t3. 상위 메뉴로 이동 ");
						System.out.print("\n\t\t메뉴를 선택하세요 : ");
						submenu = scan.nextInt();
						
						switch(submenu)
						{
							case 1: 
							// case는 중괄호가 필요없지만 이름이 같은 지역변수를 사용하기 위해 중괄호를 써준다.
							// case 끼리는 중괄호를 통해 이름이 같은 지역변수를 사용할 수 있다.
						    // 상위 반복문과 case 끼리는 중괄호를 쓰더라도 이름이 같은 지역변수를 사용할 수 없다.	
							{
								
								Random rand = new Random();
								int[] lotto = new int[6]; 
								
								// 위에 2차 배열을 선언했지만 case1에서 사용할 배열을 따로 선언해주는 것이 코드가 쉬워지고 수정도 편하다.
								// 메모리도 많이 사용하고, 속도도 느려지지만 큰 영향은x, 또한 case1에서 이차 배열은 필요 없다. 

								int temp;
								int check = 0;
								
								for(int i=0; i<6; i++)
									lotto[i] = rand.nextInt(); // 랜덤 값을 뽑는게 아니라 불러온 파일 안에 있는 값을 하나씩 읽어옴
			
								//숙제 : 중복 검사 입력 (무한루프에 빠지지 않도록 구현)
								
								do
								{
									check = 0;
									
									for(int i=0; i<6; i++)	
										lotto[i] = rand.nextInt(45)+1;
									
									for(int i=0; i<6; i++)	
										for(int j=i+1; j<6; j++)
												if(lotto[i]== lotto[j])
													check++;

								}while(check!=0);
								
								//정렬하기
								
								for(int j=0; j<5; j++)                                    // for(int j=5; j>0; j--)
									for(int i=0; i<5-j; i++)                              // for(int i=0; i<j; i++) 
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
								
								
								//lotto에 있는 값을 lottos로 옮기는 작업
								++current; 
								
								// current가 -1이었기 때문에 ++로 index를 0으로 맞춰주고 시작 
								// 후위 증가를 하게 되면 밑에 for문에서 처음에 -1로 들어가게 되므로 전위 증가 시켜줘야 한다. (문제집 p.71예제 풀어보기!)
								
								for(int i=0; i<6; i++)
									lottos[current][i]=lotto[i]; 
								
								// 이 부분에서 ++current를 넣으면 대각선으로 번호가 생성됨
								// 6개의 번호를 저장하는 동안 current 값은 변하면 안된다. 새로운 6개의 번호를 저장할 때 변한다.
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
					break;
					
				case 3: 
					
					//파일 저장 절대경로 방식은 "C:\\workspace\\hello.txt" 내 컴퓨터에 실제로 파일이 저장되어 있는 위치를 입력하기 때문에
					//다른 컴퓨터에서도 똑같은 위치에 (같은 디렉터리 내에) 파일이 존재해야 하므로 매우 비효율적이다.
					//따라서 아래처럼 상대경로 방식을 사용한다.
					
					FileOutputStream fos = new FileOutputStream("res/lotto/lottos.txt"); 
					PrintStream fout = new PrintStream(fos); // 사용할 구역 내에서 작성하는 게 코드 처음에 작성하는 것보다 낫다.
					
					//아무것도 없이 파일명만 입력하면("lottos.txt") 현재 루트 내에서 파일을 검색한다.
					//res 폴더 안의 lotto폴더 안의 lottos.txt파일 검색(상대 경로 방식)
						
					for(int i=0; i<current+1; i++)
					{
						int[] lotto = lottos[i]; 
						fout.printf("\t%d  %d  %d  %d  %d  %d\r\n", lotto[0],lotto[1],lotto[2],lotto[3],lotto[4],lotto[5]);
					} 
					// 콘솔에 입력받을 때와 같은 방법이다. fout과 System.out 의 차이일 뿐
					// 파일 입출력과 네트워크 입출력에서 파일에 저장할 때에는 줄을 바꿔줄 때 \r를 \n앞에 붙여줘야 줄바꿈이 이뤄진다. 
					
					fout.close();
					fos.close();
					
					System.out.println("\n\t\t저장 완료했습니다.");
					
					break;
					
				case 4:
					System.out.println("\n\t\t로또 프로그램을 종료합니다.");
					break end;
			}
			
		}
	}
}

