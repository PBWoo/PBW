import java.util.Scanner;

public class Omok {

	int height; 
	int width; 
	char [][] board ; 
	int[] xs; 
	int[] ys; 
	
	int count;
	int check;
	int end;
	
	
	public void drawBoard() {

		height = 20;
		width = 25;
		board = new char[height][width] ;
		
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

	}
	
	public void putOmokStone() {

			 if(count%2==0)
				 board[xs[count]-1][ys[count]-1]='○'; 
			 else
				 board[xs[count]-1][ys[count]-1]='●';
		 
		 printBoard(); // 오목판 출력
	}
	
	public void printBoard() {
		
		for(int x=0; x<height; x++)
		 {
			 for(int y=0; y<width; y++)
				 System.out.printf("%c", board[x][y]);
			
			 System.out.println();
		 }
		
	}
	
	public void inputXY(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t원하는 좌표를 입력하세요 (x sp y) : ");
		 xs[count] = scan.nextInt();
		 ys[count] = scan.nextInt();
	}
	
	public int outOfBoard(){
		
		 // ↓오목판을 벗어나는 좌표를 입력한 경우↓
		
		end = 0; //end값 0으로 초기화
		 
		 if(!(0<xs[count] && xs[count]<height+1) || !(0<ys[count] && ys[count]<width+1))
		 {
			 System.out.println("\n\t오목판을 벗어난 위치입니다. 다시 입력해주세요.");
			 end = 1;
			 count--;
		 }
		 return end;
	}
	
	public int overLap(){
		
		 // ↓이미 다른 돌이 놓인 좌표를 입력한 경우 (중복)↓
		
		end = 0; //end값 0으로 초기화
		 
		 if(board[xs[count]-1][ys[count]-1]=='○' || board[xs[count]-1][ys[count]-1]=='●')
		 {
			 System.out.println("\n\t이미 다른 오목돌이 있습니다. 다른 좌표를 입력해주세요.");
			end=1;
			count--;
		 }
		 return end;
	}
	
	// 가로 조건 검사
	public int horisontalWin() {
		
	    check = 0;
	    end = 0;       //end=1이면 게임 종료
	 
		 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
		 {		 
			 // (최근에 놓은 돌)○○○○ 의 경우
				 for(int i=1; i<5; i++){
					 if(!((ys[count]-1)>20))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
							 check += 1; 
				 }
				 if(check==4) {
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
					end = 1; 
				 }
				 check = 0;
		    
	       // ○(최근에 놓은 돌)○○○ 의 경우 
				 for(int i=1; i<4; i++){
					 if(!((ys[count]-1)>21))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
							 check += 1;
				 }
				 if(check==3)
					 if(!((xs[count]-1)<1))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)-1])
							 check += 1;
				 if(check==4){
					 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
				 }
				 check = 0;
				 
	      // ○○(최근에 놓은 돌)○○ 의 경우 
				 for(int i=1; i<3; i++){
					 if(!((ys[count]-1)>22))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1+i])
							 check += 1;
				 }
				 if(check==2)
					 for(int i=1; i<3; i++){
						 if(!((xs[count]-1)<2))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)-i])
								 check += 1;
					 }
				 if(check==4){
					 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
					}
				 check = 0;
				 
		// ○○○(최근에 놓은 돌)○ 의 경우 
				 for(int i=1; i<4; i++){
					 if(!((ys[count]-1)<3))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1-i])
							 check += 1;
				 }
				 if(check==3)
					 if(!((ys[count]-1)>23))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][(ys[count]-1)+1])
							 check += 1;
				 if(check==4){
					 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
					}
				 check = 0;
				 
		// ○○○○(최근에 놓은 돌) 의 경우
				 for(int i=1; i<5; i++){
					 if(!((ys[count]-1)<4))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1][ys[count]-1-i])
							 check += 1;
				 }
						 
				 if(check==4){
					 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
				   }
				 check = 0;
	 	}
		 return end;
	}

// 세로 조건 검사
	public int verticalWin(){

		check = 0;
		end = 0;      //end=1이면 게임 종료
		
		 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
		 {		 
		 	// (최근에 놓은 돌)○○○○↓ 의 경우
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)>15))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 check += 1;
			 }
			 if(check==4) {
			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
			 end = 1; 
			 }
			 check = 0;
	    
			 // ↑○(최근에 놓은 돌)○○○↓ 의 경우 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)>16))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)<1))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][ys[count]-1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			 }
			 check = 0;
			 
			 // ↑○○(최근에 놓은 돌)○○↓ 의 경우 
			 for(int i=1; i<3; i++){
				 if(!((xs[count]-1)>17))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!((xs[count]-1)<2))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ↑○○○(최근에 놓은 돌)○↓ 의 경우 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)<3))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)>18))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][ys[count]-1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ↑○○○○(최근에 놓은 돌) 의 경우
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)<4))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1])
						 check += 1;
			 }
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			   }
			 check = 0;
	 }
		 return end;
}

// 오른쪽 대각선 조건 검사
	public int rightDiagonalWin(){
		

	
		check = 0;
		end = 0;       //end=1이면 게임 종료
		
				 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
				 {		 
				 	// (최근에 놓은 돌)○○○○↘ 의 경우
					 for(int i=1; i<5; i++){
						 if(!((xs[count]-1)>15 || (ys[count]-1)>20))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
								 check += 1;
					 }
					 if(check==4) {
					 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
					 end = 1; 
					 }
					 check = 0;
			    
					 // ↖○(최근에 놓은 돌)○○○↘ 의 경우 
					 for(int i=1; i<4; i++){
						 if(!((xs[count]-1)>16 || (ys[count]-1)>21))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
								 check += 1;
					 }
					 if(check==3)
						 if(!((xs[count]-1)<1 || (ys[count]-1) <1))
							 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)-1])
								 check += 1;
					 if(check==4){
						 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
					 }
					 check = 0;
					 
					 // ↖○○(최근에 놓은 돌)○○↘ 의 경우 
					 for(int i=1; i<3; i++){
						 if(!((xs[count]-1)>17 || (ys[count]-1)>22))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1+i])
								 check += 1;
					 }
					 if(check==2)
						 for(int i=1; i<3; i++){
							 if(!((xs[count]-1)<2 || (ys[count]-1) <2))
								 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
									 check += 1;
						 }
					 if(check==4){
						 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
						}
					 check = 0;
					 
					 // ↖○○○(최근에 놓은 돌)○↘ 의 경우 
					 for(int i=1; i<4; i++){
						 if(!((xs[count]-1)<3 || (ys[count]-1) <3))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
								 check += 1;
					 }
					 if(check==3)
						 if(!((xs[count]-1)>18 || (ys[count]-1)>23))
							 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)+1][(ys[count]-1)+1])
								 check += 1;
					 if(check==4){
						 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
						}
					 check = 0;
					 
					 // ↖○○○○(최근에 놓은 돌) 의 경우
					 for(int i=1; i<5; i++){
						 if(!((xs[count]-1)<4 || (ys[count]-1) <4))
							 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1-i])
								 check += 1;
					 }
					 if(check==4){
						 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
						 end = 1; 
					   }
					 check = 0;
			 }
				 return end;
		}

// 왼쪽 대각선 조건 검사
	public int leftDiagonalWin(){
		
		check = 0;
		end = 0;        //end=1이면 게임 종료
		
		 if(board[xs[count]-1][ys[count]-1]=='●' || board[xs[count]-1][ys[count]-1]=='○')
		 {		 
		 	// (최근에 놓은 돌)○○○○↗ 의 경우
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)<4 || (ys[count]-1)>20))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
						 check += 1;
			 }
			 if(check==4) {
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			 }
			 check = 0;
	    
			 // ↙○(최근에 놓은 돌)○○○↗ 의 경우 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)<3 || (ys[count]-1)>21))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)>18 || (ys[count]-1) <1))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)+1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			 }
			 check = 0;
			 
			 // ↙○○(최근에 놓은 돌)○○↗ 의 경우 
			 for(int i=1; i<3; i++){
				 if(!((xs[count]-1)>17 || (ys[count]-1) <2))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
						 check += 1;
			 }
			 if(check==2)
				 for(int i=1; i<3; i++){
					 if(!((xs[count]-1)<2 || (ys[count]-1)>22))
						 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1-i][ys[count]-1+i])
							 check += 1;
				 }
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ↙○○○(최근에 놓은 돌)○↗ 의 경우 
			 for(int i=1; i<4; i++){
				 if(!((xs[count]-1)>16 || (ys[count]-1) <3))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
						 check += 1;
			 }
			 if(check==3)
				 if(!((xs[count]-1)<1 || (ys[count]-1)>23))
					 if(board[xs[count]-1][ys[count]-1]== board[(xs[count]-1)-1][(ys[count]-1)+1])
						 check += 1;
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
				}
			 check = 0;
			 
			 // ↙○○○○(최근에 놓은 돌) 의 경우
			 for(int i=1; i<5; i++){
				 if(!((xs[count]-1)>15 || (ys[count]-1) <4))
					 if(board[xs[count]-1][ys[count]-1]== board[xs[count]-1+i][ys[count]-1-i])
						 check += 1;
			 }
			 if(check==4){
				 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);
				 end = 1; 
			   }
			 check = 0;
	 }
		 return end;
}
	
	public int draw(){
		
	 // ↓ 무승부 : 더이상 놓을 자리가 없을 때 
	 
		end = 0;
		
		if(count>=500)
		{
		 System.out.println("\n\t더이상 놓을 자리가 없습니다. 무승부! \n\t게임을 종료하고 메인 메뉴로 돌아갑니다.");
		 end = 1;
	 	}
		return end;
	}
}
