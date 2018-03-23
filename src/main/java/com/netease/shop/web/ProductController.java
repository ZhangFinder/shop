package com.netease.shop.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netease.shop.meta.Product;
import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;
import com.netease.shop.service.IProductService;
import com.netease.shop.service.ITradeService;
import com.netease.shop.utils.TradeUtils;

@Controller
@RequestMapping("/product") 
public class ProductController {
	@Autowired
	IProductService productService;
	@Autowired
	ITradeService tradeService;
	/**
	 * 进入首页，即为product列表视图
	 * @return public.ftl 发布页面视图
	 */
	
	@RequestMapping("/index")
	public String index(@RequestParam(value="type", defaultValue="0") int type, HttpSession session,ModelMap map)
			throws IOException {

		User u=(User) session.getAttribute("user");
		List<Product> productList=productService.getProductList(u);
		

		map.addAttribute("user", u);
		map.addAttribute("productList", productList);
		map.addAttribute("listType", type);//1 未购买内容,2所有内容
		return "index";
	}
	/**
	 * 发布product页面
	 * @return public.ftl 发布页面视图
	 */
	@RequestMapping("/public")
	public String publish(HttpSession session,ModelMap map)
			throws IOException {        
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		return "public";
	}
	/**
	 * 增加product
	 * 
	 * @param pid,title,summary,imageUrl,detail,price
	 * @return publicSubmit.ftl 增加结果视图
	 */
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
	/**
	 * 获取pid对应的product的信息
	 * 
	 * @param pid,product的id
	 * @return show.ftl 显示视图
	 */
	@RequestMapping("/show")
	public String show(@RequestParam("id") int pid, HttpSession session, ModelMap map)
			throws IOException {
    
		Product product=productService.getProductById(pid);
		
		
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "show";
	}
	/**
	 * 获取pid对应的product的信息
	 * 
	 * @param pid,product的id
	 * @return edit.ftl 编辑视图
	 */
	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int pid, HttpSession session, ModelMap map)
			throws IOException {
    
		Product product=productService.getProductById(pid);
		
		
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "edit";
	}
	/**
	 * 提交product的更新
	 * 
	 * @param pid,title,summary,imageUrl,detail,price
	 * @return editSubmit.ftl 更新结果视图
	 */
	@RequestMapping("/editSubmit")
	public String editSubmit(@RequestParam("id") int pid,@RequestParam("title") String title,
			@RequestParam("summary") String summary,
			@RequestParam("image_url") String imageUrl,@RequestParam("detail") String detail,
			@RequestParam("price") int price ,HttpSession session, ModelMap map)
			throws IOException {
    
		Product product=new Product(pid,title,summary,imageUrl,detail,price);
		
		productService.updateProduct(product);
	
		User u=(User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "editSubmit";
	}
	@RequestMapping("/settleaccount")
    public String gotoSettleAccount(HttpSession session,ModelMap map){
    	User u=(User) session.getAttribute("user");
    	map.addAttribute("user",u);
    	return "settleaccount";
    }
	@RequestMapping("/trade")
    public @ResponseBody String buyProduct(@RequestBody String reJsonArray,HttpSession session,ModelMap map){
		User u=(User) session.getAttribute("user");
	    System.out.println(reJsonArray);
		ObjectMapper mapper = new ObjectMapper(); 
		ObjectNode root1 = mapper.createObjectNode();
	    try {
			List<Trade> tradeList=TradeUtils.requestToTradeList(reJsonArray, u);
			tradeService.insertTradeArray(tradeList);
			root1.put("code", 200); 
			root1.put("result", "购买成功！"); 
		} catch (JsonProcessingException e) {
			root1.put("code", 300); 
			root1.put("message", "购买失败！"); 
			e.printStackTrace();
		} catch (IOException e) {
			root1.put("code", 300); 
			root1.put("message", "购买失败！"); 
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			root1.put("code", 300); 
			root1.put("message", "购买失败！"); 
		}


	
     	map.addAttribute("user",u);
    	return root1.toString();
    }
	@RequestMapping("/account")
    public String account(HttpSession session,ModelMap map){
		User u=(User) session.getAttribute("user");
		List<Trade> buyList = tradeService.getTradeListByUser(u);
	
		map.addAttribute("user", u);
		map.addAttribute("buyList", buyList);
		return "account";
    	
    }
}
