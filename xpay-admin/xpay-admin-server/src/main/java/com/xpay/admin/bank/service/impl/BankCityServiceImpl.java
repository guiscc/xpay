package com.xpay.admin.bank.service.impl;

import java.util.Map;

import com.xpay.admin.bank.dao.BankCityInfoMapper;
import com.xpay.admin.bank.service.BankCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCityInfo;

@Service("bCityService")
public class BankCityServiceImpl implements BankCityService {

	@Autowired
    BankCityInfoMapper bankCityInfoMapper;
	
	@Override
	public PageList<BankCityInfo> queryBankCitiesList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<BankCityInfo> list = bankCityInfoMapper.selectByPrimaryKey(params, pageBounds);
		return list;
	}

	@Override
	public Integer insertBankCitiesInfo(BankCityInfo info) {
		Integer index = bankCityInfoMapper.insertSelective(info);
		return index;
	}

	@Override
	public void updateBankCitiesInfo(BankCityInfo info) {
		bankCityInfoMapper.updateByPrimaryKeySelective(info);
	}

	@Override
	public void deleteBankCitiesInfo(Long id) {
		// TODO Auto-generated method stub
	}
}