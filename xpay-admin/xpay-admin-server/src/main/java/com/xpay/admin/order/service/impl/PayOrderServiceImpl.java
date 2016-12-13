package com.xpay.admin.order.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.order.dao.PayOrderMapper;
import com.xpay.admin.order.entity.PayOrder;
import com.xpay.admin.order.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("xpayOrderService")
public class PayOrderServiceImpl implements PayOrderService {

	@Autowired
	private PayOrderMapper payOrderMapper;
	
	@Override
	public PageList<PayOrder> queryList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<PayOrder> bankList = payOrderMapper.selectByParams(params, pageBounds);
		return bankList;
	}

//	@Override
//	public Integer insertBankBinInfo(BankCardBinDict dict) {
//		Integer index = bankCardBinDictMapper.insertSelective(dict);
//		return index;
//	}

//	@Override
//	public void updateBankBinInfo(BankCardBinDict dict) {
//		bankCardBinDictMapper.updateByPrimaryKeySelective(dict);
//	}

//	@Override
//	public void deleteBankBinInfo(Long id) {
		// TODO Auto-generated method stub
//	}
}