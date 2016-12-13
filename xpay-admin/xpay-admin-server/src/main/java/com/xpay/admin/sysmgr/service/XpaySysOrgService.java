package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.sysmgr.entity.SysOrg;
import com.xpay.admin.sysmgr.web.TreeNode;
import com.ninefbank.smallpay.common.exception.ApplicationException;

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
	
	public List<TreeNode> getSysOrgTree(long parent) throws ApplicationException;
	
	/**
	 * 分页查询机构
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public PageList<SysOrg> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;


	/**
	 * 增加机构
	 * @param sysOrg
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void saveSysOrg(SysOrg sysOrg) throws ApplicationException;

	/**
	 * 更新机构信息
	 * @param sysOrg
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updateSysOrg(SysOrg sysOrg) throws ApplicationException;

	/**
	 * 删除机构信息
	 * @param id 机构ID
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void delSysOrg(long id) throws ApplicationException;

	/**
	 * 根据ID获取机构信息
	 * @param id 机构ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysOrg getSysOrg(long id) throws ApplicationException;

}
