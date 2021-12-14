package cn.studentscore.view;
//学生信息管理主界面类 学生信息维护窗口
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.studentscore.dao.ClassTypeDao;
import cn.studentscore.dao.StudentDao;
import cn.studentscore.model.ClassType;
import cn.studentscore.model.Student;
import cn.studentscore.util.MysqlUtil;
import cn.studentscore.util.StringToolsUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentManageFrame extends JInternalFrame {
	private JTextField stuNametxt;
	private JTextField stuIdcardtxt;
	private JTable studentTable;
	private MysqlUtil dbUtil=new MysqlUtil();
	private StudentDao studentDao=new StudentDao();
	private JTextField stuIdtxt;
	private JTextField stuTypeidtxt;
	private JTextField studentNametxt;
	private JTextField studentXuetxt;
	private JTextField studentIdcardtxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField studentAgetxt;
	private JTextField studentAddresstxt;
	private JTextField studentPhonetxt;
	private JTextField studentPart1txt;
	private JTextField studentPart2txt;
	private JTextField studentPart3txt;
	private JTextField studentSextxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageFrame frame = new StudentManageFrame();
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
	public StudentManageFrame() {
		setIconifiable(true);
		setClosable(true);
		setFrameIcon(new ImageIcon(StudentManageFrame.class.getResource("/cn/studentscore/images/log.png")));
		setTitle("\u5B66\u751F\u7EF4\u62A4\u754C\u9762");
		setBounds(100, 100, 1326, 676);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		stuNametxt = new JTextField();
		stuNametxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//根据学生姓名查询事件
				studentNameSearchActPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/cn/studentscore/images/search.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		stuIdcardtxt = new JTextField();
		stuIdcardtxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//根据学号查询学生信息  事件触发
				studentIdcardSearchActPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/cn/studentscore/images/search.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5B66\u751F\u4FE1\u606F\u64CD\u4F5C\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改信息 事件方法触发
				studentUpdateActPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/cn/studentscore/images/change.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//学生信息删除方法  触发事件
				studentDelActPerform(e);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(StudentManageFrame.class.getResource("/cn/studentscore/images/delete.png")));
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuNametxt, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addGap(42)
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 498, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuIdcardtxt, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(btnNewButton_1))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(358)
							.addComponent(btnNewButton_2)
							.addGap(171)
							.addComponent(btnNewButton_3)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stuNametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel_1)
						.addComponent(stuIdcardtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		stuIdtxt = new JTextField();
		stuIdtxt.setEditable(false);
		stuIdtxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u73ED\u7EA7\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		stuTypeidtxt = new JTextField();
		stuTypeidtxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentNametxt = new JTextField();
		studentNametxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentXuetxt = new JTextField();
		studentXuetxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentIdcardtxt = new JTextField();
		studentIdcardtxt.setEditable(false);
		studentIdcardtxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_8 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentAgetxt = new JTextField();
		studentAgetxt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentAddresstxt = new JTextField();
		studentAddresstxt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentPhonetxt = new JTextField();
		studentPhonetxt.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("\u8BFE\u7A0B\u6210\u7EE9--->>");
		lblNewLabel_11.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_12 = new JLabel("\u8BFE\u7A0B1\u6210\u7EE9\uFF1A");
		lblNewLabel_12.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentPart1txt = new JTextField();
		studentPart1txt.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("\u8BFE\u7A0B2\u6210\u7EE9\uFF1A");
		lblNewLabel_13.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentPart2txt = new JTextField();
		studentPart2txt.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("\u8BFE\u7A0B3\u6210\u7EE9\uFF1A");
		lblNewLabel_14.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentPart3txt = new JTextField();
		studentPart3txt.setColumns(10);
		
		studentSextxt = new JTextField();
		studentSextxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_10)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentPhonetxt, 567, 567, 567))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(stuIdtxt, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentNametxt)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentXuetxt))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentIdcardtxt, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stuTypeidtxt, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_9)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentAddresstxt, 567, 567, 567)))
							.addGap(30)
							.addComponent(lblNewLabel_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentSextxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_8)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentAgetxt, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_11)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_13)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentPart2txt))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_12)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentPart1txt, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_14)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentPart3txt)))))
					.addContainerGap(245, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(stuIdtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(studentIdcardtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(studentNametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(studentXuetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8)
						.addComponent(studentAgetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentSextxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(stuTypeidtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(studentAddresstxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_10)
						.addComponent(studentPhonetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_11)
						.addComponent(lblNewLabel_12)
						.addComponent(studentPart1txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_13)
						.addComponent(studentPart2txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_14)
						.addComponent(studentPart3txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		studentTable = new JTable();
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//表格单击事件  触发
				studentTableMousePressed(e);
			}
		});
		studentTable.setFont(new Font("宋体", Font.PLAIN, 14));
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u5B66\u9662", "\u5B66\u53F7", "\u6027\u522B", "\u5E74\u9F84", "\u5BB6\u5EAD\u4F4F\u5740", "\u8054\u7CFB\u65B9\u5F0F", "\u8BFE\u7A0B1\u6210\u7EE9", "\u8BFE\u7A0B2\u6210\u7EE9", "\u8BFE\u7A0B3\u6210\u7EE9", "\u73ED\u7EA7\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentTable);
		getContentPane().setLayout(groupLayout);
		//初始化表格
		this.fillTable(new Student());
		
	}
	//学生信息删除方法
	
	private void studentDelActPerform(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String id=stuIdtxt.getText();
		if (StringToolsUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请您选择需要删除的学生信息记录！");
			return;
		}
		//获取返回值
		int flag= JOptionPane.showConfirmDialog(null, "是否确定删除该条记录？");
		if (flag==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();//连接数据库
			// pankong 判空
				int del= studentDao.delstu(con, id);//删除
				if (del==1) {
					JOptionPane.showMessageDialog(null, "学生信息删除成功！");
					resetValue();
					fillstuTable(new Student());//初始化刷新表格
				}else {
					JOptionPane.showMessageDialog(null, "学生信息删除失败！");
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);//关闭数据库
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	//修改事件方法
	private void studentUpdateActPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id= stuIdtxt.getText();//获取各项属性字段内容
		String stuName= studentNametxt.getText();
		String stuXue= studentXuetxt.getText();
		String stuIdcard= studentIdcardtxt.getText();
		String stuSex= studentSextxt.getText();
		String stuAge= studentAgetxt.getText();
		String stuAddress= studentAddresstxt.getText();
		String stuPhone= studentPhonetxt.getText();
		String stuPart1= studentPart1txt.getText();
		String stuPart2= studentPart2txt.getText();
		String stuPart3= studentPart3txt.getText();
		String stuTypeid= stuTypeidtxt.getText();
		if (StringToolsUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请您选择需要修改的学生信息记录！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuName)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuXue)) {
			JOptionPane.showMessageDialog(null, "学院名称不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuIdcard)) {
			JOptionPane.showMessageDialog(null, "学号信息不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuSex)) {
			JOptionPane.showMessageDialog(null, "性别信息不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuAge)) {
			JOptionPane.showMessageDialog(null, "年龄信息不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuAddress)) {
			JOptionPane.showMessageDialog(null, "家庭住址信息不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuPhone)) {
			JOptionPane.showMessageDialog(null, "联系方式信息不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(stuPart1)&&StringToolsUtil.isEmpty(stuPart2)&&StringToolsUtil.isEmpty(stuPart3)) {
			JOptionPane.showMessageDialog(null, "各个课程成绩信息不能为空！");
			return;
		}
		/*
		 * if (StringToolsUtil.isEmpty(stuTypeid)) { JOptionPane.showMessageDialog(null,
		 * "班级编号信息不能为空！"); return; }
		 */
	
		Student student=new Student(Integer.parseInt(id),stuName,stuXue,stuIdcard,stuSex,stuAge,stuAddress,
				stuPhone,stuPart1,stuPart2,stuPart3, Integer.parseInt(stuTypeid));
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int upd= studentDao.updstu(con, student);
			if (upd==1) {
				JOptionPane.showMessageDialog(null, "学生信息修改成功！");
				resetValue();
				fillstuTable(new Student());//刷新一下
			}else {
				JOptionPane.showMessageDialog(null, "学生信息修改失败！");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭数据库
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	//初始化表格方法
		private void fillstuTable(Student student){
			DefaultTableModel dtm=(DefaultTableModel)studentTable.getModel();//强制转换
			dtm.setRowCount(0);//初始化为零
			Connection con=null;
			try {
				con=dbUtil.getCon();
				ResultSet rs= studentDao.idlist(con, student);//或者stulist也行
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
	//重置方法封装
		private void resetValue() {
			// TODO Auto-generated method stub
			this.stuIdtxt.setText("");
			this.stuTypeidtxt.setText("");
			this.studentNametxt.setText("");
			this.studentXuetxt.setText("");
			this.studentIdcardtxt.setText("");
			this.studentSextxt.setText("");
			this.studentAgetxt.setText("");
			this.studentAddresstxt.setText("");
			this.studentPhonetxt.setText("");
			this.studentPart1txt.setText("");
			this.studentPart2txt.setText("");
			this.studentPart3txt.setText("");
			
			
		}
	//biaogedanjishijiajn单击
	private void studentTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row= studentTable.getSelectedRow();
		stuIdtxt.setText((String)studentTable.getValueAt(row, 0));
		stuTypeidtxt.setText((String)studentTable.getValueAt(row, 11));
		studentNametxt.setText((String)studentTable.getValueAt(row, 1));
		studentXuetxt.setText((String)studentTable.getValueAt(row, 2));
		studentIdcardtxt.setText((String)studentTable.getValueAt(row, 3));
		studentSextxt.setText((String)studentTable.getValueAt(row, 4));
		studentAgetxt.setText((String)studentTable.getValueAt(row, 5));
		studentAddresstxt.setText((String)studentTable.getValueAt(row, 6));
		studentPhonetxt.setText((String)studentTable.getValueAt(row, 7));
		studentPart1txt.setText((String)studentTable.getValueAt(row, 8));
		studentPart2txt.setText((String)studentTable.getValueAt(row, 9));
		studentPart3txt.setText((String)studentTable.getValueAt(row, 10));
	}

	//学号查询 事件方法封装构造
	private void studentIdcardSearchActPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String studentIdcard= this.stuIdcardtxt.getText();
		Student student=new Student();
		student.setStuIdcard(studentIdcard);
		this.fill2Table(student);
	}

	//姓名查询 事件方法封装构造
	private void studentNameSearchActPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String studentName= this.stuNametxt.getText();
		Student student=new Student();
		student.setStuName(studentName);
		this.fillTable(student);
	}
	
		//初始化表格方法
		private void fillTable(Student student){
			DefaultTableModel dtm=(DefaultTableModel)studentTable.getModel();//强制转换
			dtm.setRowCount(0);//初始化为零
			Connection con=null;
			try {
				con=dbUtil.getCon();
				ResultSet rs= studentDao.stulist(con, student);
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
		//初始化表格方法
				private void fill2Table(Student student){
					DefaultTableModel dtm=(DefaultTableModel)studentTable.getModel();//强制转换
					dtm.setRowCount(0);//初始化为零
					Connection con=null;
					try {
						con=dbUtil.getCon();
						ResultSet rs= studentDao.idlist(con, student);
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
