import java.util.Scanner;

public class OmokProgram9 {

	// 오목게임 구조화!!! 아직안돼용..........
	
	public static void main(String[] args) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		omoks.height = 20;
		omoks.width = 25;
		list1.count = 0;
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;
		int height = omoks.height;
		int width = omoks.width;
		
		Scanner scan = new Scanner(System.in);
		
		omok :
		while(true)
		{	
			drawBoard(list1); // ←오목판 그리기
			 
			switch(inputMainMenu()) // ←inputMainMenu 함수를 통해 메뉴 번호 입력 받기
			{
				case 1:
					
					count = list1.count;  // ←오목돌을 놓은 횟수
					 
					printBoard(list1); // ←빈 오목판 출력
					 
					list1.check = 0;
					
					count = 0;
					
					play :
					while(true)
					{
						
						System.out.print("\n\t원하는 좌표를 입력하세요 (x sp y) : ");
						 xs[count] = scan.nextInt();
						 ys[count] = scan.nextInt();
						 
						 // ↓오목판을 벗어나는 좌표를 입력한 경우↓
						 
						 if(!(0<xs[count] && xs[count]<height+1) || !(0<ys[count] && ys[count]<width+1))
						 {
							 System.out.println("\n\t오목판을 벗어난 위치입니다. 다시 입력해주세요.");
							 continue;
						 }
						 
						 // ↓이미 다른 돌이 놓인 좌표를 입력한 경우 (중복)↓
						 
						 if(board[xs[count]-1][ys[count]-1]=='○' || board[xs[count]-1][ys[count]-1]=='●')
						 {
							 System.out.println("\n\t이미 다른 오목돌이 있습니다. 다른 좌표를 입력해주세요.");
							 continue;
						 }
						 
						// ↓사용자가 입력한 좌표에 흰 돌/검은 돌 놓기
						 
					 	putOmokStone(list1);  
					 	
					 	// ↓(가장 최근에 놓은 돌을 기준으로) 오른쪽으로 5개가 같은 돌일 때 게임 종료
					 	
					 	rightHorisontalWin(list1);  
			    		 
			    		 if(list1.check==4)
			    		 {
			    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);  // 승패가 결정났을 때의 좌표 (x,y)
			    			 break play;
			    		 }	
			    		 
			    		// ↓(가장 최근에 놓은 돌을 기준으로) 왼쪽으로 5개가 같은 돌일 때 게임 종료
						leftHorisontalWin(list1);  
						
			    		 if(list1.check==4)
			    		 {
			    			 System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**\n\t메인 메뉴로 돌아갑니다.\n\n", board[xs[count]-1][ys[count]-1]);  // 승패가 결정났을 때의 좌표 (x,y)
			    			 break play;
			    		 }	
						
						 list1.count+=1; 
						 
						 // ↓더이상 놓을 자리가 없을 때
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

	private static void leftHorisontalWin(VictoryCase list) {
		
		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;

		
		 for(int i=1; i<6; i++)
		 {
			 if(xs[count]==1 && ys[count]<5)
				 continue; 
			 else if((board[xs[count]-1][ys[count]-1]==board[xs[count]-1][(ys[count]-1)-i]) && board[xs[count]-1][ys[count]-1]!='┼')
				 list1.check +=1;
			 else
				 break;
		 }
		
	}

	private static void rightHorisontalWin(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;

		 for(int i=1; i<6; i++)
			 if((board[xs[count]-1][ys[count]-1]==board[xs[count]-1][(ys[count]-1)+i]) && board[xs[count]-1][ys[count]-1]!='┼')
				 list1.check +=1;
			 else
				 break;
	}

	private static void printBoard(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		for(int x=0; x<omoks.height; x++)
		 {
			 for(int y=0; y<omoks.width; y++)
				 System.out.printf("%c", omoks.board[x][y]);
			
			 System.out.println();
		 }
		
	}

	private static void putOmokStone(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;

		omoks.board = new char[20][25] ;
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		char[][] board = omoks.board;
		int[] xs = omoks.xs;
		int[] ys = omoks.ys;
		int count = list1.count;

	//	System.out.println(count);
		 for(int i=1; i<=count; i++)
			 if(i%2==0)
				 board[xs[i]-1][ys[i]-1]='○'; 
			 else
				 board[xs[i]-1][ys[i]-1]='●';
		 
		 printBoard(list1); // 오목판 출력
	}

	private static void drawBoard(VictoryCase list) {

		VictoryCase list1 = new VictoryCase();
		
		Omok omoks = new Omok();
		
		list1.omoks = omoks;
		
		omoks.board = new char[20][25] ;
		omoks.height = 20;
		omoks.width = 25;

		
		char[][] board = omoks.board;
		int height = omoks.height;
		int width = omoks.width;

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

	private static int inputMainMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌─────────────────────┐");
		System.out.println("│                       오목  게임                         │");
		System.out.println("└─────────────────────┘");
		System.out.println("\n\t1. 게임 시작");
		System.out.println("\t2. 게임 종료");
		
		System.out.print("\n\t원하는 메뉴를 입력하세요 : ");
		int menu = scan.nextInt();
		System.out.println("\n");
		
		return menu;
	}
}