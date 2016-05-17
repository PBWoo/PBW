package app.omok;

public class Game {

	public static void main(String[] args) {

		Board board = new Board();

		while(true)
		{
				board.print();
	
				Stone stone = new Stone();
				
				stone.input();
				
				boolean duplicated = board.checkDuplicated(stone);
				
				if(duplicated == true)
					printError();
				else
					board.add(stone); //board에게 stone 넘기기. board가 stone을 가지고 있지만 하는 일이 없기 때문에( 호출하지 않기 때문 )
				
				//board.putStone(stone); add안에 들어감
				//stone.put(board.getBuf());  
		}	
	}
	
	public static void printError() {
		
		System.out.println("\n\t이미 다른 오목돌이 있습니다. 다른 좌표를 입력해주세요.");
	}
}
