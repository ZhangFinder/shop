package com.netease.shop.meta;

import java.io.Serializable;
/**
 * 交易信息类
 */
public class Trade implements Serializable {
	private int id;
    private Product product;
    private User buyer;
    private int buyAmmount;
    private String buyTime;
    

    public Trade(){
    	
    }
	public Trade(Product product,User buyer, int buyAmmount, String buyTime) {
		super();
		this.setProduct(product);
		this.setBuyer(buyer);
		this.buyAmmount = buyAmmount;
		this.buyTime = buyTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public int getBuyAmmount() {
		return buyAmmount;
	}
	public void setBuyAmmount(int buyAmmount) {
		this.buyAmmount = buyAmmount;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

    

}
