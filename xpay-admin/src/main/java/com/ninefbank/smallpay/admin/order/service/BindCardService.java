package com.ninefbank.smallpay.admin.order.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.order.entity.CifBindCard;
import com.ninefbank.smallpay.admin.order.entity.PayOrder;

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
