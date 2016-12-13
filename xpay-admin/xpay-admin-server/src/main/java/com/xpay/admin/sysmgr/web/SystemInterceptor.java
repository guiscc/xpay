package com.xpay.admin.sysmgr.web;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
* @Title: SystemInterceptor.java 
* @Description: 接收请求判断session是否超时
* @author 尹超 
* @date 2015年12月4日 下午12:56:28 
* @version V1.0
 */
@Repository 
public class SystemInterceptor extends HandlerInterceptorAdapter {

	private static Log logger = LogFactory.getLog(SystemInterceptor.class);

	@Override
	public  boolean  preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		System.out.println("进来了================================================几耐了");
		logger.info("拦截请求判断session");
		String uri = request.getRequestURI();
			String[] noFilters = new String[] { "allSeller", "singleSeller"};
			boolean beFilter = false;  
            for (String s : noFilters) {  
                if (uri.indexOf(s) != -1) {  
                    beFilter = true;  
                    break;  
                }  
            } 
            if(beFilter){
				HttpSession session = request.getSession(false);
		        if(session == null) {
		        	if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有，x-requested-with  
		                response.setHeader("sessionstatus", "timeout");//在响应头设置session状态  
		            }else{
		                response.sendRedirect(request.getContextPath()+"/login.html");
		            }  
		 	        return false;
		        }
			}
			
			
			
        return super.preHandle(request, response, handler);
			
			
			
			
			
		
	}
	@Override  
    public void postHandle(HttpServletRequest request, HttpServletResponse response,  
            Object obj, ModelAndView mav) throws Exception {  
		 System.out.println("执行postHandle方法-->-->-->-->-->-->-->-->-->02");     
    } 

	@Override  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object obj, Exception err)  
            throws Exception {  
		System.out.println("执行afterCompletion方法-->-->-->-->-->-->-->-->-->03"); 
    } 
}
