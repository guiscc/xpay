package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.enums.EnumCardType;
import com.xpay.channel.common.enums.EnumCertType;

import java.util.Date;

/**
 * @Remark 扣款請求
 * @Author pangyiyang
 * @Date 16/5/21 下午3:34
 */
public class PayReqDto extends BaseReqDTO {

    /**
     * 卡号
     */
    private String cardNo ;
    /**
     * 卡类型
     */
    private EnumCardType cardType ;
    /**
     * 证件号
     */
    private String certNo ;
    /**
     * 证件类型
     */
    private EnumCertType certType ;
    /**
     * 持卡人姓名
     */
    private String holderName ;
    /**
     * cvv2
     */
    private String cvv2 ;
    /**
     * 有效期
     */
    private String expireDate ;
    /**
     * 渠道单号
     */
    private String channelOrderNo ;
    /**
     * 交易金额
     */
    private Long amount ;
    /**
     * 手机号
     */
    private String mobileNo ;
    /**
     * 订单创建时间
     */
    private Date createDate ;

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

    public String getChannelOrderNo() {
        return channelOrderNo;
    }

    public void setChannelOrderNo(String channelOrderNo) {
        this.channelOrderNo = channelOrderNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
}
