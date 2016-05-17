package netio.multi.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoSeverProgram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		boolean isRun = true;

	      // ������ ����(���� IP)

	      ServerSocket svrSocket = new ServerSocket(10000);

	      System.out.println("listenning...");

	      while (isRun) {

	         Socket socket = svrSocket.accept();
	         System.out.println("connected from : " + socket.getRemoteSocketAddress());
	         new Thread(new Runnable() {
	            @Override
	            public void run() {

	               try {

	                  InputStream nis = socket.getInputStream();
	                  OutputStream nos = socket.getOutputStream();
	                  PrintStream nout = new PrintStream(nos, true);
	                  Scanner nscan = new Scanner(nis);
	                  String msg;

	                  do {

	                     msg = nscan.nextLine();
	                     System.out.println(msg);
	                    
	                     nout.println("echo: " + msg);

	                  } while (!msg.equals("bye"));

	                  nout.close();
	                  nscan.close();
	                  svrSocket.close();

	               } catch (IOException e) {
	                  e.printStackTrace();
	               }
	               
	            }
	         }).start();

	      }
	      System.out.println("���۵� ������ ���� �Ǿ����ϴ�.");
	   }
	
	}


