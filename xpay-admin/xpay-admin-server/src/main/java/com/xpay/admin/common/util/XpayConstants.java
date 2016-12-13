package com.xpay.admin.common.util;

import com.xpay.admin.common.XpayAdminConstants;

public interface XpayConstants extends XpayAdminConstants {
	
	public static String LOCALHOST_IP = "0:0:0:0:0:0:0:1";
	public static String LOCALHOST_IP_T = "127.0.0.1";
	public static String PASS_IP_CHECK_USER = "admin";
	
	public static Integer SESSION_OUT_TIME = 2*60*60;//登录超时时间 单位：秒
	
	public static String CURRENT_LOGIN_SECURITY_MENU= "current_login_security_menu";//系统菜单权限
	public static String CURRENT_LOGIN_NOW = "current_login_now";
	public static String CURRENT_LOGIN_USER = "current_login_user";
	public static String CURRENT_LOGIN_USER_ROLE = "current_login_user_role";
	public static String CURRENT_LOGIN_USER_B = "loginUser";
	public static String LOGIN_USER_IP = "USERIP";

	// 待审核（审核状态）
	public static final String PENDING_AUDIT = XpayAdminConstants.PENDING_AUDIT;

	// 审核通过（审核状态）
	public static final String AUDIT_THROUGH = XpayAdminConstants.AUDIT_THROUGH;

	// 审核未通过（审核状态）
	public static final String AUDIT_NO_THROUGH = XpayAdminConstants.AUDIT_NO_THROUGH;
	
	// 正常（机构提供资金产品状态）
	public static final String ORG_STATUS_NORMAL = "00";
	
	// 临时关闭（机构提供资金产品状态）
	public static final String ORG_STATUS_TEMPORARILY_CLOSED = "01";
	
	// 永久关闭（机构提供资金产品状态）
	public static final String ORG_STATUS_PERMANENT_CLOSED = "02";
	
	// 启用（机构计算周期状态）
	public static final String ORG_SETTLE_STATUS_START = "00";
	
	// 停用（机构计算周期状态）
	public static final String ORG_SETTLE_STATUS_STOP = "01";
	
	// 币种
	public static final String CURRENCY_CNY = XpayAdminConstants.PLAT_CURRENCY_CHINA;
	
	// yyyyMMddHHmmss 
	public static final String DATE_FORMAT_STANDARD = "yyyyMMddHHmmss";
	
	// 系统编号: 通用账户平台 
	public static final String SYSTEM_ACCOUNT = "10";
	// 系统扩展号 
	public static final String SYSTEM_EXTENSION = "01";
	
	//分析平台是否返回数据标记  有
	public static final Integer REPORT_NODATA = 0;
	//分析平台是否返回数据标记  无
	public static final Integer REPORT_DATA = 1;
	
	//账户渠道编码
	public static final String ACC_CHANNAL_TYPE = "acc_channal_type";
	
	//综合调账调账方式(单边)
	public static final String COMPR_ADJ_REG_TYPE_SINGLE = "00";
	//综合调账调账方式(双边)
	public static final String COMPR_ADJ_REG_TYPE_DOUBLE = "01";
	//综合调账调账方式(多边)
	public static final String COMPR_ADJ_REG_TYPE_MANY = "02";
	//综合调账账户类型(商户)
	public static final String COM_ADJUST_ACC_TYPE_MER = "00";
	//综合调账账户类型(用户)
	public static final String COM_ADJUST_ACC_TYPE_MEM = "01";
	//综合调账账户类型(平台)
	public static final String COM_ADJUST_ACC_TYPE_PLAT = "02";
	
	//订单已记账
	public static final String HAS_ACCOUNT = "00";
	//订单未记账
	public static final String HAS_NOT_ACCOUNT = "01";
	//机构金（备付金、充值金）结算审核状态
	public static final int ORG_AMT_CHECK_STATE_NOCHECK = 0;//待审核
	public static final int ORG_AMT_CHECK_STATE_CHECKED = 1;//审核通过
	public static final int ORG_AMT_CHECK_STATE_RECHECKED = 2;//复核通过
	public static final int ORG_AMT_CHECK_STATE_NOPASS = 3;//被拒绝
	
	//商户号
	public static final String  MERCHANT_NO = "C1301003050700000001";//玖富钱包
	
	//对账文件模版
	public static final String RECON_INFO_TEMPLATE_NAME="微支付对账文件模版_v1.001229.xlsx";
	//encode 编码
	public static final String ENCODE_UTF8="UTF-8";
	public static final String ENCODE_IOS="iso-8859-1";
	

	public static final String TASK_TYPE_QUERY = "0001";//交易查证
	public static final String TASK_TYPE_RECON = "0002";//渠道对账
	
	// 记账状态（未记账）
	public static final String AWFR_STATUS_NONE = "00";
	// 记账状态（成功）
	public static final String AWFR_STATUS_SUCCESS = "01";
	// 记账状态（失败）
	public static final String AWFR_STATUS_FAILUE = "02";

	
	public static final String RES_SUCCESS_CODE="0000";//操作成功
	// 是否已经设置手续费（否）
	public static final String IS_OTRC_FALSE="0000";
	// 是否已经设置手续费（是）
	public static final String IS_OTRC_TRUE="0001";
	
	// 支付工具关联银行状态（启用）
	public static final String PAY_TOOLS_REL_STATUS_START="00";
	// 支付工具关联银行状态（停用）
	public static final String PAY_TOOLS_REL_STATUS_STOP="01";
	
	/**支付产品套餐编码前缀*/
	public static final String PAY_PRO_GROUPCODE="G01020000";
	//金融渠道管控（停启用）
	public static final String UPD_FLAG_STATUS = "00";
	//金融渠道管控（修改等级）
	public static final String UPD_FLAG_LEVEL = "01";
	//金融渠道管控（修改权重）
	public static final String UPD_FLAG_WEIGHT = "02";
	//金融渠道管控（修改分配比例）
	public static final String UPD_FLAG_SCALE = "03";
	//金融渠道管控（交易额区间）
	public static final String UPD_FLAG_INTERVAL = "04";
	
	//金融渠道等级(一级)
	public static final String ORG_LEVEL_ONE = "00";
	//金融渠道等级(二级)
	public static final String ORG_LEVEL_TOW = "01";
	//画面来源标志(金融交换中心)
	public static final String PAGE_FLAG_CENTER = "00";
	//画面来源标志(金融交换管控)
	public static final String PAGE_FLAG_MANAGE = "01";
	//匹配中文的正则表达式
	public static final String REGEX_CH = "([\u4e00-\u9fa5]+)";
	
	//退款状态（退款成功）
	public static final Byte TRADE_REFUND_STATUS_SUCCESS = 2;
	
	//回滚状态（无须回滚）
	public static final String ROLLBACK_STATUS_NONE = "00";
	
	//微支付平台金账户
	public static final String FUIOU_PLAT_ACCOUNT= "11223331162";
	
	/** 差错处理详情详情查询 处理类型（00-补记账） */
	public static final String PROCESSTYPE_BJZ = "00";
	/** 差错处理详情详情查询 处理类型（01-补单） */
	public static final String PROCESSTYPE_BD = "01";
	/** 差错处理详情详情查询 处理类型（02-人工处理） */
	public static final String PROCESSTYPE_RGCL = "02";
	/** 差错处理详情详情查询 处理类型（03-短款差异失败） */
	public static final String PROCESSTYPE_DKCYSB = "03";
	/** 差错处理详情详情查询 处理类型（04-短款补单） */
	public static final String PROCESSTYPE_DKBD = "04";
	
	/** 提现对应的冻结、划拨、解冻的状态（解冻失败、划拨失败、解冻成功）*/
	public static final String WITHDRA_STATUS_SUCCESS = "01";
	
	//业务类型（用户）
	public static final Byte BUSINESS_TYPE_USER = 1;
	//业务类型（商户）
	public static final Byte BUSINESS_TYPE_MER = 2;
	
	//订单状态（补单退余额）
	public static final Byte TRAN_STATUS_BDTYE = 7;
	//订单状态（正常差异补单）
	public static final Byte TRAN_STATUS_NOM = 4;
	//订单状态（正常差异补单）
	public static final Byte TRAN_STATUS_SUCCESS = 2;
	
	//退款类型 1:退款至余额
	public static final int REFUND_TYPE_TKZYE = 1;
	
	//提现申请订单类型 2:退款提现
	public static final int WITHDRAW_APPLY_REFUND = 2;
	
	
	///申请提现交易类型为用户提现
   public static final int WITHDRAW_APPLY_TYPE_USER = 1;
	
	//渠道推送字典的代码
	public static final String CHANNEL_CODE = "all_channel";
	
	/**人工清分-审核状态**/
	public static final String ARIT_CHECK_WAIT = "1";//待审核
	public static final String ARTI_CHECK_SUCCESS="2";//审核通过
	public static final String ARTI_CHECK_FAIL="3";//审核拒绝
}
