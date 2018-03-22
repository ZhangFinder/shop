package com.netease.shop.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netease.shop.meta.Product;
import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;

public class TradeUtils {
    public static List<Trade> requestToTradeList(String request,User u) throws JsonProcessingException, IOException{
    	if(u==null)
    		throw new NullPointerException("u为null");
    	List<Trade> tradeList=new LinkedList<Trade>();
    	ObjectMapper mapper = new ObjectMapper(); 
    	JsonNode node=mapper.readTree(request);
    	Iterator<JsonNode> array=node.iterator();
    	Date time=new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String dateTime=sdf.format(time);
    	while(array.hasNext()){
    		JsonNode temp=array.next();
    		int productId=temp.get("productId").asInt();
    		int buyAmmount=temp.get("buyAmmount").asInt();
    		if(buyAmmount<0)
    			throw new RuntimeException("数据非法");
    		Trade t=new Trade(new Product(productId),u,buyAmmount,dateTime);
    		
    		tradeList.add(t);
    		
    		
    	}
    	
    	return tradeList;
    }
    public static void main(String args[]) throws JsonProcessingException, IOException{
    	//String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}"; 
    	String json="[{\"productId\":\"2\",\"buyAmmount\":3},{\"productId\":\"3\",\"buyAmmount\":\"1\"}]";
    	ObjectMapper mapper = new ObjectMapper(); 
    	JsonNode node=mapper.readTree(json);
    	Iterator<JsonNode> array=node.iterator();
    	while(array.hasNext()){
    		JsonNode temp=array.next();
    		
    		
    		System.out.println(temp.get("productId").asInt()+" "+temp.get("buyAmmount").asInt());
    	}
    }
}
