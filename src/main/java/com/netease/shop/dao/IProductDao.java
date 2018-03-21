package com.netease.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.netease.shop.meta.Product;

public interface IProductDao {
	
	@Insert("INSERT INTO tb_product(title, summary,image_url,detail,price) VALUES(#{title}, #{summary},"
			+ "#{imageUrl},#{detail},#{price})")
	@Options(useGeneratedKeys = true, keyProperty="id", keyColumn="product_id")
	public int insertProduct(Product product);
	
	
	@Results({ 
		@Result(property = "id", column = "product_id"), 
		@Result(property = "title", column = "title"),
		@Result(property = "summary", column = "summary"),
		@Result(property = "imageUrl", column = "image_url"),
		@Result(property = "detail", column = "detail"),
		@Result(property = "price", column = "price")}
	)
	@Select("select * from tb_product where product_id=#{pid}")
	public Product selectProductById(int pid);
	
	@Update("update tb_product set title =#{title},summary=#{summary},image_url=#{imageUrl},"
			+ "detail=#{detail},price=#{price} where product_id=#{id}")	
	public int updateProduct(Product product);
	
	
	@Results({ 
		@Result(property = "id", column = "product_id"), 
		@Result(property = "title", column = "title"),
		@Result(property = "summary", column = "summary"),
		@Result(property = "imageUrl", column = "image_url"),
		@Result(property = "detail", column = "detail"),
		@Result(property = "price", column = "price")}
	)
	@Select("select * from tb_product")
	public List<Product> getProductList();
}
