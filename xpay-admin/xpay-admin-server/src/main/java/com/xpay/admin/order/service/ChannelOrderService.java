package com.xpay.admin.order.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.entity.ChannelOrder;

import java.util.Map;

public interface ChannelOrderService {
	/**
	 * 查询交易列表
	 * 
	 * @param params
	 * @return
	 */
	public PageList<ChannelOrder> queryList(Map<String, Object> params, PageBounds pageBounds);

	/**
	 * 新增银行卡BIN
	 * 
	 * @param ppe
	 * @return
	 */
//	public Integer insertBankBinInfo(BankCardBinDict dict);

	/**
	 * 更新银行卡BIN
	 * 
	 * @param ppe
	 */
//	public void updateBankBinInfo(BankCardBinDict info);

	/**
	 * 删除银行卡BIN
	 * 
	 * @param id
	 */
//	public void deleteBankBinInfo(Long id);
}
