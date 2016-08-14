package com.xpay.trade.biz;

import com.xpay.trade.common.vo.PayRepVO;
import com.xpay.trade.common.vo.PayReqVO;

/**
 * 交易处理业务
 * Created by sxfans on 16/8/13.
 */
public interface TradeBiz {

    /**
     * 收单
     * @param payReqVO
     * @return
     */
    public PayRepVO pay(PayReqVO payReqVO);
}
