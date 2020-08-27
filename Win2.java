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

public class Win2 {

	private JFrame Win2;
	private JTextField textField;
	private static JTextArea textArea;
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
					Win2 window = new Win2();
					window.Win2.setVisible(true);
					
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			s=new Socket("127.0.0.1",1201);
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			String msgin = "";
			while(!msgin.equals("bye!"))
			{
				msgin = input.readUTF();
				textArea.setText(textArea.getText().trim()+"\n Host1: "+msgin); //displaying msg from Host1
			}
			
		}catch(Exception e) {
			
	   }
	}

	/**
	 * Create the application.
	 */
	public Win2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Win2 = new JFrame();
		Win2.setTitle("Win2");
		Win2.setBounds(700, 100, 450, 300);
		Win2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Win2.getContentPane().setLayout(null);
		
	    textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 195);
		Win2.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 217, 324, 33);
		Win2.getContentPane().add(textField);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				      String msgout = "";
	                    msgout = textField.getText().trim();
	                    output.writeUTF(msgout);	//sending msg to Host1				
		
				}catch(Exception g) {
					
			   }
			}
		});
		btnNewButton.setBounds(335, 217, 89, 33);
		Win2.getContentPane().add(btnNewButton);
	}
}
