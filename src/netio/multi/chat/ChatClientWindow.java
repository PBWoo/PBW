package netio.multi.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings;

public class ChatClientWindow extends JFrame implements Runnable{
	private Socket socket;
	private PrintStream nout;
	private Scanner nscan;
	
	/*메뉴 객체의 구조*/
	private JMenuBar menuBar;
	
	private JMenu mnFile;
	private JMenuItem miExit;
	
	private JMenu mnTool;
	private JMenuItem miConn;
	private JMenuItem miSetting;
	
	private JTextArea txtInput;
	private JTextArea txtOutput;
	private JButton btnSend;
	private JPanel panel;
		
	public ChatClientWindow() {
		setSize(500, 700);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		menuBar = new JMenuBar();		
		mnFile = new JMenu("File");
		miExit = new JMenuItem("Exit");
		
		mnTool = new JMenu("Tool");
		miConn = new JMenuItem("Connect");
		miConn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket("211.238.142.105", 10000);
					
					if(socket.isConnected())
					{
						txtOutput.setText("connected to ");
						
						InputStream is = socket.getInputStream();
						OutputStream os = socket.getOutputStream();
						
						nout = new PrintStream(os,true);
						nscan = new Scanner(is);
						
						new Thread(ChatClientWindow.this).start();
						
					}
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//txtInput.setEnabled(true);
				//JOptionPane.showConfirmDialog(null, "Hello");		
			}
		});
		miSetting = new JMenuItem("Setting");
		
		mnFile.add(miExit);
		menuBar.add(mnFile);
		
		mnTool.add(miConn);
		mnTool.add(miSetting);
		menuBar.add(mnTool);
		
		setJMenuBar(menuBar);
		
		
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());		
				
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = txtInput.getText();
			
					msg += "\n" + txtOutput.getText();		
				
				nout.println(msg);
				
				txtOutput.setText(msg);
				txtInput.setText("");
				// 네트워크로 전달
				
				
			
			}
		});
		panel.add(btnSend, BorderLayout.LINE_END); 
		
		txtInput = new JTextArea();
		txtInput.setPreferredSize(new Dimension(100, 100));
		txtInput.setBorder(BorderFactory.createLineBorder(Color.black));
		//txtInput.setEnabled(false);		
		panel.add(txtInput, BorderLayout.CENTER); 
		
		this.add(panel, BorderLayout.PAGE_END);
		
		txtOutput = new JTextArea();
		txtOutput.setBorder(BorderFactory.createLineBorder(Color.black));
		txtOutput.setEditable(false);
		this.add(txtOutput, BorderLayout.CENTER);
		
		
	}

	// 네트워크로 입력 되는 값을 처리하는 함수
	@Override
	public void run() {
		while(true){
			String msg = nscan.nextLine();
			txtOutput.setText(msg);
		}
	}
}