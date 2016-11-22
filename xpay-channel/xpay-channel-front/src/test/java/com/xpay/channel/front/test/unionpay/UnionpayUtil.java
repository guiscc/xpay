package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.front.test.utils.DigestUtil;
import com.xpay.channel.front.test.utils.KeyStoreUtil;
import com.xpay.common.utils.HttpCfg;
import com.xpay.common.utils.HttpRep;
import com.xpay.common.utils.HttpReq;
import com.xpay.common.utils.HttpRequester;
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

//    public static final String cerPath = "/export/safefile/unionpay/acp_test_verify_sign.cer";
//    public static final String pfxPath = "/export/safefile/unionpay/acp_test_sign.pfx";
//    public static final String merchantNo = "777290058110097";
//    public static final String pwd = "000000";

//    public static final String cerPath ="/export/safefile/unionpay/acp_test_enc.cer";
//    public static  final String pfxPath = "/export/safefile/unionpay/700000000000001_acp.pfx";
//    public static  final String merchantNo = "777290058126761";
//    public static  final String pwd ="000000";

    //代付
    public static final String cerPath ="/export/safefile/unionpay/verify_sign_acp.cer";
    public static  final String pfxPath = "/export/safefile/unionpay/700000000000001_acp.pfx";
    public static  final String merchantNo = "777290058123381";
    public static  final String pwd ="000000";

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
            treeMap.put(entry.getKey(), entry.getValue());
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
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String sign(Map<String, String> data, String encoding) throws Exception {
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadStore(pfxPath, "PKCS12", pwd);

        data.put("certId", keyStoreUtil.getCerId()); //证书id
        String stringData = UnionpayUtil.coverMap2String(data); //转换map为字符串

        byte[] sigestByte = DigestUtil.sha1(stringData.getBytes(encoding)); //摘要
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
    public static boolean verSign(Map<String, String> dataMap) throws Exception {
        byte[] oriSign = Base64.decodeBase64(dataMap.get("signature"));

        String repStr = UnionpayUtil.coverMap2String(dataMap);
        System.out.println("验证签名之前的数据:" + repStr);

        byte[] repByte = DigestUtil.sha1(repStr.getBytes("UTF-8"));

        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(cerPath);

        return keyStoreUtil.verify(Hex.encodeHexString(repByte).getBytes(), oriSign);
    }

    /**
     *
     * @param
     */
    public static void process(Map<String,String> data,String url) throws Exception {
        HttpCfg httpCfg = new HttpCfg();
        httpCfg.setConnTimeOut(10000);
        httpCfg.setReadTimeOut(2000);
        httpCfg.setPort(443);
        httpCfg.setProtocol(HttpCfg.HTTPS);
        httpCfg.setHttps2way(false);
        httpCfg.setUrl(url);


//        String signBytes = UnionpayUtil.sign(data, "UTF-8"); //签名
//        data.put("signature", signBytes); //签名
        System.out.println("发送信息:" + data);

        HttpRequester httpRequester = new HttpRequester(httpCfg);
        HttpReq httpReq = new HttpReq();
        httpReq.setParamMap(data);
        HttpRep httpRep = httpRequester.sendPostForm(httpReq);
        Map<String, String> map = UnionpayUtil.parseQString(httpRep.getContent());
        System.out.println("返回信息:" + map);

        boolean signFlag = UnionpayUtil.verSign(map);
        System.out.println("返回签名信息:" + signFlag);
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
    private static void putKeyValueToMap(StringBuilder temp, boolean isKey,
                                  String key, Map<String, String> map)
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
