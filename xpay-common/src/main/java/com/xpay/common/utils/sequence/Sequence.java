package com.xpay.common.utils.sequence;

/**
 * 获取序列号
 * Created by sxfans on 16/8/21.
 */
public interface Sequence {

    /**
     * 获取
     * @param groupId
     * @param len
     * @return
     */
    public String getSeq(String groupId, int len);

    /**
     *
     * @param groupId
     * @param len
     * @return
     */
    public String getDTAndSeq(String groupId,int len);
}
