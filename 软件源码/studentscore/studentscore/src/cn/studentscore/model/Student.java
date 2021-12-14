package cn.studentscore.model;

//学生模型类
public class Student {

		private int id;//学生编号
		private String stuName;//学生姓名
		private String stuXue;//学院名称
		private String stuIdcard;//学生学号
		private String stuSex;//学生性别
		private String stuAge;//学生年龄
		private String stuAddress;//学生住址
		private String stuPhone;//联系方式
		private String stuPart1;//课程1成绩
		private String stuPart2;//课程2成绩
		private String stuPart3;//课程3成绩
		private Integer stuTypeid;//学生班级编号
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getStuName() {
			return stuName;
		}
		public void setStuName(String stuName) {
			this.stuName = stuName;
		}
		public String getStuXue() {
			return stuXue;
		}
		public void setStuXue(String stuXue) {
			this.stuXue = stuXue;
		}
		public String getStuIdcard() {
			return stuIdcard;
		}
		public void setStuIdcard(String stuIdcard) {
			this.stuIdcard = stuIdcard;
		}
		public String getStuSex() {
			return stuSex;
		}
		public void setStuSex(String stuSex) {
			this.stuSex = stuSex;
		}
		public String getStuAge() {
			return stuAge;
		}
		public void setStuAge(String stuAge) {
			this.stuAge = stuAge;
		}
		public String getStuAddress() {
			return stuAddress;
		}
		public void setStuAddress(String stuAddress) {
			this.stuAddress = stuAddress;
		}
		public String getStuPhone() {
			return stuPhone;
		}
		public void setStuPhone(String stuPhone) {
			this.stuPhone = stuPhone;
		}
		public String getStuPart1() {
			return stuPart1;
		}
		public void setStuPart1(String stuPart1) {
			this.stuPart1 = stuPart1;
		}
		public String getStuPart2() {
			return stuPart2;
		}
		public void setStuPart2(String stuPart2) {
			this.stuPart2 = stuPart2;
		}
		public String getStuPart3() {
			return stuPart3;
		}
		public void setStuPart3(String stuPart3) {
			this.stuPart3 = stuPart3;
		}
		public Integer getStuTypeid() {
			return stuTypeid;
		}
		public void setStuTypeid(Integer stuTypeid) {
			this.stuTypeid = stuTypeid;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Student(String stuName, String stuXue, String stuIdcard, String stuSex, String stuAge, String stuAddress,
				String stuPhone, String stuPart1, String stuPart2, String stuPart3, Integer stuTypeid) {
			super();
			this.stuName = stuName;
			this.stuXue = stuXue;
			this.stuIdcard = stuIdcard;
			this.stuSex = stuSex;
			this.stuAge = stuAge;
			this.stuAddress = stuAddress;
			this.stuPhone = stuPhone;
			this.stuPart1 = stuPart1;
			this.stuPart2 = stuPart2;
			this.stuPart3 = stuPart3;
			this.stuTypeid = stuTypeid;
		}
		public Student(int id, String stuName, String stuXue, String stuIdcard, String stuSex, String stuAge,
				String stuAddress, String stuPhone, String stuPart1, String stuPart2, String stuPart3,
				Integer stuTypeid) {
			super();
			this.id = id;
			this.stuName = stuName;
			this.stuXue = stuXue;
			this.stuIdcard = stuIdcard;
			this.stuSex = stuSex;
			this.stuAge = stuAge;
			this.stuAddress = stuAddress;
			this.stuPhone = stuPhone;
			this.stuPart1 = stuPart1;
			this.stuPart2 = stuPart2;
			this.stuPart3 = stuPart3;
			this.stuTypeid = stuTypeid;
		}
		
		
}
