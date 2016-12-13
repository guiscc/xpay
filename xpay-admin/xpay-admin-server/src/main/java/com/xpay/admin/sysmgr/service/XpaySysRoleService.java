package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.entity.SysRole;


import java.util.Map;

/**
 * 
 * 角色/岗位服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysRoleService {
	
	/**
	 * 分页查询角色/岗位
	 * @return
	 * @throws 
	 */
	public PageList<SysRole> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException;


	/**
	 * 增加角色/岗位
	 * @param sysRole
	 * @throws 
	 */
	public void saveSysRole(SysRole sysRole) throws XpayAdminException;

	/**
	 * 更新角色/岗位信息
	 * @param sysRole
	 * @throws 
	 */
	public void updateSysRole(SysRole sysRole) throws XpayAdminException;

	/**
	 * 删除角色/岗位信息
	 * @param id 角色/岗位ID
	 * @throws 
	 */
	public void delSysRole(long id) throws XpayAdminException;

	/**
	 * 根据ID获取角色/岗位信息
	 * @param id 角色/岗位ID
	 * @return
	 * @throws 
	 */
	public SysRole getSysRole(long id) throws XpayAdminException;

	/**
	 * 获取角色拥有的功能菜�?
	 * @param userId 角色ID
	 * @return 菜单功能ID数组
	 * @throws 
	 */
	public long[] getRoleMenus(long userId) throws XpayAdminException;

}
