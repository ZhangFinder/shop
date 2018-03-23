package com.netease.shop.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netease.shop.meta.Product;
import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;
import com.netease.shop.service.IProductService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	@Autowired
	IProductService productService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private String test() {
		System.out.println("teseeet");
		return "Example";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap map)
			throws IOException {

		User u = new User(name, password, 1);
		map.addAttribute("user", u);
		return "login";
	}

//	@RequestMapping("/index")
//	public String index(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap map)
//			throws IOException {
//
//		User u = new User(name, password, 1);
//		Product p1 = new Product(1, "内容A", "http://nec.netease.com/img/s/1.jpg", 1, false, true);
//		Product p2 = new Product(2, "内容A", "http://nec.netease.com/img/s/2.jpg", 2, true, false);
//		Product p3 = new Product(3, "内容A", "http://nec.netease.com/img/s/3.jpg", 3, false, true);
//		Product p4 = new Product(4, "内容A", "http://nec.netease.com/img/s/4.jpg", 4, true, false);
//		Product p5 = new Product(5, "内容A", "http://nec.netease.com/img/s/5.jpg", 5, false, true);
//		Product p6 = new Product(6, "内容A", "http://nec.netease.com/img/s/6.jpg", 6, true, false);
//		Product p7 = new Product(7, "内容A", "http://nec.netease.com/img/s/7.jpg", 7, false, true);
//		Product p8 = new Product(8, "内容A", "http://nec.netease.com/img/s/8.jpg", 8, true, false);
//		Product p9 = new Product(9, "内容A", "http://nec.netease.com/img/s/9.jpg", 9, false, true);
//		Product p10 = new Product(10, "内容A", "http://nec.netease.com/img/s/10.jpg", 10, true, false);
//		Product p11 = new Product(11, "内容A", "http://nec.netease.com/img/s/11.jpg", 11, false, true);
//		Product p12 = new Product(12, "内容A", "http://nec.netease.com/img/s/12.jpg", 12, true, false);
//		Product p13 = new Product(13, "内容A", "http://nec.netease.com/img/s/13.jpg", 13, false, true);
//		List<Product> productList = new ArrayList<Product>();
//		productList.add(p1);
//		productList.add(p2);
//		productList.add(p3);
//		productList.add(p4);
//		productList.add(p5);
//
//		productList.add(p6);
//		productList.add(p7);
//		productList.add(p8);
//		productList.add(p9);
//		productList.add(p10);
//		productList.add(p11);
//		productList.add(p12);
//		productList.add(p13);
//
//		map.addAttribute("user", u);
//		map.addAttribute("productList", productList);
//		return "index";
//	}

	@RequestMapping("/publish")
	public String publish(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap map)
			throws IOException {

		User u = new User(name, password, 1);
		map.addAttribute("user", u);
		return "public";
	}

//	@RequestMapping("/account")
//	public String account(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap map)
//			throws IOException {
//
//		User u = new User(name, password, 1);
//		List<Trade> buyList = new ArrayList<Trade>();
//		Product p1 = new Product(1, "内容A", "http://nec.netease.com/img/s/1.jpg", 1, false, true);
//		Trade buy1 = new Trade(p1, "2018-03-19 15:01");
//		Product p2 = new Product(2, "内容A", "http://nec.netease.com/img/s/2.jpg", 2, true, false);
//		Trade buy2 = new Trade(p2, "2018-03-19 15:03");
//		Product p3 = new Product(3, "内容A", "http://nec.netease.com/img/s/3.jpg", 3, false, true);
//		Trade buy3 = new Trade(p3, "2018-03-19 15:06");
//		Product p4 = new Product(4, "内容A", "http://nec.netease.com/img/s/4.jpg", 4, true, false);
//		Trade buy4 = new Trade(p4, "2018-03-19 15:10");
//		Product p5 = new Product(5, "内容A", "http://nec.netease.com/img/s/5.jpg", 5, false, true);
//		Trade buy5 = new Trade(p5, "2018-03-19 15:15");
//		buyList.add(buy1);
//		buyList.add(buy2);
//		buyList.add(buy3);
//		buyList.add(buy4);
//		buyList.add(buy5);
//		map.addAttribute("user", u);
//		map.addAttribute("buyList", buyList);
//		return "account";
//	}

//	@RequestMapping("/show")
//	public String show(@RequestParam("name") String name, @RequestParam("password") String password,
//			@RequestParam("usertype") int usertype, ModelMap map) throws IOException {
//
//		User u = new User(name, password, usertype);
//
//		Product product = new Product(1, "内容A", "http://nec.netease.com/img/s/1.jpg", 1, false, true);
//		product.setSummary("zhang摘要");
//		product.setDetail("详情，详情详情详情");
//
//		map.addAttribute("user", u);
//		map.addAttribute("product", product);
//		return "show";
//	}

	@RequestMapping("/testmybatis")
	public String testmybatis(ModelMap map) throws IOException {

		Product product = new Product("标题", "zhangyao", "http://nec.netease.com/img/s/1.jpg", "内容内容", 1);
		User u = new User("seller", "relles", 1);
	
		boolean result = productService.insertProduct(product);
		System.out.println(product);;
		if (result) {
			map.addAttribute("product", product);
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}

		
		map.addAttribute("user", u);

		return "publicSubmit";
		
	}
	@RequestMapping("/testTx")
	public @ResponseBody String  testTx(@RequestParam("id") int pid,@RequestParam("price") int price) throws IOException {

		
		ObjectMapper mapper = new ObjectMapper(); 
		ObjectNode root1 = mapper.createObjectNode();
		root1.put("state", "100");
		Product product=productService.getProductById(pid);
		product.setPrice(price);
		productService.updateTestTx(product);
		return root1.toString();
		
	}
}

