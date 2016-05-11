package com.xpay.channel.front.mapping;


import com.xpay.channel.common.exception.VldException;

/**
 * 映射工厂
 * Created by suxinxin on 15/1/11.
 */
public interface MappingFactory<T> {

    /**
     * 根据接口ID，查找前置实现
     *
     * @param interCode
     * @return
     */
    public T getChannelBean(String interCode) throws VldException;
}
