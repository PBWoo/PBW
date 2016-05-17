import java.util.Scanner;

public class OmokProgram7 {

	// 오목게임 다시 만들어보기
	
	public static void main(String[] args) {

		int height = 20;
		int width = 25;
		char [][] board = new char[height][width];
		int[] xs = new int[500];
		int[] ys = new int[500]; // 사용자가 오목돌을 놓은 좌표를 순서에 맞게 저장하는 배열
		
		Scanner scan = new Scanner(System.in);
		
		omok :
		while(true)
		{
			System.out.println("┌─────────────────────┐");
			System.out.println("│                       오목  게임                         │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 게임 시작");
			System.out.println("\t2. 게임 종료");
			
			int menu;
			System.out.print("\n\t원하는 메뉴를 입력하세요 : ");
			menu = scan.nextInt();
			System.out.println("\n");
			
			// 오목판 그리기
			
			 for(int x=0; x<height; x++)
				 for(int y=0; y<width; y++)
					  board[x][y]='┼';
			
			 for(int i=0; i<height; i++)
				 board[i][0]='├';
			 for(int i=0; i<height; i++)
				 board[i][width-1]='┤';
			 for(int i=0; i<width; i++)
				 board[0][i]='┬';
			 for(int i=0; i<width; i++)
				 board[height-1][i]='┴';
			 
			 board[0][0]='┌';
			 board[0][width-1]='┐';
			 board[height-1][0]='└';
			 board[height-1][width-1]='┘';
			 
			switch(menu)
			{
				case 1:
					
					 // 오목판 출력
					 
					 for(int x=0; x<height; x++)
					 {
						 for(int y=0; y<width; y++)
							 System.out.printf("%c", board[x][y]);
						
						 System.out.println();
					 }
					 
					 int count = 0;
					 
					play :
					while(true)
					{
						System.out.print("\n\t원하는 좌표를 입력하세요 (x sp y) : ");
						 xs[count] = scan.nextInt();
						 ys[count] = scan.nextInt();
						 
						 // 오목판을 벗어나는 좌표를 입력한 경우
						 if(!(0<xs[count] && xs[count]<height+1) || !(0<ys[count] && ys[count]<width+1))
						 {
							 System.out.println("\n\t오목판을 벗어난 위치입니다. 다시 입력해주세요.");
							 continue;
						 }
						 
						 // 이미 다른 돌이 놓인 좌표를 입력한 경우 (중복)
						 if(board[xs[count]-1][ys[count]-1]=='○' || board[xs[count]-1][ys[count]-1]=='●')
						 {
							 System.out.println("\n\t이미 다른 오목돌이 있습니다. 다른 좌표를 입력해주세요.");
							 continue;
						 }
						 
						 // 사용자가 입력한 좌표에 오목돌 출력
						 for(int i=0; i<=count; i++)
							 if(i%2==0)
								 board[xs[i]-1][ys[i]-1]='○'; // 사용자가 입력한 좌표는 (1,1) 부터 시작하지만 배열이 [0][0]부터 시작하므로 -1 해준다.
							 else
								 board[xs[i]-1][ys[i]-1]='●';
						 
						 // 오목판 출력
						 for(int x=0; x<height; x++)
						 {
							 for(int y=0; y<width; y++)
								 System.out.printf("%c", board[x][y]);
							
							 System.out.println();
						 }
					     
					     // 승패가 결정나면 게임을 끝내고 메인 메뉴로 이동
						 
						 /*if(xs[count]==1 && ys[count]==1)
						 for(int y=0; y<4; y++)
						 {
							 if((board[0][0]==board[0][y+1]) && board[0][0]!='┼')
								 check +=1;
							 else
								 break;
							 
							 if(check==4)
				    		 {
				    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[0][0]);  // 승패가 결정났을 때의 좌표 (x,y)
				    			 break play;
				    		 }	
						 }*/
					 	 
						 	// (가장 최근에 놓은 돌을 기준으로) 오른쪽으로 5개가 같은 돌일 때 게임 종료
							 int check = 0;
							
							 if(xs[count]>4)
						    	 for(int x=xs[count]-1; x<xs[count]+4; x++)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)+i]) && board[x][ys[count]-1]!='┼')
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[x][ys[count]-1]);  // 승패가 결정났을 때의 좌표 (x,y)
						    			 break play;
						    		 }	 
						    	 }
							 
							// (가장 최근에 놓은 돌을 기준으로) 왼쪽으로 5개가 같은 돌일 때 게임 종료
							 else if (xs[count]<23)
						    	 for(int x=xs[count]-1; x>xs[count]-6; x--)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)-i]) && (board[x][ys[count]-1]=='●' || board[x][ys[count]-1]=='○' ))
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[x][ys[count]-1]);  // 승패가 결정났을 때의 좌표 (x,y)
						    			 break play;
						    		 }	 
						    	 }
							 
							 // (가장 최근에 놓은 돌을 기준으로) 아래로 5개가 같은 돌일 때 게임 종료
							 else if (xs[count]<23)
						    	 for(int x=xs[count]-1; x>xs[count]-6; x--)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)-i]) && (board[x][ys[count]-1]=='●' || board[x][ys[count]-1]=='○' ))
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[x][ys[count]-1]);  // 승패가 결정났을 때의 좌표 (x,y)
						    			 break play;
						    		 }	 
						    	 }
							 
							// (가장 최근에 놓은 돌을 기준으로) 위로 5개가 같은 돌일 때 게임 종료
							 else if (ys[count]<23)
						    	 for(int x=xs[count]-1; x>xs[count]-6; x--)
						    	 {
						    		 for(int i=1; i<6; i++)
						    			 if((board[x][ys[count]-1]==board[x][(ys[count]-1)-i]) && (board[x][ys[count]-1]=='●' || board[x][ys[count]-1]=='○' ))
						    				 check +=1;
						    			 else
						    				 break;
						    	 
						    		 if(check==4)
						    		 {
						    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[x][ys[count]-1]);  // 승패가 결정났을 때의 좌표 (x,y)
						    			 break play;
						    		 }	 
						    	 }
						 count++; // 오목돌을 놓은 횟수
						 
						 // 더이상 놓을 자리가 없을 때
						 if(count>=500)
						 {
							 System.out.println("\n\t더이상 놓을 자리가 없습니다. 무승부! \n\t게임을 종료하고 메인 메뉴로 돌아갑니다.");
							 break play;
						 }
					}
				break;
				
				case 2:
					System.out.println("\n\t오목 게임을 종료합니다.");
					break omok;
			}
		}
	}
}



















