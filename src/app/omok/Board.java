package app.omok;

public class Board {

	private int width;
	private int height;
	private char[][] buf;
	private Stone[] stones;
	
	private int current;
	
	public Board(){
		width = 20;
		height = 10;
		buf = new char[height][width];
		stones = new Stone[height*width];
		
		current = -1;
		
		//initBoard(); // 비공개 함수를 이용한 코드 작성 (함수로 빼지 않으면 다시 초기값으로 되돌릴 수 없다.)
	}
	
	private void initBoard() {
		
		for(int y=0; y<height; y++)
			 for(int x=0; x<width; x++)
				  buf[y][x]='┼';
		
		 for(int i=0; i<height; i++)
			 buf[i][0]='├';
		 for(int i=0; i<height; i++)
			 buf[i][width-1]='┤';
		 for(int i=0; i<width; i++)
			 buf[0][i]='┬';
		 for(int i=0; i<width; i++)
			 buf[height-1][i]='┴';
		 
		 buf[0][0]='┌';
		 buf[0][width-1]='┐';
		 buf[height-1][0]='└';
		 buf[height-1][width-1]='┘';
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char[][] getBuf() {
		return buf;
	}

	public void setBuf(char[][] buf) {
		this.buf = buf;
	}

	public Stone[] getStones() {
		return stones;
	}

	public void setStones(Stone[] stones) {
		this.stones = stones;
	}

	public void print(){
		
		initBoard();
		
		for(int i=0; i<current+1; i++)
			putStone(stones[i]);
		
		for(int y=0; y<height; y++)
		 {
			 for(int x=0; x<width; x++)
				 System.out.printf("%c", buf[y][x]);
			
			 System.out.println();
		 }
	}
	
	public void add(Stone stone){
		
		Stone.toggleTurn();
		stones[++current] = stone;
	}
	
	public void putStone(Stone stone){
		
		/*if(stone.getType()==2)
			 buf[stone.getX()][stone.getY()]='○'; 
		 else
			 buf[stone.getX()][stone.getY()]='●';*/
		
		//삼항연산자를 사용해서 구현하면
		buf[stone.getY()][stone.getX()] = (stone.getType() == 1) ? '●' : '○'; 	
	}

	public boolean checkDuplicated(Stone stone) {
		
		/* if(buf[stone.getY()][stone.getX()]=='○' || buf[stone.getY()][stone.getX()]=='●')
			 return true;
		 else
			 return false;*/
		
		for(int i=0; i<current+1; i++)
			if(stones[i].getX()==stone.getX() && stones[i].getY() == stone.getY())
				return true;
		
		return false;
	}
}


