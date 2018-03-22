package com.netease.shop.dao.provider;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netease.shop.meta.Trade;

public class TradeDaoProvider {
	   public String insertAllTrade(Map map) {  
	        List<Trade> trades = (List<Trade>) map.get("trades");  
	        StringBuilder sb = new StringBuilder();  
	        sb.append("INSERT INTO tb_buy_history ");  
	        sb.append("(product_id, buyer_id,buy_ammount,buy_time) ");  
	        sb.append("VALUES ");  
	        MessageFormat mf = new MessageFormat("( #'{'trades[{0}].product.id'}',#'{'trades[{0}].buyer.id'}',#'{'trades[{0}].buyAmmount'}',#'{'trades[{0}].buyTime'}')");  
	        for (int i = 0; i < trades.size(); i++) {  
	            sb.append(mf.format(new Object[]{i}));  
	            if (i < trades.size() - 1) {  
	                sb.append(",");  
	            }  
	        }  
	 
	        return sb.toString();  
	    }  
//	   public static void main(String args[]){
//		   Trade[] trades=new Trade[2];
//		   trades[0]=new Trade(1,1,1,"2012-09-09 22:00:11");
//		   trades[1]=new Trade(2,1,3,"2013-09-09 22:00:11");
//		   Map<String,Trade[]> map=new HashMap<String,Trade[]>();
//		   map.put("trades", trades);
//		   new TradeDaoProvider().insertAllTrade(map);
//		   
//	   }
}
