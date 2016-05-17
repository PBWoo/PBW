import java.util.Scanner;

// 함수를 이용해 구조만 작성하는 코드

public class Program4 {

	public static void main(String[] args) {
		
		Exam exam = new Exam();
		
	//	Exam.getKor(exam);
		
	//	Exam.setKor(exam, kor);
		
		
		end :
		while(true)
		{
			switch(inputMainMenu())
			{
			case 1:
				inputExam(exam); // exam은 참조
				break;
				
			case 2:
				outputExam(exam); //여기서 받은 exam은 참조가 아닌 값
				break;
				
			case 3:
				exit();
				break end;	
			
			default :
					System.out.println("\n\t잘못 선택하셨습니다.\n");
			}
		}
	}

	private static void exit() {
	
		System.out.println("\n\tGood Bye!");
	}

	private static void outputExam(Exam exam) {
	
		int kor = exam.kor;
		int eng = exam.eng;
		int math = exam.math;
		
		int total = kor + eng + math;
		float avg = total/3.0f;
		
		System.out.println("\n┌─────────────────────┐");
		System.out.println("│                       성적  출력                         │");
		System.out.println("└─────────────────────┘");
			
			
		for(int i=0; i<3; i++)
		{
			System.out.printf(" \t번호 : %d\n ", (i+1));
			System.out.printf(" \t국어 : %d\n ", kor);
			System.out.printf(" \t영어 : %d\n ", eng);
			System.out.printf(" \t수학 : %d\n ", math);
			System.out.printf(" \t총점 : %d\n ", total);
			System.out.printf(" \t평균 : %5.2f\n ", avg);
			System.out.println("───────────────────────");
		}
			
	}

	private static void inputExam(Exam exam) {
		
		int kor;  // 임시 변수( exam.kor라고 쓰기 번거로워서 ) - 상황에 따라 사용
		int eng;
		int math;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n┌─────────────────────┐");
		System.out.println("│                       성적  입력                         │");
		System.out.println("└─────────────────────┘");
		
		do
		{
			System.out.print("\n  \t국어 : ");
			kor = scan.nextInt();
			
			if(!(0<=kor && kor<=100))
				System.out.println("잘못 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
		}
		while(!(0<=kor && kor<=100));
		
		do
		{
			System.out.print("\n  \t영어 : ");
			eng = scan.nextInt();
			
			if(!(0<=eng && eng<=100))
				System.out.println("잘못 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
		}
		while(!(0<=eng && eng<=100));
		
		do
		{
			System.out.print("\n  \t수학 : ");
			math = scan.nextInt();
			
			if(!(0<=math && math<=100))
				System.out.println("잘못 입력하셨습니다. 0~100 사이의 값을 입력하세요.");
		}
		while(!(0<=math && math<=100));
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
	}

	private static int inputMainMenu() {
	
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌─────────────────────┐");
		System.out.println("│                       메인  메뉴                         │");
		System.out.println("└─────────────────────┘");
		System.out.println("\n\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
		
		menu = scan.nextInt();
		
		return menu;
	}
}
