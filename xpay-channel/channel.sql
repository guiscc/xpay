#渠道交易流水表
CREATE TABLE channel_tradeinfo (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  tradeOrderNo varchar(50) DEFAULT NULL COMMENT '业务订单号',
  bankOrderNo varchar(50) DEFAULT NULL COMMENT '渠道订单号',
  payAmt double DEFAULT NULL COMMENT '金额',
  currency varchar(20) DEFAULT NULL COMMENT '币种',
  signCode varchar(50) DEFAULT NULL COMMENT '签约号',
  paySubToolCode varchar(40) DEFAULT NULL COMMENT '渠道编码',
  payToolChannelCode varchar(40) DEFAULT NULL COMMENT '接口编码',
  bankNo varchar(50) DEFAULT NULL COMMENT '银行流水号',
  rtnCode varchar(20) DEFAULT NULL COMMENT '银行返回码',
  rtnMsg varchar(50) DEFAULT NULL COMMENT '银行返回信息',
  merchantNo varchar(40) DEFAULT NULL COMMENT '商户号',
  payStatus varchar(20) DEFAULT NULL COMMENT '交易状态',
  createTime timestamp NULL COMMENT '创建时间',
  finishTime timestamp NULL COMMENT '完成时间',
  bankFinishtime timestamp NULL COMMENT '银行完成时间',
  reqTime timestamp NULL COMMENT '请求时间',
  mapstr varchar(500) DEFAULT NULL COMMENT '备注字段',
  PRIMARY KEY (id),
  UNIQUE KEY bankOrderNo (bankOrderNo),
  KEY bizOrderNo_index (bizOrderNo) USING BTREE,
  KEY bankOrderNo_index (bankOrderNo) USING BTREE,
  KEY signCode_index (signCode) USING BTREE,
  KEY idx_interCode_createtime (payToolChannelCode,createTime),
  KEY index_createTime (createTime),
  KEY index_interCode (payToolChannelCode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#支付工具表
CREATE TABLE channel_payTools (
  id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  payToolsCode bigint(20) NOT NULL,
  paySubToolsCode varchar(40) DEFAULT NULL COMMENT '通道编码',
  payToolStatus varchar(16) DEFAULT NULL COMMENT '通道状态',
  payToolCurrency varchar(16) DEFAULT NULL COMMENT '通道货币',
  payToolCardType varchar(16) DEFAULT NULL COMMENT '通道卡类型',
  createPersion varchar(40) DEFAULT NULL COMMENT '创建人',
  updatePersion varchar(40) DEFAULT NULL COMMENT '更新人',
  createDT timestamp NULL COMMENT '创建时间',
  updateDT timestamp NULL COMMENT '更新时间',
  PRIMARY KEY ('id'),
  UNIQUE KEY 'paySubToolsCode' ('paySubToolsCode')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#路由接口表
CREATE TABLE channel_channelInter (
  id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  channelCode varchar(40) DEFAULT NULL COMMENT '接口编码',
  channelName varchar(40) DEFAULT NULL COMMENT '接口名称',
  instId bigint(10) DEFAULT NULL,
  interStatus varchar(16) DEFAULT NULL COMMENT '接口状态',
  channelCardType varchar(16) DEFAULT NULL COMMENT '接口卡类型',
  interType varchar(16) DEFAULT NULL,
  createPersion varchar(40) DEFAULT NULL COMMENT '创建人',
  updatePersion varchar(40) DEFAULT NULL COMMENT '更新人',
  createDT timestamp NULL COMMENT '创建时间',
  updateDT timestamp NULL COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY channelCode (channelCode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#工具渠道映射表
CREATE TABLE channel_paytoolsmapping (
  id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  channelCode bigint(10) DEFAULT NULL COMMENT '通道id',
  interfaceCode bigint(10) DEFAULT NULL COMMENT '接口id',
  channelWeight int(11) DEFAULT NULL COMMENT '通道权重',
  channelRate double DEFAULT NULL COMMENT '通道费率',
  createPersion varchar(40) DEFAULT NULL COMMENT '创建人',
  updatePersion varchar(40) DEFAULT NULL COMMENT '更新人',
  createDT timestamp NULL COMMENT '创建时间',
  updateDT timestamp NULL COMMENT '更新时间',
  mappStatus varchar(16) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#渠道配置表
CREATE TABLE channel_channelCfg (
  id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  channelCode bigint(10) DEFAULT NULL,
  callBackUrl varchar(100) DEFAULT NULL,
  callPageUrl varchar(100) DEFAULT NULL,
  refundCallBackUrl varchar(100) DEFAULT NULL,
  chkFileDT timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  chkFileType varchar(20) DEFAULT NULL,
  refundType varchar(20) DEFAULT NULL,
  orderNoPrefix varchar(20) DEFAULT NULL,
  orderNoLen int(11) DEFAULT NULL,
  payType varchar(20) DEFAULT NULL,
  signType varchar(20) DEFAULT NULL,
  channelCfg varchar(20) DEFAULT NULL,
  createPersion varchar(40) DEFAULT NULL,
  updatePersion varchar(40) DEFAULT NULL,
  updateDT timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  createDT timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  smsType varchar(40) DEFAULT NULL,
  repairStatus varchar(20) DEFAULT NULL COMMENT '补单启用状态',
  repairMinute int(20) DEFAULT NULL COMMENT '补单周期',
  bankBufferMill bigint(30) DEFAULT NULL COMMENT '补单银行缓冲时间',
  repairMaxAmt double DEFAULT NULL COMMENT '补单最大金额',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##############第三方商户
CREATE TABLE channel_instmerchant (
  id bigint(10) NOT NULL AUTO_INCREMENT,
  instCode bigint(10) DEFAULT NULL,
  bizCode bigint(10) DEFAULT NULL,
  channelCode bigint(10) DEFAULT NULL,
  merchantNo varchar(40) DEFAULT NULL,
  merchantDayLimit double DEFAULT NULL,
  merchantSingleLimit double DEFAULT NULL,
  merchantMonthLimit double DEFAULT NULL,
  merchantStatus varchar(16) DEFAULT NULL,
  createPersion varchar(40) DEFAULT NULL,
  updatePersion varchar(40) DEFAULT NULL,
  createDT timestamp NULL,
  updateDT timestamp NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


################商户表
CREATE TABLE channel_merconfig (
  id bigint(10) NOT NULL AUTO_INCREMENT,
  instCode bigint(10) DEFAULT NULL,
  bizCode bigint(10) DEFAULT NULL,
  channelCode bigint(10) DEFAULT NULL,
  merchantCode bigint(10) DEFAULT NULL,
  merchantNo varchar(40) DEFAULT NULL,
  merchantDayLimit double DEFAULT NULL,
  merchantSingleLimit double DEFAULT NULL,
  merchantMonthLimit double DEFAULT NULL,
  merchantStatus varchar(16) DEFAULT NULL,
  cfgZmk varchar(40) DEFAULT NULL,
  cfgZpk varchar(255) DEFAULT NULL,
  cfgZak varchar(255) DEFAULT NULL,
  cfgPfxPath varchar(100) DEFAULT NULL,
  cfgCerPath varchar(100) DEFAULT NULL,
  cfgCerOutDate timestamp NULL,
  cfgStatus varchar(16) DEFAULT NULL,
  createPersion varchar(40) DEFAULT NULL,
  updatePersion varchar(40) DEFAULT NULL,
  updateDT timestamp NULL DEFAULT,
  createDT timestamp NULL DEFAULT,
  operatorCode varchar(50) DEFAULT NULL,
  operatorPwd varchar(50) DEFAULT NULL,
  mapstr varchar(500) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#################渠道
DROP TABLE IF EXISTS channel_instaccount;
CREATE TABLE channel_instaccount (
  id bigint(10) NOT NULL AUTO_INCREMENT,
  actCode varchar(40) DEFAULT NULL,
  actName varchar(40) DEFAULT NULL,
  actType varchar(20) DEFAULT NULL,
  actStatus bit(1) DEFAULT NULL,
  actDetail varchar(255) DEFAULT NULL,
  createPersion varchar(40) DEFAULT NULL,
  updatePersion varchar(40) DEFAULT NULL,
  createDT timestamp NULL,
  updateDT timestamp NULL,
  PRIMARY KEY (id),
  UNIQUE KEY actCode (actCode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##################渠道机构表
DROP TABLE IF EXISTS channel_institution;
CREATE TABLE channel_institution (
  id bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  instCode varchar(40) DEFAULT NULL COMMENT '机构编码',
  instName varchar(100) DEFAULT NULL COMMENT '机构名称',
  instFlag varchar(40) DEFAULT NULL COMMENT '机构商户号',
  instProvince varchar(24) DEFAULT NULL COMMENT '机构省',
  instCity varchar(24) DEFAULT NULL COMMENT '机构市',
  instArea varchar(24) DEFAULT NULL COMMENT '机构市',
  instStatus varchar(16) DEFAULT NULL,
  createPersion varchar(40) DEFAULT NULL COMMENT '创建人',
  updatePersion varchar(40) DEFAULT NULL COMMENT '更新人',
  createDT timestamp NULL COMMENT '创建时间',
  updateDT timestamp NULL COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY instCode (instCode)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;







