
public class RProgram {

	public static void main(String[] args) {

		int a = 3;
		int n = 20;
		int d = 7;
		
		int sum = sum(a, n, d);
		
		System.out.println(sum);

	}
	
	public static int an(int a, int n, int d)
	{
		return a + (n-1)*d;
	}
	
	public static int sum(int a, int n, int d)
	{
		if(n==1)
			return a;
		
		return sum(a, n-1, d) + an(a, n, d);
	}

}
