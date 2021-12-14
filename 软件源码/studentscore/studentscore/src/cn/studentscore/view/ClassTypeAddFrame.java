package cn.studentscore.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import cn.studentscore.dao.ClassTypeDao;
import cn.studentscore.model.ClassType;
import cn.studentscore.util.MysqlUtil;
import cn.studentscore.util.StringToolsUtil;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ClassTypeAddFrame extends JInternalFrame {
	private JTextField xueyuantxt;
	private JTextField gradenametxt;
	private JTextArea gradedesctxt;
	private MysqlUtil dbUtil=new MysqlUtil();
	private ClassTypeDao classTypeDao=new ClassTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassTypeAddFrame frame = new ClassTypeAddFrame();
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
	public ClassTypeAddFrame() {
		setFrameIcon(new ImageIcon(ClassTypeAddFrame.class.getResource("/cn/studentscore/images/classmanage.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 433, 427);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		xueyuantxt = new JTextField();
		xueyuantxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		gradenametxt = new JTextField();
		gradenametxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u5907\u6CE8\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		gradedesctxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//添加事件  触发
				classTypeAddActionPerfromed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ClassTypeAddFrame.class.getResource("/cn/studentscore/images/add.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//信息重置事件
				resetActionPerfromed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ClassTypeAddFrame.class.getResource("/cn/studentscore/images/reset.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(71))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradedesctxt, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gradenametxt, 204, 204, 204))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(xueyuantxt, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
							.addGap(81))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(xueyuantxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(gradenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(gradedesctxt, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		//优化边框
		gradedesctxt.setBorder(new LineBorder(new Color(127,157,185),1,false));
	}
	//添加事件  执行的方法 触发
	private void classTypeAddActionPerfromed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String xueyuan=this.xueyuantxt.getText();//获取用户输入学院信息
		String gradename=this.gradenametxt.getText();//专业班级
		String gradedesc=this.gradedesctxt.getText();//备注
		
		//判空
		if (StringToolsUtil.isEmpty(xueyuan)) {
			JOptionPane.showMessageDialog(null, "学院信息不能为空！");
			return;//错误中止执行
		}
		if (StringToolsUtil.isEmpty(gradename)) {
			JOptionPane.showMessageDialog(null, "专业班级信息不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(gradedesc)) {
			JOptionPane.showMessageDialog(null, "班级备注信息不能为空！");
			return;
		}
		ClassType classType =new ClassType(xueyuan,gradename,gradedesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=classTypeDao.add(con, classType);
			if (n==1) {
				JOptionPane.showMessageDialog(null, "班级信息添加成功！");
				resetValues();//置空封装调用
			}else {
				JOptionPane.showMessageDialog(null, "添加操作失败！");
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

	//重置方法  事件触发
	private void resetActionPerfromed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValues();//调用封装好的方法
	}
	//封装一个重置方法  添加信息后调用
	private void resetValues() {
		//置空
		this.xueyuantxt.setText("");
		this.gradenametxt.setText("");
		this.gradedesctxt.setText("");
	}
}
