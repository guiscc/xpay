package com.xpay.channel.common.enums;
/**
 * 签约类型
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月4日 下午4:25:18
 */
public enum EnumSignType {
	SIGN_ONCE(0 , "签约一次"),
	SIGN_EVERY(1 ,"每次都签约"),
	;
	private Integer key ;
	private String value ;
	
	EnumSignType(Integer key , String value){
		this.key = key ;
		this.value = value ;
	}

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
	
	//默认每次都签约
	public static EnumSignType getEnum(Integer key){
		switch (key) {
			case 0 : return SIGN_ONCE ;
			case 1 : return SIGN_EVERY ;
			default: return SIGN_EVERY ;
		}
	}
}
