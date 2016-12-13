package com.xpay.admin.bank.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCodeDict;

public interface BankBaseService {
	/**
	 * 查询银行卡基础信息列表
	 * 
	 * @param code
	 * @return
	 */
	public PageList<BankCodeDict> queryBankBaseList(Map<String, Object> params, PageBounds pageBounds);

	/**
	 * 新增银行卡基础信息
	 * 
	 * @param ppe
	 * @return
	 */
	public Integer insertBankBaseInfo(BankCodeDict dict);

	/**
	 * 更新银行卡基础信息
	 * 
	 * @param ppe
	 */
	public void updateBankBaseInfo(BankCodeDict dict);

	/**
	 * 删除银行卡基础信息
	 * 
	 * @param id
	 */
	public void deleteBankBaseInfo(Long id);
}
