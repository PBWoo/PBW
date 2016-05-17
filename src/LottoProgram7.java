
// 함수 모듈로 분리하는 로또 프로그램

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoProgram7 {

	private static int inputMainMenu() // 로또 프로그램 메인메뉴 번호 입력받기
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n\t\t=============로또 메뉴===============");
		System.out.println("\n\t\t1. 번호 목록 ");
		System.out.println("\t\t2. 번호 읽기 ");
		System.out.println("\t\t3. 번호 저장 ");
		System.out.println("\t\t4. 종료 ");
		System.out.print("\n\t\t메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		
		return menu;
	}
	
	private static void genLottoAuto(int[][] lottos) // 자동 생성
	{
		Random rand = new Random();
		int[] lotto = new int[6];

		// 중복 검사
		
		int check = 0;
		
		do{
			check = 0;
			
			for(int i=0; i<6; i++)
				lotto[i] = rand.nextInt(45)+1;
			
			for(int i=0; i<6; i++)
				for(int j=i+1; j<6; j++)
					if(lotto[i]==lotto[j])
						check+=1;            // 중복된 값이 있으면 check+1
					
		}while(check!=0);
		
		// 정렬
		
		int temp;
		
		for(int i=0; i<6; i++)
			for(int j=i+1; j<6; j++)
				if(lotto[i]>lotto[j])
				{
					temp = lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}	
	}
	
	private static void genLottoManual(int[][] lottos) // 수동 생성
	{
		
	}
	
	public static void main(String[] args) throws IOException {
	
		// 메인 메뉴 입력
		int menu = inputMainMenu();
		
		int[][] lottos = new int[10][6];
		
		switch(inputMainMenu())
		{
		case 1:
			// 로또 자동 생성
			// 생성할 개수 입력
			
				int LottoCnt = inputLottoCnt();
				
				genLottoAuto(lottos);
	
			break;
			
		case 2:
			// 로또 수동 생성
			// 수동 번호 입력
			
			genLottoManual(lottos);
			
			break;
		}

	}

	private static int inputLottoCnt() {
		// TODO Auto-generated method stub
		return 0;
	}
}

