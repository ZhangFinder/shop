package com.netease.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netease.shop.dao.IProductDao;
import com.netease.shop.meta.Product;
import com.netease.shop.service.IProductService;

@Service("productService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductDao productDao;
	public boolean insertProduct(Product product){
		int result=productDao.insertProduct(product);
		return result==1?true:false;
	}
	public Product getProductById(int pid) {
		
		return productDao.selectProductById(pid);
	}
	public boolean updateProduct(Product product) {
		int result=productDao.updateProduct(product);
		return result>=1?true:false;
	
	}
	//测试事务
	@Transactional(noRollbackFor=RuntimeException.class) 
	//不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	public void updateTestTx(Product product){
		productDao.updateProduct(product);
		throw new  RuntimeException("test");//事务测试测试成功
	}
}
