package cn.studentscore.model;
/*用户实体类*/
public class User {
	private int id;//用户编号
	private String userName;//用户名
	private String PassWord;//密码
	private int Is_Admin;//权限判定、是否管理员
	private String userTypeid;//学号  外键
	
	
	
	public String getUserTypeid() {
		return userTypeid;
	}
	public void setUserTypeid(String userTypeid) {
		this.userTypeid = userTypeid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public int getIs_Admin() {
		return Is_Admin;
	}
	public void setIs_Admin(int is_Admin) {
		Is_Admin = is_Admin;
	}
	public User() {
		super();

		// TODO Auto-generated constructor stub
	}
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		PassWord = passWord;
	}
	public User(String userName, String passWord, int is_Admin) {
		super();
		this.userName = userName;
		PassWord = passWord;
		Is_Admin = is_Admin;
	}
	public int toadminInt(){
		
		return Is_Admin;
	}
	public String toid() {
		return userTypeid;
	}
	
	/*
	 * // public String toname() { // return userName; // }
	 */	
}
