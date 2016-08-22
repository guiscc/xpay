package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.QueryTradeRepDTO;
import com.xpay.trade.common.dto.QueryTradeReqDTO;
import com.xpay.trade.common.dto.TradeRepDTO;
import com.xpay.trade.common.vo.QueryTradeRepVO;
import com.xpay.trade.common.vo.QueryTradeReqVO;
import com.xpay.trade.common.vo.TradeRepVO;

/**
 * Created by sxfans on 16/8/12.
 */
public class QueryTradeConvert {

    public static QueryTradeRepDTO getQueryTradeRepDTO(QueryTradeRepVO queryTradeRepVO) {
        QueryTradeRepDTO queryTradeRepDTO = new QueryTradeRepDTO();
        TradeRepVO tradeRepVO = queryTradeRepVO.getTradeRepVO();
        if (tradeRepVO != null) {
            TradeRepDTO tradeRepDTO = TradeConvert.getPayRepDTO(tradeRepVO);
            queryTradeRepDTO.setTradeRepVO(tradeRepDTO);
        }
        return queryTradeRepDTO;
    }

    public static QueryTradeReqVO getQueryTradeReqVO(QueryTradeReqDTO queryTradeReqDTO) {
        QueryTradeReqVO queryTradeReqVO = new QueryTradeReqVO();
        queryTradeReqVO.setBizOrderNo(queryTradeReqDTO.getBizOrderNo());
        return queryTradeReqVO;
    }
}
