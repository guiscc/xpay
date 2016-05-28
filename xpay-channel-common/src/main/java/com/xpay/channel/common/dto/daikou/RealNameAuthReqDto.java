package com.xpay.channel.common.dto.daikou;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.enums.EnumCardType;
import com.xpay.channel.common.enums.EnumCertType;

/**
 * @Remark 实名认证dto
 * @Author pangyiyang
 * @Date 16/5/19 下午11:12
 */
public class RealNameAuthReqDto extends BaseReqDTO {
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
     * 手机号
     */
    private String mobileNo ;

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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
