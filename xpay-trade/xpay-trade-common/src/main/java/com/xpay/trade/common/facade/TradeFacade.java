package com.xpay.trade.common.facade;

import com.xpay.trade.common.dto.*;

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
    public TradeRepDTO trade(TradeReqDTO payReqDTO);

    /**
     * 查询收单
     *
     * @param queryTradeReqDTO
     * @return
     */
    public QueryTradeRepDTO queryTrade(QueryTradeReqDTO queryTradeReqDTO);

    /**
     * 更新交易状态
     * @return
     */
    public UpOrderStatusRepDTO updateOrderStatus(UpOrderStatusReqDTO upOrderStatusReqDTO);
}
