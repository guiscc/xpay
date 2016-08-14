package com.xpay.trade.facade;

import com.xpay.trade.biz.TradeBiz;
import com.xpay.trade.biz.convert.PayConvert;
import com.xpay.trade.common.dto.PayRepDTO;
import com.xpay.trade.common.dto.PayReqDTO;
import com.xpay.trade.common.dto.QueryPayRepDTO;
import com.xpay.trade.common.dto.QueryPayReqDTO;
import com.xpay.trade.common.facade.TradeFacade;
import com.xpay.trade.common.vo.PayRepVO;
import com.xpay.trade.common.vo.PayReqVO;

import javax.annotation.Resource;

/**
 * Created by sxfans on 16/8/12.
 */
public class TradeFacadeImpl implements TradeFacade {

    @Resource
    private TradeBiz tradeBiz;

    @Override
    public PayRepDTO pay(PayReqDTO payReqDTO) {
        PayReqVO payReqVO = PayConvert.getPayReqVO(payReqDTO);
        PayRepVO payRepVO = tradeBiz.pay(payReqVO);
        PayRepDTO payRepDTO = PayConvert.getPayRepDTO(payRepVO);
        return payRepDTO;
    }

    @Override
    public QueryPayRepDTO queryPay(QueryPayReqDTO queryPayReqDTO) {

        return null;
    }

    @Override
    public QueryPayRepDTO updateOrderStatus() {
        return null;
    }
}
