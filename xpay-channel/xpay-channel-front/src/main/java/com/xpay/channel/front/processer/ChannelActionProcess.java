package com.xpay.channel.front.processer;

import com.xpay.channel.common.dto.BaseRepDTO;
import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.front.utils.ChannelConfig;

/**
 * 此类为模版模式，简单实现接口某些方法，避免了继承此接口的实现类必须实现过多沉长的代码
 * Created by suxinxin on 14/12/26.
 */
public class ChannelActionProcess<REQ extends BaseReqDTO, REP extends BaseRepDTO>
        extends AbsChannelActionProcess<REQ, REP> {
    @Override
    protected void beforProcess(REQ req, ChannelConfig channelConfig) {
    }

    @Override
    protected void afterProcess(REQ req, REP rep, ChannelConfig channelConfig) {

    }
}
