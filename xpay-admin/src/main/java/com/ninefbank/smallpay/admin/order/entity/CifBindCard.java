package com.ninefbank.smallpay.admin.order.entity;

import java.util.Date;

public class CifBindCard {
    private Integer id;

    private String signno;

    private String breaksignno;

    private String cardno;

    private Byte cardtype;

    private String holdername;

    private Byte certype;

    private String cerno;

    private Date expiredate;

    private String mobileno;

    private Date signcreatedt;

    private Date signfinishdt;

    private Date breaksigndt;

    private Byte signstatus;

    private String userid;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignno() {
        return signno;
    }

    public void setSignno(String signno) {
        this.signno = signno == null ? null : signno.trim();
    }

    public String getBreaksignno() {
        return breaksignno;
    }

    public void setBreaksignno(String breaksignno) {
        this.breaksignno = breaksignno == null ? null : breaksignno.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Byte getCardtype() {
        return cardtype;
    }

    public void setCardtype(Byte cardtype) {
        this.cardtype = cardtype;
    }

    public String getHoldername() {
        return holdername;
    }

    public void setHoldername(String holdername) {
        this.holdername = holdername == null ? null : holdername.trim();
    }

    public Byte getCertype() {
        return certype;
    }

    public void setCertype(Byte certype) {
        this.certype = certype;
    }

    public String getCerno() {
        return cerno;
    }

    public void setCerno(String cerno) {
        this.cerno = cerno == null ? null : cerno.trim();
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno == null ? null : mobileno.trim();
    }

    public Date getSigncreatedt() {
        return signcreatedt;
    }

    public void setSigncreatedt(Date signcreatedt) {
        this.signcreatedt = signcreatedt;
    }

    public Date getSignfinishdt() {
        return signfinishdt;
    }

    public void setSignfinishdt(Date signfinishdt) {
        this.signfinishdt = signfinishdt;
    }

    public Date getBreaksigndt() {
        return breaksigndt;
    }

    public void setBreaksigndt(Date breaksigndt) {
        this.breaksigndt = breaksigndt;
    }

    public Byte getSignstatus() {
        return signstatus;
    }

    public void setSignstatus(Byte signstatus) {
        this.signstatus = signstatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}