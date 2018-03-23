package com.netease.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netease.shop.dao.IProductDao;
import com.netease.shop.meta.Product;
import com.netease.shop.meta.User;
import com.netease.shop.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDao productDao;

	public boolean insertProduct(Product product) {
		int result = productDao.insertProduct(product);
		return result == 1 ? true : false;
	}

	/**
	 * 获取产品信息，如果u为买家，则返回product中soldAmmount为该买家购买该product的数量
	 * 如果u为卖家或者为null，则product中soldAmmount为0
	 * 
	 * @param u,pid
	 * @return
	 */
	public Product getProductById(User u, int pid) {
		Product p = productDao.selectProductById(pid);
		if (p != null && u != null && u.getUsertype() == 0) {
			p.setSoldAmmount(productDao.getProductSoldAmmount(u.getId(), pid));
		}
		return p;
	}

	public boolean updateProduct(Product product) {
		int result = productDao.updateProduct(product);
		return result >= 1 ? true : false;

	}

	// 测试事务
	@Transactional(noRollbackFor = RuntimeException.class)
	// 不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	public void updateTestTx(Product product) {
		productDao.updateProduct(product);
		throw new RuntimeException("test");// 事务测试测试成功
	}

	/**
	 * 获取所有产品，如果u为买家，则product的soldAmmount为买家u购买该product的数量
	 * 如果u为卖家或者为null,则product的soldAmmount为该product被卖出的总数量
	 * 此接口方便页面显示商品是否已卖出，已购买，卖出数量和购买数量
	 * 
	 * @param u
	 * @return
	 */
	public List<Product> getProductList(User u) {
		if (u == null || u.getUsertype() == 1) {
			return productDao.getAllProductList();
		} else {
			return productDao.getProductList(u);
		}

	}

	public boolean deleteProductById(int pid) {
		int result = productDao.deleteroduct(pid);
		return result == 1 ? true : false;
	}
}
