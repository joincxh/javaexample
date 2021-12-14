package cn.studentscore.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.studentscore.dao.StudentDao;
import cn.studentscore.dao.UserDao;
import cn.studentscore.model.Student;
import cn.studentscore.util.MysqlUtil;

public class StudentUserFrame extends JFrame {

	private JPanel contentPane;
	private JTable stuinfotable;
	private MysqlUtil dbUtil=new MysqlUtil();
	private UserDao userDao=new UserDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUserFrame frame = new StudentUserFrame();
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

	public StudentUserFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentUserFrame.class.getResource("/cn/studentscore/images/user.png")));
		setTitle("\u5B66\u751F\u7528\u6237\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u5F55\u5B66\u751F\u7528\u6237\u754C\u9762");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(StudentUserFrame.class.getResource("/cn/studentscore/images/student01.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u540C\u5B66\u60A8\u597D\uFF0C\u4EE5\u4E0B\u662F\u60A8\u7684\u57FA\u672C\u4FE1\u606F\u548C\u6210\u7EE9\u62A5\u544A:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("\u795D\u540C\u5B66\u524D\u7A0B\u4F3C\u9526\uFF01");
		lblNewLabel_2.setFont(new Font("幼圆", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1270, Short.MAX_VALUE)
								.addComponent(lblNewLabel)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(57)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(1050, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addGap(49)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(55))
		);
		
		stuinfotable = new JTable();
		stuinfotable.setFont(new Font("宋体", Font.PLAIN, 14));
		stuinfotable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u5B66\u9662", "\u5B66\u53F7", "\u6027\u522B", "\u5E74\u9F84", "\u5BB6\u5EAD\u4F4F\u5740", "\u8054\u7CFB\u65B9\u5F0F", "\u8BFE\u7A0B1\u6210\u7EE9", "\u8BFE\u7A0B2\u6210\u7EE9", "\u8BFE\u7A0B3\u6210\u7EE9", "\u73ED\u7EA7\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(stuinfotable);
		contentPane.setLayout(gl_contentPane);
		//初始化表格
		this.fillstuinfoTable(new Student());
		studentIdcardSearchActPerformed(null);
		/* 设置窗口居中 */
		this.setLocationRelativeTo(null);
	}
	
	
	//学生编号查询 事件方法封装构造
		private void studentIdcardSearchActPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
			String flagid= LoginFrame.valueString;
			Student student=new Student();
			student.setStuIdcard(flagid);
			this.fillstuinfoTable(student);
		}
	//初始化表格方法
			private void fillstuinfoTable(Student student){
				DefaultTableModel dtm=(DefaultTableModel)stuinfotable.getModel();//强制转换
				dtm.setRowCount(0);//初始化为零
				Connection con=null;
				try {
					con=dbUtil.getCon();
					ResultSet rs= userDao.infoidlist(con, student);
					while (rs.next()) {//循环遍历  添加进入table
						Vector vector=new Vector();
						vector.add(rs.getString("id"));//编号
						vector.add(rs.getString("stuName"));
						vector.add(rs.getString("stuXue"));
						vector.add(rs.getString("stuIdcard"));
						vector.add(rs.getString("stuSex"));
						vector.add(rs.getString("stuAge"));
						vector.add(rs.getString("stuAddress"));
						vector.add(rs.getString("stuPhone"));
						vector.add(rs.getString("stuPart1"));
						vector.add(rs.getString("stuPart2"));
						vector.add(rs.getString("stuPart3"));
						vector.add(rs.getString("stuTypeid"));
						dtm.addRow(vector);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						dbUtil.closeCon(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
}
