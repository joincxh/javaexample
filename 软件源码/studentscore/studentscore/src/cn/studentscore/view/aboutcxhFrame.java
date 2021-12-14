package cn.studentscore.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class aboutcxhFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aboutcxhFrame frame = new aboutcxhFrame();
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
	public aboutcxhFrame() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		setFrameIcon(new ImageIcon(aboutcxhFrame.class.getResource("/cn/studentscore/images/log.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u4F5C\u8005");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\uFF1A\u9648\u5174\u534E");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setBounds(10, 57, 180, 35);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66    \u6821\uFF1A\u95FD\u5357\u79D1\u6280\u5B66\u9662");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setBounds(10, 131, 302, 35);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel lblNewLabel_2 = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A20\u8BA1\u672C\u4E13\u5347\u672C2\u73ED");
		lblNewLabel_2.setForeground(Color.MAGENTA);
		lblNewLabel_2.setBounds(10, 176, 302, 24);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66    \u53F7\uFF1A5122512020080");
		lblNewLabel_3.setForeground(Color.MAGENTA);
		lblNewLabel_3.setBounds(10, 210, 302, 24);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel lblNewLabel_4 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A13960565525");
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setBounds(10, 244, 302, 26);
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, -29, 692, 423);
		lblNewLabel_5.setIcon(new ImageIcon(aboutcxhFrame.class.getResource("/cn/studentscore/images/back.jpg")));
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_4);
		getContentPane().add(lblNewLabel_1);
		getContentPane().add(lblNewLabel_3);
		getContentPane().add(lblNewLabel_2);
		getContentPane().add(lblNewLabel_5);

	}
}
