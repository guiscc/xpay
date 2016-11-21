package com.ninefbank.smallpay.admin.sysmgr.web;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.common.constants.AppConstants;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysMenu;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysUser;
import com.ninefbank.smallpay.admin.sysmgr.service.XpaySysMenuService;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.ninefbank.smallpay.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单页面请求处理
 * 
 * @author wangzhenlei
 *
 */
@Controller
@RequestMapping("sysMenu")
public class SysMenuController extends BaseController {
	
	@Autowired
	private XpaySysMenuService sysMenuService;

	/**
	 * 分页查询菜单
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	@RequestMapping(value = "/querySysMenu", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> querySysMenu(@RequestParam Integer pageSize, @RequestParam Integer page, @RequestParam String condition) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		PageBounds pageBounds = buildPageBounds(pageSize, page, true);
		
		if (null != condition && !"".equals(condition)) {
			params.put("menuName", "%"+condition+"%");
			params.put("parent", condition);
		}
		PageList<SysMenu> ret = sysMenuService.queryWithPage(params, pageBounds);
		
		return buildResult(pageSize, page, ret);
	}
	
	/**
	 * 新增菜单
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addSysMenu", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSysMenu(@RequestBody SysMenu sysMenu)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysMenuService.saveSysMenu(sysMenu);
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 更新菜单
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateSysMenu", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateSysMenu(@RequestBody SysMenu sysMenu)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysMenuService.updateSysMenu(sysMenu);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除菜单
	 * @param id 菜单ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/delSysMenu", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delSysMenu(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		sysMenuService.delSysMenu(id);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 根据ID获取菜单
	 * @param id 菜单ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getSysMenu", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSysMenu(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysMenu data = sysMenuService.getSysMenu(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}

	/**
	 * 获取菜单�?
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getSysMenuTree", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getMenuTree() throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TreeNode> data = sysMenuService.getMenuTree(true, null);
		result.put("success", true);
		result.put("data", data);
		return result;
	}

	/**
	 * 获取二级菜单�?
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getSysMenuTreeLeaf1", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getMenuTreeLeaf1() throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TreeNode> data = sysMenuService.getMenuTree(false, null);
		result.put("success", true);
		result.put("data", data);
		return result;
	}

	/**
	 * 查询角色授权菜单
	 * @param roleId 角色ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getCurrentRoleMenus", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getRoleMenus(HttpServletRequest request) throws ApplicationException {
		SysUser currentLoginUser = (SysUser)request.getSession().getAttribute(AppConstants.CURRENT_LOGIN_USER);
		if(null == currentLoginUser || null == currentLoginUser.getCurrentRole()){
			throw new ApplicationException("wrong.login");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		List<TreeNode> data = sysMenuService.getRoleMenus(currentLoginUser.getCurrentRole().getId());
        //只获取运营分析相关菜单
        List<TreeNode> analysisData = new ArrayList<TreeNode>();
       /* for(TreeNode node:data){
            if ("17".equals(node.getId())){
                analysisData.add(node);
            }
        }*/
		result.put("success", true);
		result.put("data", data);
		return result;
	}
	/**
	 * 登录超时
	 * @throws java.io.IOException
	 */
	@RequestMapping(value = "/sessiontimeout", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> sessiontimeout(HttpServletRequest request,HttpServletResponse response) throws ApplicationException, IOException {
	              
	        Map<String, Object> result = new HashMap<String, Object>();
	         HttpSession session = request.getSession(false);
	        if(session == null) {
	        	result.put("success", true);
	        }else{
	        	result.put("no", false);
	        }
			return result;
	}
}
