package com.ninefbank.smallpay.admin.sysmgr.web;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysOrg;
import com.ninefbank.smallpay.admin.sysmgr.service.XpaySysOrgService;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.ninefbank.smallpay.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 机构页面请求处理
 * 
 * @author wangzhenlei
 *
 */
@Controller
@RequestMapping("sysOrg")
public class SysOrgController extends BaseController {
	
	@Autowired
	private XpaySysOrgService sysOrgService;

	/**
	 * 分页查询机构
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/querySysOrg", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> querySysOrg(@RequestParam Integer pageSize, @RequestParam Integer currentPageNum, @RequestParam String condition) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		PageBounds pageBounds = buildPageBounds(pageSize, currentPageNum, true);
		
		if (null != condition && !"".equals(condition)) {
			params.put("roleName", "%"+condition+"%");
			params.put("parent", condition);
		}
		PageList<SysOrg> ret = sysOrgService.queryWithPage(params, pageBounds);
		
		return buildResult(pageSize, currentPageNum, ret);
	}
	
	/**
	 * 新增机构
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addSysOrg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSysOrg(@RequestBody SysOrg sysOrg)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysOrgService.saveSysOrg(sysOrg);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 更新机构
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateSysOrg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateSysOrg(@RequestBody SysOrg sysOrg)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysOrgService.updateSysOrg(sysOrg);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除机构
	 * @param id 机构ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/delSysOrg", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delSysOrg(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysOrgService.delSysOrg(id);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 根据ID获取机构
	 * @param id 机构ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getSysOrg", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSysOrg(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysOrg data = sysOrgService.getSysOrg(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}
	
	@RequestMapping(value = "/getSysOrgTree", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getDictTree(long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TreeNode> data = sysOrgService.getSysOrgTree(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}

}
