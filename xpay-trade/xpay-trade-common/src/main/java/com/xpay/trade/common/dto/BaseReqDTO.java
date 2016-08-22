package com.xpay.trade.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sxfans on 16/8/14.
 */
public class BaseReqDTO implements Serializable {

    /**
     * 客户端请求时间
     */
    private Date reqClientDT;

    public Date getReqClientDT() {
        return reqClientDT;
    }

    public void setReqClientDT(Date reqClientDT) {
        this.reqClientDT = reqClientDT;
    }
}
