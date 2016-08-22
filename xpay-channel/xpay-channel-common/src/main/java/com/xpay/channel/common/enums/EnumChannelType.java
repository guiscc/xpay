package com.xpay.channel.common.enums;
/**
 * 通道类型
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月1日 下午4:22:16
 */
public enum EnumChannelType {
	QUICK(0 , "快捷"),
    GATEWAY(1 ,"网关"),
    AGENTPAY(2 , "代付"),
    AGENTCOL(3 , "代收"),
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
	
	private EnumChannelType(Integer key , String value) {
		this.key = key ;
		this.value = value ;
	}
	
	public static EnumChannelType getEnum(Integer key) {
		switch (key) {
		case 0: return EnumChannelType.QUICK ;
		case 1: return EnumChannelType.GATEWAY ;
		case 2: return EnumChannelType.AGENTPAY ;
		case 3: return EnumChannelType.AGENTCOL ;
		default:return null ;
		}
	}
}	
