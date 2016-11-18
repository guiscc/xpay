package com.ninefbank.smallpay.admin.bank.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.bank.entity.BankCardBinDict;

public interface BankCardBinService {
	/**
	 * 查询银行卡BIN列表
	 * 
	 * @param code
	 * @return
	 */
	public PageList<BankCardBinDict> queryBankBinList(Map<String, Object> params, PageBounds pageBounds);

	/**
	 * 新增银行卡BIN
	 * 
	 * @param ppe
	 * @return
	 */
	public Integer insertBankBinInfo(BankCardBinDict dict);

	/**
	 * 更新银行卡BIN
	 * 
	 * @param ppe
	 */
	public void updateBankBinInfo(BankCardBinDict info);

	/**
	 * 删除银行卡BIN
	 * 
	 * @param id
	 */
	public void deleteBankBinInfo(Long id);
}
