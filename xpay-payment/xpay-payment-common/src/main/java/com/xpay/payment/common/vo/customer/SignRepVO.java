/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.customer;


import com.xpay.payment.common.enums.EnumSignStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SignRepVO.java, v 0.1 16/9/6 下午4:21 sxfans Exp $
 */
public class SignRepVO {
    /**
     * 签约号
     */
    private String signNo;

    /**
     * 解约号
     */
    private String breakSignNo;

    /**
     * 签约状态
     */
    private EnumSignStatus signStatus;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 签约创建时间
     */
    private Date signCreateDT;

    /**
     * 签约完成
     */
    private Date signFinishDT;

    /**
     * 解约日期
     */
    private Date breakSignDT;

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
     * Getter method for property userId.
     *
     * @return property value of userId
     **/
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property userId.
     *
     * @param userId value to be assigned to property userId
     **/
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property remark.
     *
     * @return property value of remark
     **/
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property remark.
     *
     * @param remark value to be assigned to property remark
     **/
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Getter method for property signCreateDT.
     *
     * @return property value of signCreateDT
     **/
    public Date getSignCreateDT() {
        return signCreateDT;
    }

    /**
     * Setter method for property signCreateDT.
     *
     * @param signCreateDT value to be assigned to property signCreateDT
     **/
    public void setSignCreateDT(Date signCreateDT) {
        this.signCreateDT = signCreateDT;
    }

    /**
     * Getter method for property signFinishDT.
     *
     * @return property value of signFinishDT
     **/
    public Date getSignFinishDT() {
        return signFinishDT;
    }

    /**
     * Setter method for property signFinishDT.
     *
     * @param signFinishDT value to be assigned to property signFinishDT
     **/
    public void setSignFinishDT(Date signFinishDT) {
        this.signFinishDT = signFinishDT;
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