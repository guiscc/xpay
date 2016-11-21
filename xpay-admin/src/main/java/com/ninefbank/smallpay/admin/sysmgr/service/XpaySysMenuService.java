package com.ninefbank.smallpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysMenu;
import com.ninefbank.smallpay.admin.sysmgr.web.TreeNode;
import com.ninefbank.smallpay.common.exception.ApplicationException;

import java.util.List;
import java.util.Map;

/**
 * 
 * 菜单服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysMenuService {
	
	/**
	 * 获取角色的所有功能菜�?
	 * @param roleId 角色ID
	 * @return 功能菜单集合,TreeNode结构数据
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public List<TreeNode> getRoleMenus(long roleId) throws ApplicationException;

	/**
	 * 获取菜单�?
	 * @param withRoot 是否返回默认根节�?
	 * @param menuIds 条件（菜单Id在数组范围之内）
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public List<TreeNode> getMenuTree(boolean withRoot, long[] menuIds) throws ApplicationException;

	/**
	 * 分页查询菜单
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public PageList<SysMenu> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;


	/**
	 * 增加菜单
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void saveSysMenu(SysMenu sysMenu) throws ApplicationException;

	/**
	 * 更新菜单信息
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updateSysMenu(SysMenu sysMenu) throws ApplicationException;

	/**
	 * 删除菜单信息
	 * @param id 菜单ID
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void delSysMenu(long id) throws ApplicationException;

	/**
	 * 根据ID获取菜单信息
	 * @param id 菜单ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysMenu getSysMenu(long id) throws ApplicationException;

}
