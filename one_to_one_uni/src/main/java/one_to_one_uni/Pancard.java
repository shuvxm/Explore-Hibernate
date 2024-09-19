package one_to_one_uni;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pancard {
	@Id
	private int id;
	private String panNo;
	private int pinCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
