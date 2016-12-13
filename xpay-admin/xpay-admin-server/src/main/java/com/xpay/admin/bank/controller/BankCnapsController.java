package com.xpay.admin.bank.controller;

import java.util.HashMap;
import java.util.Map;

import com.xpay.admin.bank.service.BankCnapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.bank.entity.BankCnapsDict;
import com.xpay.admin.common.Common;
import com.ninefbank.smallpay.common.web.BaseController;

@Controller
@RequestMapping("bankCardCnaps")
public class BankCnapsController extends BaseController{

	@Autowired
	private BankCnapsService bCnapsService;

	@RequestMapping(value = "getBankInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getBankInfo(@RequestParam Integer rows, Integer page, BankCnapsDict dict) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = Common.DataValidation(dict);
		PageBounds pageBounds = buildPageBounds(rows, page, true);
		PageList<BankCnapsDict> list = bCnapsService.queryBankCnapsList(map, pageBounds);
		Map<String,Object> re = buildResult(rows, page, list);
		return re;
	}

	@RequestMapping(value = "insBankInfo", method = RequestMethod.POST)
	public @ResponseBody String insBankInfo(@RequestParam Integer rows, Integer page, BankCnapsDict dict) {
		bCnapsService.insertBankCnapsInfo(dict);
		return "";
	}

	@RequestMapping(value = "updBankInfo", method = RequestMethod.POST)
	public @ResponseBody String updBankInfo(@RequestParam Integer rows, Integer page, BankCnapsDict dict) {
		bCnapsService.updateBankCnapsInfo(dict);
		return "";
	}
}