package com.xpay.admin.common.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 
* @ClassName: SendConstants
* @Description: 初始化sms.properties 属性
* @author clx
* @date 2016年4月28日 下午17:59:29 
*/
public final class SendConstants{

	public static final String WITHDRAWAL_DELEGATE_MSG;//人工提现处理短信内容
	
	static{
		InputStream is = SendConstants.class.getResourceAsStream("/sms.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		WITHDRAWAL_DELEGATE_MSG = prop.getProperty("withdrawal_delegate_msg");
	}
}
