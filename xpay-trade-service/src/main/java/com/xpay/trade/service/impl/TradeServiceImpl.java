package com.xpay.trade.service.impl;

import com.xpay.trade.service.TradeService;
import com.xpay.trade.service.dao.TradeDao;
import com.xpay.trade.service.entity.TradeEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 交易事务层
 * Created by sxfans on 16/8/13.
 */
@Service
public class TradeServiceImpl implements TradeService {

    /**
     * 交易持久化类
     */
    @Resource
    private TradeDao tradeDao;

    @Override
    public int add(TradeEntity tradeEntity) {
        return tradeDao.add(tradeEntity);
    }

    @Override
    public TradeEntity getByBizOrderNo(String bizOrderNo) {
        return tradeDao.getByBizOrderNo(bizOrderNo);
    }

    @Override
    public int updateOrderStatus(String bizOrderNo, String tradeOrderNo) {
        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setBizOrderNo(bizOrderNo);
        tradeEntity.setTradeOrderNo(tradeOrderNo);
        tradeEntity.setUpdateTime(new Date());
        return tradeDao.updateOrderStatus(tradeEntity);
    }
}
