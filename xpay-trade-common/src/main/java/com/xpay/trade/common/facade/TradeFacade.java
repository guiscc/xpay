package com.xpay.trade.common.facade;

import com.xpay.trade.common.dto.PayRepDTO;
import com.xpay.trade.common.dto.PayReqDTO;
import com.xpay.trade.common.dto.QueryPayRepDTO;
import com.xpay.trade.common.dto.QueryPayReqDTO;

/**
 * 交易类型
 * Created by sxfans on 16/8/12.
 */
public interface TradeFacade {

    /**
     * 收单
     *
     * @param payReqDTO
     * @return
     */
    public PayRepDTO pay(PayReqDTO payReqDTO);

    /**
     * 查询收单
     *
     * @param queryPayReqDTO
     * @return
     */
    public QueryPayRepDTO queryPay(QueryPayReqDTO queryPayReqDTO);


    public QueryPayRepDTO updateOrderStatus();
}
