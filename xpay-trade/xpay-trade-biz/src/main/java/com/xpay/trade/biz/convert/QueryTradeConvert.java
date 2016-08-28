package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.QueryTradeRepDTO;
import com.xpay.trade.common.dto.QueryTradeReqDTO;
import com.xpay.trade.common.dto.TradeRepDTO;
import com.xpay.trade.common.enums.EnumRtnResult;
import com.xpay.trade.common.exception.XpayTradeException;
import com.xpay.trade.common.vo.QueryTradeRepVO;
import com.xpay.trade.common.vo.QueryTradeReqVO;
import com.xpay.trade.common.vo.TradeRepVO;

/**
 * Created by sxfans on 16/8/12.
 */
public class QueryTradeConvert {

    public static QueryTradeRepDTO getQueryTradeRepDTO(QueryTradeRepDTO queryTradeRepDTO,
                                                       QueryTradeRepVO queryTradeRepVO)
                                                                                       throws XpayTradeException {
        TradeRepVO tradeRepVO = queryTradeRepVO.getTradeRepVO();
        queryTradeRepDTO.setId(tradeRepVO.getId());
        queryTradeRepDTO.setBizOrderNo(tradeRepVO.getBizOrderNo());

        queryTradeRepDTO.setTradeOrderNo(tradeRepVO.getTradeOrderNo());
        queryTradeRepDTO.setTradeType(tradeRepVO.getTradeTpye());
        queryTradeRepDTO.setTradeSubType(tradeRepVO.getTradeSubType());

        queryTradeRepDTO.setPayNo(tradeRepVO.getPayNo());
        queryTradeRepDTO.setPayTime(tradeRepVO.getPayTime());
        queryTradeRepDTO.setPayAmount(tradeRepVO.getPayAmt());

        queryTradeRepDTO.setCreateTime(tradeRepVO.getCreateTime());
        queryTradeRepDTO.setUpdateTime(tradeRepVO.getUpdateTime());
        queryTradeRepDTO.setExpireTime(tradeRepVO.getExpireTime());
        queryTradeRepDTO.setOrderTime(tradeRepVO.getBizOrderTime());
        queryTradeRepDTO.setTradeStatus(tradeRepVO.getTradeStatus());
        return queryTradeRepDTO;
    }

    public static QueryTradeReqVO getQueryTradeReqVO(QueryTradeReqDTO queryTradeReqDTO) {
        QueryTradeReqVO queryTradeReqVO = new QueryTradeReqVO();
        queryTradeReqVO.setBizOrderNo(queryTradeReqDTO.getBizOrderNo());
        return queryTradeReqVO;
    }
}
