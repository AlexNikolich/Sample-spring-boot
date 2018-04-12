package com.senecasoap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@OneToMany(mappedBy = "product")
	private List<Sale> sale;
	
	@Column(name="PRODUCT_NAME", length=40)
	private String productName;
	
	@Column(name="PRODUCT_DESCRIPTION", length=40)
	private String productDescription;
	
	@Column(name="UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name="UNIT_COST")
	private Double unitCost;
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, List<Sale> sale, String productName, String productDescription, Double unitPrice,
			Double unitCost) {
		super();
		this.productId = productId;
		this.sale = sale;
		this.productName = productName;
		this.productDescription = productDescription;
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<Sale> getSale() {
		return sale;
	}

	public void setSale(List<Sale> sale) {
		this.sale = sale;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	
	
}
