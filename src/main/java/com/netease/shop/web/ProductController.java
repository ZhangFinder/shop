package com.netease.shop.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.shop.meta.Product;
import com.netease.shop.meta.User;
import com.netease.shop.service.IProductService;

@Controller
@RequestMapping("/product") 
public class ProductController {
	@Autowired
	IProductService productService;
	@RequestMapping("/index")
	public String index(HttpSession session,ModelMap map)
			throws IOException {

        
	
		Product p1=new Product(1,"内容A","http://nec.netease.com/img/s/1.jpg",1,false,true);
		Product p2=new Product(2,"内容A","http://nec.netease.com/img/s/2.jpg",2,true,false);
		Product p3=new Product(3,"内容A","http://nec.netease.com/img/s/3.jpg",3,false,true);
		Product p4=new Product(4,"内容A","http://nec.netease.com/img/s/4.jpg",4,true,false);
		Product p5=new Product(5,"内容A","http://nec.netease.com/img/s/5.jpg",5,false,true);
		Product p6=new Product(6,"内容A","http://nec.netease.com/img/s/6.jpg",6,true,false);
		Product p7=new Product(7,"内容A","http://nec.netease.com/img/s/7.jpg",7,false,true);
		Product p8=new Product(8,"内容A","http://nec.netease.com/img/s/8.jpg",8,true,false);
		Product p9=new Product(9,"内容A","http://nec.netease.com/img/s/9.jpg",9,false,true);
		Product p10=new Product(10,"内容A","http://nec.netease.com/img/s/10.jpg",10,true,false);
		Product p11=new Product(11,"内容A","http://nec.netease.com/img/s/11.jpg",11,false,true);
		Product p12=new Product(12,"内容A","http://nec.netease.com/img/s/12.jpg",12,true,false);
		Product p13=new Product(13,"内容A","http://nec.netease.com/img/s/13.jpg",13,false,true);
		List<Product> productList=new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
		productList.add(p5);
		
		productList.add(p6);
		productList.add(p7);
		productList.add(p8);
		productList.add(p9);
		productList.add(p10);
		productList.add(p11);
		productList.add(p12);
		productList.add(p13);
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("productList", productList);
		map.addAttribute("listType", 1);//1 未购买内容,2所有内容
		return "index";
	}
	@RequestMapping("/public")
	public String publish(HttpSession session,ModelMap map)
			throws IOException {        
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		return "public";
	}
	@RequestMapping("/publicSubmit")
	public String publicSubmit(@RequestParam("title") String title,@RequestParam("summary") String summary,
			@RequestParam("image_url") String imageUrl,@RequestParam("detail") String detail,
			@RequestParam("price") int price,HttpSession session,ModelMap map)
			throws IOException {
        Product product =new Product(title,summary,imageUrl,detail ,price);
        System.out.println(product);
        boolean result=productService.insertProduct(product);
        if (result){
        	map.addAttribute("product", product);
        	System.out.println("插入成功");
        }else{
        	System.out.println("插入失败");
        }
        	       
        	
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
	
		return "publicSubmit";
	}
	@RequestMapping("/show")
	public String show(@RequestParam("id") int pid, HttpSession session, ModelMap map)
			throws IOException {
    
		Product product=productService.getProductById(pid);
		System.out.println(product);
		
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "show";
	}
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int pid, HttpSession session, ModelMap map)
			throws IOException {
    
		Product product=productService.getProductById(pid);
		
		
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "edit";
	}
	@RequestMapping("/editSubmit")
	public String editSubmit(@RequestParam("id") int pid,@RequestParam("title") String title,
			@RequestParam("summary") String summary,
			@RequestParam("image_url") String imageUrl,@RequestParam("detail") String detail,
			@RequestParam("price") int price ,HttpSession session, ModelMap map)
			throws IOException {
    
		Product product=new Product(pid,title,summary,imageUrl,detail,price);
		
		productService.updateProduct(product);
		System.out.println(product);
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "editSubmit";
	}
}
