package com.xpay.admin.sysmgr.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.entity.SysDictItem;
import com.xpay.admin.sysmgr.web.DictCache;

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
	 * 获取字典项名
	 * @param typeCode 字典类型代码
	 * @param itemCode 字典项代
	 * @return 字典项名
	 */
	public String getItemName(String typeCode, String itemCode) throws XpayAdminException;

	/**
	 * 获取字典
	 * @param typeCode 字典类型代码
	 * @return 字典项集
	 */
	public List<SysDictItem> getDictItems(String typeCode) throws XpayAdminException;


	/**
	 * 获取字典数据（包含所有的字典类型和字典项�?
	 * @return
	 */
	public DictCache getAll() throws XpayAdminException;

	/**
	 *
	 * @return
	 * @throws XpayAdminException
	 */
	public Map<String, Object> getMap() throws XpayAdminException;


	/**
	 * 分页查询字典
	 * @return
	 */
	public PageList<SysDictItem> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException;


	/**
	 * 增加字典
	 * @param dictItem
	 */
	public void saveSysDictItem(SysDictItem dictItem) throws XpayAdminException;

	/**
	 * 更新字典项信
	 * @param dictItem
	 */
	public void updateSysDictItem(SysDictItem dictItem) throws XpayAdminException;

	/**
	 * 删除字典项信
	 * @param id 字典项ID
	 */
	public void delSysDictItem(long id) throws XpayAdminException;

	/**
	 * 根据ID获取字典项信
	 * @param id 字典项ID
	 * @return
	 */
	public SysDictItem getSysDictItem(long id) throws XpayAdminException;

	/**
	 * 根据字典类型和  获取class属
	 * @param typeCode
	 * @param itemCode
	 * @return
	 */
	public String getItemClass(String typeCode, String itemCode) throws XpayAdminException;
}
