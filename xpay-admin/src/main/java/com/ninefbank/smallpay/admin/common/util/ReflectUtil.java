package com.ninefbank.smallpay.admin.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReflectUtil {
	
	private static Log logger = LogFactory.getLog(ReflectUtil.class);
	
	 public static Object publicEntityChangeToDTO(Object srcObj,Object toObj) throws Exception{
	    	try {
				Field[] fields = srcObj.getClass().getDeclaredFields();
				for(Field field : fields){
					String name = field.getName();
					field.setAccessible(true);
					Object obj = field.get(srcObj);
					boolean flag = false;
					Field[] recFields  = toObj.getClass().getDeclaredFields();
					for(int i = 0 ; i < recFields.length; i++){
						if(recFields[i].getName().equals(name)){
							flag = true;
							break;
						}
					}
					if(flag){
						 PropertyDescriptor pd = new PropertyDescriptor(name, toObj.getClass());
						 Method wM = pd.getWriteMethod();
						 try {
							 wM.invoke(toObj, obj);
						 }catch(InvocationTargetException e) {
							 logger.info(name + "【反射执行方法异常】 " +e.getMessage(),e);
						 }
					}
				}
			} catch (Exception e) {
				logger.info("【复制属性出现异常】",e);
			}
			return toObj;
	    }
	    
	    /**
	     * 通过反射实现列表到DTO列表的转换
	     * @param mt
	     * @param cls 目标类
	     * @return
	     * @throws Exception
	     */
		public static <T, M> List<T> publicListChangeToListDTO(List<M> mt,Class cls) throws Exception{
			if(mt!=null && mt.size()>0){
				List<T> lt = new ArrayList<T>();
				for(M m:mt){
					Object obj = cls.newInstance();
					for(Field f : obj.getClass().getDeclaredFields()){
						f.setAccessible(true);
						String name = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
						Method getValue =  m.getClass().getMethod("get" + name);
						Method setValue;
						if(f.getGenericType().toString().contains("String")){
							setValue =  obj.getClass().getMethod("set" + name, String.class);
						}else if(f.getGenericType().toString().contains("Long")){
							setValue =  obj.getClass().getMethod("set" + name, Long.class);
						}else if(f.getGenericType().toString().contains("Date")){
							setValue =  obj.getClass().getMethod("set" + name, Date.class);
						}else if(f.getGenericType().toString().contains("Integer")){
							setValue =  obj.getClass().getMethod("set" + name, Integer.class);
						}else{
							Class<?> paramValue = (Class<?>) getValue.invoke(m);
							setValue =  obj.getClass().getMethod("set" + name,paramValue);
						}
						setValue.invoke(obj,getValue.invoke(m));
					}
					lt.add((T) obj);
				}
				return lt;
			}else{
				return null;
			}
		}
}
