package com.xpay.channel.common.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * json工具类
 * @desc see class name
 * @author pangyiyang
 * @time 2016年3月7日 下午6:04:28
 */
public class JsonUtil {
	private JsonUtil(){}
	
	public static String mapToStr(Map<?, ?> map){
		if(map == null){
			return "" ;
		}
		return JSON.toJSONString(map) ;
	}

	public static Map<String , Object> jsonTomMap(String json){
		if(json == null || "".equals(json)){
			return new HashMap<String , Object>() ;
		}
		return JSON.parseObject(json , Map.class) ;
	}
}
