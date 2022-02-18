package staff.bean;


/**
 * Servlet implementation class Bmi
 */
public class InventoryListBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String reception_id;
	private String Email;
	private String reception_date;
	
	public String getReception_id() {
		return reception_id;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getReception_date() {
		return reception_date;
	}
	
	public void setReception_id(String reception_id) {
		this.reception_id = reception_id;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public void setReception_date(String reception_date) {
		this.reception_date = reception_date;
	}
}
