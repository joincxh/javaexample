package cn.studentscore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import cn.studentscore.model.Student;
import cn.studentscore.model.User;
import cn.studentscore.util.StringToolsUtil;
import cn.studentscore.view.LoginFrame;
/*记得导入包*/
/*用户访问数据库类*/
public class UserDao {
	/*first--登录验证（yonghuminghemima）*/
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;//创建一个新对象  置空
		String sql="select * from stu_user where username=? and password=?";//创建一个查找数据库的一个接口
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassWord());
		//pstmt.setInt(3, user.getIs_Admin());
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {//接着往下找
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassWord(rs.getString("PassWord"));
			resultUser.setIs_Admin(rs.getInt("Is_Admin"));
			resultUser.setUserTypeid(rs.getString("userTypeid"));
		}
		
		return resultUser;
		
	}
	//查询学生信息 方法（学号）
		public ResultSet infoidlist(Connection con,Student student) throws Exception{
			StringBuffer stu=new StringBuffer("select * from stu_student ");
			if (StringToolsUtil.isNotEmpty(student.getStuIdcard())) {
				stu.append("and stuIdcard like'%"+LoginFrame.valueString+"%'");
				//根据提前存进去的学生编号查询  登录后  用户和编号绑定
			}
			PreparedStatement pstmt=con.prepareStatement(stu.toString().replaceFirst("and", "where"));
			
			return pstmt.executeQuery();
		}
}
