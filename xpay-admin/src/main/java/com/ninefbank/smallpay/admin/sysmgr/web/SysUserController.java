package com.ninefbank.smallpay.admin.sysmgr.web;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.common.constants.AppConstants;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysUser;
import com.ninefbank.smallpay.admin.sysmgr.service.XpaySysUserService;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.ninefbank.smallpay.common.util.MD5Util;
import com.ninefbank.smallpay.common.util.StringUtil;
import com.ninefbank.smallpay.common.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 角色/岗位页面请求处理
 * 
 * @author wangzhenlei
 *
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController {
	
	@Autowired
	private XpaySysUserService sysUserService;
	private static Logger logger =LoggerFactory.getLogger(SysUserController.class);
	
	/**
	 * 系统用户登录
	 * @param loginName 登录�?
	 * @param loginPwd 登录密码
	 * @param validateCode 验证�?
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(HttpServletRequest request, @RequestParam String loginName, @RequestParam String loginPwd, String validateCode) {
		try {
			//校验验证�?
			boolean codeFlag = true;
			if(!codeFlag){
				return buildErrorResult("验证码错误");
			}
			//校验登录名和登录密码
			if(StringUtil.isNotBlank(loginPwd) && StringUtil.isNotBlank(loginName)){
				loginPwd = MD5Util.MD5(loginPwd);
				SysUser loginUser = sysUserService.login(loginName, loginPwd);
				if(null == loginUser){
					return buildErrorResult("用户名或密码错误");
				}
//				logger.info("密码是:"+loginUser.getLoginPwd());
				//将当前登录用户放到SESSION�?
				request.getSession().setAttribute(AppConstants.CURRENT_LOGIN_USER, loginUser);
			}else{
				return buildErrorResult("用户名或密码为空");
			}
		} catch (Exception e) {
			logger.error("用户登录失败!",e);
		}
		return this.buildResult("登录成功");
	}
	
	/**
	 * �?��登录
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return this.buildResult("登出成功");
	}

	/**
	 * 分页查询角色/岗位
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/querySysUser", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> querySysUser(@RequestParam Integer rows, @RequestParam Integer page, @RequestParam String condition) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		
		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%"+condition+"%");
		}
		PageList<SysUser> ret = sysUserService.queryWithPage(params, pageBounds);
		
		return buildResult(rows, page, ret);
	}
	
	/**
	 * 查询系统用户的授权角色集�?
	 * @param userId 用户ID
	 * @return
	 */
	@RequestMapping(value = "/queryUserRoles", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryUserRoles(@RequestParam long userId) {
		
		long[] urrs = sysUserService.getUserRoles(userId);
		
		return buildResult(urrs);
	}
	
	/**
	 * 新增角色/岗位
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addSysUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSysUser(@RequestBody SysUser sysUser)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.saveSysUser(sysUser);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 更新角色/岗位
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateSysUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateSysUser(@RequestBody SysUser sysUser)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.updateSysUser(sysUser);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除角色/岗位
	 * @param id 角色/岗位ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/delSysUser", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delSysUser(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysUserService.delSysUser(id);
		ret.put("success", true);
		return ret;
	}

	@RequestMapping(value="/updatePwd",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updatePwd(HttpServletRequest request,@RequestParam String newPwd){
		Map<String, Object> ret = new HashMap<String, Object>();
		try {
			SysUser sysUser = (SysUser) request.getSession().getAttribute(AppConstants.CURRENT_LOGIN_USER);
			sysUserService.updatePwd(MD5Util.MD5(newPwd), String.valueOf(sysUser.getId()));
			ret.put("success", true);
		} catch (Exception e) {
			logger.error("系统用户-修改密码失败",e);
		}
		return ret;
	}

	/**
	 * 根据ID获取角色/岗位
	 * @param id 角色/岗位ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getSysUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSysUser(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysUser data = sysUserService.getSysUser(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}

}
