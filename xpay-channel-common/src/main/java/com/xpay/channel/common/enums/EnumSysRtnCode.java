package com.xpay.channel.common.enums;

/**
 * Created by suxinxin on 16/2/5.
 */
public enum EnumSysRtnCode {
    /**
     * 系统异常
     */
    E0000("系统异常"),
    E0001("路由没有找到对应的业务线"),
    E0002("路由没有找到该业务对应的渠道"),
    E0003("路由没有找到该渠道对应的接口"),
    E0004("路由没有找到该接口对应的机构"),
    E0005("路由没有找到机构对应的商户信息"),
    E0006("路由没有找到机构对应的商户配置信息"),
    E0007("前置未配置该渠道相应接口"),
    E0008("路由没有找到该业务线相应的机构商户号"),
    E0009("路由没有找到该接口对应的配置信息"),
    E0010("路由生成支付单异常"),
    E0011("请求支付业务订单号重复"),
    E0012("路由更新订单状态异常"),
    E0013("路由签约流水插入失败"),
    E0014("请求路由数据与绑定签约信息不匹配"),
    E0015("路由更新签约信息错误"),
    E0016("请求路由的支付业务订单号不存在"),
    E0017("请求路由签约信息不存在"),
    E0018("签约状态不正确，不能交易"),
    E0019("支付状态不为成功，不能发起退款"),
    E0020("退款金额大于原交易金额，不能发起退款"),
    E0021("路由没有找到机构和通道对应的服务商配置信息"),
    E0022("退款处理中"),
    E0023("退款已成功"),
    E0024("请求路由查询订单不属于该业务线"),
    E0025("请求路由支付之前没有做签约,该签约号已经使用,该接口需要支付前每次都做签约"),
    E0026("请求路由业务签约流水号不能为空"),
    E0027("请求路由退款业务线与原交易业务线不符"),
    E0028("路由生成银行订单号异常"),
    E0029("路由补单返回上下文为空"),
    E0031("请求安全存储加密接口失败"),
    E0032("请求安全存储解密接口失败"),
    E0042("请求路由的退货业务订单号不存在"),
    E0041("签约号生成失败"),
    E0043("渠道权重未配置"),
    E0044("当前交易金额超出单比限额"),
    E0045("没有满足当前交易金额的渠道，交易超限"),
    E0046("签约状态不为'签约成功'和'签约处理中',不能解约."),
    E0047("签约已成功"),
    E0048("签约处理中"),
    E0049("解约处理中"),
    E0057("第三方商户号不存在"),
    E0058("路由没有找到符合到账时间的接口"),
    E0059("找不到对应的路由项"),

    E0050("持卡人手机号不一致"),
    E0051("身份证号不一致"),
    E0052("持卡人姓名不一致"),
    E0053("卡类型不一致"),
    E0054("有效期不一致"),
    E0055("证件类型不一致"),

    E0060("实名认证银行卡号不能为空"),
    E0061("实名认证持卡人姓名不能为空"),
    E0062("实名认证身份证号码不能为空"),
    E0063("实名认证手机号码不能为空"),

    E0070("支付金额与签约金额不符"),

    E1001("补单配置信息不存在，或者状态已经关闭"),
    E1002("补单类型不能为空"),
    E1003("补单单号不能为空"),
    E1004("补单状态不能为空"),
    E1005("补单人不能为空"),
    E1006("补单时间不能为空"),
    E1007("补单原因不能为空"),
    E1008("补单支付单状态已经为成功"),
    E1009("补单退款单状态已经为成功"),
    E1010("渠道切换类型不能为空"),
    E1011("渠道切换状态不能为空"),
    E1012("渠道切换时间不能为空"),
    E1013("渠道切换操作人不能为空"),
    E1014("渠道切换生效类型不能为空"),
    E1015("渠道切换ID不能为空"),
    E1016("渠道切换生效时间不能为空"),
    E1017("渠道切换权重值非法"),
    E1018("该笔支付单状态不允许强制补单"),
    E1019("该笔退款单状态不允许强制补单"),
    E1020("补单来源不能为空"),
    E1021("新增交易补单日志记录异常"),
    E1022("新增退款补单日志记录异常"),
    E1023("渠道补单系统繁忙,请稍后再试"),
    E0056("签约已成功，已经是激活状态"),
    E2001("传入的对象为空,请检查"),
    E2002("订单号生成错误"),

    /**
     * 代付
     */
    E3000("请求代付信息不存在"),
    E3001("请求批次号不存在"),


    /**
     * 验证参数异常
     */
    V0000("验证参数异常"),
    V0001("请求路由实体不能为空"),
    V0002("请求路由业务订单号不能为空"),
    V0003("请求路由卡号不能为空"),
    V0004("请求路由姓名不能为空"),
    V0005("请求路由金额不合法"),
    V0006("请求路由支付业务订单号不能为空"),
    V0007("请求路由支付短信验证码不能为空"),
    V0008("请求路由业务线编号不能为空"),
    V0009("请求路由渠道编码不能为空"),
    V0010("请求路由卡类型不能为空"),
    V0011("前置返回银行订单号与路由请求银行订单号不符"),
    V0012("前置返回交易金额与路由请求交易金额不符"),
    V0013("前置返回交易原单号与路由请求原单号不符"),
    V0014("请求路由原单号不能为空"),
    V0015("前置返回实体为空"),
    V0016("请求路由签约号不能为空"),
    V0017("请求路由解约订单号不能为空"),
    V0018("请求路由原单号和原业务单号不能同时为空"),
    V0019("前置返回原支付单号数据库不存在"),
    V0020("前置返回原支付单号已支付成功"),
    V0021("前置返回支付报文为空"),
    V0022("请求路由退货查询退货订单号不能为空"),
    V0023("请求路由退货查询退货流水号不能为空"),
    V0024("请求路由退货原支付订单号不能为空"),
    V0025("请求路由证件类型不能为空"),
    V0026("请求路由证件号不能为空"),
    V0027("请求路由手机号不能为空"),
    V0028("请求路由cvv2不能为空"),
    V0029("请求路由有效期不能为空"),
    V0030("请求路由业务退款流水不能为空"),
    V0031("请求路由支付签约号不能为空"),
    V0032("请求路由单比金额超限"),
    V0033("前置返回原退款单号数据库不存在"),
    V0034("前置返回原退款单号已退款成功"),
    V0035("前置返回userId与请求userId不符"),
    V0036("请求路由接口编码不能为空"),
    V0037("请求路由批量授信数据为空"),
    V0038("请求路由闪信返回还款流水号不能为空"),

    /**
     * 代付请求路由验证错误码
     */
    V0040("代付请求路由到账时间不能为空"),
    V0041("代付请求路由币种不能为空"),
    V0042("代付请求路收款人账号不能为空"),
    V0043("代付请求路收款人姓名不能为空"),
    V0044("代付请求路唯一标示号不能为空"),
    V0045("代付请求路收款人账号不能为空"),
    V0046("代付请求路由批次号不能为空"),
    V0047("代付请求路由客户端IP不能为空"),
    V0048("代付请求路由订单详情集合不能为空"),
    V0049("代付请求路由订单详情集合数量与REQ总数量不相等"),
    V0050("代付请求路由订单详情集合总金额与REQ总金额不相等"),
    V0051("代付请求路由通道编码不能为空"),
    V0052("代付请求路由接口编码不能为空"),
    V0053("代付请求路由商户号不能为空"),
    V0054("代付请求路由开始时间不能为空"),
    V0055("代付请求路由结束时间不能为空"),
    V0080("代付请求路由开户行所在省不能为空"),
    V0081("代付请求路由开户行所在市不能为空"),
    V0082("代付请求路由支行名称不能为空"),
    V0083("代付请求路由联行号不能为空"),
    V0084("代付请求路由用途不能为空"),
    V0085("代付请求路由发送方类型不能为空"),


    /**
     * 前置验证参数异常
     */
    V1000("前置验证参数异常"),
    V1001("请求前置实体不能为空"),
    V1002("请求前置业务订单号不能为空"),
    V1003("请求前置支付订单号不能为空"),
    V1004("请求前置原单号不能为空"),
    V1005("请求前置卡号不能为空"),
    V1006("请求前置卡类型不能为空"),
    V1007("请求前置USERID不能为空"),
    V1008("请求前置姓名不能为空"),
    V1009("请求前置金额不合法"),
    V1010("请求前置证件号不能为空"),
    V1011("请求前置证件类型不能为空"),
    V1012("请求前置有效期不能为空"),
    V1013("请求前置安全码不能为空"),
    V1014("请求前置支付短信验证码不能为空"),
    V1015("请求前置支付手机号不能为空"),
    V1016("请求前置银行返回流水号不能为空"),
    V1017("请求前置支付短信验证码必须为6位"),
    V1020("请求前置业务线编号不能为空"),
    V1021("请求前置渠道编码不能为空"),
    V1022("请求前置渠道配置不能为空"),
    V1023("请求前置商户号不能为空"),
    V1024("请求前置私钥证书不能为空"),
    V1025("请求前置公钥证书不能为空"),
    V1026("请求前置签名密钥不能为空"),
    V1027("请求前置签到密钥不能为空"),
    V1028("请求前置支付金额低于最小值"),
    V1029("请求前置订单下单时间不能为空"),
    V1030("请求前置快捷支付token不能为空"),
    V1103("请求前置退款订单号不能为空"),
    V1102("请求前置'商户退款单号不能为空'和'连连银通退款单号和商户退款时间不同时为空'必须满足一条"),
    V1104("请求前置退款原单号不能为空"),
    V1105("请求前置退款原单号不合法"),
    V1106("请求前置退款银行返回流水号不能为空"),
    V1107("请求前置退款金额不合法"),
    V1108("请求前置退款时间不能为空"),
    V1109("请求前置银行编码不能为空"),
    V1110("请求前置用户请求ip不能为空"),
    V1111("请求前置支付订单号和支付返回流水号不能同时为空"),
    V1112("请求前置账号的密码不能为空"),
    V1113("请求前置退货查询请求退货订单号，退货返回流水号，支付订单号，支付返回流水号不能同时为空"),
    V1114("请求前置回调请求内容不能为空"),
    V1115("请求前置拉取对账文件对账日期不能为空"),
    V1116("请求前置拉取对账文件接口编码不能为空"),
    V1117("请求前置退货查询退款单号传入有误"),
    V1118("请求前置渠道退流水号和银行返回流水号不能同时为空"),

    V1119("请求前置签约确认流水号不能为空"),
    V1120("请求前置实名认证银行卡号不能为空"),
    V1121("请求前置实名认证持卡人姓名不能为空"),
    V1122("请求前置实名认证身份证号码不能为空"),
    V1123("请求前置签约确认是否下发成功通知不能为空"),
    V1124("请求前置实名认证手机号码不能为空"),
    V1125("请求前置分期期数不能为空"),
    V1126("请求前置USER_IP不能为空"),
    V1127("请求前置实名认证业务发生地不能为空"),
    V1128("请求前置实名认证业务类型不能为空"),
    V1129("请求前置操作员账号不能为空"),
    V1130("请求前置支付订单号和Map中订单号不一致"),
    V1131("请求前置账单日期不能为空"),

    V1132("请求前置单子创建时间不能为空"),
    V1133("请求前置单子私钥密码不能为空"),


    /**
     * 代付请求前置错误码
     */
    V1137("请求前置业务线代码不能为空"),
    V1138("请求前置代付详情集合不能为空"),
    V1139("请求前置代付详情集合数量与传递总数量不相等"),
    V1140("请求前置代付详情集合总金额与传递总金额不相等"),
    V1141("请求前置批次号不能为空"),
    V1142("请求前置用途不能为空"),


    /**
     * 拼装报文异常
     */
    B0000("拼装报文异常"),
    B0001("获取配置异常"),
    B0002("创建签名错误"),

    /**
     * 通信异常
     */
    C0001("连接异常"),
    C0002("读取异常"),
    C0003("未知主机名"),
    C0004("读取证书异常"),
    C0005("连接超时"),
    C0006("异常是用于所有处理密钥管理的操作的通用密钥管理异常"),
    C9999("未知通讯类异常"),

    /**
     * 解析报文异常
     */
    R0000("解析报文异常"),
    R0001("生成PC跳转报文失败"),
    R0002("解析报文签名错误"),
    R0003("网关返回参数异常，无法解析"),
    R0004("解析报文数据为空，无法解析"),
    R0005("数据转换异常，请联系管理员");

    private String value;

    EnumSysRtnCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
