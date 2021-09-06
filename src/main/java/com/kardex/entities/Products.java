package com.kardex.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(schema = "kardex", name = "products")
public class Products {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "PRODUCTID_GENERATOR", sequenceName = "kardex.sec_product", initialValue = 1, allocationSize = 1 )
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PRODUCTID_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
	private Long productId;

    @Column(name = "product_name")
	private String productName;

    @Column(name = "product_description")
	private String productDescription;

    @Column(name = "productStock")
	private Long productStock;
   

    @Column(name = "product_price")
	private Long productPrice;
    
	public Products() {
		super();
	}


	public Products(Long productId, String productName, String productDescription, Long productStock,
			Long productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStock = productStock;
		this.productPrice = productPrice;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProducName() {
		return productName;
	}


	public void setProducName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Long getProductStock() {
		return productStock;
	}


	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}


	public Long getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
    
    
    
    }
