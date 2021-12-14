package cn.studentscore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.studentscore.dao.UserDao;
import cn.studentscore.model.ClassType;
import cn.studentscore.model.Student;
import cn.studentscore.model.User;
import cn.studentscore.util.MysqlUtil;
import cn.studentscore.util.StringToolsUtil;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField PassWord;
	private MysqlUtil dbUtil = new MysqlUtil();
	private UserDao userDao = new UserDao();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton sturole;
	private JRadioButton adminrole;
	private JComboBox roleJcb;
	private JComboBox comboBox;
	public static String valueString;//存储对象返回的编号
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		
		
		setFont(new Font("Dialog", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginFrame.class.getResource("/cn/studentscore/images/Teacher.png")));
		setTitle("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(261, 43, 275, 137);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 21));
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/student.png")));

		JLabel lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel_1.setBounds(5, 5, 92, 96);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/Teacher.png")));

		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setBounds(100, 221, 92, 32);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/user.png")));

		JLabel lblNewLabel_3 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_3.setBounds(100, 280, 92, 32);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/password.png")));

		userName = new JTextField();
		userName.setBounds(202, 227, 334, 21);
		userName.setColumns(10);

		PassWord = new JPasswordField();
		PassWord.setBounds(202, 286, 334, 21);

		JButton loginBt = new JButton("\u767B\u5F55");
		loginBt.setBounds(202, 349, 116, 41);
		loginBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* 登录事件方法 */
				loginActionPerformed(e);
			}
		});
		loginBt.setFont(new Font("宋体", Font.PLAIN, 14));
		loginBt.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/login.png")));

		JButton resetBt = new JButton("\u91CD\u7F6E");
		resetBt.setBounds(410, 349, 126, 41);
		resetBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 重置事件方法

				resetActionPerformed(e);
			}
		});
		resetBt.setFont(new Font("宋体", Font.PLAIN, 14));
		resetBt.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/reset.png")));
		contentPane.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Powered by \u9648\u5174\u534E    QQ\uFF1A1448816758");
		lblNewLabel_4.setBounds(155, 395, 281, 32);
		lblNewLabel_4.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/student01.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_2);
		contentPane.add(userName);
		contentPane.add(loginBt);
		contentPane.add(resetBt);
		contentPane.add(lblNewLabel_3);
		contentPane.add(PassWord);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(LoginFrame.class.getResource("/cn/studentscore/images/background.jpg")));
		lblNewLabel_5.setBounds(0, 0, 594, 471);
		contentPane.add(lblNewLabel_5);

		/* 设置窗口居中 */
		this.setLocationRelativeTo(null);
	}

	// 自动创建一个登录事件方法 改为私有 执行登录
	private void loginActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName = this.userName.getText();
		String PassWord = new String(this.PassWord.getPassword());// 强制转换类型
		/*
		 * User user1 = (User)comboBox.getSelectedItem(); int Is_Admin =
		 * user1.getIs_Admin();
		 */
		
		//String qx="";
		//roleJcb=null;
		 //qx= this.roleJcb.getSelectedItem().toString();
		//User user=(User)roleJcb.getSelectedItem();//强转
		//int Is_Admin1= user.getIs_Admin();
		//判断输入的角色
		/*
		 * if (qx.equals("学生")) { Is_Admin = 0; }else if (qx.equals("管理员")) { Is_Admin =
		 * 1; }
		 */
			/*
			 * if (qxString.equals("学生")) { Is_Admin=0; }else if (qxString.equals("管理员")) {
			 * Is_Admin=1; }
			 */
		
			/*
			 * String is_Admin=null; if (sturole.isSelected()) { is_Admin="学生"; }else if
			 * (adminrole.isSelected()) { is_Admin="管理员"; }
			 */
		if (StringToolsUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringToolsUtil.isEmpty(PassWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		User user = new User(userName, PassWord);
		Connection con = null;// 抛出异常
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {
				// JOptionPane.showMessageDialog(null, "登录成功");
				dispose();/// 销毁当前窗口
				int flag=currentUser.toadminInt();//获取权限标志
				valueString=currentUser.toid();//获取静态公开的学生编号外键值
				if (flag==1) {
					JOptionPane.showMessageDialog(null, "管理员，欢迎登录学生成绩管理系统！");
						new MainstudentFrame().setVisible(true);// 调到管理员主界面窗口
				  }else { 
					 JOptionPane.showMessageDialog(null, "同学，欢迎登录成绩管理系统！");
					  new StudentUserFrame().setVisible(true);//学生界面
				  }
			} else {
				JOptionPane.showMessageDialog(null, "用户名或者密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);// 抛出异常 关闭数据库

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 自动创建一个重置事件方法 改为私有 执行重置
	private void resetActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		// 当前数据置空
		this.userName.setText("");
		this.PassWord.setText("");

	}
}
