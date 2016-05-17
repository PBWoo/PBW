package practice.oop.omok;

public class Board {

	private int height;
	private int width;
	private char[][] board;
	private Stone[] stones;

	public Board(){
		
		height = 20;
		width = 25;
		board = new char[height][width];
		stones = new Stone[height*width];
	
		initBoard();
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public Stone[] getStones() {
		return stones;
	}

	public void setStones(Stone[] stones) {
		this.stones = stones;
	}
	
	private void initBoard() {

		 for(int y=0; y<height; y++)
			 for(int x=0; x<width; x++)
				  board[y][x]='¦«';
		
		 for(int i=0; i<height; i++)
			 board[i][0]='¦§';
		 for(int i=0; i<height; i++)
			 board[i][width-1]='¦©';
		 for(int i=0; i<width; i++)
			 board[0][i]='¦¨';
		 for(int i=0; i<width; i++)
			 board[height-1][i]='¦ª';
		 
		 board[0][0]='¦£';
		 board[0][width-1]='¦¤';
		 board[height-1][0]='¦¦';
		 board[height-1][width-1]='¦¥';
	}

	public void print(){
			
		for(int y=0; y<height; y++)
		 {
			 for(int x=0; x<width; x++)
				 System.out.printf("%c", board[y][x]);
			
			 System.out.println();
		 }
	
	}
}
