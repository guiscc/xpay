package com.ninefbank.smallpay.admin.order.entity;

import java.util.Date;

public class ChannelOrder {
    private Long id;

    private String payorderno;

    private String bankorderno;

    private Double amt;

    private String channelcode;

    private String intercode;

    private String bankno;

    private String rtncode;

    private String rtnmsg;

    private String tradestatus;

    private Date createtime;

    private Date finishtime;

    private Date bankfinishtime;

    private Date reqtime;

    private String mapstr;

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

    public String getBankorderno() {
        return bankorderno;
    }

    public void setBankorderno(String bankorderno) {
        this.bankorderno = bankorderno == null ? null : bankorderno.trim();
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public String getChannelcode() {
        return channelcode;
    }

    public void setChannelcode(String channelcode) {
        this.channelcode = channelcode == null ? null : channelcode.trim();
    }

    public String getIntercode() {
        return intercode;
    }

    public void setIntercode(String intercode) {
        this.intercode = intercode == null ? null : intercode.trim();
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    public String getRtncode() {
        return rtncode;
    }

    public void setRtncode(String rtncode) {
        this.rtncode = rtncode == null ? null : rtncode.trim();
    }

    public String getRtnmsg() {
        return rtnmsg;
    }

    public void setRtnmsg(String rtnmsg) {
        this.rtnmsg = rtnmsg == null ? null : rtnmsg.trim();
    }

    public String getTradestatus() {
        return tradestatus;
    }

    public void setTradestatus(String tradestatus) {
        this.tradestatus = tradestatus == null ? null : tradestatus.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public Date getBankfinishtime() {
        return bankfinishtime;
    }

    public void setBankfinishtime(Date bankfinishtime) {
        this.bankfinishtime = bankfinishtime;
    }

    public Date getReqtime() {
        return reqtime;
    }

    public void setReqtime(Date reqtime) {
        this.reqtime = reqtime;
    }

    public String getMapstr() {
        return mapstr;
    }

    public void setMapstr(String mapstr) {
        this.mapstr = mapstr == null ? null : mapstr.trim();
    }
}