package com.xpay.common.utils.jce;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by suxinxin on 16/3/28.
 */
public class DigestUtil {

    /**
     * @param data
     * @return
     */
    public static byte[] sha1(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.reset();
        md.update(data);
        return md.digest();
    }

    public static void main(String[] args) throws Exception {
        String str = "accessType=0&bizType=000201&certId=68759663125&encoding=UTF-8&merId=777290058110097&orderId=12345678&signMethod=01&txnSubType=00&txnTime=20160321201006&txnType=00&version=5.0.0";
        String temp = Hex.encodeHexString(sha1(str.getBytes("UTF-8")));
        System.out.println(temp);
    }
}
