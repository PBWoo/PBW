package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

   public static void main(String[] args) throws SQLException {
      // Class.forName("oracle.jdbc.driver.OracleDriver"); 7�̻���ʹ� �����൵ ��
      Scanner scan = new Scanner(System.in);

      System.out.println("\t\t[ȸ�� �˻� ���α׷� ]");
      System.out.print("�̸� �˻��� �Է�: ");
      String key = scan.next();

      String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
       String sql = "SELECT *  FROM MEMBER WHERE NAME LIKE '%" + key + "%'";

      //String sql = "SELECT *  FROM MEMBER WHERE REGEXP_LIKE(NAME, '^����(¯)$')";

      //System.out.println(sql);

      Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      System.out.println();
      System.out.println();
      System.out.println("������������������������������");
      System.out.println("���̵� \t �̸� \t ����");
      System.out.println("������������������������������");
      while (rs.next()) {

         // �������� ���ڵ� �ϳ��� ������
         String mid = rs.getString("MID");
         String name = rs.getString("NAME");
         String age = rs.getString("AGE");

         System.out.printf("%s \t %s \t %s \n", mid, name, age);

      }


   }

}