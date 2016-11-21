package com.ninefbank.smallpay.admin.sysmgr.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysRole;

import java.util.Map;

/**
 * 角色/岗位数据访问接口
 * 
 * @author wangzhenlei
 * 
 */
public interface SysRoleMapper extends BaseMapper {

	/**
	 * 分页条件查询角色/岗位
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<SysRole> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据ID获取角色/岗位
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysRole getSysRoleById(long id) throws Exception;
	
	/**
	 * 插入角色/岗位
	 * @param sysRole
	 * @return
	 * @throws Exception
	 */
	public Long insertSysRole(SysRole sysRole) throws Exception;

	/**
	 * 修改角色/岗位
	 * @param sysRole
	 * @return
	 * @throws Exception
	 */
	public Long updateSysRole(SysRole sysRole) throws Exception;

	/**
	 * 删除角色/岗位
	 * @param id
	 * @throws Exception
	 */
	public void delSysRole(Long id) throws Exception;

}
