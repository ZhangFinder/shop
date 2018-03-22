package com.netease.shop.meta;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String title;
	private String summary;
	private String imageUrl;
	private String detail;
	private int price;

	private boolean buy;

	private boolean sell;
	public Product() {

	}
	public Product(int id){
		this.id=id;
	}
	public Product(String title, String summary, String imageUrl, String detail, int price) {
		super();
		this.title = title;
		this.summary = summary;
		this.imageUrl = imageUrl;
		this.detail = detail;
		this.price = price;
	}

	public Product(int id, String title, String summary, String imageUrl, String detail, int price) {
		super();
		this.id=id;
		this.title = title;
		this.summary = summary;
		this.imageUrl = imageUrl;
		this.detail = detail;
		this.price = price;
	}

	public Product(int pid, String title, String summary, String imageUrl, String detail, int price, boolean buy,
			boolean sell) {
		super();
		this.id = pid;
		this.title = title;
		this.summary = summary;
		this.imageUrl = imageUrl;
		this.detail = detail;
		this.price = price;
		this.buy = buy;
		this.sell = sell;
	}
	public Product(int pid,String title,String imageUrl,int price ,boolean buy,boolean sell){
		this.id=pid;
		this.title=title;		
		this.imageUrl=imageUrl;
		this.price=price;
		this.buy=buy;
		this.sell=sell;
	}

	



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", summary=" + summary + ", imageUrl=" + imageUrl
				+ ", detail=" + detail + ", price=" + price + ", buy=" + buy + ", sell=" + sell + "]";
	}
    
}
