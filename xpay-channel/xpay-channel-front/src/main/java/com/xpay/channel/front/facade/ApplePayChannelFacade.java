package com.xpay.channel.front.facade;

import com.xpay.channel.common.dto.applepay.*;

/**
 * 苹果支付
 * Created by suxinxin on 16/3/25.
 */
public interface ApplePayChannelFacade {

    /**
     * 支付
     * @param payReqDTO
     * @return
     */
    public PayRepDTO pay(PayReqDTO payReqDTO);

    /**
     * 查询
     * @param queryReqDTO
     * @return
     */
    public QueryRepDTO query(QueryReqDTO queryReqDTO);

    /**
     * 退款
     * @param refundReqDTO
     * @return
     */
    public RefundReqDTO refund(RefundReqDTO refundReqDTO);

    /**
     * 对账
     * @param checkFileReqDTO
     * @return
     */
    public CheckFileRepDTO checkfile(CheckFileReqDTO checkFileReqDTO);
}
