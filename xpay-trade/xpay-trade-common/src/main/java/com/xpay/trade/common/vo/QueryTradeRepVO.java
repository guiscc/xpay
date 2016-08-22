package com.xpay.trade.common.vo;

/**
 * Created by sxfans on 16/8/12.
 */
public class QueryTradeRepVO extends BaseRepVO {

    /**
     * 交易请求信息
     */
    private TradeRepVO tradeRepVO;

    public TradeRepVO getTradeRepVO() {
        return tradeRepVO;
    }

    public void setTradeRepVO(TradeRepVO tradeRepVO) {
        this.tradeRepVO = tradeRepVO;
    }
}
