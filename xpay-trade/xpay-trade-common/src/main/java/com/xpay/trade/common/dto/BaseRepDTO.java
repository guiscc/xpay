package com.xpay.trade.common.dto;

import com.xpay.trade.common.enums.EnumRtnResult;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sxfans on 16/8/14.
 */
public class BaseRepDTO implements Serializable {

    /**
     * 返回码
     */
    private EnumRtnResult rtnResult = EnumRtnResult.S000000;

    /**
     * 当前时间
     *
     * @return
     */
    private Date serverDate = new Date();

    public EnumRtnResult getRtnResult() {
        return rtnResult;
    }

    public void setRtnResult(EnumRtnResult rtnResult) {
        this.rtnResult = rtnResult;
    }
}
