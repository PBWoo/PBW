import java.util.Random;

public class LottoProgram2 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int[] lotto = new int[6]; 
		int bonus = 0;
		int temp;
		int check = 0;
		
		//숙제 : 중복 검사 입력
		/*
		for(int i=0; i<6; i++)
		{
			lotto[i] = rand.nextInt(45)+1;
		
			do
			{
				for(int j=i+1; j<6; j++)
				{
					if(lotto[i]== lotto[j])
					{
						lotto[j] = rand.nextInt(45)+1;
						check++;
					}
				}
			}while(check!=0);
		}
		*/
		
		do
		{
			check = 0;
			
			for(int i=0; i<6; i++)	
				lotto[i] = rand.nextInt(45)+1;

			for(int i=0; i<6; i++)	
			System.out.print(lotto[i]);
			
			for(int i=0; i<6; i++)	
				for(int j=i+1; j<6; j++)
						if(lotto[i]== lotto[j])
							check++;
			
			System.out.println("check"+check );
		}while(check!=0);
		
		
		
		
		//번호 출력
		for(int i=0; i<6; i++)
			System.out.printf("%d\t", lotto[i]);
		
		System.out.println();
		
		//정렬하기
		for(int j=0; j<5; j++)                                    // for(int j=5; j>0; j--)
			for(int i=0; i<5-j; i++)                              // for(int i=0; i<j; i++) 
			{
				if( lotto[i]>lotto[i+1])
				{
					temp = lotto[i];
					lotto[i] = lotto[i+1];
					lotto[i+1] = temp;
				}
			}

		//번호 출력
		for(int i=0; i<6; i++)
			System.out.printf("%d\t", lotto[i]);
	}
}

