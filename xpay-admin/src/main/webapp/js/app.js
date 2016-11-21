App = {
    config:{
        url:(function(){
            //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
            var curWwwPath=window.document.location.href;
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName=window.document.location.pathname;
            var pos=curWwwPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8083
            var localhostPaht="";
            if(pathName == '/'){
            	var localhostPathUrls = curWwwPath.split('//');
            	localhostPaht=localhostPathUrls[0]+'//'+localhostPathUrls[1].substring(0,localhostPathUrls[1].indexOf(pathName));
            }else{
            	localhostPaht = curWwwPath.substring(0,pos);
            }
            //获取带"/"的项目名，如：/uimcardprj
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            if(projectName.indexOf('smallpay-smp')<=0){
            	projectName = "";
            }
            return(localhostPaht+projectName);
        }()),
        isLogin:false
    },
    cookie:{
        setCookie:function(c_name,value,expiredays){
        	//debugger;
            var exdate=new Date();
            exdate.setDate(exdate.getDate()+expiredays);
            document.cookie=c_name+ "=" +escape(value)+";path=/"+
                ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
        },
        getCookie:function(c_name){
            if (document.cookie.length>0)
            {
                c_start=document.cookie.indexOf(c_name + "=");
                if (c_start!=-1)
                {
                    c_start=c_start + c_name.length+1;
                    c_end=document.cookie.indexOf(";",c_start);
                    if (c_end==-1) c_end=document.cookie.length;
                    return unescape(document.cookie.substring(c_start,c_end));
                }
            }
            return "";
        }
    }
};

function checkShowByPageBtnKey(idAndbtnkey,pagekey){
	var requestUrl = App.config.url+"/sysSecurity/checkRoleByPageAndBtnKey";
	var check_show = true;//true 可以看
	$.ajax({
		url : requestUrl,
		method : 'post',
		async : false,
		dataType : 'json',
		data : {'pageKey':pagekey,'btnKey':idAndbtnkey},
		success : function(data) {
			var ret = eval(data);
			if(!ret.success){//TRUE 可以看
				$("#"+idAndbtnkey).hide();// FALSE 不可以看
				check_show = false;
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {	
			var result = JSON.parse(XMLHttpRequest.responseText);
		}
	});
	return check_show;
}
function a(){
	return true;
}
function checkShowByPageBtnKeyFormatter(idAndbtnkey,pagekey){
	var requestUrl = App.config.url+"/sysSecurity/checkRoleByPageAndBtnKey";
	var res;
	$.ajax({
		url : requestUrl,
		method : 'post',
		async : false,
		dataType : 'json',
		data : {'pageKey':pagekey,'btnKey':idAndbtnkey},
		success : function(data) {
			var ret = eval(data);
			res = ret.success;
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			var result = JSON.parse(XMLHttpRequest.responseText);
		}
	});
	return res; 
}
/**
 * 前端字典处理JS组件，从后台缓存/数据库中查询所有字典数据，然后再浏览器Cookie中保存，
 * HTML中显示字典直接从Cookie中获取获取数据，效率更高。
 * @author wangzhenlei
 * @since 2015-4-23 11:48 create
 * */
//获取所有字典数据
var DictCache = function() {
	if (typeof DictCache.instance === 'object') {
		return DictCache.instance;
	}
	DictCache.instance = this;
	this.dictTypes = new Array();
	this.dictItems = new Array();
	this.getDictItemName = getDictItemName;
	this.getDictItems = getDictItems;
	this.getDictItemsDflt = getDictItemsDflt;
	this.getDictItemsDefault = getDictItemsDefault;
	this.getDictItemsCallBack = getDictItemsCallBack;
	this.dictData = new Object();
	
	//获取字典项名称typeCode：字典类型编码，itemCode：字典项编码
//	function getDictItemName(typeCode, itemCode){
//		if(this.dictTypes.length <= 0){
//			return "";
//		}
//		for(var i=0; i<this.dictTypes.length; i++){
//			if(this.dictTypes[i].typeCode != typeCode){
//				continue;
//			}
//			for(var j=0; j<this.dictItems.length; j++){
//				if(this.dictItems[j].typeCode != this.dictTypes[i].typeCode || this.dictItems[j].itemCode != itemCode){
//					continue;
//				}
//				return this.dictItems[j].itemName;
//			}
//		}
//	}
	
	//获取字典项名称typeCode：字典类型编码，itemCode：字典项编码
	function getDictItemName(typeCode, itemCode){
		if(this.dictData==null){
			return "";
		}
		var data = this.dictData;
		for(var o in data){
			if(o==typeCode){
				for(var n in data[o]){
					if(data[o][n].itemCode==itemCode){	
						return data[o][n].itemName;
					}
				}
				return itemCode;
			}
			
		}
	}
	
	
	//获取所有字典项typeCode：字典类型编码
	function getDictItems(typeCode, className){
		var ret = new Array();
//		if(this.dictTypes.length <= 0){
//			return ret;
//		}
//		for(var i=0; i<this.dictTypes.length; i++){
//			if(this.dictTypes[i].typeCode != typeCode){
//				continue;
//			}
//			for(var j=0; j<this.dictItems.length; j++){
//				if(this.dictItems[j].typeCode != typeCode){
//					continue;
//				}
//				ret.push(this.dictItems[j]);
//			}
//			break;
//		}
		if(null == this.dictData){
			return ret;
		}
		ret = this.dictData[typeCode];
		if(className && ret.length > 0){
			var codeResult = [];
			for(var i=0; i<ret.length; i++){
				if(className == ret[i].className){
					codeResult.push(ret[i]);
				}
			}
			return codeResult;
		}
		return ret;
	}
	//获取所有字典项typeCode：字典类型编码 (带默认值：--请选择--)
	function getDictItemsDflt(typeCode , className){
		var ret = new Array();
		var retTem = new Array();
		if(null == this.dictData){
			return ret;
		}
		ret.push({itemCode:'',itemName:'--请选择--'});
		retTem = this.dictData[typeCode];
		for(var i=0;i<retTem.length;i++){
			ret.push(retTem[i]);
		}
		if(className && retTem.length > 0){
			var codeResult = [];
			codeResult.push({itemCode:'',itemName:'--请选择--'});
			for(var i=0; i<retTem.length; i++){
				if(className == retTem[i].className){
					codeResult.push(retTem[i]);
				}
			}
			return codeResult;
		}
		return ret;
	}
	
	//获取所有字典项typeCode：字典类型编码 (带默认值：--全部--)
	function getDictItemsDefault(typeCode , className){
		var ret = new Array();
		var retTem = new Array();
		if(null == this.dictData){
			return ret;
		}
		ret.push({itemCode:'',itemName:'全部'});
		retTem = this.dictData[typeCode];
		for(var i=0;i<retTem.length;i++){
			ret.push(retTem[i]);
		}
		if(className && retTem.length > 0){
			var codeResult = [];
			codeResult.push({itemCode:'',itemName:'全部'});
			for(var i=0; i<retTem.length; i++){
				if(className == retTem[i].className){
					codeResult.push(retTem[i]);
				}
			}
			return codeResult;
		}
		return ret;
	}
	
	//获取所有字典项typeCode：字典类型编码
	function getDictItemsCallBack(typeCode, callback){
		var ret = new Array();
		if(this.dictTypes.length <= 0){
			return ret;
		}
		for(var i=0; i<this.dictTypes.length; i++){
			if(this.dictTypes[i].typeCode != typeCode){
				continue;
			}
			for(var j=0; j<this.dictItems.length; j++){
				if(this.dictItems[j].typeCode != typeCode){
					continue;
				}
				ret.push(this.dictItems[j]);
			}
			break;
		}
		callback({"data":ret});
	}
};
//字典缓存数据JS对象
var dictCache = new DictCache();


function loadAllDictFromCache(glcache, url) {
	var requestUrl = url;
	if(null == requestUrl || undefined == requestUrl){
		requestUrl = App.config.url+"/dict/getAllFromCache";
	}
	$.ajax({
		url : requestUrl,
		method : 'post',
		async : false,
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		processData : false,
		success : function(data, textStatus, jqXHR) {
			var ret = eval(data);
			if(ret.success){
				glcache.dictData = ret.data;
				glcache.dictTypes = ret.data;
				glcache.dictItems = ret.data;
				
			}else{
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			var result = JSON.parse(XMLHttpRequest.responseText);
		}
	});
}

function loadAllDict(glcache, url) {
	var requestUrl = url;
	if(null == requestUrl || undefined == requestUrl){
		requestUrl = App.config.url+"/dict/getAllFromCache";
	}
	$.ajax({
		url : requestUrl,
		method : 'post',
		async : false,
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		processData : false,
		success : function(data, textStatus, jqXHR) {
			var ret = eval(data);
			if(ret.success){
				glcache.dictTypes = ret.data.dictTypes;
				glcache.dictItems = ret.data.dictItems;
			}else{
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			var result = JSON.parse(XMLHttpRequest.responseText);
		}
	});
}

//------时间格式化-------
//把每行的时间类型格式化（easyui）
function formatterdate(value, row, index) {
//	debugger;
	if(value==null)return;
    var date = new Date(value);
    var year = date.getFullYear().toString();
    var month = (date.getMonth() + 1);
    var day = date.getDate().toString();
    var hour = date.getHours().toString();
    var minutes = date.getMinutes().toString();
    var seconds = date.getSeconds().toString();
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
}

//把每行的时间类型格式化 只显示年月日（easyui）2015-12-12
function formatterdateday(value, row, index) {
//	debugger;
	if(value==null || value=='')return '';
    var date = new Date(value);
    var year = date.getFullYear().toString();
    var month = (date.getMonth() + 1);
    var day = date.getDate().toString();
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    return year + "-" + month + "-" + day;
}


//把每行的日期类型格式化（easyui）
function formatterday(val, row) {
	if(val==null || val == '')return;
	if (val != null) {
	var date = new Date(val);
	return date.getFullYear() + '-' + (date.getMonth() + 1) + '-'
	+ date.getDate();
	}
}

//获取日期字符串，AddDayCount为-1为昨天，0为今天，1为明天，以此类推
function GetDateStr(AddDayCount) { 
	var dd = new Date(); 
	dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期 
	var y = dd.getFullYear(); 
	var m = dd.getMonth()+1;//获取当前月份的日期 
	var d = dd.getDate(); 
	return y+"-"+m+"-"+d+" 00:00:00"; 
} 

//把时间类型转换成YY-MM-DD hh:mm:ss格式
function transTime(data){
	if(data==null)return;
	var year = data.getFullYear(); 
    var month = data.getMonth() + 1; 
    var date = data.getDate(); 
    var hours = data.getHours();
    var mins = data.getMinutes();
    var second = data.getSeconds();
    if (month < 10) { month = "0" + month; } 
    if (date < 10) { date = "0" + date; } 
    if (hours < 10) { hours = "0" + hours; } 
    if (mins < 10) { mins = "0" + mins; } 
    if (second < 10) { second = "0" + second; } 
    return  year + "-" + month + "-" + date +" " + hours+":"+mins+":"+second ;
    
}
function formatterTime(value, row ){
	if(value==null || value == ''){
		return;
	}else if(value.length == 14){
		return value.substring(0, 4) + "-" + value.substring(4, 6) + "-" + value.substring(6, 8)+" "
			  +value.substring(8,10) + ":" + value.substring(10,12) + ":" + value.substring(12);
	}else {
		return value;	
	}
}

//转换金钱，把s加逗号并保留n位
function fmoney(s,n)   
{   
	//debugger;
	if(s==null || s == ''){
		return '0';//如果为空 返回0
		// return '0.000';//如果为空 返回0
	}
    n = n > 0 && n <= 20 ? n : 2;   
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var l = s.split(".")[0].split("").reverse(),   
    r = s.split(".")[1];   
    t = "";   
    for(i = 0; i < l.length; i ++ )   
    {   
       t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
    }   
    return t.split("").reverse().join("") + "." + r;   
}

function formatterreconresult(val,row){
	if(val=='00'){
		return '是';
	}else if(val=='01'){
		return '否';
	}
}
//设置费率
function formatterrate(value){
	//debugger;
	if(value == 0 || value == undefined || value == null){
		return 0;
	}else{
		
		return accMul(value,100);
	}
}
//乘法  
function accMul(arg1,arg2)   
{   
var m=0,s1=arg1.toString(),s2=arg2.toString();   
try{m+=s1.split(".")[1].length}catch(e){}   
try{m+=s2.split(".")[1].length}catch(e){}   
return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);   
} 
//function toDecimal2(x) { 
//	debugger;
//    var f = parseFloat(x);  
//    if (isNaN(f)) {  
//        return false;  
//    }  
//    var f = x*100;  
//    var s = f.toString();  
//    var rs = s.indexOf('.');  
//    if (rs < 0) {  
//        rs = s.length;  
//        s += '.';  
//    }  
//    while (s.length <= rs + 2) {  
//        s += '0';  
//    }  
//    return s;  
//}  
// 折扣格式（n/100）
function formatterdiscount(rate){
	if(rate==null){
		return 0;
	}else{
		return rate*100;
	}
}
/*
 *根据编码获取对应的菜单状态
 */
function formatterMenuState(val,row){
	return findItemNameByCodeAndVal('MENU_STATE',val);
}
/*
*根据编码获取对应的状态
*/
function formatterLogLevel(val,row){
	return findItemNameByCodeAndVal('LOG_LEVEL',val);
}

//交易状态名称Formatter
function formatterTraneFlowStatus(val,row){
	return findItemNameByCodeAndVal('trade_flow_status',val);
}
//提现对账差错订单类型Formatter
function formatterWithdrawOrderType(val,row){
	return findItemNameByCodeAndVal('withdraw_order_type',val);
}

//提现交易订单类型Formatter
function formatterReconProcessType(val,row){
	return findItemNameByCodeAndVal('recon_process_type',val);
}

//提现交易订单差错类型Formatter
function formatterWithdrawErrorType(val,row){
	return findItemNameByCodeAndVal('recon_error_type',val);
}
//是否已记账状态
function formatterJzStatus(val,row){
	return findItemNameByCodeAndVal('jzstatus',val);
}
//交易类型Formatter
function formatterTradeType(val,row){
	return findItemNameByCodeAndVal('trade_type',val);
}
//会员账户流水交易类型Formatter
function formatterCstFTradeType(val,row){
	return findItemNameByCodeAndVal('cst_acc_flow_type',val);
}
//处理类型Formatter 00-补记账 01-补单 02-人工处理
function formatterProcessType(val,row){
	return findItemNameByCodeAndVal('process_type',val);
}
//标的状态Formatter
function formatterLendStatus(val,row){
	return findItemNameByCodeAndVal('lend_status',val);
}
//提现审核状态Formatter
function formatterWithdrawApplyStatus(val,row){
	return findItemNameByCodeAndVal('withdrawApply_status',val);
}
//订单交易状态
function formatterstatus(val,row){
	return dictCache.getDictItemName('withdra_status',val);
}
//支付方式Formatter
function formatterPayType(val,row){
	return findItemNameByCodeAndVal('pay_type',val);
}
//安全级别Formatter
function formatterSecuLevel(val,row){
	return findItemNameByCodeAndVal('secuLevel',val);
}
//账户类型Formatter
function formatterACCTYPE(val,row){
	return findItemNameByCodeAndVal('ACC_TYPE',val);
}
//支付工具状态Formatter
function formatterFundsproductStutas(val,row){
	return findItemNameByCodeAndVal('fundsproduct_stutas',val);
}
//银行卡类型Formatter
function formatterCARDTYPE(val,row){
	return findItemNameByCodeAndVal('CARD_TYPE',val);
}
//用户状态formatter
function formatterUSERTYPE(val,row){
	return findItemNameByCodeAndVal('sysuser_status',val);
}
//行业类型Formatter
function formatterINDUSTRYTYPE(val,row){
	return findItemNameByCodeAndVal('INDUSTRY_TYPE',val);
}
//是否调账类型Formatter
function formatterTTYPERECON(val,row){
	return findItemNameByCodeAndVal('t_type_recon',val);
}
//交易方式Formatter
function formatterTransType(val,row){
	return findItemNameByCodeAndVal('trans_type',val);
}
//清算状态Formatter
function formatterClearStatus(val,row){
	return findItemNameByCodeAndVal('clear_status',val);
}
//审核状态Formatter
function formatterVerifyStatus(val,row){
	return findItemNameByCodeAndVal('verify_status',val);
}
//开通状态Formatter
function formatterOpenStatus(val,row){
	return findItemNameByCodeAndVal('open_status',val);
}

//加密方式Formatter
function formatterEncType(val,row){
	return findItemNameByCodeAndVal('enc_type',val);
}

//计费方式Formatter
function formatterFeeType(val,row){
	return findItemNameByCodeAndVal('fee_type',val);
}
//控件状态Formatter
function formatterSecurity(val,row){
	return findItemNameByCodeAndVal('SECURITY_BTN',val);
}

//外部差错类型Formatter
function formatterTaskErrorType(val,row){
	return findItemNameByCodeAndVal('task_error_type',val);
}

//内部差错类型Formatter
function formatterInnerTaskError(val,row){
	return findItemNameByCodeAndVal('inner_task_error',val);
}
//短信发送支付渠道
function formattersendChannelOrg(val,row){
	if(val==''){
		return '微支付';
	}
	return findItemNameByCodeAndVal('channelOrg',val);
}

//对账状态Formatter
function formatterTaskStatus(val,row){
	return findItemNameByCodeAndVal('recon_state',val);
}

//用户开户状态
function formatteruserstatus(val){
	return dictCache.getDictItemName('acc_open_status',val);
}
//审核状态
function formatterBfjStatus(val,row){
	return findItemNameByCodeAndVal('bfj_status',val);
}
//验证方式Formatter
function formatterCertifiType(val,row){
	return findItemNameByCodeAndVal('certifi_type',val);
}
//账户类型Formatter
function formatterMerAccType(val,row){
	return findItemNameByCodeAndVal('mer_acc_type',val);
}
//商户账户类型Formatter
function formatterMerAcc(val,row){
	return findItemNameByCodeAndVal('merAcc',val);
}
//账户变动类型Formatter
function formatterAccTransType(val,row){
	return findItemNameByCodeAndVal('transType',val);
}
//平台账户流水交易类型Formatter
function formatterAccTradeType(val,row){
	return findItemNameByCodeAndVal('acc_trade_type',val);
}
//账户变动方向Formatter
function formatterDirection(val,row){
	return findItemNameByCodeAndVal('accDirection',val);
}
//证件类型Formatter
function formatterCertType(val,row){
	return findItemNameByCodeAndVal('cert_type',val);
}
//是否已实名Formatter
function formatterCuIscertified(val,row){
	return findItemNameByCodeAndVal('cuIscertified',val);
}
//认证等级Formatter
function formatterIscertifiedClass(val,row){
	return findItemNameByCodeAndVal('csrtifiedClass',val);
}
//客户账户类型Formatter
function formatterCstAcc(val,row){
	return findItemNameByCodeAndVal('cstAcc',val);
}
//交易状态Formatter
function formatterTransStatus(val,row){
	return findItemNameByCodeAndVal('transStatus',val);
}
//机构类型Formatter
function formatterOrgType(val,row){
	return findItemNameByCodeAndVal('orgAcc',val);
}
//机构账户类型
function formatterAccType(val,row){
	return findItemNameByCodeAndVal('orgAcc',val);
}
//渠道机构类型Formatter
function formatterChannelOrgType(val,row){
	return findItemNameByCodeAndVal('channel_org_type',val);
}
//第三方支付渠道
function formatterChannelOrg(val,row){
	return findItemNameByCodeAndVal('channelOrg',val);
}

//省Formatter
function formatterProvince(val,row){
	return findItemNameByCodeAndVal('province',val);
}
//市Formatter
function formatterCity(val,row){
	return findItemNameByCodeAndVal('city',val);
}
//退款时是否退回手续费Formatter
function formatterRefund(val,row){
	return findItemNameByCodeAndVal('is_refund_fee',val);
}
//商户销售产品Formatter
function formatterSalePro(val,row){
	return findItemNameByCodeAndVal('sale_pro',val);
}
//商户支付产品Formatter
function formatterPayPro(val,row){
	return findItemNameByCodeAndVal('pay_pro',val);
}
//借贷记标识Formatter
function formatterDebit(val,row){
	return findItemNameByCodeAndVal('debit_note',val);
}
//是否支持退款Formatter
function formatterIsRefund(val,row){
	return findItemNameByCodeAndVal('is_refund',val);
}
//是否渠道发送短信Formatter
function formatterIsMesg(val,row){
	return findItemNameByCodeAndVal('is_mesg',val);
}
//是否交易申请Formatter
function formatterTranspre(val,row){
	return findItemNameByCodeAndVal('is_transpre',val);
}
//是否上传协议
function formatterProtocol(val,row){
	return findItemNameByCodeAndVal('is_protocol',val);
}
//结算内容
function formatterSttContent(val,row){
	return findItemNameByCodeAndVal('stt_content',val);
}
//机构状态
function formatterOrgStt(val,row){
	return findItemNameByCodeAndVal('org_stt',val);
}
//机构结算周期状态
function formatterOrgSettleStt(val,row){
	return findItemNameByCodeAndVal('org_settle_status',val);
}
//差错处理状态
function formatterTaskErrorPro(val,row){
	return findItemNameByCodeAndVal('task_error_pro',val);
}
//差错处理审核状态
function formatterTaskErrorVer(val,row){
	return findItemNameByCodeAndVal('task_error_verify',val);
}
//交换种类
function formatterExchangeType(val,row){
	return findItemNameByCodeAndVal('exchange_type',val);
}
//线上业务还是线下业务
function formatterBusinessType(val,row){
	return findItemNameByCodeAndVal('business_type',val);
}
//是大额小额还是超网
function formatterLimitType(val,row){
	return findItemNameByCodeAndVal('limit_type',val);
}
//是否支持批量
function formatterIsBatch(val,row){
	return findItemNameByCodeAndVal('is_batch',val);
}
//账户对公还是对私
function formatterAccProp(val,row){
	return findItemNameByCodeAndVal('acc_prop',val);
}
//支付产品套餐用户类型
function formatterPayUserType(val,row){
	return findItemNameByCodeAndVal('pay_user_type',val);
}
//支付产品类型
function formatterPayPdType(val,row){
	return findItemNameByCodeAndVal('paypd_type',val);
}
//是否实时到账
function formatterIRA(val,row){
	return findItemNameByCodeAndVal('is_realtime_arrival',val);
}
function formatterNull(val, row){
	return (val == null)?"":val;
}
//获取行业名称
function formatterIndustry(val, row){
	return findItemNameByCodeAndVal('industry',val);
}
//获取子行业名称
function formatterSubIndustry(val, row){
	return findItemNameByCodeAndVal('subIndustry',val);
}

//获取商户操作员状态名称
function formatterMerOperStatus(val, row){
	return findItemNameByCodeAndVal('mer_oper_status',val);
}
//获取商户操作员身份类型名称
function formatterMerOperIdentity(val, row){
	return findItemNameByCodeAndVal('mer_oper_identity',val);
}
//获取公告状态名称
function formatterNoticeStatus(val, row){
	return findItemNameByCodeAndVal('notice_status',val);
}
//获取清结算状态名称
function formatterCearStatus(val, row){
	return findItemNameByCodeAndVal('cmf_clear_status',val);
}
//获取清结算手续费收取方式名称
function formatterClearFeeType(val, row){
	return findItemNameByCodeAndVal('cmf_clear_fee_type',val);
}
//获取币种
function formatterCurrency(val, row){
	return findItemNameByCodeAndVal('currency',val);
}
//获取对账类型
function formatterReconType(val, row){
	return findItemNameByCodeAndVal('reconType',val);
}

//获取客户、账户、用户状态
function formatterCstAccStatus(val, row){
	return findItemNameByCodeAndVal('cstAccStatus',val);
}

//获取第三方渠道
function formatterChannelOrg(val, row){
	return findItemNameByCodeAndVal('channelOrg',val);
}
//获取调账交易类型
function formatterART(val, row){
	return findItemNameByCodeAndVal('acc_regulate_type',val);
}
//获取综合调账用账户类型
function formatterCAAT(val, row){
	return findItemNameByCodeAndVal('com_adjust_acc_type',val);
}
//获取综合调账调账方式
function formatterCART(val, row){
	return findItemNameByCodeAndVal('compr_adj_reg_type',val);
}
//获取综合调账金账户类型
function formatterCAMT(val, row){
	return findItemNameByCodeAndVal('compr_adj_mo_type',val);
}
//获取综合调账用户金账户类型
function formatterCAUMT(val, row){
	return findItemNameByCodeAndVal('com_adj_us_mo_type',val);
}
//获取综合调账方向
function formatterCARD(val, row){
	return findItemNameByCodeAndVal('compr_adj_reg_dire',val);
}
//获取调账记账状态
function formatterCAS(val, row){
	return findItemNameByCodeAndVal('com_adj_status',val);
}
//定时任务名称
function formatterTaskJob(val, row){
	var retMsg = findItemNameByCodeAndVal('task_job',val);
	if(!retMsg){
		retMsg = val;
	}
	return retMsg;
}
//定时任务执行结果
function formatterTaskRunState(val, row){
	return findItemNameByCodeAndVal('task_run_state',val);
}
//定时任务类型
function formatterTaskType(val, row){
	return findItemNameByCodeAndVal('task_type',val);
}

//会员交易类型Formatter
function formatterCstTradeType(val,row){
	return findItemNameByCodeAndVal('cstTransType',val);
}

//商户交易类型Formatter
function formatterMerTradeType(val,row){
	return findItemNameByCodeAndVal('trade_type',val);
}
//商户账户流水交易类型Formatter
function formatterMerFTradeType(val,row){
	return findItemNameByCodeAndVal('mer_trade_type',val);
}

//商户等级
function formatterMerClass(val,row){
	return findItemNameByCodeAndVal('merClass',val);
}

//用户绑卡状态Formatter
function formatterCardStatus(val,row){
	return findItemNameByCodeAndVal('boundCardStatus',val);
}
//交易状态
function formatterdatahead(val){
	return dictCache.getDictItemName('trans_source',val);
}
//是否为提现卡Formatter
function formatterWithdrawFlag(val,row){
	return findItemNameByCodeAndVal('withdrawFlag',val);
}
//
function formatterPayProStatus(val, row){
	return findItemNameByCodeAndVal('payProStatus',val);
}
//银行卡认证状态Formatter
function formatterCAT(val,row){
	return findItemNameByCodeAndVal('cardAuth_type',val);
}
//会员账户流水 交易类型Formatter
function formatterCAFT(val,row){
	return findItemNameByCodeAndVal('cst_acc_flow_type',val);
}
//退款流水查询 退款类型Formatter 
function formatterRT(val,row){
	return findItemNameByCodeAndVal('refund_type',val);
}
//退款流水查询 退款状态Formatter 
function formatterRS(val,row){
	return findItemNameByCodeAndVal('refund_status',val);
}
//退款流水查询 支付状态Formatter 
function formatterPS(val,row){
	return findItemNameByCodeAndVal('pay_status',val);
}

//金融交换信息 是否已经设置手续费Formatter 
function formatterISOTS(val,row){
	return findItemNameByCodeAndVal('is_ots',val);
}

//金融交换信息 卡级别Formatter 
function formatterCardLevel(val,row){
	return findItemNameByCodeAndVal('card_level',val);
}

//金融交换信息 同行异行Formatter 
function formatterIsDirect(val,row){
	return findItemNameByCodeAndVal('is_direct',val);
}

//支付工具 支付工具接入方式Formatter 
function formatterPayToolJoinType(val,row){
	return findItemNameByCodeAndVal('pay_tool_join_type',val);
}

//支付工具 支付方式Formatter 
function formatterPayTypeTool(val,row){
	return findItemNameByCodeAndVal('pay_type_tool',val);
}

//支付工具 对公对私Formatter 
function formatterPrivatePublic(val,row){
	return findItemNameByCodeAndVal('private_public',val);
}

//支付工具 业务模式Formatter 
function formatterBusinessMode(val,row){
	return findItemNameByCodeAndVal('business_mode',val);
}

//支付工具 业务提交模式Formatter 
function formatterBusiCommitModel(val,row){
	return findItemNameByCodeAndVal('busi_commit_model',val);
}

//支付工具 支付资金载体Formatter 
function formatterCapitalCarrier(val,row){
	return findItemNameByCodeAndVal('capital_carrier',val);
}
//支付工具 支付工具类型Formatter 
function formatterPayToolType(val,row){
	return findItemNameByCodeAndVal('pay_way_type',val);
}

//月份Formatter
function formatterMonth(val,row){
	return findItemNameByCodeAndVal('month_code',val);
}
//日Formatter
function formatterDay(val,row){
	return findItemNameByCodeAndVal('day_code',val);
}
//日类型Formatter
function formatterDayType(val,row){
	return findItemNameByCodeAndVal('day_type',val);
}

//金融管控 渠道等级 
function formatterOrgLevel(val,row){
	return findItemNameByCodeAndVal('ORG_LEVEL',val);
}

//提现冻结类型
function formatterWithdraFreezeType(val,row){
	return findItemNameByCodeAndVal('withdra_freeze_type',val);
}

//提现划拨类型
function formatterWithdraXfeType(val,row){
	return findItemNameByCodeAndVal('withdra_xfe_type',val);
}

//提现解冻类型
function formatterWithdraThawType(val,row){
	return findItemNameByCodeAndVal('withdra_thaw_type',val);
}

//提现冻结状态
function formatterWithdraFreStatus(val,row){
	return findItemNameByCodeAndVal('withdra_fre_status',val);
}

//提现划拨状态
function formatterWithdraXfeStatus(val,row){
	return findItemNameByCodeAndVal('withdra_xfe_status',val);
}

//提现解冻状态
function formatterWithdraThawStatus(val,row){
	return findItemNameByCodeAndVal('withdra_thaw_status',val);
}

//交易退款类型
function formatterTradeRefundType(val,row){
	return findItemNameByCodeAndVal('trade_refund_type',val);
}

//交易退款状态
function formatterTradeRefundStatus(val,row){
	return findItemNameByCodeAndVal('trade_refund_status',val);
}

//冻结回滚状态
function formatterWdrRollbackStatus(val,row){
	return findItemNameByCodeAndVal('wdr_rollback_status',val);
}

//委托提现状态
function formatterDelegateStatus(val,row){
	return findItemNameByCodeAndVal('delegate_status',val);
}

//委托受理状态
function formatterDlgtWithdrawStatus(val,row){
	return findItemNameByCodeAndVal('dlgt_withdraw_status',val);
}

//订单交易状态
function formatterWithdraStatus(val,row){
	return dictCache.getDictItemName('withdra_status',val);
}
//对账报警邮件类型
function formatterWarnMailType(val,row){
	var ret = findItemNameByCodeAndVal('warn_mail_type',val);
	if(ret){
		return ret;
	}
	return val;
}

//对账报警邮件接收类型
function formatterAcceptType(val,row){
	var ret = findItemNameByCodeAndVal('accept_type',val);
	if(ret){
		return ret;
	}
	return val;
}

/*
*根据编码和值获取对应的名称
*/
function findItemNameByCodeAndVal(type, val){
	return dictCache.getDictItemName(type,val);
}
// 校验
$.extend($.fn.validatebox.defaults.rules, {  
    phone : {// 验证电话号码  
        validator : function(value) {  
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);  
        },  
        message : '格式不正确,请使用下面格式:010-88888888'  
    },  
    mobile : {// 验证手机号码  
        validator : function(value) {  
            return /^(13|15|18)\d{9}$/i.test(value);  
        },  
        message : '手机号码格式不正确'  
    },  
    card : {// 验证身份证号码  
        validator : function(value) {  
            return /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X|x)$/i.test(value);  
        },  
        message : '身份证号码格式不正确'  
    }, 
    newpass : {// 验证新密码策略  
        validator : function(value) {  
            return /^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[@!#$%^&*()_+\.\-\?<>'"|=]+).{8,30}$/i.test(value);  
        },  
        message : '内容长度在8到30位之间,包含大写或小写英文、数字、特珠字符(如@!#$%等)'  
    }, 
    /*ip : {// 验证IP地址  
        validator : function(value) {  
            return /d+.d+.d+.d+/i.test(value);  
        },  
        message : 'IP地址格式不正确'  
    }  */
    
    //国内邮编验证  
    zipcode: {  
        validator: function (value) {  
            var reg = /^[1-9]\d{5}$/;  
            return reg.test(value);  
        },  
        message: '邮编必须是非0开始的6位数字.'  
    },
    notNull : {// 验证是否为空 
        validator : function(value) {  
            return value != null && value != '';  
        },  
        message : '此项为必填项'  
    }, 
});


//请求数据字典的combox公用方法
function findDicforType(typeCode, inputId){
	$.ajax({  
 	   type: "POST",  
 	   url: "../../dict/getDictItems?typeCode="+typeCode,  
 	   success: function(json){ 
				var str = '[{"value":"","text":"--"},';
				for(var o in json.data){
					 var text = json.data[o].itemName;
					 var id = json.data[o].itemCode;
					 var sr = '{"value":"'+id+'","text":"'+text+'" },';
					 str = str + sr;
				} 
				str=str.substring(0,str.length-1);
				str = str+']';

				var obj = eval('(' + str + ')');
 	    	 $("#"+inputId).combobox( 'loadData' , obj);
 	   }  
    }); 
}

//搜索框的重置方法
function cleanText(formId){
	$("#"+formId).form('clear');
}


