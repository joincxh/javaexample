package cn.studentscore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Table;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Window.Type;
import javax.swing.BoxLayout;
//系统主界面
public class MainstudentFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainstudentFrame frame = new MainstudentFrame();
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
	public MainstudentFrame() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainstudentFrame.class.getResource("/cn/studentscore/images/Teacher.png")));
		setTitle("\u5B66\u751F\u6210\u7EE9\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 511);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu_3.setIcon(new ImageIcon(MainstudentFrame.class.getResource("/cn/studentscore/images/student01.png")));
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//退出系统 事件处理
				int result= JOptionPane.showConfirmDialog(null, "是否退出系统");
				//System.out.println(result);//测试
				if (result==0) {
					dispose();//销毁当前系统
				}
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu.setIcon(new ImageIcon(MainstudentFrame.class.getResource("/cn/studentscore/images/classmanage.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//班级添加事件
				ClassTypeAddFrame classTypeAddFrame=new ClassTypeAddFrame();
				classTypeAddFrame.setVisible(true);//显示界面
				table.add(classTypeAddFrame);//添加组件界面
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u73ED\u7EA7\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//班级维护事件 触发
				ClassTypeManageFrame classTypeManageFrame=new ClassTypeManageFrame();
				classTypeManageFrame.setVisible(true);//显示界面
				table.add(classTypeManageFrame);//添加组件界面
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainstudentFrame.class.getResource("/cn/studentscore/images/studentmanage.png")));
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//学生添加触发事件  方法
				StudentAddFrame studentAddFrame=new StudentAddFrame();
				studentAddFrame.setVisible(true);//显示界面
				table.add(studentAddFrame);//添加组件界面
				
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5B66\u751F\u7EF4\u62A4");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//学生维护  事件触发
				StudentManageFrame studentManageFrame=new StudentManageFrame();
				studentManageFrame.setVisible(true);//显示界面
				table.add(studentManageFrame);//添加组件界面
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_2.setIcon(new ImageIcon(MainstudentFrame.class.getResource("/cn/studentscore/images/log.png")));
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u5173\u4E8E\u4F5C\u8005");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//关于我们   事件处理
				aboutcxhFrame cxh=new aboutcxhFrame();
				cxh.setVisible(true);
				table.add(cxh);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 table = new JDesktopPane();
		 table.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗口最大化
		/*设置窗口居中*/
		this.setLocationRelativeTo(null);
	}
}
