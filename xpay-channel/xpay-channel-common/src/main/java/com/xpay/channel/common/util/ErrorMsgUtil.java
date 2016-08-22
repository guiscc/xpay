package com.xpay.channel.common.util;

import com.xpay.channel.common.exception.BaseException;

/**
 * 获取errorCode 和 errorMsg
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月2日 下午4:37:55
 */
public class ErrorMsgUtil {

	private ErrorMsgUtil() {
	}

	/**
	 * 获取错误码信息
	 * @param ex
	 * @return
	 */
	public static String getCodeAndMsg(BaseException ex) {
		return ";errorCode为：" + ex.getErrorCode() + ";errorMsg为："
				+ ex.getErrorMsg() + ";";
	}
}
