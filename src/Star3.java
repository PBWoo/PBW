import java.util.Scanner;

public class Star3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int  line;
			
			System.out.print("한 변의 별 개수 : ");
			line = scan.nextInt();
			System.out.println(); 

		    
			for(int y=1; y<=line; y++)
			{
				System.out.println(); 

				for(int x=1; x<=line; x++)
				{
					if((y<=x-2) && (y>=x+2) && (y<=-x+4) && (y>=-x+8))
						System.out.print("★");
					else	
						System.out.print("○");
				}
			}
		}
	}	
