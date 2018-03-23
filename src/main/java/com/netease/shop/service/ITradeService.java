package com.netease.shop.service;

import java.util.List;

import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;

public interface ITradeService {
	/**
	 * 批量插入交易记录
	 * 
	 * @param trades
	 * @return
	 */
	public int insertTradeArray(List<Trade> trades);

	/**
	 * 查找用户u的交易记录
	 * 
	 * @param u
	 * @return
	 */
	public List<Trade> getTradeListByUser(User u);
}
