package com.xpay.common.enums;

/**
 * @author qinshou
 * @version $Id: EnumCertType.java, v 0.1 16/8/31 下午6:54 sxfans Exp $
 */
public enum EnumCertType {

    IDCARD("身份证");

    EnumCertType(String key) {
        this.key = key;
    }

    private String key;

    /**
     * Getter method for property key.
     *
     * @return property value of key
     **/
    public String getKey() {
        return key;
    }

    /**
     * Setter method for property key.
     *
     * @param key value to be assigned to property key
     **/
    public void setKey(String key) {
        this.key = key;
    }
}
