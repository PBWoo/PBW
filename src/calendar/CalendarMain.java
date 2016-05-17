package calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarMain {

    public static void main(String[] args) {
    	
        int year;
        int month;
        int date;
        int menu;
        
        Scanner scan = new Scanner(System.in);
        
        Calendar calendar = Calendar.getInstance();
       
        year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		date = calendar.get(Calendar.DATE);
		
        System.out.println("\n      \t┌────────────────────────────────────────────────┐");
        System.out.printf("      \t│\t               오늘은 %d년 %d월 %d일 입니다.\t         │\n", year, month, date);
		System.out.println("      \t└────────────────────────────────────────────────┘\n");
		
		System.out.printf("\t\t\t      %d 월 \n\n", month);
		
    	CalendarPrint cal = new CalendarPrint(year, month, date);
    	cal.setDate(date);
        cal.printCal(year, month, date);
        
        calProgram:
        while(true){

			System.out.println("\n\n\t1. 월 검색 ");
			System.out.println("\t2. 년/월/일 검색");
			System.out.println("\t3. 종료\n\n");
			System.out.print("\t원하시는 메뉴를 입력하세요 : ");
			menu = scan.nextInt();

			switch(menu){
			
			case 1:
				
				CalendarPrint thiscal = new CalendarPrint(year, month, date);

		        System.out.print("\t월을 입력하세요 : ");
		        month=scan.nextInt();
		        System.out.println("\n");
		        
		        //입력 범위 벗어난 경우 반환된 error값이 0이면 처음으로 돌아감
		        if(cal.inputError(year, month, date)==0) 
		        	continue;
				
		        System.out.printf("\t\t\t      %d 월 \n\n", month);
		        
		        thiscal.printCal(month);
				break;
				
			case 2:
					
					System.out.print("\n\n\t년도를 입력하세요 : ");
			        year=scan.nextInt();
			        System.out.print("\t월을 입력하세요 : ");
			        month=scan.nextInt();
			        System.out.print("\t날짜를 입력하세요 : ");
			        date=scan.nextInt();
			        cal.setDate(date);

			        if(cal.inputError(year, month, date)==0)
			        	continue;

		        System.out.printf("\n\t\t\t   %d 년   %d 월  %d 일\n\n", year, month, date);
		        
		        CalendarPrint inputcal = new CalendarPrint(year, month, date);
		        inputcal.setDate(date);
		        inputcal.printCal(year, month, date);
		        break;
		        
			case 3:
				System.out.println("\n\t프로그램을 종료합니다.");
				break calProgram;
			default :
				System.out.println("\n\t잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
				continue;
				
			}     
        }     
    }
}
