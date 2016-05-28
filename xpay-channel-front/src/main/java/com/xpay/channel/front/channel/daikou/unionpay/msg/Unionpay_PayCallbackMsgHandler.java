package com.xpay.channel.front.channel.daikou.unionpay.msg;

import com.xpay.channel.common.dto.daikou.CancelCallbackReqDto;
import com.xpay.channel.common.dto.daikou.PayCallbackRepDto;
import com.xpay.channel.common.dto.daikou.PayCallbackReqDto;
import com.xpay.channel.common.enums.EnumSysRtnCode;
import com.xpay.channel.common.enums.EnumTradeStatus;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.front.channel.daikou.unionpay.util.UnionpayUtil;
import com.xpay.channel.front.msg.impl.FreemarkChannelMsgHandlerImpl;
import com.xpay.channel.front.utils.ChannelConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/28 下午3:00
 */
public class Unionpay_PayCallbackMsgHandler extends FreemarkChannelMsgHandlerImpl<PayCallbackReqDto,PayCallbackRepDto> {

    @Override
    protected String getTemplatePath() {
        return null;
    }

    private static final Logger logger = LoggerFactory.getLogger(Unionpay_PayCallbackMsgHandler.class) ;

    @Override
    public byte[] builderMsg(PayCallbackReqDto t, ChannelConfig channelConfig) throws BuildMsgException {
        return "".getBytes() ;
    }

    @Override
    public PayCallbackRepDto resolveMsg(PayCallbackReqDto reqDto, byte[] rtnMsg, ChannelConfig channelConfig) throws ResolveMsgException {
        PayCallbackRepDto repDto = new PayCallbackRepDto() ;
        try {
            logger.info("#####[银联全渠道代扣] 异步回调 处理开始.");
            Map<String, String> map = reqDto.getMap();
            logger.info("#####[[银联全渠道代扣] 异步回调 返回Map为:" + map);
            if (map == null || map.isEmpty()) {
                logger.info("#####[银联全渠道代扣] 异步回调 获取的返回报文为空.");
                throw new ResolveMsgException(EnumSysRtnCode.R0004, EnumTradeStatus.UNKNOW);
            }

            boolean flag = UnionpayUtil.verSign(map, reqDto.getChannelRemark().getCerPath()) ;
            if (flag) {
                //拼装报文,并返回结果
                logger.info("#####[银联全渠道代扣] 异步回调 验签成功:flag=" + flag);

            }else{
                logger.info("#####[银联全渠道代扣] 回调验签失败:flag=" + flag) ;
                repDto.setTradeStatus(EnumTradeStatus.UNKNOW) ;
                repDto.setRtnMsg("验签失败");
                repDto.setRtnCode(EnumTradeStatus.UNKNOW.name());
            }
        }catch (Exception e){
            logger.info("#####[银联全渠道代扣] 解析报文异常." , e);
            throw new ResolveMsgException(EnumSysRtnCode.R0000, EnumTradeStatus.UNKNOW);
        }

        return repDto;
    }
}
