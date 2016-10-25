package com.xpay.channel.front.factory;

import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.facade.QuickPayChannelFacade;
import com.xpay.common.enums.EnumRtnResult;

import java.util.Map;

/**
 * 通道映射工厂，主要将路由传过来的接口编码映射到具体接口实现，
 * mappingMap为spring注入进去
 * Created by suxinxin on 14/12/26.
 */
public class QuickChannelMappingFactory implements MappingFactory<QuickPayChannelFacade> {

    /**
     * 接口具体实现集合
     * key : 接口编码
     * val : 接口具体实现类
     */
    private Map<String, QuickPayChannelFacade> mappingMap;

    /**
     * 根据接口编码找到接口具体实现
     *
     * @param interCode
     * @return
     * @throws VldException
     */
    public QuickPayChannelFacade getChannelBean(String interCode) throws VldException {
        QuickPayChannelFacade quickPayChannelFacade = mappingMap.get(interCode);
        if (null == quickPayChannelFacade) {
            throw new VldException(EnumRtnResult.E000000);
        }
        return quickPayChannelFacade;
    }

    public Map<String, QuickPayChannelFacade> getMappingMap() {
        return mappingMap;
    }

    public void setMappingMap(Map<String, QuickPayChannelFacade> mappingMap) {
        this.mappingMap = mappingMap;
    }
}
