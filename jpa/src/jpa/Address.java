package jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Address {
	private String houseInfo;
	private String state;
	@Column(nullable = false)
	private String city;
	private long pincode;
	public String getHouseInfo() {
		return houseInfo;
	}
	public void setHouseInfo(String houseInfo) {
		this.houseInfo = houseInfo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [houseInfo=" + houseInfo + ", state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}
	public Address(String houseInfo, String state, String city, long pincode) {
		super();
		this.houseInfo = houseInfo;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
