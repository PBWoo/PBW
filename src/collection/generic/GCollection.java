package collection.generic;

public class GCollection <T> { // G = templet
	// 전체에서 달라지는 부분이 있다면 구멍내겠다.
	// 자료형은 변수처럼 그릇으로서 값을 교체할 수 있는 그릇이 존재하지 않는다.
	// 템플릿을 만드는 이유 : 결정짓지 않으려고, 구멍은 자료형과 템플릿이라는 정보를 주면 컴파일러가 완성한다.

	private int current;
	
	private int capacity;
	
	private int amount; 
	
	private T[] data;
	
	public class Iterator {  //thread마다 index가 따로 만들어진다.
		
		private int index;
		
		public Iterator(){
			index = -1;
		}
		
		public T next() {
			
			return data[++index];
		}
	
		public boolean hasNext() {
			
			return index < current;
		}
		
		public void clear() {
			
			index = -1;
			
		}
	}
	public GCollection(){
		
		amount = 5;
		capacity = 3;
		data = (T[]) new Object[capacity];
		current = -1;	
	}

	public int size() {
		
		return current+1;
	}

	public T get(int i) {
	
		return data[i];
	}

	public void add(T exam) { //exam을 받아서 실행
		
		++current;
		//만약 공간이 모자라면 공간을 늘려준다.
		
		if(current>=capacity)//current = -1 이었기 때문에 같아도 문제가 된다.
		{
			T[] temp = (T[])new Object[capacity + amount];
		
			// exams 배열에 있는 객체를 temp 배열로 옮긴다.
			for(int i=0; i<capacity; i++)
				temp[i] = data[i];
			
			//기존의 배열은 버려질 필요가 있고 새로운 배열이 현재 참조되는 배열이 되어야 한다.
			data = temp;
			
			//늘어난 용량이 새로운 값으로 대치되어야 한다. 
			capacity += amount;
		}	
		data[current] = exam;
	}
	// ArrayList를 선언해서 add함수 호출하는 방법으로 사용하면 위의 add함수 구현 필요 없다. 이미 라이브러리에 존재

	public Iterator iterator() {           // index와 관련된 함수들을 따로 캡슐화한다.
		
		return new Iterator();
	}
}
