package com.xpay.admin.common.control;

import java.util.HashMap;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.xpay.admin.common.model.PageModel;

public class WebController extends BaseController{

	public Map<String, Object> buildResult(Integer pageSize, Integer currentPageNum, PageModel<?> model){
		if(null == pageSize){
			pageSize = 10;
		}
		if(null == currentPageNum){
			currentPageNum = 1;
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		
		if(null != model && null != model.getPaginator()){
			result.put("rows", model.getResultList());
			Paginator paginator = model.getPaginator();
			result.put("total", paginator.getTotalCount());
			result.put("totalPages", paginator.getTotalPages());
		}else{
			result.put("rows", null);
			result.put("total", 0);
			result.put("totalPages", 0);
		}
		return result;
	}
}
