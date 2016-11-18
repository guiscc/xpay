package com.ninefbank.smallpay.admin.order.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.order.dao.CifBindCardMapper;
import com.ninefbank.smallpay.admin.order.dao.PayOrderMapper;
import com.ninefbank.smallpay.admin.order.entity.CifBindCard;
import com.ninefbank.smallpay.admin.order.entity.PayOrder;
import com.ninefbank.smallpay.admin.order.service.BindCardService;
import com.ninefbank.smallpay.admin.order.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("cardService")
public class BindCardServiceImpl implements BindCardService {

	@Autowired
	private CifBindCardMapper bindCardMapper;
	
	@Override
	public PageList<CifBindCard> queryList(Map<String, Object> params, PageBounds pageBounds) {
		PageList<CifBindCard> bankList = bindCardMapper.selectByParams(params, pageBounds);
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