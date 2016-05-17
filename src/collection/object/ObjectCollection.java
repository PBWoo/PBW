package collection.object;

public class ObjectCollection { // exam을 관리하는 컬렉션

	private int current;
	
	private int capacity;
	
	private int amount; // 배열 크기 추가 증가량
	
	private Object[] data; // 캡슐을 깨지 않도록 private
	
	public ObjectCollection(){
		
		amount = 5;
		capacity = 3;
		data = new Object[capacity];
		current = -1;	
	}

	public int size() {
		
		return current+1;
	}

	public Object get(int i) {
	
		return data[i];
	}

	public void add(Object exam) { //exam을 받아서 실행
		
		++current;
		//만약 공간이 모자라면 공간을 늘려준다.
		
		if(current>=capacity)//current = -1 이었기 때문에 같아도 문제가 된다.
		{
			Object[] temp = new Object[capacity + amount];
		
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
}
