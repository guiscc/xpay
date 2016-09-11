package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumCertType.java, v 0.1 16/8/31 下午6:54 sxfans Exp $
 */
public enum EnumCertType {

    IDCARD((byte) 0, "身份证");


    private byte key;
    private String msg;

    EnumCertType(byte key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    /**
     * 支付工具
     *
     * @param key
     * @return
     */
    public static EnumCertType toCerType(byte key) {
        for (EnumCertType type : EnumCertType.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return null;
    }

    /**
     * Getter method for property key.
     *
     * @return property value of key
     **/
    public byte getKey() {
        return key;
    }

    /**
     * Setter method for property key.
     *
     * @param key value to be assigned to property key
     **/
    public void setKey(byte key) {
        this.key = key;
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
}
