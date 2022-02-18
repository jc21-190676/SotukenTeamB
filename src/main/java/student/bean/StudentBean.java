package student.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;		//名前
	private String no;			//学籍番号
	private String birthday;	//生年月日
	private String grade;		//学年
	private String dept;		//学科名
	private String mail;		//メールアドレス
	private String dormitory;	//寮名
	private String sum;			//合計金額
	
	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}
	ArrayList<Certificate> certList= new ArrayList<Certificate>(); //申込書類、金額などのリスト
	
	public StudentBean() {	//コンストラクタ
		super();
	}
	
	public StudentBean(String name, String no, String birthday,String grade, String dept , String mail, String dormitory,String sum) {
		setName(name);
		setNo(no);
		setBirthday(birthday);
		setGrade(grade);
		setDept(dept);
		setMail(mail);
		setDormitory(dormitory);
		setSum(sum);
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNo() {
		return this.no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	
	public ArrayList<Certificate> getCertList() {
		return certList;
	}
	public void setCertList(ArrayList<Certificate> certList) {
		this.certList = certList;
	}
	
	
}
