package student.bean;

import java.io.Serializable;

public class Certificate implements Serializable{
	private static final long serialVersionUID = 1L;
	private String certName;	//証明書ID
	private String price;		//金額
	private String quantity;	//部数
	
	public Certificate() {	//コンストラクタ
		super();
	}
	
	public Certificate(String certName,String price,String quantity) { //コンストラクタ
		setCert_name(certName);
		setPrice(price);
		setQuantity(quantity);
	}
	
	public String getCertName() {
		return certName;
	}
	public void setCert_name(String certificate_name) {
		certName = certificate_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
