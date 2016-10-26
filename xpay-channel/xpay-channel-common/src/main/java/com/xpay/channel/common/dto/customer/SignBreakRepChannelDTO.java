/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.common.dto.customer;

import java.util.Date;

import com.xpay.channel.common.dto.BaseRepChannelDTO;
import com.xpay.common.enums.EnumSignStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qinshou
 * @version $Id: SignBreakRepChannelDTO.java, v 0.1 16/9/6 下午4:20 sxfans Exp $
 */
public class SignBreakRepChannelDTO extends BaseRepChannelDTO {

    /**
     * 签约信息
     */
    private String signNo;

    /**
     * 签约号
     */
    private String breakSignNo;

    /**
     * 签约日期
     */
    private Date breakSignDT;

    /**
     * 签约状态
     */
    private EnumSignStatus signStatus;

    /**
     * Getter method for property breakSignNo.
     *
     * @return property value of breakSignNo
     **/
    public String getBreakSignNo() {
        return breakSignNo;
    }

    /**
     * Setter method for property breakSignNo.
     *
     * @param breakSignNo value to be assigned to property breakSignNo
     **/
    public void setBreakSignNo(String breakSignNo) {
        this.breakSignNo = breakSignNo;
    }

    /**
     * Getter method for property signStatus.
     *
     * @return property value of signStatus
     **/
    public EnumSignStatus getSignStatus() {
        return signStatus;
    }

    /**
     * Setter method for property signStatus.
     *
     * @param signStatus value to be assigned to property signStatus
     **/
    public void setSignStatus(EnumSignStatus signStatus) {
        this.signStatus = signStatus;
    }

    /**
     * Getter method for property signNo.
     *
     * @return property value of signNo
     **/
    public String getSignNo() {
        return signNo;
    }

    /**
     * Setter method for property signNo.
     *
     * @param signNo value to be assigned to property signNo
     **/
    public void setSignNo(String signNo) {
        this.signNo = signNo;
    }

    /**
     * Getter method for property breakSignDT.
     *
     * @return property value of breakSignDT
     **/
    public Date getBreakSignDT() {
        return breakSignDT;
    }

    /**
     * Setter method for property breakSignDT.
     *
     * @param breakSignDT value to be assigned to property breakSignDT
     **/
    public void setBreakSignDT(Date breakSignDT) {
        this.breakSignDT = breakSignDT;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}