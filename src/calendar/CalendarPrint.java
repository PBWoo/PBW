package calendar;

import java.util.Calendar;

public class CalendarPrint {
    
    // Calendar 인스턴스 생성
    Calendar cal = Calendar.getInstance();
    
    // 요일명 배열
    private String[] calDay = {"일","월","화","수","목","금","토"};
    
    private String[][] calDate = new String[6][7];  // 날짜 배열

    private int width=calDay.length; // 7(개의 요일) = width
    private int startDay;   
    private int lastDay; 
    private int inputDate=1;  // 날짜 출력할 때 사용되는 변수
    private int error=1; // 입력 년/월/일 값이 범위를 벗어 났을 때 사용하는 변수
    
    private int date;
    
    
    public int getDate() {
      return date;
   }

   public void setDate(int date) {
      this.date = date;
   }
   
   // 생성자 - 달력 setting
    public CalendarPrint(int year, int month, int date){
       
            // Calendar에 년,월,일 setting 
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, month-1);
            cal.set(Calendar.DATE, 1);
            
            startDay = cal.get(Calendar.DAY_OF_WEEK);
 
            lastDay = cal.getActualMaximum(Calendar.DATE);
            
            // calDate에 날짜 setting
            int row = 0;
            for(int i=1; inputDate<=lastDay; i++){
                
                // 시작 요일이 오기전에는 공백 대입
                if(i<startDay) calDate[row][i-1]=" ";
                else{
                
                    calDate[row][(i-1)%width]=Integer.toString(inputDate);
                    // (i-1)%width 값이 같으면 요일이 같다. 0일때 일요일, 1일때 월요일..
                    inputDate++;
                   
                    // 마지막 열에 오면(=토요일이되면)행 바꿔야 하므로 row 늘려줌
                    if(i%width==0) row++;
     
            }
        }
    }

    // 적합하지 않은 년/월/일 을 입력한 경우 호출되는 함수
    public int inputError(int year, int month, int date){
       
       error = 1;
       
       if(year<1916 || year>2116){ // 현재 1916~2116까지 달력 출력 가능
            System.out.println("\n\t달력을 확인할 수 없는 년도 입니다.\n");
            error = 0;
            return error;
        }
       
       if(month<1 || month>12){
          System.out.printf("\n\t%d월은 없습니다.\n", month);
            System.out.println("\n\t1~12 사이의 월을 입력하세요.\n");
            error = 0;
            return error;
        }
       
       //if(date>lastDay)
       
       if(month==4 || month==6 || month==9 || month==11) // 30일까지 있는 달
          if(date<1 || date>30){
             System.out.println("\n\t1~30 사이의 날짜를 입력하세요.\n");
             error = 0;
             return error;
          }
       
       // 31일까지 있는 달
       if((month%2==1 && month<8) || month==8 || month==10 || month==12){
          if(date<1 || date>31){
             System.out.println("\n\t1~31 사이의 날짜를 입력하세요.\n");
             error = 0;
             return error;
          }
       }
       
       // 2월은 윤년인 경우 29일까지
      if(month==2){
         if((year%4==0) && (!(1<=date && date<=29))){
             System.out.printf("\n\t%d년은 윤년입니다. 1~29 사이의 날짜를 입력하세요.\n", year);
             error = 0;
             return error;
         }
         else if((year%4!=0) && (!(1<=date && date<=28))){
            System.out.println("\n\t1~28 사이의 날짜를 입력하세요.\n");
             error = 0;
             return error;
         }
      }
       return error;
    }

   // 달력 출력
    public void printCal(int year, int month, int date){
        
        // 요일명 출력
        for(int i=0; i<width; i++){
            System.out.print("\t" + calDay[i]);
        }
        System.out.println();
        
        // 날짜 출력
        int row=0;
        for(int j=1 ; j<lastDay+startDay; j++){ 
           // lastDay(해당 월의 날짜 수) + startDay(시작요일 전까지의 공백 수) : 달력에 출력이 필요한 총 칸 수(공백+날짜)
            
           
           // calDate String형 배열이므로 date값을 string형으로 형변환 해준다.
           if(calDate[row][(j-1)%width].equals(Integer.toString(getDate())))
              System.out.print("\t" + "[" + date + "]");
           else
              System.out.print("\t" + calDate[row][(j-1)%width]);
           
           // (j-1)%width == width-1 (6이면 토요일) 를 만족하면 행을 바꾸고 row값 늘려줌
           if((j-1)%width==width-1){
                System.out.println();
                row++;
            }
        }
    }

    
    // 메인메뉴에서 1번 선택시 호출되는 월 검색 함수 (오버로드)
    public void printCal(int month){  
        
        // 요일명 출력 "일월화수목금토"
        for(int i=0; i<width; i++){
            System.out.print("\t" + calDay[i]);
        }
        System.out.println();
        
        // 날짜 출력
        int row=0;
        for(int j=1 ; j<lastDay+startDay; j++){
                
              System.out.print("\t" + calDate[row][(j-1)%width]);
           
           if((j-1)%width==width-1){
                System.out.println();
                row++;
            }
        }
    }
}