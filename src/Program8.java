import java.util.Scanner;

// 공유 데이터를 전역화하기

public class Program8 {

	// 복도에 있어요 마음대로 가져다 쓰세용
	static ExamCollection list;  // static이 없으면 정의, 있으면 선언 / 여기서 초기화 시킬 수도 있다. static ExamCollection list = -1; 가능
	// 재사용을 위해서도 좋지 않는 방법. 
	
	public static void main(String[] args) {
		
		/*int current = -1;
		
		Exam exams[] = new Exam[3];*/
		
		list = new ExamCollection(); //new를 통해 생성한 것은 참조. 무조건 공유. new로 생성한 것은 복사할 수 없으므로
		
		list.exams = new Exam[3];
		list.current = -1;
		
		// 공간이 아니라 데이터 구조체를 나타내는 이름표 세 개를 만든 것이다. (데이터 구조체 배열은 없다.) 
		// 
		
		/*
		exams[0] = new Exam(); // 공간이 생성됨
		
		exams[0].kor = 3; // 위에서 new로 공간 생성하기 전에는 이름표에 값을 넣는 건 불가능
		 */		
		
		end :
		while(true)
		{
			switch(inputMainMenu())
			{
			case 1:
				inputExam(list); // exam은 참조
				break;
				
			case 2:
				outputExam(list); //여기서 받은 exam은 참조가 아닌 값
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
			
		for(int i=0; i<list.current+1; i++)
		{
			Exam exam = list.exams[i];
			
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
		
		// list를 쓰지 않고 return current; 를 사용해서 current값을 반환하는 방법은 함수명과 모순 
		// input은 입력받는다는 의미이기 때문에 결과가 나에게 반환되는 것이 없어야 한다. (get-반환되는 값이 있어야한다.)
		
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
		
		Exam exam = new Exam();
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		
		list.exams[++list.current] = exam;
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
