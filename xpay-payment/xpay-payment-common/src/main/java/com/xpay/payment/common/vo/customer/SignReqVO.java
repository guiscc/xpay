/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.common.vo.customer;


import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.payment.common.enums.EnumSignStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @author qinshou
 * @version $Id: SignReqVO.java, v 0.1 16/9/6 下午4:22 sxfans Exp $
 */
public class SignReqVO {

    /**
     * 签约号
     */
    private String signNo;

    /**
     * 签约请求号
     */
    private String signOrderNo;

    /**
     * 解约号
     */
    private String breakSignNo;

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 卡类型
     */
    private EnumCardType cardType;

    /**
     * 持卡人姓名
     */
    private String holderName;

    /**
     * 证件类型
     */
    private EnumCertType cerType;

    /**
     * 证件号
     */
    private String cerNo;

    /**
     * 有效期
     */
    private String expireDate;

    /**
     * cvv2
     */
    private String cvv2;

    /**
     * 手机号
     */
    private String mobileNo;

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
     * 签约时间
     */
    private Date signCreateDT;

    /**
     * 签约完成时间
     */
    private Date signFinishDT;

    /**
     * 解约时间
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
     * Getter method for property cardNo.
     *
     * @return property value of cardNo
     **/
    public String getCardNo() {
        return cardNo;
    }

    /**
     * Setter method for property cardNo.
     *
     * @param cardNo value to be assigned to property cardNo
     **/
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * Getter method for property holderName.
     *
     * @return property value of holderName
     **/
    public String getHolderName() {
        return holderName;
    }

    /**
     * Setter method for property holderName.
     *
     * @param holderName value to be assigned to property holderName
     **/
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * Getter method for property cerNo.
     *
     * @return property value of cerNo
     **/
    public String getCerNo() {
        return cerNo;
    }

    /**
     * Setter method for property cerNo.
     *
     * @param cerNo value to be assigned to property cerNo
     **/
    public void setCerNo(String cerNo) {
        this.cerNo = cerNo;
    }

    /**
     * Getter method for property expireDate.
     *
     * @return property value of expireDate
     **/
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Setter method for property expireDate.
     *
     * @param expireDate value to be assigned to property expireDate
     **/
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Getter method for property mobileNo.
     *
     * @return property value of mobileNo
     **/
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Setter method for property mobileNo.
     *
     * @param mobileNo value to be assigned to property mobileNo
     **/
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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
     * Getter method for property cardType.
     *
     * @return property value of cardType
     **/
    public EnumCardType getCardType() {
        return cardType;
    }

    /**
     * Setter method for property cardType.
     *
     * @param cardType value to be assigned to property cardType
     **/
    public void setCardType(EnumCardType cardType) {
        this.cardType = cardType;
    }

    /**
     * Getter method for property cerType.
     *
     * @return property value of cerType
     **/
    public EnumCertType getCerType() {
        return cerType;
    }

    /**
     * Setter method for property cerType.
     *
     * @param cerType value to be assigned to property cerType
     **/
    public void setCerType(EnumCertType cerType) {
        this.cerType = cerType;
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

    /**
     * Getter method for property cvv2.
     *
     * @return property value of cvv2
     **/
    public String getCvv2() {
        return cvv2;
    }

    /**
     * Setter method for property cvv2.
     *
     * @param cvv2 value to be assigned to property cvv2
     **/
    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    /**
     * Getter method for property signOrderNo.
     *
     * @return property value of signOrderNo
     **/
    public String getSignOrderNo() {
        return signOrderNo;
    }

    /**
     * Setter method for property signOrderNo.
     *
     * @param signOrderNo value to be assigned to property signOrderNo
     **/
    public void setSignOrderNo(String signOrderNo) {
        this.signOrderNo = signOrderNo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}