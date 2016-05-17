import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int kor = 0;
		int eng = 0;
		int math = 0;
		int total;
		int menu;
		float avg;

		/* kor=60;
		eng=70;
		math=100; */
		
		while(true){
			
			System.out.println("┌─────────────────────┐");
			System.out.println("│                       메인  메뉴                         │");
			System.out.println("└─────────────────────┘");
			System.out.println("\n\t1. 성적 입력");
			System.out.println("\t2. 성적 출력");
			System.out.println("\t3. 종료");
			System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
			
			menu = scan.nextInt();
			
			//성적입력 코드 작성
			
			if(menu == 1){
				
				System.out.println("\n┌─────────────────────┐");
				System.out.println("│                       성적  입력                         │");
				System.out.println("└─────────────────────┘");
				System.out.print("\n  \t국어 : ");
				kor = scan.nextInt();
				System.out.print("  \n\t영어 : ");
				eng = scan.nextInt();
				System.out.print("  \n\t수학 : ");
				math = scan.nextInt();
			}
	
			else if(menu == 2){
			
				total = kor + eng + math;
				avg = total/3.0f;
				
				System.out.println("\n┌─────────────────────┐");
				System.out.println("│                       성적  출력                         │");
				System.out.println("└─────────────────────┘");
				System.out.printf(" \t국어 : %d\n ", kor);
				System.out.printf(" \t영어 : %d\n ", eng);
				System.out.printf(" \t수학 : %d\n ", math);
				System.out.printf(" \t총점 : %d\n ", total);
				System.out.printf(" \t평균 : %5.2f\n ", avg);
				System.out.println("───────────────────────");
			}
			
			else if(menu == 3){
				System.out.println("\n\tGood Bye!");
				System.exit(0);
			}
			else
			{
					System.out.println("\n\t잘못 선택하셨습니다.\n");
			}
		}
	}
}
