package cn.studentscore.util;
/*数据库连接类*/

import java.sql.DriverManager;
import java.sql.Connection;

public class MysqlUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/studentscoremanage?useUnicode=true&characterEncoding=utf-8";//数据库连接地址
	private String dbUserName="root";//数据库连接用户名
	private String dbPassWord="root";//数据库用户密码
	private String jdbcName="com.mysql.cj.jdbc.Driver";//jdbc驱动程序jar包
	
	//数据库连接
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
		return con;//返回这个链接  连接成功
	}
	//数据库关闭
	public void closeCon(Connection con) throws Exception{
		if (con!=null) {//判断数据库是否为空
			con.close();
			
		}
	} 
	//数据库连接测试
	public static void main(String[] args ) {
		//创建一个对象
		MysqlUtil dbUtil=new MysqlUtil();
		try {//需要一个处理异常
			dbUtil.getCon();
			System.out.println("恭喜，数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
