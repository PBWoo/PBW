import java.util.Scanner;

public class OmokProgram10 {

	// 오목게임 다시 만들어보기 ( 외곽처리만 남음)
	
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
						 
						 // 예외) 외곽에 놓은 경우
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
					 	 
	// 가로 조건 검사
						 
						 int check = 0;
						 int end = 0; //end=1이면 게임 종료
						 
						 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
						 {		 
							 	// (최근에 놓은 돌)○○○○ 의 경우
								 for(int i=1; i<5; i++)
									 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
										 check += 1;
										 
								 if(check==4) {
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									break play;
								 }
								 check = 0;
						    
								 // ○(최근에 놓은 돌)○○○ 의 경우 
								 for(int i=1; i<4; i++)
						 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
						 				check += 1;
								 
								 if(check==3)
										 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)-1])
											 check += 1;
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
								 }
								 check = 0;
								 
								 // ○○(최근에 놓은 돌)○○ 의 경우 
								 for(int i=1; i<3; i++)
						 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
						 				check += 1;
								 
								 if(check==2)
									 for(int i=1; i<3; i++)
										 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)-i])
											 check += 1;
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
									}
								 check = 0;
								 
								 // ○○○(최근에 놓은 돌)○ 의 경우 
								 for(int i=1; i<4; i++)
						 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1-i])
						 				check += 1;
								 
								 if(check==3)
										 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)+1])
											 check += 1;
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
									}
								 check = 0;
								 
								 // ○○○○(최근에 놓은 돌) 의 경우
						 		 for(int i=1; i<5; i++)
									 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1-i])
										 check += 1;
										 
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
								   }
								 check = 0;
						 }
				    		 
     // 세로 조건 검사
						 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
						 {		 
							 	// (최근에 놓은 돌)○○○○ 의 경우
								 for(int i=1; i<5; i++)
									 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
										 check += 1;
										 
								 if(check==4) {
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play;
								 }
								 check = 0;
						    
								 // ○(최근에 놓은 돌)○○○ 의 경우 
								 for(int i=1; i<4; i++)
						 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 				check += 1;
								 
								 if(check==3)
										 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][ys[count]-1])
											 check += 1;
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
								 }
								 check = 0;
								 
								 // ○○(최근에 놓은 돌)○○ 의 경우 
								 for(int i=1; i<3; i++)
						 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 				check += 1;
								 
								 if(check==2)
									 for(int i=1; i<3; i++)
										 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
											 check += 1;
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
									}
								 check = 0;
								 
								 // ○○○(최근에 놓은 돌)○ 의 경우 
								 for(int i=1; i<4; i++)
						 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
						 				check += 1;
								 
								 if(check==3)
										 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][ys[count]-1])
											 check += 1;
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
									}
								 check = 0;
								 
								 // ○○○○(최근에 놓은 돌) 의 경우
								 for(int i=1; i<5; i++)
									 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
										 check += 1;
										 
								 if(check==4){
									 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
									 break play;
								   }
								 check = 0;
						 }
						 
	// 오른쪽 대각선 조건 검사
						 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
						 {		 
						 	// (최근에 놓은 돌)○○○○↘ 의 경우
							 for(int i=1; i<5; i++)
								 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
									 check += 1;
									 
							 if(check==4) {
							 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
							 break play; 
							 }
							 check = 0;
					    
							 // ↖○(최근에 놓은 돌)○○○↘ 의 경우 
							 for(int i=1; i<4; i++)
					 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
					 				check += 1;
							 
							 if(check==3)
									 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)-1])
										 check += 1;
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play; 
							 }
							 check = 0;
							 
							 // ↖○○(최근에 놓은 돌)○○↘ 의 경우 
							 for(int i=1; i<3; i++)
					 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
					 				check += 1;
							 
							 if(check==2)
								 for(int i=1; i<3; i++)
									 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
										 check += 1;
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play; 
								}
							 check = 0;
							 
							 // ↖○○○(최근에 놓은 돌)○↘ 의 경우 
							 for(int i=1; i<4; i++)
					 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
					 				check += 1;
							 
							 if(check==3)
									 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][(ys[count]-1)+1])
										 check += 1;
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play; 
								}
							 check = 0;
							 
							 // ↖○○○○(최근에 놓은 돌) 의 경우
							 for(int i=1; i<5; i++)
								 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
									 check += 1;
									 
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play; 
							   }
							 check = 0;
					 }
						 
	 // 왼쪽 대각선 조건 검사
						 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
						 {		 
						 	// (최근에 놓은 돌)○○○○↗ 의 경우
							 for(int i=1; i<5; i++)
								 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
									 check += 1;
									 
							 if(check==4) {
							 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
							 break play;
							 }
							 check = 0;
					    
							 // ↙○(최근에 놓은 돌)○○○↗ 의 경우 
							 for(int i=1; i<4; i++)
					 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
					 				check += 1;
							 
							 if(check==3)
									 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)+1])
										 check += 1;
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play;
							 }
							 check = 0;
							 
							 // ↙○○(최근에 놓은 돌)○○↗ 의 경우 
							 for(int i=1; i<3; i++)
					 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
					 				check += 1;
							 
							 if(check==2)
								 for(int i=1; i<3; i++)
									 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
										 check += 1;
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play;
								}
							 check = 0;
							 
							 // ↙○○○(최근에 놓은 돌)○↗ 의 경우 
							 for(int i=1; i<4; i++)
					 			if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
					 				check += 1;
							 
							 if(check==3)
									 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][(ys[count]-1)-1])
										 check += 1;
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play;
								}
							 check = 0;
							 
							 // ↙○○○○(최근에 놓은 돌) 의 경우
							 for(int i=1; i<5; i++)
								 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
									 check += 1;
									 
							 if(check==4){
								 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
								 break play;
							   }
							 check = 0;
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