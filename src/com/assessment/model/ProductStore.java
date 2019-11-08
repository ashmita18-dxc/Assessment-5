package com.assessment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductStore {
	
	@Id
	@GeneratedValue
	private long prodid;
	private String prodname;
	private String proddesc;
	private int prodquant;
	private int prodprice;
	
	public ProductStore() {
		
	}
	
	public ProductStore(String prodname, String proddesc, int prodquant, int prodprice) {
		super();
	
		this.prodname = prodname;
		this.proddesc = proddesc;
		this.prodquant = prodquant;
		this.prodprice = prodprice;
	}
	
	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getProddesc() {
		return proddesc;
	}

	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}

	public int getProdquant() {
		return prodquant;
	}

	public void setProdquant(int prodquant) {
		this.prodquant = prodquant;
	}

	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}

}
