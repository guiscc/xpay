package com.xpay.admin.bank.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.dao.BankCardBinDictMapper;
import com.xpay.admin.bank.entity.BankCardBinDict;
import com.xpay.admin.bank.service.BankCardBinService;

@Service("bcBinService")
public class BankCardBinServiceImpl implements BankCardBinService{

	@Autowired
	private BankCardBinDictMapper bankCardBinDictMapper;
	
	@Override
	public PageList<BankCardBinDict> queryBankBinList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<BankCardBinDict> bankList = bankCardBinDictMapper.selectByPrimaryKey(params, pageBounds);
		return bankList;
	}

	@Override
	public Integer insertBankBinInfo(BankCardBinDict dict) {
		Integer index = bankCardBinDictMapper.insertSelective(dict);
		return index;
	}

	@Override
	public void updateBankBinInfo(BankCardBinDict dict) {
		bankCardBinDictMapper.updateByPrimaryKeySelective(dict);
	}

	@Override
	public void deleteBankBinInfo(Long id) {
		// TODO Auto-generated method stub
	}
}