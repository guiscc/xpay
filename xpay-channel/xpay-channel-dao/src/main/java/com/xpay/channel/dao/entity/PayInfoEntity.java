/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qinshou
 * @version $Id: PayInfoEntity.java, v 0.1 16/11/30 上午11:45 sxfans Exp $
 */
public class PayInfoEntity {

    /**
     * 主键
     */
    private long id;

    /**
     * 支付单号
     */
    private String payOrderNo;

    /**
     * 银行订单号
     */
    private String bankOrderNo;

    /**
     * 支付金额
     */
    private BigDecimal payAmt;

    /**
     * 货币金额
     */
    private int currency;

    /**
     * 签约号
     */
    private String signCode;

    /**
     * 支付工具子类型
     */
    private String paySubToolCode;

    /**
     * 通道编码
     */
    private String channelCode;

    /**
     * 银行流水
     */
    private String bankNo;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 支付状态
     */
    private int payStatus;

    /**
     * 创建时间
     */
    private Date createDT;

    /**
     * 完成时间
     */
    private Date finishDT;

    /**
     * 银行完成时间
     */
    private Date bankFinishDT;

    /**
     * 银行返回码
     */
    private String rtnCode;

    /**
     * 银行返回信息
     */
    private String rtnMsg;

    /**
     * 扩展字段
     */
    private String mapstr;



    /**
     * Getter method for property id.
     *
     * @return property value of id
     **/
    public long getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     **/
    public void setId(long id) {
        this.id = id;
    }

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

    /**
     * Getter method for property bankOrderNo.
     *
     * @return property value of bankOrderNo
     **/
    public String getBankOrderNo() {
        return bankOrderNo;
    }

    /**
     * Setter method for property bankOrderNo.
     *
     * @param bankOrderNo value to be assigned to property bankOrderNo
     **/
    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo;
    }

    /**
     * Getter method for property payAmt.
     *
     * @return property value of payAmt
     **/
    public BigDecimal getPayAmt() {
        return payAmt;
    }

    /**
     * Setter method for property payAmt.
     *
     * @param payAmt value to be assigned to property payAmt
     **/
    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    /**
     * Getter method for property currency.
     *
     * @return property value of currency
     **/
    public int getCurrency() {
        return currency;
    }

    /**
     * Setter method for property currency.
     *
     * @param currency value to be assigned to property currency
     **/
    public void setCurrency(int currency) {
        this.currency = currency;
    }

    /**
     * Getter method for property signCode.
     *
     * @return property value of signCode
     **/
    public String getSignCode() {
        return signCode;
    }

    /**
     * Setter method for property signCode.
     *
     * @param signCode value to be assigned to property signCode
     **/
    public void setSignCode(String signCode) {
        this.signCode = signCode;
    }

    /**
     * Getter method for property paySubToolCode.
     *
     * @return property value of paySubToolCode
     **/
    public String getPaySubToolCode() {
        return paySubToolCode;
    }

    /**
     * Setter method for property paySubToolCode.
     *
     * @param paySubToolCode value to be assigned to property paySubToolCode
     **/
    public void setPaySubToolCode(String paySubToolCode) {
        this.paySubToolCode = paySubToolCode;
    }

    /**
     * Getter method for property channelCode.
     *
     * @return property value of channelCode
     **/
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * Setter method for property channelCode.
     *
     * @param channelCode value to be assigned to property channelCode
     **/
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * Getter method for property bankNo.
     *
     * @return property value of bankNo
     **/
    public String getBankNo() {
        return bankNo;
    }

    /**
     * Setter method for property bankNo.
     *
     * @param bankNo value to be assigned to property bankNo
     **/
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
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

    /**
     * Getter method for property payStatus.
     *
     * @return property value of payStatus
     **/
    public int getPayStatus() {
        return payStatus;
    }

    /**
     * Setter method for property payStatus.
     *
     * @param payStatus value to be assigned to property payStatus
     **/
    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * Getter method for property createDT.
     *
     * @return property value of createDT
     **/
    public Date getCreateDT() {
        return createDT;
    }

    /**
     * Setter method for property createDT.
     *
     * @param createDT value to be assigned to property createDT
     **/
    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }

    /**
     * Getter method for property finishDT.
     *
     * @return property value of finishDT
     **/
    public Date getFinishDT() {
        return finishDT;
    }

    /**
     * Setter method for property finishDT.
     *
     * @param finishDT value to be assigned to property finishDT
     **/
    public void setFinishDT(Date finishDT) {
        this.finishDT = finishDT;
    }

    /**
     * Getter method for property bankFinishDT.
     *
     * @return property value of bankFinishDT
     **/
    public Date getBankFinishDT() {
        return bankFinishDT;
    }

    /**
     * Setter method for property bankFinishDT.
     *
     * @param bankFinishDT value to be assigned to property bankFinishDT
     **/
    public void setBankFinishDT(Date bankFinishDT) {
        this.bankFinishDT = bankFinishDT;
    }

    /**
     * Getter method for property rtnCode.
     *
     * @return property value of rtnCode
     **/
    public String getRtnCode() {
        return rtnCode;
    }

    /**
     * Setter method for property rtnCode.
     *
     * @param rtnCode value to be assigned to property rtnCode
     **/
    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    /**
     * Getter method for property rtnMsg.
     *
     * @return property value of rtnMsg
     **/
    public String getRtnMsg() {
        return rtnMsg;
    }

    /**
     * Setter method for property rtnMsg.
     *
     * @param rtnMsg value to be assigned to property rtnMsg
     **/
    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    /**
     * Getter method for property mapstr.
     *
     * @return property value of mapstr
     **/
    public String getMapstr() {
        return mapstr;
    }

    /**
     * Setter method for property mapstr.
     *
     * @param mapstr value to be assigned to property mapstr
     **/
    public void setMapstr(String mapstr) {
        this.mapstr = mapstr;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}