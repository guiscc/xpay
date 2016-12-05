/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.xpay.channel.dao.test;

import com.xpay.channel.dao.InstitutionDao;
import com.xpay.channel.dao.entity.InstitutionEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qinshou
 * @version $Id: TestInstitution.java, v 0.1 16/12/5 上午11:47 sxfans Exp $
 */
public class TestInstitution extends BaseTest{

    @Resource
    private InstitutionDao institutionDao;

    @Test
    public void findInstituion(){
        String ids ="\"ALIPAY\",\"UNIONPAY\",\"ABC\"";
        List<InstitutionEntity> list = institutionDao.findByInstCodes(ids);
        System.out.println(list);
    }
}