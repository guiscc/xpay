package com.xpay.trade.biz.impl;

import com.xpay.trade.biz.TradeBiz;
import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.vo.*;
import com.xpay.trade.service.TradeService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sxfans on 16/8/13.
 */
public class TradeBizImpl implements TradeBiz {

    @Resource
    private TradeService tradeService;

    @Override
    public TradeRepVO trade(TradeReqVO tradeReqVO) {
        TradeRepVO tradeRepVO = tradeService.trade(tradeReqVO);
        return tradeRepVO;
    }

    @Override
    public QueryTradeRepVO queryTrade(String bizOrderNo) {
        TradeRepVO queryPayRepVO = tradeService.getByBizOrderNo(bizOrderNo);
        QueryTradeRepVO queryTradeRepVO = new QueryTradeRepVO();
        queryTradeRepVO.setTradeRepVO(queryPayRepVO);
        return queryTradeRepVO;
    }

    @Override
    public UpOrderStatusRepVO updateOrderStatus(String bizOrderNo, EnumTradeStatus orderStatus) {
        boolean flag = tradeService.updateOrderStatus(bizOrderNo, orderStatus);
        UpOrderStatusRepVO upOrderStatusRepVO = new UpOrderStatusRepVO();
        if (flag) {
            upOrderStatusRepVO.setBizOrderNo(bizOrderNo);
            upOrderStatusRepVO.setOrderStatus(orderStatus);
        }
        return upOrderStatusRepVO;
    }
}
