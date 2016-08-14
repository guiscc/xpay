package com.xpay.trade.service;

import com.xpay.trade.service.entity.TradeEntity;

/**
 * 交易事务层
 * Created by sxfans on 16/8/13.
 */
public interface TradeService {

    /**
     * 新增交易
     *
     * @param tradeEntity
     * @return
     */
    public int add(TradeEntity tradeEntity);

    /**
     * 根据业务订单号查询
     *
     * @param bizOrderNo
     * @return
     */
    public TradeEntity getByBizOrderNo(String bizOrderNo);

    /**
     * 更新订单信息
     * @param bizOrderNo
     * @param tradeOrderNo
     * @return
     */
    public int updateOrderStatus(String bizOrderNo,String tradeOrderNo);
}
