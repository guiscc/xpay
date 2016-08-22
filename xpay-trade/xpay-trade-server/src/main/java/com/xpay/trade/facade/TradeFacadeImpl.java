package com.xpay.trade.facade;

import com.xpay.trade.biz.TradeBiz;
import com.xpay.trade.biz.convert.QueryTradeConvert;
import com.xpay.trade.biz.convert.TradeConvert;
import com.xpay.trade.biz.convert.UpOrderStatusConvert;
import com.xpay.trade.common.dto.*;
import com.xpay.trade.common.enums.EnumRtnResult;
import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.facade.TradeFacade;
import com.xpay.trade.common.vo.*;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeFacadeImpl implements TradeFacade {

    private TradeBiz tradeBiz;

    @Override
    public TradeRepDTO trade(TradeReqDTO tradeReqDTO) {
        TradeRepDTO tradeRepDTO = null;
        try {
            TradeReqVO tradeReqVO = TradeConvert.getPayReqVO(tradeReqDTO);
            TradeRepVO tradeRepVO = tradeBiz.trade(tradeReqVO);
            tradeRepDTO = TradeConvert.getPayRepDTO(tradeRepVO);
        } catch (Exception e) {
            tradeRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return tradeRepDTO;
    }

    @Override
    public QueryTradeRepDTO queryTrade(QueryTradeReqDTO queryTradeReqDTO) {
        QueryTradeRepDTO queryTradeRepDTO = null;
        try {
            QueryTradeReqVO queryTradeReqVO = QueryTradeConvert.getQueryTradeReqVO(queryTradeReqDTO);
            QueryTradeRepVO queryTradeRepVO = tradeBiz.queryTrade(queryTradeReqVO.getBizOrderNo());
            queryTradeRepDTO = QueryTradeConvert.getQueryTradeRepDTO(queryTradeRepVO);
        } catch (Exception e) {
            queryTradeRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return queryTradeRepDTO;
    }

    @Override
    public UpOrderStatusRepDTO updateOrderStatus(UpOrderStatusReqDTO upOrderStatusReqDTO) {
        UpOrderStatusRepDTO upOrderStatusRepDTO = null;
        try {
            UpOrderStatusReqVO upOrderStatusReqVO = UpOrderStatusConvert.getUpOrderStatusReqVO(upOrderStatusReqDTO);
            UpOrderStatusRepVO upOrderStatusRepVO = tradeBiz.updateOrderStatus(upOrderStatusReqVO.getBizOrderNo(), EnumTradeStatus.SUCCESS);
            upOrderStatusRepDTO = UpOrderStatusConvert.getUpOrderStatusRepDTO(upOrderStatusRepVO);
        } catch (Exception e) {
            upOrderStatusRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return upOrderStatusRepDTO;
    }


    public TradeBiz getTradeBiz() {
        return tradeBiz;
    }

    public void setTradeBiz(TradeBiz tradeBiz) {
        this.tradeBiz = tradeBiz;
    }
}
