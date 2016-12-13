package com.xpay.admin.bank.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCnapsDict;

public interface BankCnapsService {
	/**
	 * 查询银行卡联行号列表
	 * 
	 * @param code
	 * @return
	 */
	public PageList<BankCnapsDict> queryBankCnapsList(Map<String, Object> params, PageBounds pageBounds);

	/**
	 * 新增银行卡联行号
	 * 
	 * @param ppe
	 * @return
	 */
	public Integer insertBankCnapsInfo(BankCnapsDict ppe);

	/**
	 * 更新银行卡联行号
	 * 
	 * @param ppe
	 */
	public void updateBankCnapsInfo(BankCnapsDict ppe);

	/**
	 * 删除银行卡联行号
	 * 
	 * @param id
	 */
	public void deleteBankCnapsInfo(Long id);
}
