package com.netease.shop.meta;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String title;
	private String image;
	private int price;
	private String summary;
	private String detail;
	private boolean buy;
   
	private boolean sell;

    public Product(){
    	
    }
	public Product(int id, String title, String image, int price,boolean isBuy,boolean isSell) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price=price;
		this.buy = isBuy;
		this.sell=isSell;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public boolean isSell() {
		return sell;
	}
	public void setSell(boolean sell) {
		this.sell = sell;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
