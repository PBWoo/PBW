package practice.oop.omok;

import java.util.Scanner;

public class OmokGame {

	public static void main(String[] args) {
		
		game : 
		while(true)
		{
			switch(inputMainMenu())
			{
				case 1:
				{
					Board board = new Board();
					board.print();
					
					play :
					while(true)
					{	
						Stone stones = new Stone();
						
						stones.input();
						
						if(stones.outOfBoard(board.getHeight(), board.getWidth())==1)
							continue;
						
						if(stones.overLap(board.getBoard())==1)
							continue;
						
						stones.put(board.getBoard());
						
						board.print();
						 
						// ↓조건 검사
						
						if(stones.CheckWin(board.getBoard())==1)
							break play;
						
						 // ↓더이상 놓을 자리가 없을 때
						 
						 if(stones.draw()==1)
							 break play;
					}
				}
				break;
				
				case 2:
					System.out.println("\n\t게임을 종료합니다.");
					break game;
					
				default :
					System.out.println("\n\t잘못 입력하셨습니다. 다시 입력해주세요.");
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
