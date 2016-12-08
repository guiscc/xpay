/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;

import com.xpay.channel.common.exception.ChannelRouterException;
import com.xpay.channel.service.router.handler.RouterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author qinshou
 * @version $Id: AbsChannelRouter.java, v 0.1 16/11/30 上午9:45 sxfans Exp $
 */
public class AbsChannelRouter implements ChannelRouter {

    private Logger logger = LoggerFactory.getLogger(AbsChannelRouter.class);

    private RouterHandlerFactory routerHandlerFactory;


    @Override
    public RouterContext router(RouterParam param) throws ChannelRouterException {

        //路由上下文
        RouterContext routerContext = new RouterContext();

        //获取命令链
        Map<String, RouterHandler> maps = routerHandlerFactory.getRouterHandlerMap();
        for(RouterHandler routerHandler :maps.values()){
            routerContext = routerHandler.routerHandler(routerContext,param);
        }
        logger.info("[渠道系统][路由模块]路由结果:{}",routerContext);
        return routerContext;
    }

    /**
     * Getter method for property routerHandlerFactory.
     *
     * @return property value of routerHandlerFactory
     **/
    public RouterHandlerFactory getRouterHandlerFactory() {
        return routerHandlerFactory;
    }

    /**
     * Setter method for property routerHandlerFactory.
     *
     * @param routerHandlerFactory value to be assigned to property routerHandlerFactory
     **/
    public void setRouterHandlerFactory(RouterHandlerFactory routerHandlerFactory) {
        this.routerHandlerFactory = routerHandlerFactory;
    }
}