package oop;

public class Program {
	
	public static void main(String[] args) {
		
/*		Exam exam = new Exam(2,3,4);
		
		exam.setKor(30);
		
		exam.getKor();
		
		exam.printExam();*/
		
		ExamConsole console = new ExamConsole();
		
		console.inputExam();
		
		console.printExam();

	}
}