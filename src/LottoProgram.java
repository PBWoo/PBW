import java.util.Scanner;

public class LottoProgram {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1=15, num2=13, num3=10, num4=7, num5=29, num6=30, bonus=17;
		int result1, result2, result3, result4, result5, result6, bonusnum;
		
		result1 = (int)(Math.random()*45)+1;
		
		result2 = (int)(Math.random()*45)+1;
		
			if(result2 == result1) {
				while(true) {
					result2 = (int)(Math.random()*45)+1;
					
					if(result2 != result1)
						break;
				}
			}
			
		result3 = (int)(Math.random()*45)+1;
		
			if((result3 == result1) || (result3 == result2)){
				while(true) {
					result2 = (int)(Math.random()*45)+1;
					
					if((result3 != result1) && (result3 != result2))
						break;
				}
			}
			
		result4 = (int)(Math.random()*45)+1;
		
			if((result4 == result1) || (result4 == result2) || (result4 == result3)){
				while(true) {
					result2 = (int)(Math.random()*45)+1;
					
					if((result4 != result1) && (result4 != result2) && (result4 != result3))
						break;
				}
			}
			
		result5 = (int)(Math.random()*45)+1;
		
			if((result5 == result1) || (result5 == result2) || (result5 == result3) || (result5 == result4)){
				while(true) {
					result2 = (int)(Math.random()*45)+1;
					
					if((result5 != result1) && (result5 != result2) && (result5 != result3) && (result5 != result4))
						break;
				}
			}
		
		result6 = (int)(Math.random()*45)+1;
		
			if((result6 == result1) || (result6 == result2) || (result6 == result3) || (result6 == result4) || (result6 == result5)){
				while(true) {
					result2 = (int)(Math.random()*45)+1;
					
					if((result6 != result1) && (result6 != result2) && (result6 != result3) && (result6 != result4) && (result6 != result5))
						break;
				}
			}
		
		bonusnum = (int)(Math.random()*45)+1;
		
			if((bonusnum == result1) || (bonusnum == result2) || (bonusnum == result3) || (bonusnum == result4) || (bonusnum == result5) ||(bonusnum == result6)){
				while(true) {
					result2 = (int)(Math.random()*45)+1;
					
					if((bonusnum != result1) && (bonusnum != result2) && (bonusnum != result3) && (bonusnum != result4) && (bonusnum != result5) && (bonusnum != result6))
						break;
				}
			}
		
		System.out.println("┌────────────────────┐");
		System.out.println("│              제 777회 Lotto 복 권                 │");
		System.out.println("└────────────────────┘");
		
		
		System.out.println(" *************************************\n");
		System.out.println("\t\t\t번호 입력\n");
		System.out.println(" *************************************\n");
		System.out.print("\t [1]~[6]까지 번호를 입력하세요.\n");
		System.out.print("\n\t\t\t[1] : ");
		num1 = scan.nextInt();
		System.out.print("\n\t\t\t[2] : ");
		num2 = scan.nextInt();
		System.out.print("\n\t\t\t[3] : ");
		num3 = scan.nextInt();
		System.out.print("\n\t\t\t[4] : ");
		num4 = scan.nextInt();
		System.out.print("\n\t\t\t[5] : ");
		num5 = scan.nextInt();
		System.out.print("\n\t\t\t[6] : ");
		num6 = scan.nextInt();
		System.out.print("\n\t    보너스 번호를 입력하세요.\n\n");
		System.out.print("\t\t[bonus] : ");
		bonus = scan.nextInt();
		
		System.out.println("\n *************************************\n");
		System.out.println("\t     선택하신 번호를 확인하세요.\n");
		System.out.println(" *************************************\n");
		System.out.printf("%6d\t", num1);
		System.out.printf("%6d\t", num2);
		System.out.printf("%6d\t", num3);
		System.out.printf("%6d\t", num4);
		System.out.printf("%6d\t", num5);
		System.out.printf("%6d\t", num6);
		System.out.printf("%6d\n", bonus);
		
		System.out.println("\n\n *************************************\n");
		System.out.println("\t\t\t당첨 번호\n");
		System.out.println(" *************************************\n");
		System.out.print("    " + result1 + "\t");
		System.out.print(" " + result2 + "\t");
		System.out.print(" " + result3 + "\t");
		System.out.print(" " + result4 + "\t");
		System.out.print(" " + result5 + "\t");
		System.out.print(" " + result6 + "\t");
		System.out.print(" " + bonusnum);
		
	}

}
