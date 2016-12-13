package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.entity.SysOrg;
import com.xpay.admin.sysmgr.web.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * 
 * 机构服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysOrgService {
	
	public List<TreeNode> getSysOrgTree(long parent) throws XpayAdminException;
	
	/**
	 * 分页查询机构
	 * @return
	 */
	public PageList<SysOrg> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException;


	/**
	 * 增加机构
	 * @param sysOrg
	 */
	public void saveSysOrg(SysOrg sysOrg) throws XpayAdminException;

	/**
	 * 更新机构信息
	 * @param sysOrg
	 */
	public void updateSysOrg(SysOrg sysOrg) throws XpayAdminException;

	/**
	 * 删除机构信息
	 * @param id 机构ID
	 */
	public void delSysOrg(long id) throws XpayAdminException;

	/**
	 * 根据ID获取机构信息
	 * @param id 机构ID
	 * @return
	 */
	public SysOrg getSysOrg(long id) throws XpayAdminException;

}
