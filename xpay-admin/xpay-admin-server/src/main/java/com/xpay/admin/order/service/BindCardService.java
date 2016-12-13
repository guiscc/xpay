package com.xpay.admin.order.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.entity.CifBindCard;

import java.util.Map;

public interface BindCardService {
	/**
	 * 查询交易列表
	 * 
	 * @param params
	 * @return
	 */
	public PageList<CifBindCard> queryList(Map<String, Object> params, PageBounds pageBounds);

}
