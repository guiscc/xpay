package com.xpay.trade.service;

import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.vo.TradeRepVO;
import com.xpay.trade.common.vo.TradeReqVO;

/**
 * 交易事务层
 * Created by sxfans on 16/8/13.
 */
public interface TradeService {

    /**
     * 新增交易
     *
     * @param tradeReqVO
     * @return
     */
    public TradeRepVO trade(TradeReqVO tradeReqVO);

    /**
     * 根据业务订单号查询
     *
     * @param bizOrderNo
     * @return
     */
    public TradeRepVO getByBizOrderNo(String bizOrderNo);

    /**
     * 更新订单信息
     *
     * @param bizOrderNo
     * @param tradeStatus
     * @return
     */
    public boolean updateOrderStatus(String bizOrderNo, EnumTradeStatus tradeStatus);
}
