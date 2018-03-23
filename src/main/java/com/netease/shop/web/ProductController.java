package com.netease.shop.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.netease.shop.meta.Product;
import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;
import com.netease.shop.service.IProductService;
import com.netease.shop.service.ITradeService;
import com.netease.shop.utils.TradeUtils;

/**
 * 产品相关Controller,包括产品的购买，删除，查看以及交易记录
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	IProductService productService;
	@Autowired
	ITradeService tradeService;

	/**
	 * 进入首页，即为product列表视图
	 * 
	 * @param type
	 *            1 未购买内容,2所有内容
	 * @return public.ftl 发布页面视图
	 */

	@RequestMapping("/index")
	public String index(@RequestParam(value = "type", defaultValue = "0") int type, HttpSession session, ModelMap map)
			throws IOException {

		User u = (User) session.getAttribute("user");
		List<Product> productList = productService.getProductList(u);

		map.addAttribute("user", u);
		map.addAttribute("productList", productList);
		map.addAttribute("listType", type);// 1 未购买内容,2所有内容
		return "index";
	}

	/**
	 * 进入product发布页面
	 * 
	 * @return public.ftl 发布页面视图
	 */
	@RequestMapping("/public")
	public String publish(HttpSession session, ModelMap map) throws IOException {
		User u = (User) session.getAttribute("user");
		map.addAttribute("user", u);
		return "public";
	}

	/**
	 * 增加一条product
	 * 
	 * @param pid,title,summary,imageUrl,detail,price
	 * @return publicSubmit.ftl 增加结果视图
	 */
	@RequestMapping("/publicSubmit")
	public String publicSubmit(@RequestParam("title") String title, @RequestParam("summary") String summary,
			@RequestParam("image_url") String imageUrl, @RequestParam("detail") String detail,
			@RequestParam("price") int price, HttpSession session, ModelMap map) throws IOException {
		Product product = new Product(title, summary, imageUrl, detail, price);
		
		boolean result = productService.insertProduct(product);
		if (result) {
			map.addAttribute("product", product);

		} else {

		}

		User u = (User) session.getAttribute("user");
		map.addAttribute("user", u);

		return "publicSubmit";
	}

	/**
	 * 上传图片文件
	 * 
	 * @param file
	 * @return json
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/uploadfiles");
			// 上传文件名
			String fileName = file.getOriginalFilename();
			String fileFormat = fileName.substring(fileName.lastIndexOf("."));
			File filepath = new File(path);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.exists()) {
				filepath.mkdirs();
			}

			String newFileName = new Date().getTime() + fileFormat;
			
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + newFileName));

			String imageUrl = request.getContextPath() + "/uploadfiles/" + newFileName;

			result.put("code", 200);
			result.put("result", imageUrl);
			result.put("message", "上传图片成功");
		} else {
			result.put("code", 300);
			result.put("result", "failure");
			result.put("message", "上传图片失败");
		}
		return result.toString();
	}

	/**
	 * 获取pid对应的product的信息
	 * 
	 * @param pid,product的id
	 * @return show.ftl 显示视图
	 */
	@RequestMapping("/show")
	public String show(@RequestParam("id") int pid, HttpSession session, ModelMap map) throws IOException {
		User u = (User) session.getAttribute("user");
		Product product = productService.getProductById(u, pid);

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
	public String edit(@RequestParam("id") int pid, HttpSession session, ModelMap map) throws IOException {

		Product product = productService.getProductById(null, pid);

		User u = (User) session.getAttribute("user");
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
	public String editSubmit(@RequestParam("id") int pid, @RequestParam("title") String title,
			@RequestParam("summary") String summary, @RequestParam("image_url") String imageUrl,
			@RequestParam("detail") String detail, @RequestParam("price") int price, HttpSession session, ModelMap map)
					throws IOException {

		Product product = new Product(pid, title, summary, imageUrl, detail, price);

		productService.updateProduct(product);

		User u = (User) session.getAttribute("user");
		map.addAttribute("user", u);
		map.addAttribute("product", product);
		return "editSubmit";
	}

	/**
	 * 删除product
	 * 
	 * @param pid
	 * @return json
	 */
	@RequestMapping("/delete")
	public @ResponseBody String deleteProduct(@RequestParam("id") int pid, HttpSession session) {
		User u = (User) session.getAttribute("user");

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		boolean flag = false;
		if (u != null && u.getUsertype() == 1) {
			flag = productService.deleteProductById(pid);

		}
		if (flag) {

			result.put("code", 200);
			result.put("result", true);
			result.put("message", "删除成功");

		} else {
			result.put("code", 300);
			result.put("result", false);
			result.put("message", "删除失败");
		}

		return result.toString();

	}

	/**
	 * 进入购物车视图
	 * 
	 * @param
	 * @return settleaccount。ftl
	 */
	@RequestMapping("/settleaccount")
	public String gotoSettleAccount(HttpSession session, ModelMap map) {
		User u = (User) session.getAttribute("user");
		map.addAttribute("user", u);
		return "settleaccount";
	}

	/**
	 * 购买商品
	 * 
	 * @param reJsonArray
	 * @return json
	 */
	@RequestMapping("/trade")
	public @ResponseBody String buyProduct(@RequestBody String reJsonArray, HttpSession session, ModelMap map) {
		User u = (User) session.getAttribute("user");

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode result = mapper.createObjectNode();
		boolean flag = false;
		try {
			List<Trade> tradeList = TradeUtils.requestToTradeList(reJsonArray, u);
			tradeService.insertTradeArray(tradeList);
			flag = true;
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

		if (flag) {
			result.put("code", 200);
			result.put("result", true);
			result.put("message", "购买成功");

		} else {
			result.put("code", 300);
			result.put("result", false);
			result.put("message", "购买失败");
		}

		map.addAttribute("user", u);
		return result.toString();
	}

	/**
	 * 查看账户，进入账户视图
	 * 
	 * @return account.ftl
	 */
	@RequestMapping("/account")
	public String account(HttpSession session, ModelMap map) {
		User u = (User) session.getAttribute("user");
		List<Trade> buyList = tradeService.getTradeListByUser(u);

		map.addAttribute("user", u);
		map.addAttribute("buyList", buyList);
		return "account";

	}
}
