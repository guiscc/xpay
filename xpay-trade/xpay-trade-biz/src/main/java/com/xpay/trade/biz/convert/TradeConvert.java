package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.TradeRepDTO;
import com.xpay.trade.common.dto.TradeReqDTO;
import com.xpay.trade.common.vo.TradeRepVO;
import com.xpay.trade.common.vo.TradeReqVO;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeConvert {

    public static TradeReqVO getPayReqVO(TradeReqDTO tradeReqDTO) {
        TradeReqVO tradeReqVO = new TradeReqVO();
        return tradeReqVO;
    }

    public static TradeRepDTO getPayRepDTO(TradeRepVO tradeRepVO) {
        TradeRepDTO tradeRepDTO = new TradeRepDTO();
        return tradeRepDTO;
    }
}