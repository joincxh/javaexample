package cn.studentscore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.studentscore.model.ClassType;
import cn.studentscore.util.StringToolsUtil;

/*
班级分类类别类
主要执行增删改查等一系列操作

*/public class ClassTypeDao {
	//班级添加
	public int add(Connection con,ClassType classtype)throws Exception{
		String sql="insert into stu_grade values(null,?,?,?)";//添加班级语句
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, classtype.getXueyuan());//学院
		pstmt.setString(2, classtype.getGradename());//专业班级
		pstmt.setString(3, classtype.getGradedesc());//备注
		
		return pstmt.executeUpdate();
	}
	//班级查询操作集合
	public ResultSet list(Connection con,ClassType classType)throws Exception{
		StringBuffer somebody=new StringBuffer("select * from stu_grade");
		if (StringToolsUtil.isNotEmpty(classType.getGradename())) {//班级名称判空
			somebody.append(" and gradename like '%"+classType.getGradename()+"%'");
			
		}
		PreparedStatement pstmt=con.prepareStatement(somebody.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}
	
	//班级删除方法
	public int delclass(Connection con,String id)throws Exception {
		String sql="delete from stu_grade where id=? ";//删除操作
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	//班级修改方法的实现
	
	public int updclass(Connection con,ClassType classType) throws Exception{
		String sql="update stu_grade set xueyuan=?,gradename=?,gradedesc=? where id=?";//修改
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, classType.getXueyuan());//学院
		pstmt.setString(2, classType.getGradename());//专业班级
		pstmt.setString(3, classType.getGradedesc());//班级备注
		pstmt.setInt(4, classType.getId());//编号
		
		return pstmt.executeUpdate();
	}
}
