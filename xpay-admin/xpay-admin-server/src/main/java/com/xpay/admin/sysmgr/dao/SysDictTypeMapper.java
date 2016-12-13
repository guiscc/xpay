package com.xpay.admin.sysmgr.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.sysmgr.entity.SysDictType;

import java.util.List;
import java.util.Map;

/**
 * 字典类型数据访问接口
 * 
 * @author wangzhenlei
 * 
 */
public interface SysDictTypeMapper extends BaseMapper {
	
	public PageList<SysDictType> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据ID获取字典类型
	 * @param id 字典类型ID
	 * @return
	 * @throws Exception
	 */
	public SysDictType getDictTypeById(long id) throws Exception;
	
	/**
	 * 根据查询条件查询�?��字典类型
	 * @param params 查询条件参数
	 * @return
	 * @throws Exception
	 */
	public List<SysDictType> queryByParams(Map<String, Object> params) throws Exception;

	/**
	 * 插入字典类型
	 * @param dictType
	 * @return
	 * @throws Exception
	 */
	public Long insertDictType(SysDictType dictType) throws Exception;

	/**
	 * 修改字典类型
	 * @param dictType
	 * @return
	 * @throws Exception
	 */
	public Long updateDictType(SysDictType dictType) throws Exception;

	/**
	 * 删除字典类型
	 * @param id
	 * @throws Exception
	 */
	public void delDictType(Long id) throws Exception;

}
