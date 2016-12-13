package com.xpay.admin.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 
* @ClassName: DataBaseConst
* @Description: 初始化database.properties 属性
* @author fan
* @date 2016年1月15日 下午3:00:29 
*/
public final class DataBaseConst {

	public static final String HTTP_URL;//smallpay_clear URL
	public static final String MERDOC_CONTEXT_PATH;//商户上传文件根目录地址
	public static final String MERDOC_PATH;//商户上传文件地址
	public static final String SEND_MSG_PATH;//发送短信验证码path
	public static final String SEND_CONTEXT_PATH;//发送短信内容path
	public static final String LAN_IP_PATH;//局域网ip前两位
	
	static{
		InputStream is = DataBaseConst.class.getResourceAsStream("/database.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		MERDOC_CONTEXT_PATH = prop.getProperty("mer.Dom.ContextPath");
		MERDOC_PATH = prop.getProperty("mer.Dom.Path");	
		HTTP_URL = prop.getProperty("smallpay.clear.path");
		SEND_MSG_PATH = prop.getProperty("sendVerifyCodeMsg.Url");
		SEND_CONTEXT_PATH = prop.getProperty("sendTriggerMsg.Url");
		LAN_IP_PATH = prop.getProperty("lan.ip");
	}
}
