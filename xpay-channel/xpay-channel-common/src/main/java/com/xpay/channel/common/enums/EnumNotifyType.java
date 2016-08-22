package com.xpay.channel.common.enums;
/**
 * 通知类型
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月1日 下午7:44:15
 */
public enum EnumNotifyType {
	RETURN("同步回调") ,
	NOTIFY("异步回调") ,
	;
	
	private String value ;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	private EnumNotifyType(String value) {
		this.value = value ;
	}
}
