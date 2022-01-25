package jpa;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
     private int enrollmentNumber;
     private String name;
     @Embedded
     @AttributeOverrides({
 		@AttributeOverride(name="houseInfo",column=@Column(name="Temporary_HouseInfo",nullable=true)),
 		@AttributeOverride(name="state",column=@Column(name="Temporary_state",nullable=true)),
 		@AttributeOverride(name="city",column=@Column(name="Temporary_city",nullable=true)),
 		@AttributeOverride(name="pincode",column=@Column(name="Temporary_pincode",nullable=true))
 	})
     private Address permanentAddress;
     @Embedded
     private Address temporaryAddress;
    
	public int getEnrollmentNumber() {
		return enrollmentNumber;
	}
	public void setEnrollmentNumber(int enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public Address getTemporaryAddress() {
		return temporaryAddress;
	}
	public void setTemporaryAddress(Address temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}
	public Student(int enrollmentNumber, String name, Address permanentAddress, Address temporaryAddress) {
		super();
		this.enrollmentNumber = enrollmentNumber;
		this.name = name;
		this.permanentAddress = permanentAddress;
		this.temporaryAddress = temporaryAddress;
	}
	
	@Override
	public String toString() {
		return "Student [enrollmentNumber=" + enrollmentNumber + ", name=" + name + ", permanentAddress="
				+ permanentAddress + ", temporaryAddress=" + temporaryAddress + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
     
}
