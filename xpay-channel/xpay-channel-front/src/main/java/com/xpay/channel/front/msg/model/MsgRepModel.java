/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.msg.model;

import com.xpay.channel.common.enums.EnumMsgRepType;

import java.util.Arrays;

/**
 * @author qinshou
 * @version $Id: MsgRepModel.java, v 0.1 16/11/22 下午3:33 sxfans Exp $
 */
public class MsgRepModel {

    /**
     * 返回信息类型
     */
    private EnumMsgRepType msgRepType;

    /**
     * 报文
     */
    private String         msg;

    /**
     * 报文
     */
    private byte[]         msgBytes;

    /**
     * Getter method for property msgRepType.
     *
     * @return property value of msgRepType
     **/
    public EnumMsgRepType getMsgRepType() {
        return msgRepType;
    }

    /**
     * Setter method for property msgRepType.
     *
     * @param msgRepType value to be assigned to property msgRepType
     **/
    public void setMsgRepType(EnumMsgRepType msgRepType) {
        this.msgRepType = msgRepType;
    }

    /**
     * Getter method for property msg.
     *
     * @return property value of msg
     **/
    public String getMsg() {
        return msg;
    }

    /**
     * Setter method for property msg.
     *
     * @param msg value to be assigned to property msg
     **/
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * Getter method for property msgBytes.
     *
     * @return property value of msgBytes
     **/
    public byte[] getMsgBytes() {
        return msgBytes;
    }

    /**
     * Setter method for property msgBytes.
     *
     * @param msgBytes value to be assigned to property msgBytes
     **/
    public void setMsgBytes(byte[] msgBytes) {
        this.msgBytes = msgBytes;
    }

    @Override
    public String toString() {
        if (msgRepType == EnumMsgRepType.BYTES) {
            return msgBytes.length + "";
        } else {
            return msg;
        }
    }
}