package com.senecasoap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long saleId;

	@Column(name = "SALE_AMOUNT")
	private Double saleAmount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Product product;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private SaleRep saleRep;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Time time;
	
	
	

	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(Long saleId, Double saleAmount, Customer customer, Product product, SaleRep saleRep, Time time) {
		super();
		this.saleId = saleId;
		this.saleAmount = saleAmount;
		this.customer = customer;
		this.product = product;
		this.saleRep = saleRep;
		this.time = time;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SaleRep getSaleRep() {
		return saleRep;
	}

	public void setSaleRep(SaleRep saleRep) {
		this.saleRep = saleRep;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
