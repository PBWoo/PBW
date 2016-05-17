import java.util.Scanner;

public class Star2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int  line;
		int num=0;
		int num2, num3;
		
			
			System.out.print("한 변의 별 개수 : ");
			line = scan.nextInt();
			System.out.println(); 

		    num2 = line;
			num3 = line;
	
			for(int j=0; j<line; j++)
			{
				for(int i=0; i<=(num2-1); i++)
				{
					System.out.print("○");
				}
				num2--;
				
				for(int i=0; i<=num; i++ )
				{
					System.out.print("★");
				}
				num += 2;
				
				for(int i=0; i<=(num3-1); i++)
				{
					System.out.print("○");
				}
				num3--;
			
				System.out.println(); 
			} 	
			
			for(int i=0; i<=num; i++)
			{
				System.out.print("★");
			}
			/*
			System.out.println(); 
			
			for(int j=0; j<(line/2); j++)
			{		
				
				for(int i=(line)/2; i>(num4-1); i--)
				{
					System.out.print("○");
				}
				num4--;
				
				for(int i=0; i<=(num6-1); i++)
				{
					System.out.print("★");
				}
				num6 -= 2;
				
				for(int i=(line)/2; i>(num5-1); i--)
				{
					System.out.print("○");
				}
				num5--;
				
				System.out.println(); 
			} */ 	
		}
	}	
