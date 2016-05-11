package com.xpay.channel.common.enums;

/**
 * 币种
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月1日 下午4:12:45
 */
public enum EnumCurrencyType {
	CNY(0 , "人民币"),
	;
	private Integer key ;
	private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}
	
	EnumCurrencyType(Integer key , String value) {
        this.value = value;
        this.key = key ;
    }
}
