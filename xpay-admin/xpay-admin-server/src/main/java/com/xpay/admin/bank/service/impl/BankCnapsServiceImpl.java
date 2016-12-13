package com.xpay.admin.bank.service.impl;

import java.util.Map;

import com.xpay.admin.bank.dao.BankCnapsDictMapper;
import com.xpay.admin.bank.entity.BankCnapsDict;
import com.xpay.admin.bank.service.BankCnapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service("bCnapsService")
public class BankCnapsServiceImpl implements BankCnapsService {
	
	@Autowired
    BankCnapsDictMapper bankCnapsDictMapper;

	@Override
	public PageList<BankCnapsDict> queryBankCnapsList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<BankCnapsDict> list = bankCnapsDictMapper.selectByPrimaryKey(params, pageBounds);
		return list;
	}

	@Override
	public Integer insertBankCnapsInfo(BankCnapsDict dict) {
		Integer index = bankCnapsDictMapper.insertSelective(dict);
		return index;
	}

	@Override
	public void updateBankCnapsInfo(BankCnapsDict dict) {
		bankCnapsDictMapper.updateByPrimaryKeySelective(dict);
	}

	@Override
	public void deleteBankCnapsInfo(Long id) {
		
	}
}