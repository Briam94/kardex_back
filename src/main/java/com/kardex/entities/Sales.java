package com.kardex.entities;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(schema = "kardex", name = "sales")
public class Sales {


	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "PRODUCTID_GENERATOR", sequenceName = "kardex.sec_product", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PRODUCTID_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "sales_id")
	private Long salesId;

	@OneToOne
	@JoinColumn(name = "sales_product_id", referencedColumnName = "product_id")
	private Products salesProduct;

    @Column(name = "sales_product_amount")
	private Long salesProductAmount;

    @Column(name = "sales_price")
	private String salesPrice;

    @OneToOne
	@JoinColumn(name = "sales_user_id", referencedColumnName = "user_id")
	private Users salesUser;

	@Column(name = "sales_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date salesDate;

	public Sales() {
		super();
	}

	public Sales(Long salesId, Products salesProduct, Long salesProductAmount, String salesPrice, Users salesUser,
			Date salesDate) {
		super();
		this.salesId = salesId;
		this.salesProduct = salesProduct;
		this.salesProductAmount = salesProductAmount;
		this.salesPrice = salesPrice;
		this.salesUser = salesUser;
		this.salesDate = salesDate;
	}

	public Long getSalesId() {
		return salesId;
	}

	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}

	public Products getSalesProduct() {
		return salesProduct;
	}

	public void setSalesProduct(Products salesProduct) {
		this.salesProduct = salesProduct;
	}

	public Long getSalesProductAmount() {
		return salesProductAmount;
	}

	public void setSalesProductAmount(Long salesProductAmount) {
		this.salesProductAmount = salesProductAmount;
	}

	public String getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Users getSalesUser() {
		return salesUser;
	}

	public void setSalesUser(Users salesUser) {
		this.salesUser = salesUser;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	
}
