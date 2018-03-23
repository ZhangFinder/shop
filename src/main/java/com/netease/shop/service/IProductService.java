package com.netease.shop.service;

import java.util.List;

import com.netease.shop.meta.Product;
import com.netease.shop.meta.User;

/**
 * 产品相关业务
 */
public interface IProductService {

	/**
	 * 向数据库插入一条产品记录
	 * 
	 * @param product
	 * @return
	 */
	public boolean insertProduct(Product product);

	/**
	 * 获取产品信息，如果u为买家，则返回product中soldAmmount为该买家购买该product的数量
	 * 如果u为卖家或者为null，则product中soldAmmount为0
	 * 
	 * @param u,pid
	 * @return
	 */
	public Product getProductById(User u, int pid);

	/**
	 * 更新产品
	 * 
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product);

	/**
	 * 测试用，测试事务
	 * 
	 * @param product
	 * @return
	 */
	public void updateTestTx(Product product);

	/**
	 * 获取所有产品，如果u为买家，则product的soldAmmount为买家u购买该product的数量
	 * 如果u为卖家或者为null,则product的soldAmmount为该product被卖出的总数量
	 * 此接口方便页面显示商品是否已卖出，已购买，卖出数量和购买数量
	 * 
	 * @param u
	 * @return
	 */
	public List<Product> getProductList(User u);

	/**
	 * 删除产品
	 * 
	 * @param pid
	 * @return
	 */
	public boolean deleteProductById(int pid);
}
