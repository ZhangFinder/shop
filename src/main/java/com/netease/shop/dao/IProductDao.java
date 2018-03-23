package com.netease.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.netease.shop.meta.Product;
import com.netease.shop.meta.User;

/**
 * 内容产品Product的数据库操作,对应表tb_product
 */
public interface IProductDao {

	@Insert("INSERT INTO tb_product(title, summary,image_url,detail,price) VALUES(#{title}, #{summary},"
			+ "#{imageUrl},#{detail},#{price})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "product_id")
	public int insertProduct(Product product);

	@Delete("Delete from tb_product where product_id=#{pid}")
	public int deleteroduct(int pid);

	@Results({ @Result(property = "id", column = "product_id"), @Result(property = "title", column = "title"),
			@Result(property = "summary", column = "summary"), @Result(property = "imageUrl", column = "image_url"),
			@Result(property = "detail", column = "detail"), @Result(property = "price", column = "price") })
	@Select("select * from tb_product where product_id=#{pid}")
	public Product selectProductById(@Param("pid") int pid);

	@Update("update tb_product set title =#{product.title},summary=#{product.summary},image_url=#{product.imageUrl},"
			+ "detail=#{product.detail},price=#{product.price} where product_id=#{product.id}")
	public int updateProduct(@Param("product") Product product);

	@Results({ @Result(property = "id", column = "product_id"), @Result(property = "title", column = "title"),
			@Result(property = "summary", column = "summary"), @Result(property = "imageUrl", column = "image_url"),
			@Result(property = "detail", column = "detail"), @Result(property = "price", column = "price"),
			@Result(property = "soldAmmount", column = "sold_ammount") })
	@Select("select a.product_id as product_id ,a.title as title,a.summary as summary,"
			+ " a.image_url as image_url ,a.detail as detail, a.price as price,"
			+ " b.sold_ammount as sold_ammount from tb_product a  left join (select product_id ,sum(buy_ammount)as sold_ammount from tb_buy_history where buyer_id=#{u.id} group by product_id)b on a.product_id =b.product_id")
	public List<Product> getProductList(@Param("u") User u);

	@Select("select IFNULL(sum(buy_ammount) ,0) from tb_buy_history where product_id=#{pid} and buyer_id=#{uid}")
	public int getProductSoldAmmount(@Param("uid") int uid, @Param("pid") int pid);

	@Results({ @Result(property = "id", column = "product_id"), @Result(property = "title", column = "title"),
			@Result(property = "summary", column = "summary"), @Result(property = "imageUrl", column = "image_url"),
			@Result(property = "detail", column = "detail"), @Result(property = "price", column = "price"),
			@Result(property = "soldAmmount", column = "sold_ammount") })
	@Select("select a.product_id as product_id ,a.title as title,a.summary as summary,"
			+ " a.image_url as image_url ,a.detail as detail, a.price as price,"
			+ " b.sold_ammount as sold_ammount from tb_product a  left join (select product_id ,sum(buy_ammount)as sold_ammount from tb_buy_history group by product_id)b on a.product_id =b.product_id")
	public List<Product> getAllProductList();

}
