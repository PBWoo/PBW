import java.util.Scanner;

public class OmokProgram2 {

	public static void main(String[] args) {
		
		int x = 0;
		int y = 0;
		
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<20; i++)
		{
			for(int j=0; j<20; j++)
			{
				if(i==0 && j==0)
					System.out.printf("%c", '┌'); // 특화된 것일 수록 위에 써야 한다.
				else if(i==0 && j==19)
					System.out.printf("%c", '┐');
				else if(i==19 && j==19)
					System.out.printf("%c", '┘');
				else if(i==19 && j==0)
					System.out.printf("%c", '└');
				else if(j==0)
					System.out.printf("%c", '├');
				else if(i==0)
					System.out.printf("%c", '┬');
				else if(j == 19)
					System.out.printf("%c", '┤');
				else if(i==19)
					System.out.printf("%c", '┴');
				else
					System.out.printf("%c", '┼');
			}
			System.out.println();
		}	
		
		//사용자에게 오목 좌표 하나를 입력 받는다.
		System.out.print("\n바둑알을 두고 싶은 좌표를 입력하세요. (x sp y) : ");
		x = scan.nextInt();
		y = scan.nextInt();
		System.out.println();
		
		
		//오목판 출력
		
		for(int i=1; i<=20; i++)
		{
			for(int j=1; j<=20; j++)
			{
				if(i==y && j==x)
					System.out.printf("%c", '●');  // 특정 위치 조건
			
				else if(i==1 && j==1)
					System.out.printf("%c", '┌'); // 모퉁이
				else if(i==1 && j==20)
					System.out.printf("%c", '┐');
				else if(i==20 && j==20)
					System.out.printf("%c", '┘');
				else if(i==20 && j==1)
					System.out.printf("%c", '└');
			
				else if(j==1)
					System.out.printf("%c", '├'); // 외벽
				else if(i==1)
					System.out.printf("%c", '┬');
				else if(j == 20)
					System.out.printf("%c", '┤');
				else if(i==20)
					System.out.printf("%c", '┴');
				
				else
					System.out.printf("%c", '┼'); // 안쪽
			}
			System.out.println();
		}
		
	}

}
