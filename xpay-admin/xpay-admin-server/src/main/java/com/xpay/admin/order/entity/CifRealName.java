package com.xpay.admin.order.entity;

import java.util.Date;

public class CifRealName {
    private Integer id;

    private String username;

    private Byte certype;

    private String cerno;

    private Byte realstatus;

    private Date createdt;

    private Date expire;

    private String userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public Byte getRealstatus() {
        return realstatus;
    }

    public void setRealstatus(Byte realstatus) {
        this.realstatus = realstatus;
    }

    public Date getCreatedt() {
        return createdt;
    }

    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}