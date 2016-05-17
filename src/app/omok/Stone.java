package app.omok;

import java.util.Scanner;

public class Stone {

	private int x;
	private int y;
	private int type; // 오목돌 하나(객체 하나)에 하나씩 다 필요한 변수들
	
	private static boolean isWhiteTurn; // 공용으로 쓰기 때문에 전체에서 하나만 필요한 변수 (static)
	
	// isWhiteTurn은 객체마다 갖는 값이 아니다. 따라서 static으로 선언해주면 여러 객체에서 사용해도 값이 유지가 된다.
	// 객체 생성할 때마다 호출하게 하면 계속 false로 시작하기 때문에 static으로 선언해야 한다.
	
	static{
		isWhiteTurn = false; // static 변수를 초기화하는 방법
	}
	
	public Stone(){
		x = -1;
		y = -1;
		type = 1; // 1 : 검은돌 2 : 흰돌
	}
	
	public static boolean isWhiteTurn() {
		return isWhiteTurn;
	}

	public static void setWhiteTurn(boolean isWhiteTurn) {
		Stone.isWhiteTurn = isWhiteTurn;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void input(){
	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t원하는 좌표를 입력하세요 (x sp y) : ");
		 x = scan.nextInt();
		 y = scan.nextInt();
		 
		type = isWhiteTurn ? 2 : 1; // type 값 정하기
	}
 
	public static void toggleTurn() {
		isWhiteTurn = !isWhiteTurn;
	}
	

	
}
