package com.xpay.channel.front.processer;

import com.xpay.channel.common.dto.BaseRepDTO;
import com.xpay.channel.common.dto.BaseReqDTO;
import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.channel.front.tongxin.ChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.vld.ChannelValidateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * 前置系统主要行为的实现封装类，抽象实现了整个前置的全部行为，集成了系统各个组件
 * Created by suxinxin on 14/12/25.
 */
public abstract class AbsChannelActionProcess<REQ extends BaseReqDTO, REP extends BaseRepDTO> {
    private static final Logger logger = LoggerFactory.getLogger(AbsChannelActionProcess.class);

    /**
     * 接口验证参数
     */
    private ChannelValidateHandler<REQ> channelValidate;

    /**
     * 报文组件
     */
    private ChannelMsgHandler<REQ, REP> channelMsgHandler;

    /**
     * 通信组件
     */
    private ChannelTongXinHandler channelTongXinHandler;

    /**
     * 配置组件
     */
    private ChannelConfig channelConfig;


    /**
     * 核心方法
     *
     * @param req 上层平台请求实体
     * @return
     * @throws BuildMsgException
     * @throws ResolveMsgException
     * @throws CommuException
     */
    public REP doProcess(REQ req) throws VldException, BuildMsgException, ResolveMsgException, CommuException {

        logger.info("[渠道系统][前置模块]请求前置参数为:" + req);
        logger.info("[渠道系统][前置模块]渠道配置参数为:" + channelConfig);
        beforProcess(req, channelConfig); //前置处理

        if (channelValidate != null) {   //如果参数校验组建为空则不验证参数
            channelValidate.validate(req);
            logger.info("[渠道系统][前置模块]参数验证完成:" + req);
        }

        byte[] reqAfter = null; //请求报文
        REQ reqBefor = null;    //请求实体
        if (channelMsgHandler != null) {   //如果报文组件为空就不组建报文
            reqBefor = channelMsgHandler.beforBuildMsg(req, channelConfig);  //拼装报文之前
            byte[] reqMsg = channelMsgHandler.builderMsg(reqBefor, channelConfig); //组建报文
            reqAfter = channelMsgHandler.afterBuildMsg(reqBefor, reqMsg, channelConfig); //拼装报文之后
            try {
                logger.info("[渠道系统][前置模块]前置创建报文完成:" + new String(reqAfter, channelConfig.getCharset()));
            } catch (UnsupportedEncodingException e) {
                logger.error("[渠道系统][前置模块]不支持报文编码格式:" + channelConfig.getCharset(), e);
            }
        }


        byte[] rtnMsg = reqAfter;
        if (channelTongXinHandler != null || reqAfter == null) { //如果通信组件为空，或者内容为null，就不发送报文。
            rtnMsg = channelTongXinHandler.sendBefor(reqBefor, rtnMsg, channelConfig); //发送报文之前
            rtnMsg = channelTongXinHandler.send(reqBefor, rtnMsg, channelConfig);    //发送报文
            rtnMsg = channelTongXinHandler.sendAfter(reqBefor, rtnMsg, channelConfig);  //发送报文之后
            try {
                logger.info("[渠道系统][前置模块]返回报文为:" + new String(rtnMsg, channelConfig.getCharset()));
            } catch (UnsupportedEncodingException e) {
                logger.error("[渠道系统][前置模块]不支持报文编码格式:" + channelConfig.getCharset(), e);
            }
        }


        REP resolveMsgAfter = null;
        if (channelMsgHandler != null || rtnMsg == null) { //如果通信组建或者，返回消息为null，就不解析报文。
            byte[] resolveMsgBefor = channelMsgHandler.beforResolveMsg(reqBefor, rtnMsg, channelConfig);
            REP resolveMsg = channelMsgHandler.resolveMsg(reqBefor, resolveMsgBefor, channelConfig);
            resolveMsgAfter = channelMsgHandler.afterResolveMsg(reqBefor, resolveMsg, channelConfig);
            logger.info("[渠道系统][前置模块]解析后的数据为:" + resolveMsgAfter);
        }
        afterProcess(reqBefor, resolveMsgAfter, channelConfig);
        logger.info("[渠道系统][前置模块]响应参数为:" + resolveMsgAfter);
        return resolveMsgAfter;
    }


    /**
     * 核心方法执行前
     *
     * @param req
     * @param channelConfig
     */
    protected abstract void beforProcess(REQ req, ChannelConfig channelConfig);

    /**
     * 放心方法执行后
     *
     * @param req
     * @param rep
     * @param channelConfig
     */
    protected abstract void afterProcess(REQ req, REP rep, ChannelConfig channelConfig);


    public ChannelConfig getChannelConfig() {
        return channelConfig;
    }

    public void setChannelConfig(ChannelConfig channelConfig) {
        this.channelConfig = channelConfig;
    }

    public ChannelTongXinHandler getChannelTongXinHandler() {
        return channelTongXinHandler;
    }

    public void setChannelTongXinHandler(ChannelTongXinHandler channelTongXinHandler) {
        this.channelTongXinHandler = channelTongXinHandler;
    }

    public ChannelMsgHandler<REQ, REP> getChannelMsgHandler() {
        return channelMsgHandler;
    }

    public void setChannelMsgHandler(ChannelMsgHandler<REQ, REP> channelMsgHandler) {
        this.channelMsgHandler = channelMsgHandler;
    }

    public ChannelValidateHandler<REQ> getChannelValidate() {
        return channelValidate;
    }

    public void setChannelValidate(ChannelValidateHandler<REQ> channelValidate) {
        this.channelValidate = channelValidate;
    }
}
