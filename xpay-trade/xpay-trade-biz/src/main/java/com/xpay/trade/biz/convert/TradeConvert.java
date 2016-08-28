package com.xpay.trade.biz.convert;

import com.xpay.trade.common.dto.TradeRepDTO;
import com.xpay.trade.common.dto.TradeReqDTO;
import com.xpay.trade.common.enums.EnumTradeSubType;
import com.xpay.trade.common.enums.EnumTradeType;
import com.xpay.trade.common.vo.TradeRepVO;
import com.xpay.trade.common.vo.TradeReqVO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeConvert {

    public static TradeReqVO getPayReqVO(TradeReqDTO tradeReqDTO) {
        TradeReqVO tradeReqVO = new TradeReqVO();
        tradeReqVO.setBizOrderNo(tradeReqDTO.getBizOrderNo());
        tradeReqVO.setTradeType(EnumTradeType.ACQUIRING);
        tradeReqVO.setTradeSubType(EnumTradeSubType.GENERALACCEPT);
        tradeReqVO.setGoodsName(tradeReqDTO.getGoodsName());
        tradeReqVO.setBizOrderNo(tradeReqDTO.getBizOrderNo());
        tradeReqVO.setPayAmt(tradeReqDTO.getPayAmt());
        tradeReqVO.setBizOrderTime(tradeReqDTO.getBizOrderTime());
        tradeReqVO.setExpireTime(tradeReqDTO.getBizOrderTime());
        tradeReqVO.setBizOrderTime(tradeReqDTO.getBizOrderTime());
        return tradeReqVO;
    }

    public static TradeRepDTO getPayRepDTO(TradeRepDTO tradeRepDTO, TradeRepVO tradeRepVO) {
        tradeRepDTO.setBizOrderNo(tradeRepVO.getBizOrderNo());
        tradeRepDTO.setPayAmt(tradeRepVO.getPayAmt());
        tradeRepDTO.setTradeOrderNo(tradeRepVO.getTradeOrderNo());
        tradeRepDTO.setBizOrderNo(tradeRepVO.getBizOrderNo());
        tradeRepDTO.setTradeStatus(tradeRepVO.getTradeStatus());
        return tradeRepDTO;
    }
}