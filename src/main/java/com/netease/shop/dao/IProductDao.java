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
import com.netease.shop.meta.User;

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
		@Result(property = "price", column = "price"),
		@Result(property = "soldAmmount", column = "sold_ammount")}
	)
	@Select("select a.product_id as product_id ,a.title as title,a.summary as summary,"
			+" a.image_url as image_url ,a.detail as detail, a.price as price,"
			+" b.sold_ammount as sold_ammount from tb_product a  left join (select product_id ,sum(buy_ammount)as sold_ammount from tb_buy_history where buyer_id=#{id} group by product_id)b on a.product_id =b.product_id")
	public List<Product> getProductList(User u);
	
	
	@Results({ 
		@Result(property = "id", column = "product_id"), 
		@Result(property = "title", column = "title"),
		@Result(property = "summary", column = "summary"),
		@Result(property = "imageUrl", column = "image_url"),
		@Result(property = "detail", column = "detail"),
		@Result(property = "price", column = "price"),
		@Result(property = "soldAmmount", column = "sold_ammount")}
	)
	@Select("select a.product_id as product_id ,a.title as title,a.summary as summary,"
			+" a.image_url as image_url ,a.detail as detail, a.price as price,"
			+" b.sold_ammount as sold_ammount from tb_product a  left join (select product_id ,sum(buy_ammount)as sold_ammount from tb_buy_history group by product_id)b on a.product_id =b.product_id")
	public List<Product> getAllProductList();
	
	

}
