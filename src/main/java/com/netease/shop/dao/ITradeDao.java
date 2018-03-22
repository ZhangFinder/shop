package com.netease.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import com.netease.shop.dao.provider.TradeDaoProvider;
import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;

public interface ITradeDao {
	 /**
	    * 批量增加
	    * @param user
	    * @return
	    * @throws Exception
	  */
    public int batchInsertTrade(@Param("trades")List<Trade> trades); //复杂数据库操作不用注解，用XML 	
    
    public List<Trade> getTradeByUser(@Param("u")User u);
}
