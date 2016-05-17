package practice.oop.omok;

import java.util.Scanner;

public class Stone {

	private int x;
	private int y;
	private int type;
	private int check;
	static boolean isWhiteTurn;
	
	private int end;
	
	public Stone(){
		x = -1;
		y = -1;
		type = 0; // 흰돌
		end = 0;
		check = 0;
	}
	
	static{
		isWhiteTurn = false; 
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void input(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t원하는 좌표를 입력하세요 (x sp y) : ");
		 x = scan.nextInt();
		 y = scan.nextInt();
		 
		 type = isWhiteTurn ? 0 : 1;
		isWhiteTurn = !isWhiteTurn;
	}
	
	public void put(char[][] board){
		
		board[y][x] = (type==0) ? '○' : '●';
	}


	public int outOfBoard(int height, int width){
		
		 // ↓오목판을 벗어나는 좌표를 입력한 경우↓
		
		end = 0; //end값 0으로 초기화
		 
		 if(!(0<y && y<height) || !(0<x && x<width))
		 {
			 System.out.println("\n\t오목판을 벗어난 위치입니다. 다시 입력해주세요.");
			 end = 1;
			 isWhiteTurn = !isWhiteTurn;
		 }
		 return end;
	}
	
	public int overLap(char[][] board){
		
		 // ↓이미 다른 돌이 놓인 좌표를 입력한 경우 (중복)↓
		
		end = 0; //end값 0으로 초기화
		 
		 if(board[y][x]=='○' || board[y][x]=='●')
		 {
			 System.out.println("\n\t이미 다른 오목돌이 있습니다. 다른 좌표를 입력해주세요.");
			end=1;
			isWhiteTurn = !isWhiteTurn;
		 }
		 return end;
	}
		
public int CheckWin(char[][] board) {
		
	    check = 0;
	    end = 0;       //end=1이면 게임 종료
	 
		 if(board[y][x]=='●' || board[y][x]=='○')
		 {		 
			 // 가로
				 for(int i=1; i<5; i++){
					 if(!(x>20))
						 if(board[y][x]== board[y][x+i])
							 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(!(i>x))
						 if(board[y][x]== board[y][x-i])
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;
		    
	       // 세로
				 for(int i=1; i<5; i++){
					 if(!(y<i))
						 if(board[y][x]== board[y-i][x])
							 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(!(15<y))
						 if(board[y][x]== board[y+i][x])
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;
				 
	      // 왼쪽대각선
				 for(int i=1; i<5; i++){
					 if(y<i || x<i)
						 continue;
					 if(board[y][x]!= board[y-i][x-i])
						 break;
					 
						 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(15<y || x>20)
						 continue;
					 
					 if(board[y][x]!= board[y+i][x+i])
						 break;
					 
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;
				 
		// 오른쪽 대각선 
				 for(int i=1; i<5; i++){
					 if(!(y<i || x>20))
						 if(board[y][x]== board[y-i][x+i])
							 check += 1; 
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 for(int i=1; i<5; i++){
					 if(!(15<y || x<i))
						 if(board[y][x]== board[y+i][x-i])
							 check += 1;
				 
					 if(check==4){
						 WinMessage(board);
						 return end;
					 }
				 }
				 check = 0;		 
		 }
		 return end; 
	}
	
	public void WinMessage(char[][] board){

		 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[y][x]);
			end = 1; 
	}
	
		public int draw(){
			
		 // ↓ 무승부 : 더이상 놓을 자리가 없을 때 
		 
			end = 0;
			
			if(x>=500)
			{
			 System.out.println("\n\t더이상 놓을 자리가 없습니다. 무승부! \n\t게임을 종료하고 메인 메뉴로 돌아갑니다.");
			 end = 1;
		 	}
			return end;
		}
}