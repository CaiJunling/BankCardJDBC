package com.oracle.jdbc.t3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ATMLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATMLogin frame = new ATMLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ATMLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\work\\workspace\\java\\JavaEE\\JDBCDemo\\timg.jpg"));
		lblNewLabel.setBounds(0, 0, 530, 144);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(180, 154, 174, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 197, 166, 21);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登陸");
		button.setBounds(214, 228, 93, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//1.先获取用户在界面上输入的账户名和密码
				String  yourInputAccount=textField.getText().toString().trim();
				String  yourInputPassword=passwordField.getText().toString();
				System.out.println(yourInputAccount+"\t"+yourInputPassword);
				
				//2.连接数据库根据输入的用户名和密码查询该用户是否存在
				
				try {
					Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@172.19.22.111:1521:XE", "bankadmin", "bankadmin");
					Statement  sta=con.createStatement();
					
					ResultSet  rs=sta.executeQuery("select * from accounts where accId="+yourInputAccount+"  and  accpass='"+yourInputPassword+"' ");
					
					if(rs.next())
					{
						String name=rs.getString("accrealname");
						float  money=rs.getFloat("accMoney");
						ATMMain  main=new ATMMain(name,money);
						main.setVisible(true);
						ATMLogin.this.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "用户名或密码错误", "温馨提示", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		contentPane.add(button);
	}
}
