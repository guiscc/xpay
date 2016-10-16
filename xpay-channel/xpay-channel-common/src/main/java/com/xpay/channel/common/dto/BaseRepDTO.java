package com.xpay.channel.common.dto;

import com.xpay.common.enums.EnumRtnResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by suxinxin on 16/2/5.
 */
public class BaseRepDTO implements Serializable {

    /**
     * 返回状态
     */
    private EnumRtnResult rtnResult  = EnumRtnResult.S000000;

    /**
     * 服务器时间
     */
    private Date          serverDate = new Date();

    /**
     * Getter method for property rtnResult.
     *
     * @return property value of rtnResult
     **/
    public EnumRtnResult getRtnResult() {
        return rtnResult;
    }

    /**
     * Setter method for property rtnResult.
     *
     * @param rtnResult value to be assigned to property rtnResult
     **/
    public void setRtnResult(EnumRtnResult rtnResult) {
        this.rtnResult = rtnResult;
    }

    /**
     * Getter method for property serverDate.
     *
     * @return property value of serverDate
     **/
    public Date getServerDate() {
        return serverDate;
    }

    /**
     * Setter method for property serverDate.
     *
     * @param serverDate value to be assigned to property serverDate
     **/
    public void setServerDate(Date serverDate) {
        this.serverDate = serverDate;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
