package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseReqChannelDTO;
import com.xpay.common.enums.EnumCardType;
import com.xpay.common.enums.EnumCertType;
import com.xpay.common.enums.EnumCurrency;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Remark 扣款請求
 * @Author pangyiyang
 * @Date 16/5/21 下午3:34
 */
public class ACPayReqChannelDTO extends BaseReqChannelDTO {

    /**
     * 支付订单号
     */
    private String       payOrderNo;

    /**
     * 用户id
     */
    private String       userId;

    /**
     * 卡号
     */
    private String       cardNo;

    /**
     * 卡类型
     */
    private EnumCardType cardType;

    /**
     * 证件号
     */
    private String       certNo;

    /**
     * 机构编码
     */
    private String       instCode;

    /**
     * 证件类型
     */
    private EnumCertType certType;

    /**
     * 持卡人姓名
     */
    private String       holderName;

    /**
     * cvv2
     */
    private String       cvv2;

    /**
     * 有效期
     */
    private String       expireDate;

    /**
     * 货币类型
     */
    private EnumCurrency currency;

    /**
     * 交易金额
     */
    private BigDecimal   amount;
    /**
     * 手机号
     */
    private String       mobileNo;
    /**
     * 订单创建时间
     */
    private Date         createDate;

    /**
     * Getter method for property payOrderNo.
     *
     * @return property value of payOrderNo
     **/
    public String getPayOrderNo() {
        return payOrderNo;
    }

    /**
     * Setter method for property payOrderNo.
     *
     * @param payOrderNo value to be assigned to property payOrderNo
     **/
    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public EnumCardType getCardType() {
        return cardType;
    }

    public void setCardType(EnumCardType cardType) {
        this.cardType = cardType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public EnumCertType getCertType() {
        return certType;
    }

    public void setCertType(EnumCertType certType) {
        this.certType = certType;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Getter method for property amount.
     *
     * @return property value of amount
     **/
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method for property amount.
     *
     * @param amount value to be assigned to property amount
     **/
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
     * Getter method for property currency.
     *
     * @return property value of currency
     **/
    public EnumCurrency getCurrency() {
        return currency;
    }

    /**
     * Setter method for property currency.
     *
     * @param currency value to be assigned to property currency
     **/
    public void setCurrency(EnumCurrency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
