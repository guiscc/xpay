package com.ninefbank.smallpay.admin.sysmgr.dao;

import com.ninefbank.smallpay.admin.sysmgr.entity.SysRoleMenuRel;

import java.util.List;
import java.util.Map;

/**
 * 角色/岗位和菜单关系数据访问接�?
 * 
 * @author wangzhenlei
 * 
 */
public interface SysRoleMenuRelMapper extends BaseMapper {


	public List<SysRoleMenuRel> queryByParams(Map<String, Object> params) throws Exception;
	
	public void insertRoleMenuRel(SysRoleMenuRel roleMenuRel) throws Exception;
	
	public void delByRoleId(long roleId) throws Exception;
	
}
