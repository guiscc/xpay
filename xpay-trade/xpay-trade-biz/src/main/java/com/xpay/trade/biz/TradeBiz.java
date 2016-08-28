package com.xpay.trade.biz;

import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.exception.XpayTradeException;
import com.xpay.trade.common.vo.*;

/**
 * 交易处理业务
 * Created by sxfans on 16/8/13.
 */
public interface TradeBiz {

    /**
     * 收单
     *
     * @param tradeReqVO
     * @return
     */
    public TradeRepVO trade(TradeReqVO tradeReqVO) throws XpayTradeException;

    /**
     * 查询
     *
     * @param bizOrderNo
     * @return
     */
    public QueryTradeRepVO queryTrade(String bizOrderNo) throws XpayTradeException;


    /**
     * 更新订单状态
     *
     * @return
     */
    public UpOrderStatusRepVO updateOrderStatus(String bizOrderNo, EnumTradeStatus orderStatus) throws XpayTradeException;
}
