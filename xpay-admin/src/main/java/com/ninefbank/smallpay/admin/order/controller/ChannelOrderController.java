package com.ninefbank.smallpay.admin.order.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ninefbank.smallpay.admin.bank.entity.BankCardBinDict;
import com.ninefbank.smallpay.admin.common.Common;
import com.ninefbank.smallpay.admin.order.entity.ChannelOrder;
import com.ninefbank.smallpay.admin.order.entity.TradeOrder;
import com.ninefbank.smallpay.admin.order.service.ChannelOrderService;
import com.ninefbank.smallpay.admin.order.service.TradeOrderService;
import com.ninefbank.smallpay.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("channel")
public class ChannelOrderController extends BaseController{

	@Autowired
	private ChannelOrderService xchannelOrderService;

	@RequestMapping(value = "queryList", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getBankInfo(@RequestParam Integer rows, Integer page, ChannelOrder dict) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = Common.DataValidation(dict);
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		PageList<ChannelOrder> list = xchannelOrderService.queryList(map, pageBounds);
		Map<String,Object> re = buildResult(rows, page, list);
		return re;
	}

//	@RequestMapping(value = "insBankInfo", method = RequestMethod.POST)
//	public @ResponseBody String insBankInfo(@RequestParam Integer rows, Integer page, BankCardBinDict dict) {
//        xtradeOrderService.insertBankBinInfo(dict);
//
//		return "";
//	}
//
//	@RequestMapping(value = "updBankInfo", method = RequestMethod.POST)
//	public @ResponseBody String updBankInfo(@RequestParam Integer rows, Integer page, BankCardBinDict dict) {
//        xtradeOrderService.updateBankBinInfo(dict);
//
//		return "";
//	}
}