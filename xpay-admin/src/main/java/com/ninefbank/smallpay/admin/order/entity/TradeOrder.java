package com.ninefbank.smallpay.admin.order.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TradeOrder {
    private Long id;

    private String bizorderno;

    private String tradeorderno;

    private Byte tradetype;

    private Byte tradesubtype;

    private Date bizordertime;

    private Date expiretime;

    private String payno;

    private BigDecimal payamt;

    private Date paytime;

    private Byte tradestatus;

    private Date createtime;

    private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizorderno() {
        return bizorderno;
    }

    public void setBizorderno(String bizorderno) {
        this.bizorderno = bizorderno == null ? null : bizorderno.trim();
    }

    public String getTradeorderno() {
        return tradeorderno;
    }

    public void setTradeorderno(String tradeorderno) {
        this.tradeorderno = tradeorderno == null ? null : tradeorderno.trim();
    }

    public Byte getTradetype() {
        return tradetype;
    }

    public void setTradetype(Byte tradetype) {
        this.tradetype = tradetype;
    }

    public Byte getTradesubtype() {
        return tradesubtype;
    }

    public void setTradesubtype(Byte tradesubtype) {
        this.tradesubtype = tradesubtype;
    }

    public Date getBizordertime() {
        return bizordertime;
    }

    public void setBizordertime(Date bizordertime) {
        this.bizordertime = bizordertime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public String getPayno() {
        return payno;
    }

    public void setPayno(String payno) {
        this.payno = payno == null ? null : payno.trim();
    }

    public BigDecimal getPayamt() {
        return payamt;
    }

    public void setPayamt(BigDecimal payamt) {
        this.payamt = payamt;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Byte getTradestatus() {
        return tradestatus;
    }

    public void setTradestatus(Byte tradestatus) {
        this.tradestatus = tradestatus;
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
}