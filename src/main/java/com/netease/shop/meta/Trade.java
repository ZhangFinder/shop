package com.netease.shop.meta;

import java.io.Serializable;

public class Trade implements Serializable {
	private Product product;
	private String buyTime;
    public Trade(){
    	
    }
	public Trade(Product product, String buyTime) {
		super();
		this.product = product;
		this.buyTime = buyTime;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

}
