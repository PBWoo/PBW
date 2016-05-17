package collection.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import collection.generic.GCollection.Iterator;

public class Program {

	public static void main(String[] args) {
		
		// 범용적인 자료형은 단일한 자료형을 일괄처리하고 싶을 때 형변환을 해야하는 경우를 생각해야 한다.(단점)
		// 다양한 자료형을 일괄처리하고 싶을 때에는 아무 값이나 넣어줘도 가능하다.
		
		/*GCollection list = new GCollection();
		
		for(int i=0; i<100; i++)
			list.add(i+1);*/
		
		

		List<String> list = new ArrayList<>();
	
		list.add("hello");
		list.add("ok");
		list.add("hello");
		list.add("ok");

		/*for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		// 직접 꺼내오는 방법
*/		
		for(String s : list)  
			System.out.println(s);
		// 위에 List<String>으로 명시했기 때문에 String형으로 하나씩 꺼내온다.
		// String 대신 Object 등 다른 참조형도 가능 (참조형만 가능)
		// 리스트에 데이터를 넣었다 뺄 때 순서에 기반한다.

		System.out.println("------------------<Set>--------------------");
		
		Set<String> sets = new HashSet<>();
		sets.add("hello");
		sets.add("ok");
		sets.add("hello");
		sets.add("ok");
		
		sets.add("23");
		sets.add("5");
		sets.add("12");
		sets.add("7");   // 정렬 기준이 없다. 어떤 값이 먼저 출력될 지 모른다.
		
		
		System.out.println(sets); // 출력결과 : [hello, ok] 
		/*for(String s : sets)
			System.out.println(s);*/
		
		Set<String> tset = new TreeSet<>();
		tset.add("23");
		tset.add("5");
		tset.add("12"); 
		tset.add("7"); // 앞의 숫자가 작으면 작은값, 23<5  - 이 기준으로 정렬된다.

		// set은 같은 값이면 한번만 출력
		// list는 값이 누적된다. - 순서를 기준으로 값을 꺼냄
		// 출력 순서는 고려하지 않는다.
		// 트리 - 조회를 빠르게 한다.
		// 해쉬 - 식별가능하도록 절대 중복을 허용하지 않는다.
	
		System.out.println("------------------<Map>--------------------");
		
		//set은 값 데이터 자체가 식별자(key)이다. 특별히 뽑아내는 기능 없이 열거만 가능
		//map은 값에 이름을 부여 - 순서가 아니라 key를 기반으로 값을 뽑아낼 수 있다.
		
		Map<String, String> m = new HashMap<>();
		m.put("name", "홍길동");
		m.put("addr", "서울시 마포구");
		m.put("name", "김길동");
		
		System.out.println(m.get("name"));  // Hash가 있기 때문에 name 중복안됨 - 김길동 출력
		
		//print(2,list, 0, 5); //0번째부터 5번째까지 출력
		//print(1,list, 5); //5번째부터 나머지
		
		/*for(int i=0; i<100; i++)
			list.get(i);  // 개수나 위치를 사용 흐름에서 결정
		
		list.clear(); //위치 초기화
		while(list.hasNext())
			System.out.println(list.next()); */
		
/*		
		//다른 흐름 : Thread -> run()
		Thread th = new Thread(new Runnable(){

			@Override
			public void run() { //보조흐름
				
				print(2,list);
				
			}});
		
		th.start(); // 새로 생성한 흐름은 start를 통해 시작
		
		print(1,list);
		
		list.add(23);
		list.add("dd");
		list.add(23.5);
		list.add(new Exam());
	}

	private static void print(int key, GCollection list) {
		
		for(int i=0; i<100; i++)
			System.out.printf("key : %d, value : %d\n", key, list.get(i));
		
		
		list.clear(); //위치 초기화
		while(list.hasNext())
			System.out.printf("key : %d, value : %d\n", key, list.next());
		
		Iterator it = list.iterator();  // 함수의 반환값이 Iterator의 새로운 객체
		it.clear(); 
		while(it.hasNext())
			System.out.printf("key : %d, value : %d\n", key, it.next());
	}*/
	}
}
