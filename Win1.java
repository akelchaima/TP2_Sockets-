import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win1 {

	private JFrame Win1;
	private static JTextArea textArea;
	private JTextField textField;
	static ServerSocket ss;
	static Socket s;
	static DataInputStream input;
	static DataOutputStream output;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win1 window = new Win1();
					window.Win1.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String msgin = "";
		try {
			ss=new ServerSocket(1201);
			s= ss.accept();
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			while(!msgin.equals("bye!"))
			{
				msgin = input.readUTF();
				textArea.setText(textArea.getText().trim()+"\n Host2: "+msgin); //displaying msg from Host2
			}
			
		}catch(Exception e) {
			
	   }
	}



	/**
	 * Create the application.
	 */
	public Win1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		Win1 = new JFrame();
		Win1.setTitle("Win1");
		Win1.setBounds(100, 100, 450, 300);
		Win1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Win1.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 195);
		Win1.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 217, 324, 33);
		Win1.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    String msgout = "";
                    msgout = textField.getText().trim();
                    output.writeUTF(msgout);	//sending msg to Host2				
 
				}catch(Exception g) {
					
			   }
			}
		});
		btnSend.setBounds(335, 217, 89, 33);
		Win1.getContentPane().add(btnSend);
	}
}
