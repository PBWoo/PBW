// 파일 입/출력 코드 포함

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram3 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\workspace\\lotto.txt"); //\ 두번 써주기
		Scanner fscan = new Scanner(fis);
		FileOutputStream fos = new FileOutputStream("C:\\workspace\\lotto.txt");
		PrintStream fout = new PrintStream(fos);
		
		Random rand = new Random();
		
		int[] lotto = new int[6]; 
		int bonus = 0;
		int temp;
		int check = 0;
		
		for(int i=0; i<6; i++)
			lotto[i] = fscan.nextInt(); // 랜덤 값을 뽑는게 아니라 불러온 파일 안에 있는 값을 하나씩 읽어옴

		fscan.close();
		fis.close();

		//숙제 : 중복 검사 입력 (무한루프에 빠지지 않도록 구현)
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
		{
			System.out.printf("%d\t", lotto[i]);
			fout.printf("%d", lotto[i]);
		}
		
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

		fout.close();
		fos.close();

	}
}

