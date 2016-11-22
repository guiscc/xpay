package com.xpay.channel.front.channel.agentcollect.unionpay.util;

import com.xpay.channel.front.utils.ChannelConfig;
import com.xpay.common.utils.jce.DigestUtil;
import com.xpay.common.utils.jce.KeyStoreUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by suxinxin on 16/3/29.
 */
public class UnionpayUtil {

    /**
     * 将map排序拼接成字符串
     *
     * @param dataMap
     * @return
     */
    public static String coverMap2String(Map<String, String> dataMap) {
        TreeMap<String, String> treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            if ("signature".equals(entry.getKey().trim())) {
                continue;
            }
            treeMap.put(entry.getKey(), entry.getValue() + "");
        }

        StringBuffer sf = new StringBuffer();
        int i = 0;
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sf.append(entry.getKey() + "=" + entry.getValue());
            if (++i < treeMap.size()) {
                sf.append("&");
            }
        }
        return sf.toString();
    }

    /**
     * 签名
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String sign(Map<String, String> data, ChannelConfig channelConfig)
                                                                                    throws Exception {
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadStore(channelConfig.getPfxPath(), "PKCS12", channelConfig.getPfxPwd());
        data.put("certId", keyStoreUtil.getCerId()); //证书id
        String stringData = UnionpayUtil.coverMap2String(data); //转换map为字符串

        byte[] sigestByte = DigestUtil.sha1(stringData.getBytes(channelConfig.getCharset())); //摘要
        String str = Hex.encodeHexString(sigestByte); //16进制

        PrivateKey privateKey = keyStoreUtil.getPrivateKey(); //获取私钥

        Signature st = Signature.getInstance("SHA1withRSA");
        st.initSign(privateKey);
        st.update(str.getBytes());
        String signStr = Base64.encodeBase64String(st.sign());
        return signStr;
    }

    /**
     * 验证签名
     *
     * @param dataMap
     * @return
     */
    public static boolean verSign(Map<String, String> dataMap, String cerPath) throws Exception {
        byte[] oriSign = Base64.decodeBase64(dataMap.get("signature") + "");

        String repStr = UnionpayUtil.coverMap2String(dataMap);

        byte[] repByte = DigestUtil.sha1(repStr.getBytes("UTF-8"));

        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(cerPath);

        return keyStoreUtil.verify(Hex.encodeHexString(repByte).getBytes(), oriSign);
    }

    /**
     * 解析应答字符串，生成应答要素
     *
     * @param str 需要解析的字符串
     * @return 解析的结果map
     * @throws UnsupportedEncodingException
     */
    public static Map<String, String> parseQString(String str) throws Exception {
        Map<String, String> map = new HashMap();
        int len = str.length();
        StringBuilder temp = new StringBuilder();
        char curChar;
        String key = null;
        boolean isKey = true;
        boolean isOpen = false;//值里有嵌套
        char openName = 0;
        if (len > 0) {
            for (int i = 0; i < len; i++) {// 遍历整个带解析的字符串
                curChar = str.charAt(i);// 取当前字符
                if (isKey) {// 如果当前生成的是key

                    if (curChar == '=') {// 如果读取到=分隔符
                        key = temp.toString();
                        temp.setLength(0);
                        isKey = false;
                    } else {
                        temp.append(curChar);
                    }
                } else {// 如果当前生成的是value
                    if (isOpen) {
                        if (curChar == openName) {
                            isOpen = false;
                        }

                    } else {//如果没开启嵌套
                        if (curChar == '{') {//如果碰到，就开启嵌套
                            isOpen = true;
                            openName = '}';
                        }
                        if (curChar == '[') {
                            isOpen = true;
                            openName = ']';
                        }
                    }
                    if (curChar == '&' && !isOpen) {// 如果读取到&分割符,同时这个分割符不是值域，这时将map里添加
                        putKeyValueToMap(temp, isKey, key, map);
                        temp.setLength(0);
                        isKey = true;
                    } else {
                        temp.append(curChar);
                    }
                }

            }
            putKeyValueToMap(temp, isKey, key, map);
        }
        return map;
    }

    /**
     * @param temp
     * @param isKey
     * @param key
     * @param map
     * @throws UnsupportedEncodingException
     */
    private static void putKeyValueToMap(StringBuilder temp, boolean isKey, String key,
                                         Map<String, String> map)
                                                                 throws UnsupportedEncodingException {
        if (isKey) {
            key = temp.toString();
            if (key.length() == 0) {
                throw new RuntimeException("QString format illegal");
            }
            map.put(key, "");
        } else {
            if (key.length() == 0) {
                throw new RuntimeException("QString format illegal");
            }
            map.put(key, temp.toString());
        }
    }
}
