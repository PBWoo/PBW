package practice.book;

public class Ch6_ex15_MemberService {

	public boolean login(String id, String password) {
		
		if(id.equals("hong") && password.equals("12345"))
			return true;
		else
			return false;
	}

	public void logout(String id) {
		
		System.out.println("\n\t로그아웃 되었습니다.");
	}

	
}
