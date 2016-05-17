import java.util.Scanner;

public class OmokProgram3 {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 25;
		int[] xs = new int[400];
		int[] ys = new int[400];
		int[] types = new int[400];
		int count = 0;
		
		
		// 오목판 배열 생성
		
		char[][] board = new char[height][width]; // 400이라고 직접 쓴다면 20*20이라고 쓰는 게 나중에 보기 좋다.
		
		// 오목판 초기화
		
		for(int x=0; x<height; x++)
			for(int y=0; y<width; y++)
				board[x][y] = '┼';
		
		// 테두리 그리기 : 데코레이션 (덮어쓰기에도 우선순위가 있다. - 특화된 것을 더 위에)
		
		for(int i=0; i<width; i++)
			board[0][i]='┬';
		
		for(int i=0; i<width; i++)
			board[height-1][i]='┴';
		
		for(int i=0; i<height; i++)
			board[i][0]='├';
		
		for(int i=0; i<height; i++)
			board[i][width-1]='┤';
		
		board[0][0] = '┌';
		board[0][width-1] = '┐';
		board[height-1][width-1] = '┘';
		board[height-1][0] = '└';
		
		// 사용자 입력을 받는 로직
		
		int ox;
		int oy;
		int otype;
		
		ox=5;
		oy=7;
		otype=1; // 하얀돌 1, 검은돌 2
		
		xs[count] = ox;
		ys[count] = oy;
		types[count] = otype;
		count++;
		
		// 사용자 입력에 대한 위치에 오목을 두는 로직
		
		for(int i=0; i<count; i++)
			board[ys[i]-1][xs[i]-1] = '○'; // 배열은 0부터 시작하므로 1을 빼준다.
		
		// 오목판 출력
		
		for(int x=0; x<height; x++)
		{
			for(int y=0; y<width; y++)
				System.out.printf("%c", board[x][y]); // board[j]라고 작성하면 첫 줄이 계속 반복되는 꼴 (400개의 배열 다 사용해야한다.)
			
			System.out.println();
		}
	}

}
