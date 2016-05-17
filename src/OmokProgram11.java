import java.util.Scanner;

public class OmokProgram11 {

	// 오목게임 구조화 (완성)
	
	public static void main(String[] args) {

		
		Omok omoks = new Omok();
		
		omoks.xs = new int[500];
		omoks.ys = new int[500];
		
		omoks.count = -1;
		
		omok :
		while(true)
		{	
			omoks.end = 0;
			omoks.drawBoard(); // ←오목판 그리기
			 
			switch(inputMainMenu()) // ←inputMainMenu 함수를 통해 메뉴 번호 입력 받기
			{
				case 1:
					 
					omoks.printBoard(); // ←빈 오목판 출력
					
					play :
					while(true)
					{
						omoks.count += 1;
						omoks.inputXY();
						 
						 // ↓오목판을 벗어나는 좌표를 입력한 경우↓
						 
						 if(omoks.outOfBoard()==1)
							 continue;
						 
						 
						 // ↓이미 다른 돌이 놓인 좌표를 입력한 경우 (중복)↓
						 
						 if(omoks.overLap()==1)
							 continue;
						 
						// ↓사용자가 입력한 좌표에 흰 돌/검은 돌 놓기
						 
					 	omoks.putOmokStone();   
					 	
					 	if(omoks.horisontalWin()==1)  // ← 가로 승리 조건 만족시 end=1이 되어 게임 종료
					 		break play;
					 	else if(omoks.verticalWin()==1)
					 		break play;
					 	else if(omoks.rightDiagonalWin()==1)
					 		break play;
					 	else if(omoks.leftDiagonalWin()==1)
					 		break play;
					 		
						 
						 // ↓더이상 놓을 자리가 없을 때
						 
						 if(omoks.draw()==1)
							 break play;
						 
					}
				break;
				
				case 2:
					System.out.println("\n\t오목 게임을 종료합니다.");
					break omok;
			}
		}
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