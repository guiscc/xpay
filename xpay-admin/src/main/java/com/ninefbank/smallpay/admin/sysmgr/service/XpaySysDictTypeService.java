package com.ninefbank.smallpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysDictType;
import com.ninefbank.smallpay.admin.sysmgr.web.TreeNode;
import com.ninefbank.smallpay.common.exception.ApplicationException;

import java.util.List;
import java.util.Map;

/**
 * 字典类型服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysDictTypeService {
	
	public List<TreeNode> getDictTypeTree() throws ApplicationException;
	
	/**
	 * 分页查询字典类型信息
	 * @param pageInfo
	 * @return
	 */
	public PageList<SysDictType> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;
	
	/**
	 * 增加字典类型
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void saveSysDictType(SysDictType dictType) throws ApplicationException;

	/**
	 * 更新字典类型信息
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updateSysDictType(SysDictType dictType) throws ApplicationException;

	/**
	 * 删除字典类型信息
	 * @param id 字典类型ID
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void delSysDictType(long id) throws ApplicationException;

	/**
	 * 根据ID获取字典类型信息
	 * @param id 字典类型ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysDictType getSysDictType(long id) throws ApplicationException;

}
