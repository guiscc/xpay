package com.xpay.channel.common.dto.agentcollect;

import com.xpay.channel.common.dto.BaseReqChannelDTO;

import java.util.Date;

/**
 *
 * @Remark 查询
 * @Author pangyiyang
 * @Date 16/5/22 下午4:26
 */
public class ACQueryPayReqChannelDTO extends BaseReqChannelDTO {

    /**
     * 银行订单号
     */
    private String bankOrderNo;

    /**
     * 支付单号
     */
    private String payOrderNo;

    /**
     * 创建时间
     */
    private Date   createDT;

    /**
     * Getter method for property bankOrderNo.
     *
     * @return property value of bankOrderNo
     **/
    public String getBankOrderNo() {
        return bankOrderNo;
    }

    /**
     * Setter method for property bankOrderNo.
     *
     * @param bankOrderNo value to be assigned to property bankOrderNo
     **/
    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo;
    }

    /**
     * Getter method for property payOrderNo.
     *
     * @return property value of payOrderNo
     **/
    public String getPayOrderNo() {
        return payOrderNo;
    }

    /**
     * Setter method for property payOrderNo.
     *
     * @param payOrderNo value to be assigned to property payOrderNo
     **/
    public void setPayOrderNo(String payOrderNo) {
        this.payOrderNo = payOrderNo;
    }

    /**
     * Getter method for property createDT.
     *
     * @return property value of createDT
     **/
    public Date getCreateDT() {
        return createDT;
    }

    /**
     * Setter method for property createDT.
     *
     * @param createDT value to be assigned to property createDT
     **/
    public void setCreateDT(Date createDT) {
        this.createDT = createDT;
    }
}
