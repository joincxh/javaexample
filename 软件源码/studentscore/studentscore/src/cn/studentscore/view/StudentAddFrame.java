package cn.studentscore.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import cn.studentscore.dao.ClassTypeDao;
import cn.studentscore.dao.StudentDao;
import cn.studentscore.model.ClassType;
import cn.studentscore.model.Student;
import cn.studentscore.util.MysqlUtil;
import cn.studentscore.util.StringToolsUtil;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAddFrame extends JInternalFrame {
	private JTextField stuNametxt;
	private JTextField stuXuetxt;
	private JTextField stuIdcardtxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField stuAgetxt;
	private JTextField stuPhonetxt;
	private JTextField stuAddresstxt;
	private JTextField stuPart1txt;
	private JTextField stuPart2txt;
	private JTextField stuPart3txt;
	private MysqlUtil dbUtil=new MysqlUtil();
	private ClassTypeDao classTypeDao=new ClassTypeDao();
	private StudentDao studentDao=new StudentDao();
	private JComboBox stuClasstxt;
	private JRadioButton manJcb;
	private JRadioButton femaleJcb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAddFrame frame = new StudentAddFrame();
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
	public StudentAddFrame() {
		getContentPane().setFont(new Font("????", Font.PLAIN, 14));
		setFrameIcon(new ImageIcon(StudentAddFrame.class.getResource("/cn/studentscore/images/studentmanage.png")));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5B66\u751F\u4FE1\u606F\u6DFB\u52A0\u754C\u9762");
		setBounds(100, 100, 566, 576);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setFont(new Font("????", Font.PLAIN, 14));
		
		stuNametxt = new JTextField();
		stuNametxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u9662\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("????", Font.PLAIN, 14));
		
		stuXuetxt = new JTextField();
		stuXuetxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E13\u4E1A\u73ED\u7EA7\uFF1A");
		lblNewLabel_2.setFont(new Font("????", Font.PLAIN, 14));
		
		stuClasstxt = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u5B66\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("????", Font.PLAIN, 14));
		
		stuIdcardtxt = new JTextField();
		stuIdcardtxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("????", Font.PLAIN, 14));
		
		manJcb = new JRadioButton("\u7537");
		manJcb.setFont(new Font("????", Font.PLAIN, 14));
		buttonGroup.add(manJcb);
		manJcb.setSelected(true);
		
		femaleJcb = new JRadioButton("\u5973");
		femaleJcb.setFont(new Font("????", Font.PLAIN, 14));
		buttonGroup.add(femaleJcb);
		
		JLabel lblNewLabel_5 = new JLabel("\u5B66\u751F\u5E74\u9F84\uFF1A");
		lblNewLabel_5.setFont(new Font("????", Font.PLAIN, 14));
		
		stuAgetxt = new JTextField();
		stuAgetxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblNewLabel_6.setFont(new Font("????", Font.PLAIN, 14));
		
		stuPhonetxt = new JTextField();
		stuPhonetxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		lblNewLabel_7.setFont(new Font("????", Font.PLAIN, 14));
		
		stuAddresstxt = new JTextField();
		stuAddresstxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u8BFE\u7A0B1\u6210\u7EE9\uFF1A");
		lblNewLabel_8.setFont(new Font("????", Font.PLAIN, 14));
		
		stuPart1txt = new JTextField();
		stuPart1txt.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u8BFE\u7A0B2\u6210\u7EE9\uFF1A");
		lblNewLabel_9.setFont(new Font("????", Font.PLAIN, 14));
		
		stuPart2txt = new JTextField();
		stuPart2txt.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("\u8BFE\u7A0B3\u6210\u7EE9\uFF1A");
		lblNewLabel_10.setFont(new Font("????", Font.PLAIN, 14));
		
		stuPart3txt = new JTextField();
		stuPart3txt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//????ѧ????Ϣ????   ????????
				studentAddActPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StudentAddFrame.class.getResource("/cn/studentscore/images/add.png")));
		btnNewButton.setFont(new Font("????", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//?????¼?  ????
				studentResetActPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StudentAddFrame.class.getResource("/cn/studentscore/images/reset.png")));
		btnNewButton_1.setFont(new Font("????", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel_7)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(stuAddresstxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_6)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(stuPhonetxt))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(lblNewLabel_2))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(stuClasstxt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(stuNametxt, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_4)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(manJcb)
										.addGap(33)
										.addComponent(femaleJcb)))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(stuAgetxt))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(stuXuetxt, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(stuIdcardtxt)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_9)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(stuPart2txt))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(stuPart1txt, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_10)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(stuPart3txt)))
									.addGap(33))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(46)))
							.addComponent(btnNewButton_1)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(stuNametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(stuXuetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(stuClasstxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(stuIdcardtxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(manJcb)
						.addComponent(femaleJcb)
						.addComponent(lblNewLabel_5)
						.addComponent(stuAgetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(stuPhonetxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(stuAddresstxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(stuPart1txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(stuPart2txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuPart3txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10))
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		//???ó?ʼ??רҵ?༶???????ĺ???
		this.fillClassType();
	}
	//????ѧ????Ϣ????  ?????????庯??
	private void studentAddActPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String stuName=this.stuNametxt.getText();
		String stuXue=this.stuXuetxt.getText();
		String stuIdcard=this.stuIdcardtxt.getText();
		//stuSex=this.stuNametxt.getText();
		String stuAge=this.stuAgetxt.getText();
		String stuAddress=this.stuAddresstxt.getText();
		String stuPhone=this.stuPhonetxt.getText();
		String stuPart1=this.stuPart1txt.getText();
		String stuPart2=this.stuPart2txt.getText();
		String stuPart3=this.stuPart3txt.getText();
		//String stuname=this.stuNametxt.getText();
		//?пղ???
		if (StringToolsUtil.isEmpty(stuName)) {
			JOptionPane.showMessageDialog(null, "ѧ????????Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuXue)) {
			JOptionPane.showMessageDialog(null, "ѧԺ??????Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuIdcard)) {
			JOptionPane.showMessageDialog(null, "ѧ??ѧ????Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuAge)) {
			JOptionPane.showMessageDialog(null, "ѧ????????Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuAddress)) {
			JOptionPane.showMessageDialog(null, "??ͥסַ??Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuPhone)) {
			JOptionPane.showMessageDialog(null, "??ϵ??ʽ??Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuPart1)) {
			JOptionPane.showMessageDialog(null, "?γ?1?ɼ???Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuPart2)) {
			JOptionPane.showMessageDialog(null, "?γ?2?ɼ???Ϣ????Ϊ?գ?");
			return;
		}
		if (StringToolsUtil.isEmpty(stuPart3)) {
			JOptionPane.showMessageDialog(null, "?γ?3?ɼ???Ϣ????Ϊ?գ?");
			return;
		}
		//?ж????????Ա?
		String stuSex=null;
		if (manJcb.isSelected()) {//??ѡ???еĻ?
			stuSex="??";
			
		}else if (femaleJcb.isSelected()) {
			stuSex="Ů";
		}
		//??ȡרҵ?༶
		ClassType classType=(ClassType)stuClasstxt.getSelectedItem();//ǿת
		int stuTypeid= classType.getId();
		//?????û?????  ???????д洢????????
		Student student=new Student(stuName,stuXue,stuIdcard,stuSex,stuAge,stuAddress,
				stuPhone,stuPart1,stuPart2,stuPart3,stuTypeid);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int addstring= studentDao.add(con, student);
			if (addstring==1) {
				JOptionPane.showMessageDialog(null, "ѧ????Ϣ???ӳɹ???");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "ѧ????Ϣ????ʧ?ܣ?");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);//?ر????ݿ?
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//???÷?????װ  ????
	private void studentResetActPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.resetValue();//???÷???????
		
		
	}
	//??дһ?????????õķ????庯??
	public void resetValue() {
		this.stuNametxt.setText("");//?ÿղ???
		this.stuXuetxt.setText("");//?ÿղ???
		this.stuIdcardtxt.setText("");//?ÿղ???
		this.stuAddresstxt.setText("");//?ÿղ???
		this.stuAgetxt.setText("");//?ÿղ???
		this.stuPhonetxt.setText("");//?ÿղ???
		this.stuPart1txt.setText("");//?ÿղ???
		this.stuPart2txt.setText("");//?ÿղ???
		this.stuPart3txt.setText("");//?ÿղ???
		
	}
	

	//??ʼ??רҵ?༶????????
	private void fillClassType() {
		Connection con=null;
		ClassType classType=null;
		try {
			con=dbUtil.getCon();//????????·
			ResultSet rs=classTypeDao.list(con,new ClassType());
			while (rs.next()) {
				classType=new ClassType();
				classType.setId(rs.getInt("id"));
				classType.setGradename(rs.getString("gradename"));
				this.stuClasstxt.addItem(classType);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);//?ر????ݿ?
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
