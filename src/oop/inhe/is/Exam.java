package oop.inhe.is;

public class Exam {
	
	private int kor; // 다른 클래스에서  set함수 없이는 접근 할 수 없게 된다.
	private int math;
	private int eng;
	
	// 다른 클래스에서 변수를 사용하는 경우, 캡슐 안의 내용을 수정하면 그 클래스 안의 변수에 오류 발생
	// 다른 클래스에서 변수를 갖다 쓰더라도 수정은 캡슐 안의 내용만 할 수 있도록 set함수를 만들어 사용한다.

	public Exam() {
	
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math) {
		
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	
	public int total(int kor, int eng, int math) {
		
		return kor + eng + math ;
	}
	
	public int total() {
		
		return total(this.kor, this.eng, this.math) ;
	}
	
	public float avg() { 
		
		return total()/3.0f;
	} 

}
