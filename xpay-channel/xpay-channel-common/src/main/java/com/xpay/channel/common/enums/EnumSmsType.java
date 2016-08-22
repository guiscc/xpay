package com.xpay.channel.common.enums;

/**
 * 
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月4日 下午4:41:23
 */
public enum EnumSmsType {
    CHANNEL(0 , "渠道发送短信"),
    BANK(1 , "银行发送短信");
    
    private Integer key ;
    EnumSmsType(Integer key , String value) {
    	this.key = key ;
        this.value = value;
    }

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
	
	//默认每次都签约
	public static EnumSmsType getEnum(Integer key){
		switch (key) {
			case 0 : return CHANNEL ;
			case 1 : return BANK ;
			default: return BANK ;
		}
	}
}
