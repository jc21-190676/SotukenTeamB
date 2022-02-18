package staff.bean;

public class RequestDetailsBean implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reception_id;
	private String student_no;
	private String reception_date;
	private String name;
	private String birthday;
	private String school_grade;
	private String dept_name;
	private String certificate_name;
	private String quantity;
	private String total_price;
	
	public String getReception_id() {
		return reception_id;
	}
	
	public String getStudent_no() {
		return student_no;
	}
	
	public String getReception_date() {
		return reception_date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getSchool_grade() {
		return school_grade;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	
	public String getCertificate_name() {
		return certificate_name;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public String getTotal_price() {
		return total_price;
	}
	
	public void setReception_id(String reception_id) {
		this.reception_id = reception_id;
	}
	
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	
	public void setReception_date(String reception_date) {
		this.reception_date = reception_date;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public void setSchool_grade(String school_grade) {
		this.school_grade = school_grade;
	}
	
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	
	

}
