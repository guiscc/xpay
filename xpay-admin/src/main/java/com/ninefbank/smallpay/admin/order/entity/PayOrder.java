package com.ninefbank.smallpay.admin.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PayOrder {
    private Long id;

    private String payorderno;

    private String tradeorderno;

    private Byte paytool;

    private Byte paysubtool;

    private String channelcode;

    private BigDecimal payamt;

    private Byte currency;

    private String userid;

    private Byte paystatus;

    private Date createtime;

    private Date updatetime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayorderno() {
        return payorderno;
    }

    public void setPayorderno(String payorderno) {
        this.payorderno = payorderno == null ? null : payorderno.trim();
    }

    public String getTradeorderno() {
        return tradeorderno;
    }

    public void setTradeorderno(String tradeorderno) {
        this.tradeorderno = tradeorderno == null ? null : tradeorderno.trim();
    }

    public Byte getPaytool() {
        return paytool;
    }

    public void setPaytool(Byte paytool) {
        this.paytool = paytool;
    }

    public Byte getPaysubtool() {
        return paysubtool;
    }

    public void setPaysubtool(Byte paysubtool) {
        this.paysubtool = paysubtool;
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
    }

    public BigDecimal getPayamt() {
        return payamt;
    }

    public void setPayamt(BigDecimal payamt) {
        this.payamt = payamt;
    }

    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Byte getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Byte paystatus) {
        this.paystatus = paystatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}