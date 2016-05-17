package collection;

import java.util.Scanner;

public class Program8 {

	static ExamCollection list;
	
	public static void main(String[] args) {
		
		list = new ExamCollection();	
		
		end :
		while(true)
		{
			switch(inputMainMenu())
			{
			case 1:
				inputExam(list);
				break;
				
			case 2:
				outputExam(list);
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

	private static void outputExam(ExamCollection list) {

		System.out.println("\n┌─────────────────────┐");
		System.out.println("│                       성적  출력                         │");
		System.out.println("└─────────────────────┘");
			
		// 객체지향적으로 캡슐화 하는 중
		// for(int i=0; i<list.current+1; i++)
		// 이 부분에서 캡슐을 깨는 문제가 발생하였다.
		// 위 코드를 아래처럼 고치려고 한다. size() 메소드를 작성하자.
		for(int i=0; i<list.size(); i++)
		{
			// Exam exam = list.exams[i];
			// 이 부분에서 또 캡슐을 깨는 문제가 발생
			// 아래처럼 고쳐서 항목을 반환해주는 메소드를 작성하자.
			Exam exam = list.get(i);
			
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;
			
			int total = kor + eng + math;
			float avg = total/3.0f;
			
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
		
		int kor;
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
		
		Exam exam = new Exam();
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		
		// list.exams[++list.current] = exam;
		// 캡슐을 깨지 않기 위해 임시변수 exam에 있던 성적 값을 배열에 넣어주는 메소드를 작성하자.
		list.add(exam); // exam을 함수안으로 넘겨준다.
						// current를 통해 배열 어디까지 저장되었는지 알 수 있다.
		// capacity : 배열 용량을 의미하는 변수
		// 처음부터 배열의 크기를 엄청 크게 정해놓는 것보다 처음에 작게 정해놓고 필요하면 늘려가는 방식을 위해 필요한 변수
		
	}

	private static int inputMainMenu() {
	
		int menu;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌─────────────────────┐");
		System.out.println("│        메인  메뉴                   │");
		System.out.println("└─────────────────────┘");
		System.out.println("\n\t1. 성적 입력");
		System.out.println("\t2. 성적 출력");
		System.out.println("\t3. 종료");
		System.out.print("\n\t원하는 메뉴 번호를 입력하세요 : ");
		
		menu = scan.nextInt();
		
		return menu;
	}
}