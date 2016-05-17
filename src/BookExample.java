/* 배열 ex 7)


public class BookExample {

	public static void main(String[] args) {

		int max=0;
		int[] array = {1, 5, 3, 8, 2};
		
		for(int i=0; i<array.length; i++)
			if(array[i]>max)
				max = array[i];
		
		System.out.println("max : " + max);

	}

}


ex 8)

public class BookExample {

	public static void main(String[] args) {
	
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		int sum = 0;
		int num =0;
		double avg = 0.0;
		
		for(int i=0; i<array.length; i++)
		{
			for(int j=0; j<array[i].length; j++)
			{	
				if((i>=0) && (j>=0))
				{
					sum += array[i][j];
					num ++;
				}
			}
		}
		avg = (double)sum/num;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
		
	}
}

ex 9)
 
import java.util.Scanner;

public class BookExample {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);

		int menu = 0;
		int students = 0;
		int[] scores = null;
		
		end :
		while(true)
		{	
			System.out.println("\n┌─────────────────────┐");
			System.out.println("│                    성적  프로그램                     │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 학생수");
			System.out.println("\t2. 점수 입력");
			System.out.println("\t3. 점수리스트");
			System.out.println("\t4. 분석");
			System.out.println("\t5. 종료");
			
			System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
			menu = scan.nextInt();
			System.out.println();
			
			switch(menu)
			{
				case 1:
					
					System.out.print("\n\t학생 수를 입력하세요 : ");
					students = scan.nextInt();
					scores = new int[students];
					
					System.out.printf("\n\n\t입력하신 학생 수는 %d명 입니다.", students);
					
					break;
					
				case 2:
		
					System.out.println("\n\n\t학생들의 점수를 차례대로 입력해주세요.");
					
					for(int i=0; i<students; i++)
					{
						System.out.printf("\n\n\t%d번째 학생 점수 scores[%d] : ", i+1, i);
						scores[i] = scan.nextInt();
						System.out.println();
					}
					break;
				
				case 3:
				{
					System.out.println("\n\n\t학생들의 점수 목록입니다.\n");
					
					for(int i=0; i<scores.length; i++)
						System.out.printf("\n\t학생%d : %d\n", i+1, scores[i]);	
				}	
				break;
				
				case 4:
				{
					int top = 0;
					int sum = 0;
					double avg = 0;
					
					top = scores[0];
					
					for(int i=0; i<scores.length; i++)
					{	
						if(top<scores[i])
							top = scores[i];
						
						sum += scores[i];
					}
					
					avg =  (double)sum/scores.length;
							
					System.out.printf("\n\t최고 점수 : %d\n", top);
					System.out.printf("\n\t평균 점수 : %5.1f\n", avg);
				}
				break;
				
				case 5:
				{
					System.out.println("\n\t프로그램을 종료합니다.");
					break end;
				}
	
				default :
					System.out.println("\n\t잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
	}
}
	


ex 9) 함수를 이용하여 구현해보기

import java.util.Scanner;

public class BookExample {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);

		int menu = 0;
		int students = 0;
		int[] scores = null;
		
		end :
		while(true)
		{	
			System.out.println("\n┌─────────────────────┐");
			System.out.println("│                    성적  프로그램                     │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 학생수");
			System.out.println("\t2. 점수 입력");
			System.out.println("\t3. 점수리스트");
			System.out.println("\t4. 분석");
			System.out.println("\t5. 종료");
			
			System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
			menu = scan.nextInt();
			System.out.println();
			
			if(menu==1)
				inputStudentNum(students, scores);
				
			else if(menu==2)
				inputScores(scores);
			
			else if(menu==3)
				scoresList(scores);
			
			else if(menu==4)
				analysis(scores);
			
			else if(menu==5)
			{
				System.out.println("\n\t프로그램을 종료합니다.");
				break end;
			}	
			else
				System.out.println("\n\t잘못 입력하셨습니다. 다시 입력하세요.");
		}
	}

	private static void analysis(int[] scores) {
		
		int top = 0;
		int sum = 0;
		double avg = 0;
		
		top = scores[0];
		
		for(int i=0; i<scores.length; i++)
		{	
			if(top<scores[i])
				top = scores[i];
			
			sum += scores[i];
		}
		
		avg =  (double)sum/scores.length;
				
		System.out.printf("\n\t최고 점수 : %d\n", top);
		System.out.printf("\n\t평균 점수 : %5.1f\n", avg);
		
	}

	private static void scoresList(int[] scores) {
		
		System.out.println("\n\n\t학생들의 점수 목록입니다.\n");
		
		for(int i=0; i<scores.length; i++)
			System.out.printf("\n\t학생%d : %d\n", i+1, scores[i]);	

	}

	private static void inputScores(int[] scores) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\n\t학생들의 점수를 차례대로 입력해주세요.");
		
		for(int i=0; i<scores.length; i++)
		{
			System.out.printf("\n\n\t%d번째 학생 점수 scores[%d] : ", i+1, i);
			scores[i] = scan.nextInt();
			System.out.println();
		}
		
	}

	private static void inputStudentNum(int students, int[] scores) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\t학생 수를 입력하세요 : ");
		students = scan.nextInt();
		scores = new int[students];
		
		System.out.printf("\n\n\t입력하신 학생 수는 %d명 입니다.", students);
		
	}
}

클래스 ex 1) */



































