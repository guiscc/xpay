package com.xpay.channel.front.executor;

import com.xpay.channel.common.exception.BuildMsgException;
import com.xpay.channel.common.exception.CommuException;
import com.xpay.channel.common.exception.ResolveMsgException;
import com.xpay.channel.common.exception.VldException;
import com.xpay.channel.front.dto.BaseRepFrontDTO;
import com.xpay.channel.front.dto.BaseReqFrontDTO;
import com.xpay.channel.front.msg.ChannelMsgHandler;
import com.xpay.channel.front.msg.model.MsgReqModel;
import com.xpay.channel.front.tongxin.ChannelTongXinHandler;
import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.channel.front.vld.ChannelValidateHandler;
import com.xpay.common.enums.EnumChannelType;
import com.xpay.common.enums.EnumRtnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 前置系统主要行为的实现封装类，抽象实现了整个前置的全部行为，集成了系统各个组件
 * Created by suxinxin on 14/12/25.
 */
public abstract class AbsFrontExecutor<REQ extends BaseReqFrontDTO, REP extends BaseRepFrontDTO> {
    private static final Logger logger = LoggerFactory.getLogger(AbsFrontExecutor.class);

    /**
     * 配置
     */
    protected ChannelConfig                 channelConfig = new ChannelConfig();

    /**
     * 参数验证组件
     */
    private Map<EnumChannelType, ChannelValidateHandler<REQ>> channelValidateHandlerMap;

    /**
     * 通信组件
     */
    private Map<EnumChannelType, ChannelTongXinHandler>  channelTongXinHandlerMap;

    /**
     * 报文组件
     */
    private Map<EnumChannelType, ChannelMsgHandler<REQ,REP>>      channelMsgHandlerMap;

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

        ChannelValidateHandler<REQ> channelValidate = channelValidateHandlerMap.get(req.getChannelType());
        ChannelMsgHandler<REQ,REP> channelMsgHandler = channelMsgHandlerMap.get(req.getChannelType());
        ChannelTongXinHandler<REQ> channelTongXinHandler = channelTongXinHandlerMap.get(req.getChannelType());

        logger.info("[渠道系统][前置模块]请求前置参数为:" + req);
        logger.info("[渠道系统][前置模块]渠道配置参数为:" + channelConfig);

        beforProcess(req, channelConfig); //前置处理

        if (channelValidate != null) {   //如果参数校验组建为空则不验证参数
            channelValidate.validate(req);
            logger.info("[渠道系统][前置模块]参数验证完成");
        }

        MsgReqModel msgReqModel = null; //请求报文
        REQ reqBefor = null;    //请求实体
        if (channelMsgHandler != null) {   //如果报文组件为空就不组建报文
            reqBefor = channelMsgHandler.beforBuildMsg(req, channelConfig);  //拼装报文之前
            msgReqModel = channelMsgHandler.builderMsg(reqBefor, channelConfig); //组建报文
            if(msgReqModel == null){
                throw new VldException(EnumRtnResult.E000000);
            }
            msgReqModel = channelMsgHandler.afterBuildMsg(reqBefor, msgReqModel, channelConfig); //拼装报文之后
            logger.info("[渠道系统][前置模块]创建报文完成:" + msgReqModel.toString());
        }

        byte[] rtnMsg = null;
        if (channelTongXinHandler != null && msgReqModel != null) { //如果通信组件为空，或者内容为null，就不发送报文。
            msgReqModel = channelTongXinHandler.sendBefor(reqBefor, msgReqModel, channelConfig); //发送报文之前

            rtnMsg = channelTongXinHandler.send(reqBefor, msgReqModel, channelConfig);    //发送报文
            if(rtnMsg == null){
                throw new VldException(EnumRtnResult.E000000);
            }

            rtnMsg = channelTongXinHandler.sendAfter(reqBefor, rtnMsg, channelConfig);  //发送报文之后

            try {
                logger.info("[渠道系统][前置模块]返回报文为:" + new String(rtnMsg, channelConfig.getCharset()));
            } catch (UnsupportedEncodingException e) {
                logger.error("[渠道系统][前置模块]不支持报文编码格式:" + channelConfig.getCharset(), e);
            }
        }

        REP resolveMsgAfter = null;
        if (channelMsgHandler != null && rtnMsg != null) { //如果通信组建或者，返回消息为null，就不解析报文。
            REQ resolveMsgBefor = channelMsgHandler.beforResolveMsg(reqBefor, channelConfig);
            REP resolveMsg = channelMsgHandler.resolveMsg(reqBefor, rtnMsg, channelConfig);
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


    /**
     * Getter method for property channelConfig.
     *
     * @return property value of channelConfig
     **/
    public ChannelConfig getChannelConfig() {
        return channelConfig;
    }

    /**
     * Setter method for property channelConfig.
     *
     * @param channelConfig value to be assigned to property channelConfig
     **/
    public void setChannelConfig(ChannelConfig channelConfig) {
        this.channelConfig = channelConfig;
    }

    /**
     * Getter method for property channelValidateHandlerMap.
     *
     * @return property value of channelValidateHandlerMap
     **/
    public Map<EnumChannelType, ChannelValidateHandler<REQ>> getChannelValidateHandlerMap() {
        return channelValidateHandlerMap;
    }

    /**
     * Setter method for property channelValidateHandlerMap.
     *
     * @param channelValidateHandlerMap value to be assigned to property channelValidateHandlerMap
     **/
    public void setChannelValidateHandlerMap(Map<EnumChannelType, ChannelValidateHandler<REQ>> channelValidateHandlerMap) {
        this.channelValidateHandlerMap = channelValidateHandlerMap;
    }

    /**
     * Getter method for property channelTongXinHandlerMap.
     *
     * @return property value of channelTongXinHandlerMap
     **/
    public Map<EnumChannelType, ChannelTongXinHandler> getChannelTongXinHandlerMap() {
        return channelTongXinHandlerMap;
    }

    /**
     * Setter method for property channelTongXinHandlerMap.
     *
     * @param channelTongXinHandlerMap value to be assigned to property channelTongXinHandlerMap
     **/
    public void setChannelTongXinHandlerMap(Map<EnumChannelType, ChannelTongXinHandler> channelTongXinHandlerMap) {
        this.channelTongXinHandlerMap = channelTongXinHandlerMap;
    }

    /**
     * Getter method for property channelMsgHandlerMap.
     *
     * @return property value of channelMsgHandlerMap
     **/
    public Map<EnumChannelType, ChannelMsgHandler<REQ, REP>> getChannelMsgHandlerMap() {
        return channelMsgHandlerMap;
    }

    /**
     * Setter method for property channelMsgHandlerMap.
     *
     * @param channelMsgHandlerMap value to be assigned to property channelMsgHandlerMap
     **/
    public void setChannelMsgHandlerMap(Map<EnumChannelType, ChannelMsgHandler<REQ, REP>> channelMsgHandlerMap) {
        this.channelMsgHandlerMap = channelMsgHandlerMap;
    }
}
