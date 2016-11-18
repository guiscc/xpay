package com.ninefbank.smallpay.admin.sysmgr.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author wangzhenlei
 */
public interface SysUserMapper extends BaseMapper {
	
	public List<SysUser> queryByParams(Map<String, Object> params) throws Exception;
	
	/**
	 * 分页条件查询用户
	 * @param params
	 * @param pageBounds
	 * @return
	 * @throws Exception
	 */
	public PageList<SysUser> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public SysUser getSysUserById(long id) throws Exception;
	
	/**
	 * 插入用户
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public Long insertSysUser(SysUser sysUser) throws Exception;

	/**
	 * 修改用户
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public Long updateSysUser(SysUser sysUser) throws Exception;

	/**
	 * 删除用户
	 * @param id
	 * @throws Exception
	 */
	public void delSysUser(Long id) throws Exception;
	/**
	 * 修改用户密码
	 * @param id
	 * @throws Exception
	 */
	public void updatePwd(Map<String, Object> params) throws Exception;

}
