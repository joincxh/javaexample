package cn.studentscore.view;

import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.util.StringUtils;

import cn.studentscore.dao.ClassTypeDao;
import cn.studentscore.model.ClassType;
import cn.studentscore.util.MysqlUtil;
import cn.studentscore.util.StringToolsUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
//班级维护内部窗口
public class ClassTypeManageFrame extends JInternalFrame {
	private JTextField s_gradenametxt;
	private JTable classTypeTxt;
	private MysqlUtil dbUtil=new MysqlUtil();
	private ClassTypeDao classTypeDao=new ClassTypeDao();
	private JTextField classidtxt;
	private JTextField classxueyuantxt;
	private JTextField gradenametxt;
	private JTextArea gradedesctxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassTypeManageFrame frame = new ClassTypeManageFrame();
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
	public ClassTypeManageFrame() {
		setFrameIcon(new ImageIcon(ClassTypeManageFrame.class.getResource("/cn/studentscore/images/classrepair.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u73ED\u7EA7\u7EF4\u62A4\u754C\u9762");
		setBounds(100, 100, 816, 648);
		
		JLabel lblNewLabel = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		s_gradenametxt = new JTextField();
		s_gradenametxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询事件  触发
				gradenameSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ClassTypeManageFrame.class.getResource("/cn/studentscore/images/search.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u73ED\u7EA7\u6570\u636E\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改操作  触发的事件方法
				classTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ClassTypeManageFrame.class.getResource("/cn/studentscore/images/change.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除操作  触发的方法
				classTypeDelActPerform(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ClassTypeManageFrame.class.getResource("/cn/studentscore/images/delete.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(s_gradenametxt, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addGap(74)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(btnNewButton_1)
							.addGap(182)
							.addComponent(btnNewButton_2)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_gradenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(24))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		classidtxt = new JTextField();
		classidtxt.setEditable(false);
		classidtxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		classxueyuantxt = new JTextField();
		classxueyuantxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		gradenametxt = new JTextField();
		gradenametxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u73ED\u7EA7\u5907\u6CE8\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		gradedesctxt = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(classidtxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(classxueyuantxt, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(gradedesctxt, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(gradenametxt, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addGap(203))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(classidtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(classxueyuantxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(gradenametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(gradedesctxt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		classTypeTxt = new JTable();
		classTypeTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				classTypeTableMousePressed(e);
			}
		});
		classTypeTxt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u9662\u540D\u79F0", "\u4E13\u4E1A\u73ED\u7EA7", "\u73ED\u7EA7\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(classTypeTxt);
		getContentPane().setLayout(groupLayout);
		
		//调用初始化表格
		this.fillTable(new ClassType());
		//优化边框
		gradedesctxt.setBorder(new LineBorder(new Color(127,157,185),1,false));
	}
	
	//删除操作执行的事件方法
	private void classTypeDelActPerform(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=classidtxt.getText();
		if (StringToolsUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请您选择需要删除的班级信息记录！");
			return;
		}
		//获取返回值
		int flag= JOptionPane.showConfirmDialog(null, "是否确定删除该条记录？");
		if (flag==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();//连接数据库
				//有学生的班级不能删除  没有学生的班级可以删除  pankong 判空
				int del= classTypeDao.delclass(con, id);//删除
				if (del==1) {
					JOptionPane.showMessageDialog(null, "班级信息删除成功！");
					resetValue();
					fillTable(new ClassType());//初始化刷新表格
				}else {
					JOptionPane.showMessageDialog(null, "班级信息删除失败！");
					
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

	//表格信息修改事件方法
	private void classTypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id= classidtxt.getText();//获取各项属性字段内容
		String xueyuan= classxueyuantxt.getText();
		String gradename= gradenametxt.getText();
		String gradedesc= gradedesctxt.getText();
		if (StringToolsUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请您选择需要修改的班级信息记录！");
			return;
		}
		if (StringToolsUtil.isEmpty(xueyuan)) {
			JOptionPane.showMessageDialog(null, "学院名称不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(gradename)) {
			JOptionPane.showMessageDialog(null, "专业班级不能为空！");
			return;
		}
		if (StringToolsUtil.isEmpty(gradedesc)) {
			JOptionPane.showMessageDialog(null, "班级备注信息不能为空！");
			return;
		}
		ClassType classType=new ClassType(Integer.parseInt(id),xueyuan,gradename,gradedesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int upd= classTypeDao.updclass(con, classType);
			if (upd==1) {
				JOptionPane.showMessageDialog(null, "班级信息修改成功！");
				resetValue();
				fillTable(new ClassType());//刷新一下
			}else {
				JOptionPane.showMessageDialog(null, "班级信息修改失败！");
				
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
	//重置方法封装
	private void resetValue() {
		// TODO Auto-generated method stub
		this.classidtxt.setText("");
		this.classxueyuantxt.setText("");
		this.gradenametxt.setText("");
		this.gradedesctxt.setText("");
		
	}

	//表格单击事件
	private void classTypeTableMousePressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		int row= classTypeTxt.getSelectedRow();
		classidtxt.setText((String)classTypeTxt.getValueAt(row, 0));
		classxueyuantxt.setText((String)classTypeTxt.getValueAt(row, 1));
		gradenametxt.setText((String)classTypeTxt.getValueAt(row, 2));
		gradedesctxt.setText((String)classTypeTxt.getValueAt(row, 3));
		
		
	}

	//班级查询方法
	private void gradenameSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_gradename = this.s_gradenametxt.getText();
		ClassType classType=new ClassType();
		classType.setGradename(s_gradename);
		this.fillTable(classType);
	}
	
	
	//初始化表格方法
	private void fillTable(ClassType classType){
		DefaultTableModel dtm=(DefaultTableModel)classTypeTxt.getModel();//强制转换
		dtm.setRowCount(0);//初始化为零
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs= classTypeDao.list(con, classType);
			while (rs.next()) {//循环遍历  添加进入table
				Vector vector=new Vector();
				vector.add(rs.getString("id"));//编号
				vector.add(rs.getString("xueyuan"));//学院
				vector.add(rs.getString("gradename"));//专业班级
				vector.add(rs.getString("gradedesc"));//班级备注
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
