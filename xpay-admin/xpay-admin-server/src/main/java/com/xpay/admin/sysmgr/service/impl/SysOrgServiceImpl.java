package com.xpay.admin.sysmgr.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.common.exception.XpayAdminException;
import com.xpay.admin.sysmgr.dao.SysOrgMapper;
import com.xpay.admin.sysmgr.entity.SysOrg;
import com.xpay.admin.sysmgr.service.XpaySysOrgService;
import com.xpay.admin.sysmgr.web.TreeNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机构服务实现
 * 
 * @author wangzhenlei
 *
 */
@Service("sysOrgService")
@Transactional(readOnly = true)
public class SysOrgServiceImpl implements XpaySysOrgService {

	private static Log logger = LogFactory.getLog(SysOrgServiceImpl.class);

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void saveSysOrg(SysOrg sysOrg)
			throws XpayAdminException {
		try{
			sysOrgMapper.insertSysOrg(sysOrg);
		}catch(Exception e){
			logger.error("添加机构失败", e);
			throw new XpayAdminException("error.dictitem.add");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void updateSysOrg(SysOrg sysOrg)
			throws XpayAdminException {
		try{
			sysOrgMapper.updateSysOrg(sysOrg);
		}catch(Exception e){
			logger.error("更新机构失败", e);
			throw new XpayAdminException("error.dictitem.update");
		}
	}

	@Transactional(readOnly = false, rollbackFor=Exception.class )
	public void delSysOrg(long id) throws XpayAdminException {
		try{
			sysOrgMapper.delSysOrg(id);
		}catch(Exception e){
			logger.error("删除机构失败", e);
			throw new XpayAdminException("error.dictitem.delete");
		}
	}
	
	public SysOrg getSysOrg(long id) throws XpayAdminException {
		try{
			return sysOrgMapper.getSysOrgById(id);
		}catch(Exception e){
			logger.error("获取机构失败", e);
			throw new XpayAdminException("error.sysOrg.get");
		}
	}

	public PageList<SysOrg> queryWithPage( Map<String, Object> params, PageBounds pageBounds) throws XpayAdminException {
		try{
			return sysOrgMapper.queryWithPage(params, pageBounds);
		} catch (Exception e) {
			logger.error("查询机构失败", e);
			throw new XpayAdminException("error.sysorg.query");
		}
	}

	/* (non-Javadoc)
	 * @see com.wangzhenlei.ssm.sysmgr.service.XpaySysOrgService#getSysOrgTree(long)
	 */
	public List<TreeNode> getSysOrgTree(long parent) throws XpayAdminException {
		
		List<TreeNode> ret = new ArrayList<TreeNode>();
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parent", parent);
		try {
			List<SysOrg> orgs = sysOrgMapper.queryByParams(params);
			for(SysOrg org : orgs){
				TreeNode treeNode = new TreeNode();
				treeNode.setId(String.valueOf(org.getId()));
				treeNode.setText(org.getOrgName());
				treeNode.setState("closed");
				if(org.getHasChild() == "1"){
					treeNode.setChildren(getSysOrgTree(org.getId()));
				}
				ret.add(treeNode);
			}
		} catch (Exception e) {
			logger.error("查询机构失败", e);
			throw new XpayAdminException("error.sysorg.query");
		}
		return ret;
	}

}
