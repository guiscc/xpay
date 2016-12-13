package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.entity.SysUser;

import java.util.Map;

/**
 * 
 * 用户服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysUserService {
	
	/**
	 * 系统用户登录
	 * @param loginName 登录名称
	 * @param loginPwd 登录密码
	 * @return 
	 * @throws 
	 */
	public SysUser login(String loginName, String loginPwd) throws XpayAdminException;

	/**
	 * 分页查询用户
	 * @return
	 * @throws 
	 */
	public PageList<SysUser> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException;

	/**
	 * 获取系统用户拥有的角�?
	 * @param userId 用户ID
	 * @return 角色ID数组
	 * @throws 
	 */
	public long[] getUserRoles(long userId) throws XpayAdminException;

	/**
	 * 增加用户
	 * @param dictType
	 * @throws 
	 */
	public void saveSysUser(SysUser sysUser) throws XpayAdminException;

	/**
	 * 更新用户信息
	 * @param dictType
	 * @throws 
	 */
	public void updateSysUser(SysUser sysUser) throws XpayAdminException;

	/**
	 * 更新用户密码
	 * @param newPwd
	 * @throws 
	 */
	public void updatePwd(String newPwd, String id) throws XpayAdminException;

	/**
	 * 删除用户信息
	 * @param id 用户ID
	 * @throws 
	 */
	public void delSysUser(long id) throws XpayAdminException;

	/**
	 * 根据ID获取用户信息
	 * @param id 用户ID
	 * @return
	 * @throws 
	 */
	public SysUser getSysUser(long id) throws XpayAdminException;

}
