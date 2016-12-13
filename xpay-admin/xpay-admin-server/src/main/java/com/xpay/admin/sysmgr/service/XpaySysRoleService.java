package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.sysmgr.entity.SysRole;
import com.ninefbank.smallpay.common.exception.ApplicationException;

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
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public PageList<SysRole> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;


	/**
	 * 增加角色/岗位
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void saveSysRole(SysRole sysRole) throws ApplicationException;

	/**
	 * 更新角色/岗位信息
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updateSysRole(SysRole sysRole) throws ApplicationException;

	/**
	 * 删除角色/岗位信息
	 * @param id 角色/岗位ID
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void delSysRole(long id) throws ApplicationException;

	/**
	 * 根据ID获取角色/岗位信息
	 * @param id 角色/岗位ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysRole getSysRole(long id) throws ApplicationException;

	/**
	 * 获取角色拥有的功能菜�?
	 * @param roleId 角色ID
	 * @return 菜单功能ID数组
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public long[] getRoleMenus(long userId) throws ApplicationException;

}
