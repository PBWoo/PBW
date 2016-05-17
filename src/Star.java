import java.util.Scanner;

public class Star {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int  line;
		int num=0, num6;
		int num2, num3, num4, num5;
		
			
			System.out.print("홀수 중 원하는 라인 수를 입력하세요 : ");
			line = scan.nextInt();
			System.out.println(); 
			
			
			if((line%2)==0)
			{
				System.out.println("홀수를 입력해주세요.\n");
			}
			
			else
			{
			    num2 = line/2;
				num3 = line/2;
				num4 = line/2;
				num5 = line/2;
				num6 = (line-2);
				
				for(int j=0; j<(line/2); j++)
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
				} 	
			}	
		}
	}	
