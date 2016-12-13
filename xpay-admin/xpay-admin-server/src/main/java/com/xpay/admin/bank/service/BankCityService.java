package com.xpay.admin.bank.service;

import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCityInfo;

public interface BankCityService {
	/**
	 * 查询银行卡城市信息列表
	 * 
	 * @param code
	 * @return
	 */
	public PageList<BankCityInfo> queryBankCitiesList(Map<String, Object> params, PageBounds pageBounds);

	/**
	 * 新增银行卡城市信息
	 * 
	 * @param ppe
	 * @return
	 */
	public Integer insertBankCitiesInfo(BankCityInfo ppe);

	/**
	 * 更新银行卡城市信息
	 * 
	 * @param ppe
	 */
	public void updateBankCitiesInfo(BankCityInfo ppe);

	/**
	 * 删除银行卡城市信息
	 * 
	 * @param id
	 */
	public void deleteBankCitiesInfo(Long id);
}
