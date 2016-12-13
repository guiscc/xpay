package com.xpay.admin.common.util;

import com.xpay.admin.sysmgr.entity.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.*;

/** 
* @ClassName: AdminUtil 
* @Description:系统信息公共utils
* @author fan
* @date 2016年1月14日 下午7:09:43 
* 
* zhoulei 2015/07/25 修改，将HttpServletRequest 提出为公共方法，添加 getUserInfo、getIpAddr重载方法
*/
public class AdminUtil {
	
	/** 
	 * @Title: AdminUtil
	 * @Description: 获取登录用户
	 * @param @return 
	 * @return  
	 * @author fan
	 * @throws 
	 */
	public static SysUser getUserInfo(){
		HttpServletRequest req = getContextRequest();
		Assert.notNull(req, "请求req为NULL");
		SysUser loginUser = (SysUser)req.getSession(true).getAttribute(XpayConstants.CURRENT_LOGIN_USER);
		if(loginUser==null){
			loginUser = (SysUser)req.getSession(true).getAttribute(XpayConstants.CURRENT_LOGIN_USER_B);
		}
		return loginUser;
	}
	
	/** 重载方法,增加session参数
	 * @Title: AdminUtil
	 * @Description: 获取登录用户
	 * @param @return 
	 * @return  
	 * @author zhoulei
	 * @throws 
	 */
	public static SysUser getUserInfo(HttpSession session){
		Assert.notNull(session,"session为null");
		SysUser loginUser = (SysUser)session.getAttribute(XpayConstants.CURRENT_LOGIN_USER);
		if(loginUser==null){
			loginUser = (SysUser)session.getAttribute(XpayConstants.CURRENT_LOGIN_USER_B);
		}
		return loginUser;
	}

	/**
	 * 获取request
	 * @author zhoulei
	 * @return
	 */
	private static HttpServletRequest getContextRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/** 
	 * @Title: AdminUtil
	 * @Description:由ip获取对应城市
	 * @param @param ip
	 * @param @return 
	 * @return  
	 * @author fan
	 * @throws 
	 */
	public static String getCityByIP(String ip){
		try {
			StringBuffer result;
			URL url = new URL( "http://ip.qq.com/cgi-bin/searchip?searchip1=" + ip); 
			URLConnection conn = url.openConnection(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK")); 
			String line = null; 
			result = new StringBuffer(); 
			while((line = reader.readLine()) != null)
			{ 
			  result.append(line); 
			} 
			reader.close();
			String strIP = result.substring(result.indexOf( "该IP所在地为：" ));
		    strIP = strIP.substring(strIP.indexOf( "：") + 1);
		    return strIP.substring(6, strIP.indexOf("&nbsp"));
		} catch (Exception e) {
			e.printStackTrace();
		} return null;
	}
	/** 
	 * @Title: AdminUtil
	 * @Description:浏览器下载文件中文不兼容
	 * @param @param request
	 * @param @param fileName
	 * @param @return
	 * @param @throws UnsupportedEncodingException 
	 * @return  
	 * @author fan
	 * @throws 
	 */
	public static String downLoadEncodeName(String fileName)
			throws UnsupportedEncodingException {
		HttpServletRequest request = getContextRequest();
		String agent = request.getHeader("USER-AGENT");
        if(null != agent && -1 != agent.indexOf("MSIE")){//IE
        	fileName = URLEncoder.encode(fileName, XpayConstants.ENCODE_UTF8);
        }else if(null != agent && -1 != agent.indexOf("Mozilla")){//firefox
        	fileName = new String (fileName.getBytes(XpayConstants.ENCODE_UTF8), XpayConstants.ENCODE_IOS);
        }else{
        	fileName = URLEncoder.encode(fileName, XpayConstants.ENCODE_UTF8);
        }
		return fileName;
	}
	/** 
	 * @Description: 获取请求ip
	 * @param @param request
	 * @param @return 
	 * @return  
	 * @author fan
	 * @throws 
	 */
	public static String getIpAddr() {
		HttpServletRequest request = getContextRequest();
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}
	
	
	/** 
	 * 重载方法
	 * @Description: 获取请求ip
	 * @param @param request
	 * @param @return 
	 * @return  
	 * @author fan
	 * @throws 
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		return request.getRemoteAddr();
	}

	public static String getMacOne(){
		StringBuilder sb = new StringBuilder();
		try {
			InetAddress ip = InetAddress.getLocalHost();
			  NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			  if (network != null) {
			    byte[] mac = network.getHardwareAddress();
			    if(mac != null) {
			      System.out.print("MAC address : ");
			      for (int i = 0; i < mac.length; i++) {
			        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
			      }
			      System.out.println(sb.toString());  
			   }
			  }
			} catch (UnknownHostException e) {
			  e.printStackTrace();
			} catch (SocketException e) {
			  e.printStackTrace();
			}
		return sb.toString();
	}


}
