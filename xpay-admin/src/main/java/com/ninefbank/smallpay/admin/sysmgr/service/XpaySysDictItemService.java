package com.ninefbank.smallpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysDictItem;
import com.ninefbank.smallpay.admin.sysmgr.web.DictCache;
import com.ninefbank.smallpay.common.exception.ApplicationException;

import java.util.List;
import java.util.Map;

/**
 * 
 * 字典项目服务接口
 * 
 * @author wangzhenlei
 *
 */
public interface XpaySysDictItemService {
	
	/**
	 * 获取字典项名�?
	 * @param typeCode 字典类型代码
	 * @param itemCode 字典项代�?
	 * @return 字典项名�?
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public String getItemName(String typeCode, String itemCode) throws ApplicationException;

	/**
	 * 获取�?��字典�?
	 * @param typeCode 字典类型代码
	 * @return 字典项集�?
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public List<SysDictItem> getDictItems(String typeCode) throws ApplicationException;


	/**
	 * 获取�?��字典数据（包含所有的字典类型和字典项�?
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public DictCache getAll() throws ApplicationException;

	public Map<String, Object> getMap() throws ApplicationException;


	/**
	 * 分页查询字典�?
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public PageList<SysDictItem> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws ApplicationException;


	/**
	 * 增加字典�?
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void saveSysDictItem(SysDictItem dictItem) throws ApplicationException;

	/**
	 * 更新字典项信�?
	 * @param dictType
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void updateSysDictItem(SysDictItem dictItem) throws ApplicationException;

	/**
	 * 删除字典项信�?
	 * @param id 字典项ID
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public void delSysDictItem(long id) throws ApplicationException;

	/**
	 * 根据ID获取字典项信�?
	 * @param id 字典项ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public SysDictItem getSysDictItem(long id) throws ApplicationException;

	/**
	 * 根据字典类型和�?  获取class属�?
	 * @param typeCode
	 * @param itemCode
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	public String getItemClass(String typeCode, String itemCode) throws ApplicationException;
}
