package com.xpay.trade.biz.impl;

import com.xpay.trade.biz.TradeBiz;
import com.xpay.trade.common.enums.EnumRtnResult;
import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.exception.XpayTradeException;
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
    public TradeRepVO trade(TradeReqVO tradeReqVO) throws XpayTradeException {
        tradeReqVO.setTradeStatus(EnumTradeStatus.WATING);
        TradeRepVO tradeRepVO = tradeService.trade(tradeReqVO);
        if(tradeRepVO == null){
            throw new XpayTradeException(EnumRtnResult.E000003);
        }
        return tradeRepVO;
    }

    @Override
    public QueryTradeRepVO queryTrade(String bizOrderNo) throws XpayTradeException {
        TradeRepVO tradeRepVO = tradeService.getByBizOrderNo(bizOrderNo);
        if (tradeRepVO == null) {
            throw new XpayTradeException(EnumRtnResult.E000001);
        }
        QueryTradeRepVO queryTradeRepVO = new QueryTradeRepVO();
        queryTradeRepVO.setTradeRepVO(tradeRepVO);
        return queryTradeRepVO;
    }

    @Override
    public UpOrderStatusRepVO updateOrderStatus(String bizOrderNo, EnumTradeStatus orderStatus)
                                                                                               throws XpayTradeException {
        boolean flag = tradeService.updateOrderStatus(bizOrderNo, orderStatus);
        UpOrderStatusRepVO upOrderStatusRepVO = new UpOrderStatusRepVO();
        if (!flag) {
            throw new XpayTradeException(EnumRtnResult.E000002);
        }
        upOrderStatusRepVO.setBizOrderNo(bizOrderNo);
        upOrderStatusRepVO.setOrderStatus(orderStatus);
        return upOrderStatusRepVO;
    }
}
