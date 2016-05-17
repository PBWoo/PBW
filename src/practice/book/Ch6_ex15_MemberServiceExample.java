package practice.book;

public class Ch6_ex15_MemberServiceExample {

	public static void main(String[] args) {
		
		Ch6_ex15_MemberService memberService = new Ch6_ex15_MemberService();
		
		boolean result = memberService.login("hong", "12345");
		
		if(result){
			System.out.println("\n\t로그인 되었습니다.");
			memberService.logout("hong");
		}
		else{
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}

	}

}
