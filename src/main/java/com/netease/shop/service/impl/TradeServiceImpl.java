package com.netease.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netease.shop.dao.ITradeDao;
import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;
import com.netease.shop.service.ITradeService;

@Service("tradeService")
public class TradeServiceImpl implements ITradeService {
	@Autowired
    ITradeDao tradeDao;
	@Transactional
	public int insertTradeArray(List<Trade> trades) {
		
		return tradeDao.batchInsertTrade(trades);
	}
	public List<Trade> getTradeListByUser(User u) {
		
		return tradeDao.getTradeByUser(u);
	}

}
