package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.sysmgr.entity.SysUser;
import com.ninefbank.smallpay.common.exception.ApplicationException;

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
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysUser login(String loginName, String loginPwd) throws ApplicationException;

	/**
	 * 分页查询用户
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public PageList<SysUser> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;

	/**
	 * 获取系统用户拥有的角�?
	 * @param userId 用户ID
	 * @return 角色ID数组
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public long[] getUserRoles(long userId) throws ApplicationException;

	/**
	 * 增加用户
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void saveSysUser(SysUser sysUser) throws ApplicationException;

	/**
	 * 更新用户信息
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updateSysUser(SysUser sysUser) throws ApplicationException;

	/**
	 * 更新用户密码
	 * @param newPwd
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updatePwd(String newPwd, String id) throws ApplicationException;

	/**
	 * 删除用户信息
	 * @param id 用户ID
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void delSysUser(long id) throws ApplicationException;

	/**
	 * 根据ID获取用户信息
	 * @param id 用户ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysUser getSysUser(long id) throws ApplicationException;

}
