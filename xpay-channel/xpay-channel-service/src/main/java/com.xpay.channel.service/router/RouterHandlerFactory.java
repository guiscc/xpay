/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.service.router;

import com.xpay.channel.service.router.handler.RouterHandler;

import java.util.Map;

/**
 * @author qinshou
 * @version $Id: RouterHandlerFactory.java, v 0.1 16/12/1 上午10:39 sxfans Exp $
 */
public class RouterHandlerFactory {

    /**
     * 路由工厂
     */
    private Map<String,RouterHandler> routerHandlerMap;

    /**
     * Getter method for property routerHandlerMap.
     *
     * @return property value of routerHandlerMap
     **/
    public Map<String, RouterHandler> getRouterHandlerMap() {
        return routerHandlerMap;
    }

    /**
     * Setter method for property routerHandlerMap.
     *
     * @param routerHandlerMap value to be assigned to property routerHandlerMap
     **/
    public void setRouterHandlerMap(Map<String, RouterHandler> routerHandlerMap) {
        this.routerHandlerMap = routerHandlerMap;
    }
}