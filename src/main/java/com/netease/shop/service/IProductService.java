package com.netease.shop.service;

import com.netease.shop.meta.Product;

public interface IProductService {
   public boolean insertProduct(Product product);
   public Product getProductById(int pid);
   public boolean updateProduct(Product product);
   public void updateTestTx(Product product);
}
