package com.xpay.admin.common;

/**
 * @author wangzhenlei
 * 
 */
public interface XpayAdminConstants {
	public static final String MD5_SA = "djldjgajdglahgwieinxkgowgbssog";//MD5密码加密盐值
	public static final String CHARSET_GBK = "GBK";
	public static final String CHARSET_GB2312 = "GB2312";
	public static final String CHARSET_UTF8 = "UTF-8";

	public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_17 = "yyyyMMddHHmmssSSS";
	public static final String DATE_FORMAT_18 = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DATE_FORMAT_14 = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_12 = "yyMMddHHmmss";
	public static final String DATE_FORMAT_8 = "yyyyMMdd";
	public static final String DATE_FORMAT_6 = "yyyyMM";
	public static final String DATE_FORMAT_PATH = "yyyy/MM/dd";
	public static final String DATE_FORMAT_10 = "yyyy-MM-dd";
	
	//加密方式
	public static final String ENCRYPT_TYPE_DES = "DES";
	public static final String ENCRYPT_TYPE_3DES = "DES3";
	
	// 微支付平台系统编号，生成流水号时前两位代表系统编号
	public static final String SYSTEM_API = "10";
	public static final String SYSTEM_TRADE = "10";
	public static final String SYSTEM_PAYMENT = "12";
	public static final String SYSTEM_CHANNEL = "13";
	public static final String SYSTEM_ACCOUNT = "14";
	public static final String SYSTEM_CLEAR = "15";
	public static final String SYSTEM_ADMIN = "16";
	public static final String SYSTEM_REPORT = "17";
	public static final String SYSTEM_MONITOR = "18";
	public static final String SYSTEM_CARD = "20";

	public static final String SYSTEM_NEW_CUSTOMER = "32";

	// 客户账户生成系统编号标示
	public static final String SYSTEM_CUSTOMER_NO = "30";
	// 用户账户生成系统编号标示
	public static final String SYSTEM_USERID_NO = "31";
	// 业务用户账户生成系统编号标示
	public static final String SYSTEM_BIZUSERID_NO = "32";

	// 支付方式
	public static final String PAY_TYPE_KJ = "04";// 快捷
	public static final String PAY_TYPE_WG = "01";// 网关
	public static final String PAY_TYPE_YE = "00";// 余额
	public static final String PAY_TYPE_DK = "02";// 代扣
	public static final String PAY_TYPE_PAYMENT = "03";// 代发

	public static final String TRADE_TYPE_VER_CARD = "05";// 验证银行卡
	public static final String TRADE_TYPE_REAL_NAME = "06";// 实名认证

	public static final String QUERY_DK_ORDER = "01"; // 代扣订单查询
	public static final String QUERY_DF_ORDER = "02"; // 代付订单查询
	public static final String QUERY_TP_ORDER = "03"; // 退票订单查询
	
	//交换业务
	public static final String SERVICE_PAY = "servicePay";//代扣
	public static final String SERVICE_QUICK_PAY = "serviceQuickPay";//快捷
	public static final String SERVICE_PAY_WITH_QIC = "servicePayAndQic";//代扣和快捷
	public static final String SERVICE_PAYMENT = "serivcePayment";//代付
	public static final String SERVICE_INDAUTH_ONLY = "serivceIndAuthOnly";//纯鉴权
	public static final String SERVICE_INDAUTH_SDM = "serivceIndAuthSDM";//发送短信鉴权
	
	public static final String CHANNEL_INFO = "channelInfo";//chanel 中渠道信息在redis中对应的key
	
	/**
	 * 对账类型
	 */
	public static class WITHDRA_TYPE{
		/**  提现  */
		public static final String WITHDRA_TYPE_TX = "0001";
	}
	/**
	 *提现交易订单对账 订单类型
	 */
	public static class WITHDRA_TYPE_TX{
		/**  提现订单  */
		public static final String WITHDRA_TYPE_TX_TX = "101";
		/**  冻结订单  */
		public static final String WITHDRA_TYPE_TX_DJ = "102";
		/**  划拨订单  */
		public static final String WITHDRA_TYPE_TX_HB = "103";
		/**  解冻订单  */
		public static final String WITHDRA_TYPE_TX_JD = "104";
		/**  委托提现订单  */
		public static final String WITHDRA_TYPE_TX_WTTX = "105";
	}
	/**
	 *提现交易订单对账 订单差异类型
	 */
	public static class WITHDRA_TYPE_TX_STATUS{
		/**  正常  */
		public static final String WITHDRA_TYPE_TX_STATUS_SUCC = "000";
		/**  订单差异    */
		public static final String WITHDRA_TYPE_TX_STATUS_OERR = "001";
		/**  金额差异 */
		public static final String WITHDRA_TYPE_TX_STATUS_CERR = "002";
		
	}
	/**操作类型 新增*/
	public static final String OP_TYPE_NEW = "00";// 
	/**操作类型 更新*/
	public static final String OP_TYPE_UP = "01";// 
	

	// 交易类型
	public static final String TRAN_TYPE_RC = "0001";//  充值
	public static final String TRAN_TYPE_WD = "0002";//  提现申请
	public static final String TRAN_TYPE_TF = "0003";//  转账
	public static final String TRAN_TYPE_BIV= "0004";//  银行卡支付投资消费
	public static final String TRAN_TYPE_IV = "0005";//  余额支付投资消费
	public static final String TRAN_TYPE_RF = "0006";//  退款
	public static final String TRAN_TYPE_BI = "0007";//  理财兑付
	public static final String TRAN_TYPE_CI = "0008";//  放款
	public static final String TRAN_TYPE_JQ = "0009";//  鉴权
	public static final String TRAN_TYPE_POQ ="0010";//  订单查询
	public static final String TRAN_TYPE_DPOQ="0011";//  日交易订单查询
	public static final String TRAN_TYPE_PBOQ="0012";//  日退款订单查询
	public static final String TRAN_TYPE_ZC = "0013";//  理财金转出
	public static final String TRAN_TYPE_WZZ ="0014";//  提现转账
	public static final String TRAN_TYPE_FRC ="0015";// 补充值
	public static final String TRAN_TYPE_FBIV="0016";//  补银行卡支付理财
	public static final String TRAN_TYPE_FWZZ="0017"; // 补提现转账
	public static final String TRAN_TYPE_FZC ="0018";//  补理财金转出
	public static final String TRAN_TYPE_WDF ="0019";//  提现代付
	public static final String TRAN_TYPE_QBLANCE ="0020";//  用户余额查询
	public static final String TRANS_TYPE_BFJJZ = "0021"; // 备付金结算记账（机构金账户流水表用）
	public static final String TRANS_TYPE_JGJCZ = "0022"; // 机构金充值记账（机构金账户流水表用）
	public static final String TRANS_TYPE_RZJZ = "0023"; // 结转待清算充值款（机构金账户流水表用）
	public static final String TRANS_TYPE_DKZH = "0024"; // 交易类型 : 短款找回（机构金账户流水表用）
	public static final String TRANS_TYPE_FXJZR = "0025"; // 风险金转入（机构金账户流水表用） 
	public static final String TRANS_TYPE_RS = "0026"; // 认损（机构金账户流水表用） 
	public static final String TRANS_TYPE_RGTZ = "0027"; // 交易类型 : 人工调账
	public static final String TRAN_TYPE_NO ="0028";//未知
	public static final String TRAN_TYPE_BACKAVMONEY = "0029"; //账务记账补单退余额
	public static final String TRAN_TYPE_MERLCJCX = "0030"; //商户理财金查询(玖富账务中心使用)
	public static final String TRAN_TYPE_CHARGERECORD = "0031"; //充值记录查询
	public static final String TRAN_TYPE_WDRECORD = "0032"; //提现记录查询
	public static final String TRAN_TYPE_REFUND = "0033"; //提现退款
	public static final String TRAN_TYPE_LCCX = "0034";// 支付冲正
	public static final String TRAN_TYPE_TXDZ = "0035"; //提现对账
	public static final String TRAN_TYPE_XTLC = "0036"; //续投理财
	public static final String TRAN_TYPE_ZZYCL = "0037"; //转账预处理
	public static final String TRAN_TYPE_FREEZE = "0038";//富友提现冻结
	public static final String TRAN_TYPE_ASSIGN = "0039";//富友提现划拨
	public static final String TRAN_TYPE_THAW = "0040";//富友提现解冻
	public static final String TRAN_TYPE_FREEZE_BACK = "0041";//富友提现冻结回退
	public static final String TRAN_TYPE_ASSIGN_BACK = "0042";//富友提现划拨回退
	public static final String TRAN_TYPE_THAW_BACK = "0043";//富友提现解冻回退
	public static final String TRAN_TYPE_FREEZE_FILL = "0044";//富友提现冻结短款补单
	public static final String TRAN_TYPE_ASSIGN_FILL = "0045";//富友提现划拨短款补单
	public static final String TRAN_TYPE_THAW_FILL = "0046";//富友提现解冻短款补单
	public static final String TRAN_TYPE_CLEARING = "0047";//后收清分记账
	public static final String TRAN_TYPE_BILL_TO_CASH = "0048";//结算
	public static final String TRAN_TYPE_MER_RC = "0049";//商户充值
	public static final String TRAN_TYPE_RF_ACC = "0050";//退款至账户
	public static final String TRAN_TYPE_FY_NO = "0051";//富友未知
	public static final String TRAN_TYPE_BAIL_FILL = "0052";//富友委托提现短款补单
	public static final String TRAN_TYPE_BAIL_WD = "0056";//富友委托提现
	public static final String TRAN_TYPE_TALLY = "0057";//记账冲正（提现申请冲正，提现预处理冲正，委托体现冲正，商户提现冻结冲正，商户提现划拨冲正，商户提现解冻冲正）
	public static final String TRAN_TYPE_ENTRUST_COLLECTION = "0058";//企业代收 
	public static final String TRAN_TYPE_MER_ASSIGN = "0059";//商户提现划拨
	public static final String TRAN_TYPE_MER_THAW = "0060";//商户提现解冻
	public static final String TRAN_TYPE_MER_FREEZE = "0061";//商户提现冻结
	public static final String TRAN_TYPE_TEST_FEE = "0062";//费用维护

	// 交易流水状态
	public static final String TRAN_STATUS_SUCCESS = "01";// 交易成功
	public static final String TRAN_STATUS_FAIL = "02";// 交易失败
	public static final String TRAN_STATUS_UNKNOWN = "03";//未知
	public static final String TRAN_STATUS_DOING = "04";// 交易中
	public static final String TRAN_STATUS_NOM = "05";// 正常差异补单
	public static final String TRAN_STATUS_REFUND = "06";// 退票
	public static final String TRAN_STATUS_BDTYE = "07";//补单退余额
	public static final String TRAN_STATUS_WAITING = "08";// 待处理
	public static final String TRAN_STATUS_CORRECT = "09";// 已冲正
	public static final String TRAN_STATUS_INVALID = "10";//已失效
	public static final String TRAN_STATUS_SUSPEND = "11";// 挂起
	public static final String TRAN_STAUTS_DIFF_FIAL = "12";//短款差异失败
	public static final String TRAN_STAUTS_NOT_DEAL = "13";//无需处理
	
	// 审核状态
	public static final String PENDING_AUDIT = "00";// 待审核（审核状态）
	public static final String AUDIT_THROUGH = "01";// 审核通过（审核状态）
	public static final String AUDIT_NO_THROUGH = "02";// 审核未通过（审核状态）
	public static final String AUDIT_NO_NEED = "03";// 不需审核（审核状态）
	public static final String AUDIT_RE_PASS = "04";// 复核通过
	public static final String AUDIT_RE_NO = "05";// 复核未通过
	
	//提现交易订单状态
	public static final String WITHDRA_STATUS_WATTING = "00";//待处理
	public static final String WITHDRA_STATUS_DOING = "04";//银行处理中
	public static final String WITHDRA_STATUS_PASS = "01";//提现成功
	public static final String WITHDRA_STATUS_FAIL = "09";//提现审核被拒绝
	public static final String WITHDRA_STATUS_NOPASS = "02";// 提现失败
	public static final String WITHDRA_STATUS_SUSPEND = "11";// 挂起
	public static final String WITHDRA_STATUS_BANK_PASS = "12"; //提现已处理完成
	
	// 差错类型：外部对账
	public static final String TASK_ERRTYPE_LONG = "1000";// 渠道成功，平台非成功
	public static final String TASK_ERRTYPE_AMOUNT = "2000";// 渠道和平台都存在该记录，但金额不一致
	//public static final String TASK_ERRTYPE_AUTOFAIL = "3000";// 渠道成功，平台非成功(系统自动补单失败)
	public static final String TASK_ERRTYPE_BANKFAIL = "4000";// 渠道非成功，平台成功
	public static final String TASK_ERRTYPE_SHORT = "5000";// 渠道无记录，平台有记录(短款待处理)
	public static final String TASK_ERRTYPE_ACCOUNT = "6000"; // 渠道无记录，平台有记录(短款挂账)
	public static final String TASK_ERRTYPE_PLATNO = "7000";// 渠道存在，平台不存在对应的流水
	public static final String TASK_ERRTYPE_ALLFAIL = "8000";// 渠道非成功，平台非成功
	
	// 差错类型：内部对账
	public static final String TASK_ERRTYPE_INNER_ACCOUNTNO = "1000";// 支付订单存在，账务流水不存在
	public static final String TASK_ERRTYPE_INNER_ORDERNO = "2000";// 支付订单失败，记账成功
	public static final String TASK_ERRTYPE_INNER_AMOUNT = "3000";// 支付订单和账务流水都存在，但金额不一致
	public static final String TASK_ERRTYPE_INNER_W_AMOUNT = "4000";// 转账和代付订单都存在（1:1），但金额不一致
	public static final String TASK_ERRTYPE_INNER_W_DFMORE = "5000";// 转账和代付订单都存在（1:n）
	public static final String TASK_ERRTYPE_INNER_W_DFNO = "6000";// 转账订单存在，代付订单不存在（1:0）
	
	/** 对账类型：内部对账 */
	public static final String RECON_TYPE_INNER = "00";//内部对账
	/** 对账类型：外部对账 */
	public static final String RECON_TYPE_OUTER = "01";//外部对账

	/** 手续费收取方式-后收 */
	public static final String FEE_TYPE_LATER = "00";
	// 手续费收取方式
	public static final String FEE_TYPE_RATE = "01";// 按费率收取
	public static final String FEE_TYPE_SIG = "02";// 按笔固定金额

	// 支付产品类型
	public static final String PAY_TYPE_CHARGE = "00";// 充值
	public static final String PAY_TYPE_WITHDRA = "01";// 提现
	public static final String PAY_TYPE_ENTR = "02";// 委托代收

	// 差错处理状态
	public static final String TASK_ERROROPERT_NO = "01"; // 未处理
	public static final String TASK_ERROROPERT_ING = "02"; // 处理中
	public static final String TASK_ERROROPERT_FIN = "03"; // 已处理

	// 流水号
	public static final String FLOWNUM_SYSID_DEFAULT = "10";// 流水号系统编号（默认）
	public static final String FLOWNUM_EXTID_DEFAULT = "001";// 流水号扩展位（默认）

	// 币种
	public static final String PLAT_CURRENCY_CHINA = "156";// 币种（人民币）

	// 身份证类型
	String CERT_TYPE_ID = "00";// 身份证

	// 用户绑卡状态
	String USER_BANK_STATUS_NORMAL = "01";// 正常
	String USER_BANK_STATUS_FREEZE = "02";// 冻结
	String USER_BANK_STATUS_CANCLE = "03";// 销户
	
	//本地认证库状态
	String BANK_LIB_STATUS_NORMAL = "01";// 正常
	
	/** 用户,客户,账户状态.正常 */
	public static final String NORMAL = "00";
	/** 用户,客户,账户状态.冻结 */
	public static final String FREEZE = "01";
	/** 用户,客户,账户状态.注销 */
	public static final String LOGOUT ="02";
	
	// 借贷记标识
	String CARD_TYPE_DEBIT = "01";// 借记卡
	String CARD_TYPE_CREDIT = "02";// 贷记卡

	// 银行卡认证状态
	String CARD_AUTH_NO = "00";// 待认证
	String CARD_AUTH_SUCCESS = "01";// 认证成功
	String CARD_AUTH_FAIL = "02";// 认证失败

	// 验证码失效时间（单位：秒）
	public static final int VERIFICODE_TIMEOUT = 120;
	// 订单失效时间（单位：秒）
	public static final int PAYORDER_TIMEOUT = 60*15;
	
	// 检验订单失效时间（单位：秒）
	public static final int CHECK_PAYORDER_TIMEOUT = 60*30;
	// 用户冻结时间（单位：秒）
	public static final int USER_FROZEN_TIMEOUT = 60*20;
	// 需要签约
	public static final String NEED_SIGN_TRUE = "1";
	// 不需要签约
	public static final String NEED_SIGN_FALSE = "0";
	// 最优认证渠道交易码
	public static final String FITCHANNEL_AUTH_TRANCODE = "5000";
	// 货币
	String CURRENCY_CHINA = "0001";// 人民币

	/*************************** 账户类型 *****************************/
	/** 用户余额账户 */
	public static final String CST_BALANCE = "01";
	/** 用户冻结账户 */
	public static final String CST_FREEZE = "02";
	/** 用户富友可用账户*/
	public static final String CST_AVACC = "03";
	/** 商户账户类型-临时账户 */
	public static final String MER_INVESTMENT = "01";
	/** 商户账户类型-兑付金账户 */
	public static final String MER_CASH = "02";
	/** 商户账户类型-现金账户*/
	public static final String MER_BALANCE = "03";
	/**商户账户类型-待结算账户*/
	public static final String MER_PRE = "04";
	/**商户账户类型-应缴手续费账户*/
	public static final String MER_FEE = "05";
	/**商户账户类型-商户富友冻结账户*/
	public static final String MER_FY_FREEZE = "06";

	/************************** 账户余额类型 ***************************/
	/**冻结余额*/
	public static final String AMT_TYPE_FREEZE = "00";
	/**可用余额*/
	public static final String AMT_TYPE_AV = "01";
	/**总余额*/
	public static final String AMT_TYPE_TOTAL = "02";
	
	// 商户账户类型
	String MER_ACC_TYPE_FINANCIAL = "01";// 商户理财账户

	// 差错处理类型
	String TASK_ERROR_BACK = "01";// 平台找回
	String TASK_ERROR_LOSS = "02";// 认损
	String TASK_ERROR_ACCOUNT = "03";// 调账
	String TASK_ERROR_NEXTRE = "05";// 次日对对账
	String TASK_ERROR_SUPPLE = "06";// 补单
	String TASK_ERROR_OTHER = "07";// 其他处理
	String TASK_ERROR_VERTIFY = "08";// 审核通过
	String TASK_ERROR_NOVER = "09";// 审核不通过

	//未实名认证
	public static final String AUTHENTICATION_REAL_NAME_NO = "00";
	//已实名认证
	public static final String AUTHENTICATION_REAL_NAME_YES = "01";
	//已银行卡认证
	public static final String AUTHENTICATION_REAL_NAME_CARD = "02";
	
	//富友开户未知
	public static final String FY_ACC_STATUS_UNKNOWN = "00";
	//富友状态正常
	public static final String FY_ACC_STATUS_SUCCESS = "01";
	//富友状态异常
	public static final String FY_ACC_STATUS_EXCEPTION = "02";
	
	
	// 正常返回码（payment和admin交互使用）
	public static final String RES_SUCCESS_CODE = "0000";
	
	// 正常返回码（database和admin交互使用）
		public static final String BASE_RES_SUCCESS_CODE = "00000";
	// 错误返回码（payment和admin交互使用）
	public static final String RES_ERROR_CODE = "0001";

	// redis 常用key
	String SYSTEM_FLOW_NO_KEY = "SYSTEM_FLOW_NO_KEY";// 自增流水号key 
	String CHANNEL_PAY_DAY_COUNT ="CHANNEL_PAY_DAY_COUNT";//日统计
	String CHANNEL_PAY_MONTH_COUNT ="CHANNEL_PAY_MONTH_COUNT";//月统计
	String ORG_ACCOUNT_NO_KEY = "ORG_ACCOUNT_NO_KEY";//机构账户生成六位自增序列号key
	// 代付渠道号
	public static final String INSTEADPAY_CHANNELNO = "03174307";
	
	public static final String TANMONEY_OUT ="01";
	
	//金融渠道编码
	public static final String CHANNEL_HEBAO = "he_bao";
	public static final String CHANNEL_FUYOU = "fu_you";
	public static final String CHANNEL_JIUFU = "jiu_fu";
	
	/** 对账状态：对账成功 */
	public static final String RECON_STATUS_SUCCESS = "00";
	/** 对账状态：对账失败 */
	public static final String RECON_STATUS_FAIL = "01";
	
	//机构状态
	public static final String ORG_STT_NORMAL = "00";//正常
	
	/** 流水号生成：系统编号 */
	public static final String SYS_NO = XpayAdminConstants.SYSTEM_CLEAR;
	/** 流水号生成：扩展编号 */
	public static final String EXT_NO = "001";
	
	/** 数据来源 01 代表:H5收银台,02:自动提现*/
	public static final String MO_DATAHEAD = "01";
	public static final String MO_DATAHEAD_YY = "02";
	
	/** 交易系统业务扩展号：兑付交易订单 */
	public static final String FLOWNUM_EXTNO_TRADE_CASH = "004";
	
	//支持的业务交换类型(流入、流出、信息)
	public static final String IN_TRANSTYPE = "00";
	public static final String OUT_TRANSTYPE = "01";
	public static final String INF_TRANSTYPE = "02";
	
	/** 冻结类型：提现冻结 */
	public static final String FREEZE_TYPE_DJ = "01";
	/** 冻结类型：提现解冻回退 */
	public static final String FREEZE_TYPE_JDHT = "02";
	/** 冻结类型：提现冻结短款补单 */
	public static final String FREEZE_TYPE_DJDKBD = "03";
	
	/** 划拨类型：提现资金划拨 */
	public static final String TRANSFER_TYPE_HB = "01";
	/** 划拨类型：提现资金划拨回退 */
	public static final String TRANSFER_TYPE_HBHT = "02";
	/** 划拨类型：提现资金划拨短款补单 */
	public static final String TRANSFER_TYPE_HBDKBD = "03";
	
	/** 解冻类型：提现解冻 */
	public static final String UNFREEZE_TYPE_JD = "01";
	/** 解冻类型：提现冻结回退 */
	public static final String UNFREEZE_TYPE_DJHT = "02";
	/** 解冻类型：提现解冻短款补单 */
	public static final String UNFREEZE_TYPE_JDDKBD = "03";
	
	/** 待清分 */
	public static final String CLEAR_STATUS_WAITING = "00";
	/** 已清分 */
	public static final String CLEAR_STATUS_CLEARED = "01";
	/** 待结算 */
	public static final String CLEAR_STATUS_UNLIQUIDATED = "02";
	/** 已结算 */
	public static final String CLEAR_STATUS_LIQUIDATED = "03";
	
	/** 提现至银行卡*/
	public static final Integer WITHDRA_TO_CARD = 1;
	public static final Integer WITHDRA_TO_BALANCE = 2;
	
	/** 结算方式 - 结算到现金账户 */
	public static final int SETTLE_TO_CASH = 1;
	/** 结算方式 - 结算到富友账户 */
	public static final int SETTLE_TO_FUYOU = 2;
	/** 结算方式 - 结算到银行账户 */
	public static final int SETTLE_TO_BANK = 3;
	
}
