package com.xpay.admin.bank.controller;

import java.util.HashMap;
import java.util.Map;

import com.xpay.admin.bank.entity.BankCardBinDict;
import com.xpay.admin.bank.entity.BankCodeDict;
import com.xpay.admin.common.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xpay.admin.bank.service.BankBaseService;

@Controller
@RequestMapping("bankCardBase")
public class BankBaseController extends BaseController {

	@Autowired
	private BankBaseService bBaseService;

	@RequestMapping(value = "getBankInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getBankInfo(@RequestParam Integer rows, Integer page, BankCardBinDict dict) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = Common.DataValidation(dict);
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		PageList<BankCodeDict> list = bBaseService.queryBankBaseList(map, pageBounds);
		Map<String,Object> re = buildResult(rows, page, list);
		return re;
	}

	@RequestMapping(value = "insBankInfo", method = RequestMethod.POST)
	public @ResponseBody String insBankInfo(@RequestParam Integer rows, Integer page, BankCodeDict dict) {
		bBaseService.insertBankBaseInfo(dict);

		return "";
	}

	@RequestMapping(value = "updBankInfo", method = RequestMethod.POST)
	public @ResponseBody String updBankInfo(@RequestParam Integer rows, Integer page, BankCodeDict dict) {
		bBaseService.updateBankBaseInfo(dict);

		return "";
	}
}