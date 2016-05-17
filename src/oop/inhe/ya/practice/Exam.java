package oop.inhe.ya.practice;

public class Exam {
	
	private int kor; 
	private int math;
	private int eng;
	
	private AvgListener avgListener;

	public void setAvgListener(AvgListener avgListener) {
		this.avgListener = avgListener;
	}

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
	
	public float avg(){
		
		return avgListener.avg();
	}

}
