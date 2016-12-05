/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;


import com.xpay.channel.dao.entity.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

/**
 * 路由结果上下文
 * @author qinshou
 * @version $Id: RouterContext.java, v 0.1 16/11/25 下午4:47 sxfans Exp $
 */
public class RouterContext {

    /**
     * 支付工具子类型银行
     */
    private PayToolsBankEntity payToolsBankEntity;

    /**
     * 支付工具子类型对应得渠道映射
     */
    private Map<String,PayToolsMappingEntity> payToolsMappingMap;

    /**
     * 支付工具子类型对应得渠道信息
     */
    private List<ChannelEntity> channelEntityList;

    /**
     * 所属机构
     */
    private List<InstitutionEntity> institutionEntityList;

    /**
     * 机构商户
     * 过滤后的渠道
     */
    private InstMerchantEntity instMerchantEntity;

    /**
     * 接口配置
     */
    private ChannelCfgEntity channelCfgEntity;

    /**
     * 过滤筛选后的渠道实体
     */
    private ChannelEntity channelEntity;
//    /**
//     * 订单生成器
//     */
//    private SequenceService   sequenceService;
//
//    /**
//     * 订单生成器
//     */
//    private SequenceService   refundSequenceService;


    /**
     * Getter method for property payToolsBankEntity.
     *
     * @return property value of payToolsBankEntity
     **/
    public PayToolsBankEntity getPayToolsBankEntity() {
        return payToolsBankEntity;
    }

    /**
     * Setter method for property payToolsBankEntity.
     *
     * @param payToolsBankEntity value to be assigned to property payToolsBankEntity
     **/
    public void setPayToolsBankEntity(PayToolsBankEntity payToolsBankEntity) {
        this.payToolsBankEntity = payToolsBankEntity;
    }

    /**
     * Getter method for property channelCfgEntity.
     *
     * @return property value of channelCfgEntity
     **/
    public ChannelCfgEntity getChannelCfgEntity() {
        return channelCfgEntity;
    }

    /**
     * Setter method for property channelCfgEntity.
     *
     * @param channelCfgEntity value to be assigned to property channelCfgEntity
     **/
    public void setChannelCfgEntity(ChannelCfgEntity channelCfgEntity) {
        this.channelCfgEntity = channelCfgEntity;
    }

    /**
     * Getter method for property institutionEntityList.
     *
     * @return property value of institutionEntityList
     **/
    public List<InstitutionEntity> getInstitutionEntityList() {
        return institutionEntityList;
    }

    /**
     * Setter method for property institutionEntityList.
     *
     * @param institutionEntityList value to be assigned to property institutionEntityList
     **/
    public void setInstitutionEntityList(List<InstitutionEntity> institutionEntityList) {
        this.institutionEntityList = institutionEntityList;
    }

    /**
     * Getter method for property instMerchantEntity.
     *
     * @return property value of instMerchantEntity
     **/
    public InstMerchantEntity getInstMerchantEntity() {
        return instMerchantEntity;
    }

    /**
     * Setter method for property instMerchantEntity.
     *
     * @param instMerchantEntity value to be assigned to property instMerchantEntity
     **/
    public void setInstMerchantEntity(InstMerchantEntity instMerchantEntity) {
        this.instMerchantEntity = instMerchantEntity;
    }

    /**
     * Getter method for property channelEntityList.
     *
     * @return property value of channelEntityList
     **/
    public List<ChannelEntity> getChannelEntityList() {
        return channelEntityList;
    }

    /**
     * Setter method for property channelEntityList.
     *
     * @param channelEntityList value to be assigned to property channelEntityList
     **/
    public void setChannelEntityList(List<ChannelEntity> channelEntityList) {
        this.channelEntityList = channelEntityList;
    }

    /**
     * Getter method for property payToolsMappingMap.
     *
     * @return property value of payToolsMappingMap
     **/
    public Map<String, PayToolsMappingEntity> getPayToolsMappingMap() {
        return payToolsMappingMap;
    }

    /**
     * Setter method for property payToolsMappingMap.
     *
     * @param payToolsMappingMap value to be assigned to property payToolsMappingMap
     **/
    public void setPayToolsMappingMap(Map<String, PayToolsMappingEntity> payToolsMappingMap) {
        this.payToolsMappingMap = payToolsMappingMap;
    }

    /**
     * Getter method for property channelEntity.
     *
     * @return property value of channelEntity
     **/
    public ChannelEntity getChannelEntity() {
        return channelEntity;
    }

    /**
     * Setter method for property channelEntity.
     *
     * @param channelEntity value to be assigned to property channelEntity
     **/
    public void setChannelEntity(ChannelEntity channelEntity) {
        this.channelEntity = channelEntity;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}