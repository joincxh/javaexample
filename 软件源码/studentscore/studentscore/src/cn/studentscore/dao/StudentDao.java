package cn.studentscore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.studentscore.model.ClassType;
import cn.studentscore.model.Student;
import cn.studentscore.util.StringToolsUtil;

//学生方法集合类
//一些执行操作的方法体
public class StudentDao {
	//添加功能
	public int add(Connection con,Student student)throws Exception {
		String sql="insert into stu_student values(null,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, student.getStuName());
		pstmt.setString(2, student.getStuXue());
		pstmt.setString(3, student.getStuIdcard());
		pstmt.setString(4, student.getStuSex());
		pstmt.setString(5, student.getStuAge());
		pstmt.setString(6, student.getStuAddress());
		pstmt.setString(7, student.getStuPhone());
		pstmt.setString(8, student.getStuPart1());
		pstmt.setString(9, student.getStuPart2());
		pstmt.setString(10, student.getStuPart3());
		pstmt.setInt(11, student.getStuTypeid());
		
		return pstmt.executeUpdate();
	}
	//查询学生信息 方法（姓名）
	public ResultSet stulist(Connection con,Student student) throws Exception{
		StringBuffer stu=new StringBuffer("select * from stu_student ");
		if (StringToolsUtil.isNotEmpty(student.getStuName())) {
			stu.append("and stuName like'%"+student.getStuName()+"%'");
			
		}
		PreparedStatement pstmt=con.prepareStatement(stu.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}
	//查询学生信息 方法（学号）
	public ResultSet idlist(Connection con,Student student) throws Exception{
		StringBuffer stu=new StringBuffer("select * from stu_student ");
		if (StringToolsUtil.isNotEmpty(student.getStuIdcard())) {
			stu.append("and stuIdcard like'%"+student.getStuIdcard()+"%'");
			
		}
		PreparedStatement pstmt=con.prepareStatement(stu.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}
	//学生信息删除方法
		public int delstu(Connection con,String id)throws Exception {
			String sql="delete from stu_student where id=? ";//删除操作
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		}
		
		//学生信息修改方法的实现
		
		public int updstu(Connection con,Student student) throws Exception{
			String sql="update stu_student set stuName=?,stuXue=?,stuIdcard=?,stuSex=?,stuAge=?,stuAddress=?,stuPhone=?,stuPart1=?,stuPart2=?,stuPart3=?,stuTypeid=? where id=?";//修改
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getStuName());
			pstmt.setString(2, student.getStuXue());
			pstmt.setString(3, student.getStuIdcard());
			pstmt.setString(4, student.getStuSex());
			pstmt.setString(5, student.getStuAge());
			pstmt.setString(6, student.getStuAddress());
			pstmt.setString(7, student.getStuPhone());
			pstmt.setString(8, student.getStuPart1());
			pstmt.setString(9, student.getStuPart2());
			pstmt.setString(10, student.getStuPart3());
			pstmt.setInt(11, student.getStuTypeid());
			pstmt.setInt(12, student.getId());
			
			return pstmt.executeUpdate();
		}
}
