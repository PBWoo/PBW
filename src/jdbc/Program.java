package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

   public static void main(String[] args) throws SQLException {
      // Class.forName("oracle.jdbc.driver.OracleDriver"); 7이상부터는 안해줘도 됨
      Scanner scan = new Scanner(System.in);

      System.out.println("\t\t[회원 검색 프로그램 ]");
      System.out.print("이름 검색어 입력: ");
      String key = scan.next();

      String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
       String sql = "SELECT *  FROM MEMBER WHERE NAME LIKE '%" + key + "%'";

      //String sql = "SELECT *  FROM MEMBER WHERE REGEXP_LIKE(NAME, '^나정(짱)$')";

      //System.out.println(sql);

      Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      System.out.println();
      System.out.println();
      System.out.println("───────────────");
      System.out.println("아이디 \t 이름 \t 나이");
      System.out.println("───────────────");
      while (rs.next()) {

         // 서버에서 레코드 하나를 가져옴
         String mid = rs.getString("MID");
         String name = rs.getString("NAME");
         String age = rs.getString("AGE");

         System.out.printf("%s \t %s \t %s \n", mid, name, age);

      }


   }

}