package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.entity.SysDictType;
import com.xpay.admin.sysmgr.web.TreeNode;

import java.util.List;
import java.util.Map;

/**
 * 字典类型服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysDictTypeService {
	
	public List<TreeNode> getDictTypeTree() throws XpayAdminException;
	
	/**
	 * 分页查询字典类型信息
	 * @return
	 */
	public PageList<SysDictType> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException;
	
	/**
	 * 增加字典类型
	 * @param dictType
	 */
	public void saveSysDictType(SysDictType dictType) throws XpayAdminException;

	/**
	 * 更新字典类型信息
	 * @param dictType
	 */
	public void updateSysDictType(SysDictType dictType) throws XpayAdminException;

	/**
	 * 删除字典类型信息
	 * @param id 字典类型ID
	 */
	public void delSysDictType(long id) throws XpayAdminException;

	/**
	 * 根据ID获取字典类型信息
	 * @param id 字典类型ID
	 * @return
	 */
	public SysDictType getSysDictType(long id) throws XpayAdminException;

}
