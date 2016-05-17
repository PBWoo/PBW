import java.util.Scanner;

public class Program9 {
	
	public static void main(String[] args) {
		
		ExamCollection list = new ExamCollection();
		
		list.exams = new Exam[3];
		list.current = -1;
		
		while(true)
		{
			//메인메뉴 입력
			
			switch(inputMainMenu())
			{
			case 1: // 성적 입력
				inputExam(list);
				break;
				
			case 2: // 성적 출력
				outputExam(list);
				break;
				
			case 3: // 종료
				exit();
				break;
				
			default :
				
			}
		}
	}


	private static void exit() {
		
		System.out.println("\n\t성적 프로그램을 종료합니다.");
	}

	private static void outputExam(ExamCollection list) {
		
		int total = 0;
		float avg = 0;
		
		System.out.println("\n┌─────────────────────┐");
		System.out.println("│                       성적  출력                         │");
		System.out.println("└─────────────────────┘");
			
			for(int i=0; i<=list.current+1; i++)
			{
				Exam exams = list.exams[i];
				
				int kor = exams.kor;
				int math = exams.math;
				int eng = exams.eng;
				
				total = kor + eng + math;
				avg = total/3.0f;
				
				System.out.printf(" \t번호 : %d\n ", (i+1));
				System.out.printf(" \t국어 : %d\n ", kor);
				System.out.printf(" \t영어 : %d\n ", eng);
				System.out.printf(" \t수학 : %d\n ", math);
				System.out.printf(" \t총점 : %d\n ", total);
				System.out.printf(" \t평균 : %5.2f\n ", avg);
				System.out.println("───────────────────────");
			}

	}

	private static void inputExam(ExamCollection list) { 
	
		Exam exam = new Exam();
		
		int kor = exam.kor;
		int math = exam.math;
		int eng = exam.eng;
		
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
		
		Exam[] exams = list.exams;
		
		list.exams[++list.current] = exam;
	}

	private static int inputMainMenu() {
		
		Scanner  scan = new Scanner(System.in);
		
		System.out.println("┌─────────────────────┐");
		System.out.println("│                       메인  메뉴                         │");
		System.out.println("└─────────────────────┘");
		System.out.println("\n\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
		
		int menu = scan.nextInt();
		
		return menu;
	}
}
