
public class Exam {
	
	 int kor;
	 int math;
	 int eng;
	
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

}
