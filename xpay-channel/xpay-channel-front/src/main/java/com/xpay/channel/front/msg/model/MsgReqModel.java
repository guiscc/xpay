/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.front.msg.model;

import com.xpay.channel.common.enums.EnumMsgType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qinshou
 * @version $Id: MsgReqModel.java, v 0.1 16/11/21 上午11:48 sxfans Exp $
 */
public class MsgReqModel {

    /**
     * 报文格式枚举
     */
    private EnumMsgType msgType;

    /**
     * 报文字符形态
     */
    private String msgStr;

    /**
     * 报文字节形态
     */
    private byte[] msgBytes;

    /**
     * 报文表单形态
     */
    private Map<String,Object> msgMap = new HashMap<>();

    /**
     * Getter method for property msgType.
     *
     * @return property value of msgType
     **/
    public EnumMsgType getMsgType() {
        return msgType;
    }

    /**
     * Setter method for property msgType.
     *
     * @param msgType value to be assigned to property msgType
     **/
    public void setMsgType(EnumMsgType msgType) {
        this.msgType = msgType;
    }

    /**
     * Getter method for property msgStr.
     *
     * @return property value of msgStr
     **/
    public String getMsgStr() {
        return msgStr;
    }

    /**
     * Setter method for property msgStr.
     *
     * @param msgStr value to be assigned to property msgStr
     **/
    public void setMsgStr(String msgStr) {
        this.msgStr = msgStr;
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

    /**
     * Getter method for property msgMap.
     *
     * @return property value of msgMap
     **/
    public Map<String, Object> getMsgMap() {
        return msgMap;
    }

    /**
     * Setter method for property msgMap.
     *
     * @param msgMap value to be assigned to property msgMap
     **/
    public void setMsgMap(Map<String, Object> msgMap) {
        this.msgMap = msgMap;
    }

    @Override
    public String toString() {
        if(msgType==null){
            return "";
        }else if(msgType == EnumMsgType.FORM){
            return  this.getMsgMap().toString();
        }else{
            return "";
        }
    }
}