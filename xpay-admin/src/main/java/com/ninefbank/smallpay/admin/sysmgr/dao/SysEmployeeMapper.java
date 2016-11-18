package com.ninefbank.smallpay.admin.sysmgr.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysEmployee;

import java.util.Map;

/**
 * 员工数据访问接口
 * 
 * @author wangzhenlei
 * 
 */
public interface SysEmployeeMapper extends BaseMapper {

	/**
	 * 分页条件查询员工
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<SysEmployee> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据ID获取员工
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysEmployee getSysEmployeeById(long id) throws Exception;
	
	/**
	 * 插入员工
	 * @param sysEmployee
	 * @return
	 * @throws Exception
	 */
	public Long insertSysEmployee(SysEmployee sysEmployee) throws Exception;

	/**
	 * 修改员工
	 * @param sysEmployee
	 * @return
	 * @throws Exception
	 */
	public Long updateSysEmployee(SysEmployee sysEmployee) throws Exception;

	/**
	 * 删除员工
	 * @param id
	 * @throws Exception
	 */
	public void delSysEmployee(Long id) throws Exception;

}
