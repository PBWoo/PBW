package netio.multi.chat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClientProgram {
	public static void main(String[] args) throws UnknownHostException, IOException {

		try (Socket socket = new Socket("211.238.142.115", 10000)) {
			socket.setSoTimeout(15000);

			OutputStream nos = socket.getOutputStream();
			InputStream nis = socket.getInputStream();

			PrintStream nout = new PrintStream(nos, true);
			Scanner nscan = new Scanner(nis);

			Scanner scan = new Scanner(System.in);
			String msg;

			do {

				msg = scan.nextLine();
				nout.println(msg);

				String echo = nscan.nextLine();
				System.out.println(echo);

			} while (!msg.equals("bye"));
			nout.close();
			nscan.close();
			nis.close();
			nos.close();
			socket.close();

			// nout.write('h');
			// nout.flush();

		} catch (IOException ex) {
			System.out.println("연결오류");
		}
	}
}