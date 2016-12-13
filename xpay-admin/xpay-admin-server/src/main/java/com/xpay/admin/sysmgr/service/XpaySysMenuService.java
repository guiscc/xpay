package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.entity.SysMenu;
import com.xpay.admin.sysmgr.web.TreeNode;
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
	 * 获取角色的所有功能菜
	 * @param roleId 角色ID
	 * @return 功能菜单集合,TreeNode结构数据
	 * @throws XpayAdminException
	 */
	public List<TreeNode> getRoleMenus(long roleId) throws XpayAdminException;


	/**
	 * 获取菜单
	 * @param withRoot 是否返回默认根节
	 * @param menuIds 条件（菜单Id在数组范围之内）
	 * @return
	 * @throws XpayAdminException
	 */
	public List<TreeNode> getMenuTree(boolean withRoot, long[] menuIds) throws XpayAdminException;

	/**
	 * 分页查询菜单
	 * @return
	 */
	public PageList<SysMenu> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException;


	/**
	 * 增加菜单
	 * @param sysMenu
	 */
	public void saveSysMenu(SysMenu sysMenu) throws XpayAdminException;

	/**
	 * 更新菜单信息
	 * @param sysMenu
	 */
	public void updateSysMenu(SysMenu sysMenu) throws XpayAdminException;

	/**
	 * 删除菜单信息
	 * @param id 菜单ID
	 */
	public void delSysMenu(long id) throws XpayAdminException;

	/**
	 * 根据ID获取菜单信息
	 * @param id 菜单ID
	 * @return
	 */
	public SysMenu getSysMenu(long id) throws XpayAdminException;

}
