package com.xpay.channel.front.channel.quick.billpay;

import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.front.tongxin.impl.Https2ChannelHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import org.apache.commons.codec.binary.Base64;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suxinxin on 16/2/19.
 */
public class BillPay_TongxinHandler<REQ extends BaseReqDTO> extends Https2ChannelHandler {
    @Override
    public byte[] sendBefor(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        Map<String, String> map = new HashMap<String, String>();
//        String authString = "812310060110178:vpos123";
        String authString = baseReqDTO.getMerchantNo()+":"+baseReqDTO.getPfxPass();
        String auth = "Basic " + Base64.encodeBase64String(authString.getBytes());
        map.put("Authorization", auth);
        baseReqDTO.setHeadMap(map);
        return super.sendBefor(baseReqDTO, reqMsg, channelConfig);
    }

    @Override
    public byte[] sendAfter(BaseReqDTO baseReqDTO, byte[] reqMsg, ChannelConfig channelConfig) throws CommuException {
        return super.sendAfter(baseReqDTO, reqMsg, channelConfig);
    }
}
