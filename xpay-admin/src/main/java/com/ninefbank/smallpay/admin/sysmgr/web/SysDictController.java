package com.ninefbank.smallpay.admin.sysmgr.web;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysDictItem;
import com.ninefbank.smallpay.admin.sysmgr.entity.SysDictType;
import com.ninefbank.smallpay.admin.sysmgr.service.XpaySysDictItemService;
import com.ninefbank.smallpay.admin.sysmgr.service.XpaySysDictTypeService;
import com.ninefbank.smallpay.common.exception.ApplicationException;
import com.ninefbank.smallpay.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典类型和字典项页面清楚处理
 * 
 * @author wangzhenlei
 *
 */
@Controller
@RequestMapping("dict")
public class SysDictController extends BaseController {
	
	@Autowired
	private XpaySysDictItemService dictItemService;

	@Autowired
	private XpaySysDictTypeService dictTypeService;
	
	/**
	 * 根据字典类型编码和字典项编码获取字典项名�?
	 * @param typeCode 字典类型编码
	 * @param itemCode 字典项编�?
	 * @return 字典项名�?
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "getItemName", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getItemName(@RequestParam String typeCode,
			@RequestParam String itemCode) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		String data = dictItemService.getItemName(typeCode, itemCode);
		ret.put("success", true);
		ret.put("data", data);
		return ret;
	}

	/**
	 * 根据字典类型编码和字典项编码获取字典项名�?
	 * @param typeCode 字典类型编码
	 * @param itemCode 字典项编�?
	 * @return 字典项名�?
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "getItemClass", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getItemClass(@RequestParam String typeCode,
			@RequestParam String itemCode) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		String data = dictItemService.getItemClass(typeCode, itemCode);
		ret.put("success", true);
		ret.put("data", data);
		return ret;
	}

	/**
	 * 根据字典类型编码，获取该类型的所有字典项
	 * @param typeCode 字典类型编码
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "getDictItems", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getDictItems(@RequestParam String typeCode) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		List<SysDictItem> data = dictItemService.getDictItems(typeCode);
		ret.put("success", true);
		ret.put("data", data);
		return ret;
	}

	/**
	 * 从缓存中获取�?��字典数据，用户也页面端进行字典数据缓�?
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "getAllFromCache", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll() throws ApplicationException {
		Map<String, Object> dictData = dictItemService.getMap();
		return this.buildResult(dictData);
	}

	/**
	 * 分页查询字典�?
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryDictItem", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> queryDictItem(@RequestParam Integer pageSize, @RequestParam Integer page, @RequestParam String condition) {

		Map<String, Object> params = new HashMap<String, Object>();

		PageBounds pageBounds = buildPageBounds(pageSize, page, true);

		if (null != condition && !"".equals(condition)) {
			params.put("typeCode", "%"+condition+"%");
		}
		PageList<SysDictItem> ret = dictItemService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, page, ret);
	}

	/**
	 * 新增字典�?
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addDictItem", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addDictItem(@RequestBody SysDictItem dictType)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dictItemService.saveSysDictItem(dictType);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 更新字典�?
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateDictItem", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateDictItem(@RequestBody SysDictItem dictType)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dictItemService.updateSysDictItem(dictType);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除字典�?
	 * @param id 字典项ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/delDictItem", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delDictItem(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dictItemService.delSysDictItem(id);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 根据ID获取字典�?
	 * @param id 字典项ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getDictItem", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getDictItem(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysDictItem data = dictItemService.getSysDictItem(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}




	////////////////////////////////////////////////字典类型处理////////////////////////////////////////////////////////////
	/**
	 * 分页查询字典类型
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryDictType", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> queryDictType(@RequestParam Integer pageSize, @RequestParam Integer page, @RequestParam String condition) {

		Map<String, Object> params = new HashMap<String, Object>();

		PageBounds pageBounds = buildPageBounds(pageSize, page, true);

		if (null != condition && !"".equals(condition)) {
			params.put("condition", "%"+condition+"%");
		}
		PageList<SysDictType> ret = dictTypeService.queryWithPage(params, pageBounds);

		return buildResult(pageSize, page, ret);
	}

	/**
	 * 新增字典类型
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/addDictType", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addDictType(@RequestBody SysDictType dictType)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dictTypeService.saveSysDictType(dictType);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 更新字典类型
	 * @param p2pUser
	 * @return
	 */
	@RequestMapping(value = "/updateDictType", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateDictType(@RequestBody SysDictType dictType)throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dictTypeService.updateSysDictType(dictType);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 删除字典类型
	 * @param id 字典类型ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/delDictType", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> delDictType(@RequestParam long id) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		dictTypeService.delSysDictType(id);
		ret.put("success", true);
		return ret;
	}

	/**
	 * 根据ID获取字典类型
	 * @param id 字典类型ID
	 * @return
	 * @throws com.ninefbank.smallpay.common.exception.ApplicationException
	 */
	@RequestMapping(value = "/getDictType", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getDictType(@RequestParam long id) throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		SysDictType data = dictTypeService.getSysDictType(id);
		result.put("success", true);
		result.put("data", data);
		return result;
	}
	
	
	@RequestMapping(value = "/getDictTree", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getDictTree() throws ApplicationException {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TreeNode> data = dictTypeService.getDictTypeTree();
		result.put("success", true);
		result.put("data", data);
		return result;
	}

}
