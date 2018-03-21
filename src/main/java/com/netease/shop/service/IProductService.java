package com.netease.shop.service;

import java.util.List;

import com.netease.shop.meta.Product;

public interface IProductService {
   public boolean insertProduct(Product product);
   public Product getProductById(int pid);
   public boolean updateProduct(Product product);
   public void updateTestTx(Product product);
   public List<Product> getProductList();
}
