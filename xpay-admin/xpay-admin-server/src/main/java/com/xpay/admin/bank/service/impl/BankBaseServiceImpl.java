package com.xpay.admin.bank.service.impl;

import java.util.Map;

import com.xpay.admin.bank.dao.BankCodeDictMapper;
import com.xpay.admin.bank.entity.BankCodeDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.service.BankBaseService;

@Service("bBaseService")
public class BankBaseServiceImpl implements BankBaseService {

	@Autowired
    BankCodeDictMapper bankCodeDictMapper;
	
	@Override
	public PageList<BankCodeDict> queryBankBaseList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<BankCodeDict> list = bankCodeDictMapper.selectByPrimaryKey(params, pageBounds);
		return list;
	}

	@Override
	public Integer insertBankBaseInfo(BankCodeDict dict) {
		Integer index = bankCodeDictMapper.updateByPrimaryKeySelective(dict);
		return index;
	}

	@Override
	public void updateBankBaseInfo(BankCodeDict dict) {
		bankCodeDictMapper.updateByPrimaryKeySelective(dict);
	}

	@Override
	public void deleteBankBaseInfo(Long id) {
		// TODO Auto-generated method stub
	}
}