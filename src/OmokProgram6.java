import java.util.Scanner;

public class OmokProgram6 {

	public static void main(String[] args) {
		
		int height = 20;
		int width = 25;
		int[] xs = new int[500];
		int[] ys = new int[500];

		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		
		// 오목판 배열 생성
		
		char[][] board = new char[height][width];
		
		// 오목판 초기화
		
		for(int x=0; x<height; x++)
			for(int y=0; y<width; y++)
				board[x][y] = '┼';
		
		// 테두리 그리기
		
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
		
		for(int x=0; x<height; x++)
		{
			for(int y=0; y<width; y++)
				System.out.printf("%c", board[x][y]); 
			
			System.out.println();
		}
		
		play :
		while(true)
		{
			place :
			while(true)
			{
				System.out.print("\n\t오목 두기 (x sp y) : ");
				xs[count]=scan.nextInt();
				ys[count]=scan.nextInt();
			
				//바둑판 좌표를 벗어난 경우
				if(!(0<=(xs[count]-1) && (xs[count]-1)<=20) || !(0<=(ys[count]-1) && (ys[count]-1)<=20))
				{
					System.out.println("\n\t좌표를 벗어났습니다. 다른 곳에 놓으세요.");
					continue;
				}
				
				//중복된 경우
				if(board[ys[count]-1][xs[count]-1]=='○' || board[ys[count]-1][xs[count]-1]=='●')
					System.out.println("\n\t이미 놓은 자리입니다. 다른 곳에 놓으세요.");
				else
					break place;
				
				System.out.println();
			}
			count++;
	
			// 사용자 입력에 대한 위치에 오목을 두는 로직
			
			for(int i=0; i<count; i++)
			{
				if(i%2==0)
					board[ys[i]-1][xs[i]-1] = '○'; 
				else
					board[ys[i]-1][xs[i]-1] = '●';
			}
			// 오목판 출력
			
			for(int x=0; x<height; x++)
			{
				for(int y=0; y<width; y++)
					System.out.printf("%c", board[x][y]); 
				
				System.out.println();
			}
			
			// 오목 이겼을 때 게임 종료 (안됩니당...........ㅠㅠ)
			
			int check = 0;
			
			end :
			for(int x=0; x<4; x++)
			{
				for(int y=0; y<4; y++)
				{
					if(board[xs[count]][ys[count]]!=board[xs[count]][ys[count]+1])
						break end;
					else
						check++;
				}
				if(check==4)
				{
					System.out.printf("\n\t**축하합니다! %c 이 이겼습니다**", board[xs[count]][ys[count]]);
					System.out.println("\n\t게임을 종료합니다.");
					break play;
				}
			}
				
			// 더 이상 둘 곳이 없으면 종료
			
			if(count>=500)
			{
				System.out.println("\t더 이상 둘 곳이 없습니다. 무승부!");
				break play;
			}		
			
		}
	}

}
