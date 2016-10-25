package com.xpay.channel.front.factory;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.facade.AgentCollectChannelFacade;
import com.xpay.common.enums.EnumRtnResult;

import java.util.Map;

/**
 * 通道映射工厂，主要将路由传过来的接口编码映射到具体接口实现，
 * mappingMap为spring注入进去
 * Created by suxinxin on 14/12/26.
 */
public class ACChannelMappingFactory implements MappingFactory<AgentCollectChannelFacade> {

    /**
     * 接口具体实现集合
     * key : 接口编码
     * val : 接口具体实现类
     */
    private Map<String, AgentCollectChannelFacade> mappingMap;

    /**
     * 根据接口编码找到接口具体实现
     *
     * @param interCode
     * @return
     * @throws VldException
     */
    public AgentCollectChannelFacade getChannelBean(String interCode) throws VldException {
        AgentCollectChannelFacade facade = mappingMap.get(interCode);
        if (null == facade) {
            throw new VldException(EnumRtnResult.E000000);
        }
        return facade;
    }

    public Map<String, AgentCollectChannelFacade> getMappingMap() {
        return mappingMap;
    }

    public void setMappingMap(Map<String, AgentCollectChannelFacade> mappingMap) {
        this.mappingMap = mappingMap;
    }
}
