package com.xpay.admin.sysmgr.dao;

import com.xpay.admin.sysmgr.entity.SysUserRoleRel;

import java.util.List;
import java.util.Map;

/**
 * 系统用户和角�?岗位关系数据访问接口
 * 
 * @author wangzhenlei
 * 
 */
public interface SysUserRoleRelMapper extends BaseMapper {


	public List<SysUserRoleRel> queryByParams(Map<String, Object> params) throws Exception;
	
	public void insertUserRoleRel(SysUserRoleRel userRoleRel) throws Exception;
	
	public void delByUserId(long userId) throws Exception;
}
