package com.xpay.channel.common.enums;
/**
 * 是否可用
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月1日 下午4:16:28
 */
public enum EnumUseStatus {
	TRUE( 1 , "可用"),
	FALSE( 0 , "不可用"),
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
	
	EnumUseStatus(Integer key , String value) {
        this.value = value;
        this.key = key ;
    }
}
