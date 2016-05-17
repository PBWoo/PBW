package exceptionlib;

public class Calculator {
		
	public static int add(int x, int y){
		int result = x + y;
		return result;
	}

	public static int sub(int x, int y){
		int result = x - y;
		return result;
	}

	public static int multi(int x, int y){
		int result = x * y;
		return result;
	}

	public static int div(int x, int y) throws 영으로나눈예외오류, 범위를벗어난예외오류{

		if(y==0)
			throw new 영으로나눈예외오류();
		
		if(!(0<=x && x<=100))
			throw new 범위를벗어난예외오류();
		
		int result = x / y;
		return result;
	}
	
	// 위 함수들을 사용하려면 Calculator 객체를 생성해서 사용해야한다.
	// 하지만 객체지향적으로 작성한 프로그램은 아니다. this를 사용할 필요가 없다. 객체가 필요없다.
	// 함수에 static을 붙여서 객체지향적이지 않은 함수지향적으로 만들어야 한다. (캡슐에 담아 놓긴 한다.)
}

