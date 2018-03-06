package com.oracle.jdbc.t3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ATMMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ATMMain frame = new ATMMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public ATMMain(String name,float money) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("欢迎您:"+name+"!");
		label.setBounds(23, 68, 93, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("您的账户余额:"+money+"元RMB");
		label_1.setBounds(246, 68, 161, 15);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("转账");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(23, 169, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查询");
		btnNewButton_1.setBounds(188, 136, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("取钱");
		btnNewButton_2.setBounds(188, 169, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("存钱");
		btnNewButton_3.setBounds(23, 136, 93, 23);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("退卡");
		button.setBounds(188, 214, 93, 23);
		contentPane.add(button);
	}

}
