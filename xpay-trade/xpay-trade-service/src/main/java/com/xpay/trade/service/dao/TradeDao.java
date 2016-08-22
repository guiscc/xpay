package com.xpay.trade.service.dao;

import com.xpay.trade.service.entity.TradeEntity;
import org.springframework.stereotype.Repository;

/**
 * 收单持久化类
 * Created by sxfans on 16/8/13.
 */
@Repository
public interface TradeDao {

    /**
     * 新增交易收单
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
     *
     * @param tradeEntity
     * @return
     */
    public int updateOrderStatus(TradeEntity tradeEntity);
}
