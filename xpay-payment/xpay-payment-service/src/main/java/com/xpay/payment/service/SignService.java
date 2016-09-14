/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.payment.service;

import com.xpay.payment.common.vo.customer.*;

/**
 * @author qinshou
 * @version $Id: SignDao.java, v 0.1 16/9/11 上午9:58 sxfans Exp $
 */
public interface SignService {

    /**
     * 新增签约信息
     *
     * @param signReqVO
     * @return
     */

    public SignRepVO add(SignReqVO signReqVO);

    /**
     * 签约确认
     *
     * @param signConfirmReqVO
     * @return
     */
    public SignConfirmRepVO signConfirm(SignConfirmReqVO signConfirmReqVO);

    /**
     * 解约
     *
     * @return
     */
    public SignBreakRepVO signBreak(SignBreakReqVO signBreakReqVO);

    /**
     * 更新签约信息
     *
     * @param signReqVO
     * @return
     */
    public boolean updateStatus(SignReqVO signReqVO);

    /**
     * 查找签约信息
     *
     * @param signReqVO
     * @return
     */
    public SignRepVO get(SignReqVO signReqVO);
}