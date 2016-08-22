package com.xpay.channel.common.enums;


public enum EnumCertType {
	ID(0, "身份证"), ;
	private Integer key;
	private String value;

	EnumCertType(Integer key, String value) {
		this.key = key;
		this.value = value;
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

	public static final EnumCertType getEnum(Integer key) {
		switch (key) {
			case 0:
				return EnumCertType.ID;
			default:
				return EnumCertType.ID;
		}
	}
}
