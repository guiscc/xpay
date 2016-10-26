package com.xpay.channel.front.vld;


import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.common.exception.VldException;

/**
 * 请求实体接口验证
 * Created by suxinxin on 15/1/15.
 */
public interface ChannelValidateHandler<REQ extends BaseReqFrontDTO> {

    /**
     * 渠道接口验证参数
     * @param req
     * @throws VldException
     */
    public void validate(REQ req) throws VldException;
}
