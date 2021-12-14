package cn.studentscore.model;

/*班级管理分类实体
 * 
*/
public class ClassType {
	//和数据库表中字段一致
	private int id;
	private String xueyuan;
	private String gradename;
	private String gradedesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXueyuan() {
		return xueyuan;
	}
	public void setXueyuan(String xueyuan) {
		this.xueyuan = xueyuan;
	}
	public String getGradename() {
		return gradename;
	}
	public void setGradename(String gradename) {
		this.gradename = gradename;
	}
	public String getGradedesc() {
		return gradedesc;
	}
	public void setGradedesc(String gradedesc) {
		this.gradedesc = gradedesc;
	}
	public ClassType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassType(String xueyuan, String gradename, String gradedesc) {
		super();
		this.xueyuan = xueyuan;
		this.gradename = gradename;
		this.gradedesc = gradedesc;
	}
	public ClassType(int id, String xueyuan, String gradename, String gradedesc) {
		super();
		this.id = id;
		this.xueyuan = xueyuan;
		this.gradename = gradename;
		this.gradedesc = gradedesc;
	}
	
	public String toString(){
		
		return gradename;
	}
	
}
