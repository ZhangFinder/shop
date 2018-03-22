package com.netease.shop.service;

import java.util.List;

import com.netease.shop.meta.Trade;
import com.netease.shop.meta.User;

public interface ITradeService {
   public int insertTradeArray(List<Trade> trades);
   public List<Trade> getTradeListByUser(User u);
}
