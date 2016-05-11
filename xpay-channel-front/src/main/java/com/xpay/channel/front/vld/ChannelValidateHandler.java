package com.xpay.channel.front.vld;


import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.VldException;

/**
 * 请求实体接口验证
 * Created by suxinxin on 15/1/15.
 */
public interface ChannelValidateHandler<T extends BaseReqDTO> {

    /**
     * 渠道接口验证参数
     * @param t
     * @throws VldException
     */
    public void validate(T t) throws VldException;
}
