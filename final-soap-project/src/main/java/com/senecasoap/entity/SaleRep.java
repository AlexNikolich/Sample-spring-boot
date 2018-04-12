package com.senecasoap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SaleRep {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SALE_REP_ID")
	private Long saleRepId;
	
	@OneToMany(mappedBy = "saleRep")
	private List<Sale> sale;
	
	@Column(name="FIRST_NAME", length=30)
	private String firstName;
	
	@Column(name="LAST_NAME", length=30)
	private String lastName;
	
	@Column(name="ADDRESS_1", length=40)
	private String address1;
	
	@Column(name="ADDRESS_2", length=40)
	private String address2;
	
	@Column(name="CITY", length=20)
	private String city;
	
	@Column(name="STATE", length=20)
	private String state;
	
	@Column(name="ZIP", length=10)
	private String zip;
	
	@Column(name="COUNTRY", length=10)
	private String country;
	
	

	public SaleRep() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleRep(Long saleRepId, List<Sale> sale, String firstName, String lastName, String address1, String address2,
			String city, String state, String zip, String country) {
		super();
		this.saleRepId = saleRepId;
		this.sale = sale;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public Long getSaleRepId() {
		return saleRepId;
	}

	public void setSaleRepId(Long saleRepId) {
		this.saleRepId = saleRepId;
	}

	public List<Sale> getSale() {
		return sale;
	}

	public void setSale(List<Sale> sale) {
		this.sale = sale;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
