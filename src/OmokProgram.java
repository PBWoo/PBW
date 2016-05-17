import java.util.Scanner;

public class OmokProgram {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 20;
		
		// 오목판 배열 생성
		char[] board = new char[height * width]; // 400이라고 직접 쓴다면 20*20이라고 쓰는 게 나중에 보기 좋다.
		
		// 오목판 초기화
		for(int i=0; i<400; i++) 
			board[i] = '┼';
		
		// 좌표를 이용한 오목 두기 또는 테두리 그리기
		board[width*0 + 0] = '┌';
		board[width*0 + 19] = '┐';
		board[width*19 + 19] = '┘';
		board[width*19 + 0] = '└';
		
		board[width*(3-1) + (3-1)] = '●';
		
		// 오목판 출력
		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
				System.out.printf("%c", board[j + i*height]); //board[j]라고 작성하면 첫 줄이 계속 반복되는 꼴 (400개의 배열 다 사용해야한다.)
			
			System.out.println();
		}
	}

}
