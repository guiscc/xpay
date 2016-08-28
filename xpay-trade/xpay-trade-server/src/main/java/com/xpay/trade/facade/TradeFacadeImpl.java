package com.xpay.trade.facade;

import com.xpay.trade.biz.TradeBiz;
import com.xpay.trade.biz.convert.QueryTradeConvert;
import com.xpay.trade.biz.convert.TradeConvert;
import com.xpay.trade.biz.convert.UpOrderStatusConvert;
import com.xpay.trade.common.dto.*;
import com.xpay.trade.common.enums.EnumRtnResult;
import com.xpay.trade.common.enums.EnumTradeStatus;
import com.xpay.trade.common.exception.XpayTradeException;
import com.xpay.trade.common.facade.TradeFacade;
import com.xpay.trade.common.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeFacadeImpl implements TradeFacade {

    private static final Logger logger = LoggerFactory.getLogger(TradeFacadeImpl.class);

    private TradeBiz tradeBiz;

    @Override
    public TradeRepDTO trade(TradeReqDTO tradeReqDTO) {
        TradeRepDTO tradeRepDTO = new TradeRepDTO();
        try {
            TradeReqVO tradeReqVO = TradeConvert.getPayReqVO(tradeReqDTO);
            TradeRepVO tradeRepVO = tradeBiz.trade(tradeReqVO);
            tradeRepDTO = TradeConvert.getPayRepDTO(tradeRepDTO, tradeRepVO);
        } catch (XpayTradeException e) {
            logger.warn("系统异常:",e);
            tradeRepDTO.setRtnResult(e.getRtnResult());
        } catch (Exception e) {
            logger.error("系统错误:",e);
            tradeRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return tradeRepDTO;
    }

    @Override
    public QueryTradeRepDTO queryTrade(QueryTradeReqDTO queryTradeReqDTO) {
        QueryTradeRepDTO queryTradeRepDTO = new QueryTradeRepDTO();
        try {
            QueryTradeReqVO queryTradeReqVO = QueryTradeConvert.getQueryTradeReqVO(queryTradeReqDTO);
            QueryTradeRepVO queryTradeRepVO = tradeBiz.queryTrade(queryTradeReqVO.getBizOrderNo());
            queryTradeRepDTO = QueryTradeConvert.getQueryTradeRepDTO(queryTradeRepDTO, queryTradeRepVO);
        } catch (XpayTradeException e) {
            logger.warn("系统异常:",e);
            queryTradeRepDTO.setRtnResult(e.getRtnResult());
        } catch (Exception e) {
            logger.error("系统错误:",e);
            queryTradeRepDTO.setRtnResult(EnumRtnResult.E000000);
        }
        return queryTradeRepDTO;
    }

    @Override
    public UpOrderStatusRepDTO updateOrderStatus(UpOrderStatusReqDTO upOrderStatusReqDTO) {
        UpOrderStatusRepDTO upOrderStatusRepDTO = new UpOrderStatusRepDTO();
        try {
            UpOrderStatusReqVO upOrderStatusReqVO = UpOrderStatusConvert.getUpOrderStatusReqVO(upOrderStatusReqDTO);
            UpOrderStatusRepVO upOrderStatusRepVO = tradeBiz.updateOrderStatus(upOrderStatusReqVO.getBizOrderNo(), EnumTradeStatus.SUCCESS);
            upOrderStatusRepDTO = UpOrderStatusConvert.getUpOrderStatusRepDTO(upOrderStatusRepDTO,upOrderStatusRepVO);
        } catch (XpayTradeException e) {
            logger.warn("系统异常:",e);
            upOrderStatusRepDTO.setRtnResult(e.getRtnResult());
        } catch (Exception e) {
            logger.error("系统错误:",e);
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
