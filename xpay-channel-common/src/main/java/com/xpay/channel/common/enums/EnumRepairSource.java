package com.xpay.channel.common.enums;
/**
 * 补单来源
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月1日 下午7:36:03
 */
public enum EnumRepairSource {
	CHANNEL(0 , "渠道补单") , 
	TRADE(1 , "交易补单") ,
	OTHER(9 , "未知来源") ,
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
	
	private EnumRepairSource(Integer key , String value) {
		this.key = key ;
		this.value = value ;
	}
	
	public static final EnumRepairSource getEnum(Integer key){
		switch (key) {
		case 0:
			return EnumRepairSource.CHANNEL ;
		case 1:
			return EnumRepairSource.TRADE ;
		case 2:
			return EnumRepairSource.OTHER ;
		default:
			return EnumRepairSource.OTHER ;
		}
	}
	
}
