/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: MerchantMappingEntity.java, v 0.1 16/12/5 下午2:12 sxfans Exp $
 */
public class MerchantMappingEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 机构编码
     */
    private String instCode;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * Getter method for property id.
     *
     * @return property value of id
     **/
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     **/
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for property instCode.
     *
     * @return property value of instCode
     **/
    public String getInstCode() {
        return instCode;
    }

    /**
     * Setter method for property instCode.
     *
     * @param instCode value to be assigned to property instCode
     **/
    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    /**
     * Getter method for property merchantNo.
     *
     * @return property value of merchantNo
     **/
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * Setter method for property merchantNo.
     *
     * @param merchantNo value to be assigned to property merchantNo
     **/
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}