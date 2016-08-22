package com.xpay.channel.common.util;

import java.math.BigDecimal;

/**
 * 数转换工具
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月3日 下午1:43:35
 */
public class BigDecimalUtil {
	
	private BigDecimalUtil () {} 
	
	public static double toDouble(BigDecimal decimal){
		return decimal.doubleValue() ;
	}
}
