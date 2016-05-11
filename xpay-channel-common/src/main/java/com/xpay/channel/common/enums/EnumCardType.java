package com.xpay.channel.common.enums;
/**
 * 卡类型
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月1日 下午4:24:51
 */
public enum EnumCardType {
	
    CREDIT(0 , "信用卡"),
    DEBIT(1 , "借记卡"),
    CRDE(2 , "混合卡"),
    PREPAY(3 , "预付费卡"),
    ;
    
    private Integer key ;
	private String value ;
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	private EnumCardType(Integer key , String value) {
		this.key = key ;
		this.value = value ;
	}
}
