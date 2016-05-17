package capsule;

import java.util.Scanner;

public class Exam {
	
	private int kor; // 다른 클래스에서  set함수 없이는 접근 할 수 없게 된다.
	private int math;
	private int eng;
	
	// 다른 클래스에서 변수를 사용하는 경우, 캡슐 안의 내용을 수정하면 그 클래스 안의 변수에 오류 발생
	// 다른 클래스에서 변수를 갖다 쓰더라도 수정은 캡슐 안의 내용만 할 수 있도록 set함수를 만들어 사용한다.
	public static void setKor(Exam exam, int kor){  
		exam.kor = kor;
	}
	
	public static int getKor(Exam exam){  // 매개변수 꼭 필요! exam에서 kor을 꺼내달라
		return exam.kor; // 외부에서는 exam을 가지고 있더라도 kor변수에 직접 접근할 수 없기 때문에 exam에서 kor값을 꺼내 전달해주는 역할
	}
	
	public static void setEng(Exam exam, int eng){  
		exam.eng = eng;
	}
	
	public static int getEng(Exam exam){ 
		return exam.eng;
	}
	
	public static void setMath(Exam exam, int math){  
		exam.math = math;
	}
	
	public static int getMath(Exam exam){ 
		return exam.math;
	}
	
	static void outputExam(Exam exam) {
		
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

	static void inputExam(Exam exam) {
		
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
	
	static int total(int kor, int eng, int math) {
		
		return kor + eng + math ;
	}
	
	static int total(Exam exam) {
		
		return total(exam.kor, exam.eng, exam.math) ;
	}

}
