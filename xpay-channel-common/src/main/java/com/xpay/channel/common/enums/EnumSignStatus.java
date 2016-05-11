package com.xpay.channel.common.enums;
/**
 * 签约结果
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月8日 下午2:54:03
 */
public enum EnumSignStatus {
	SIGN_SUCCESS(0 , "签约成功"),
    SIGN_FAIL(1 , "签约失败"),
    SIGN_PROCESS(2 , "签约处理中"),
    BREAK_SUCCESS(3 , "解约成功"),
    BREAK_FAIL(4 , "解约失败"),
    BREAK_PROCESS(5 , "解约处理中");
	
	private Integer key ;
	private String vaule ;
	
	EnumSignStatus(Integer key , String value){
		this.key = key ;
		this.vaule = value ;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getVaule() {
		return vaule;
	}

	public void setVaule(String vaule) {
		this.vaule = vaule;
	}
	
	public static EnumSignStatus getEnum(Integer key){
		switch (key) {
		case 0: return EnumSignStatus.SIGN_SUCCESS;
		case 1: return EnumSignStatus.SIGN_FAIL;
		case 2: return EnumSignStatus.SIGN_PROCESS;
		case 3: return EnumSignStatus.BREAK_SUCCESS;
		case 4: return EnumSignStatus.BREAK_FAIL;
		case 5: return EnumSignStatus.BREAK_PROCESS;
		default:return null ;
		}
	}
}
