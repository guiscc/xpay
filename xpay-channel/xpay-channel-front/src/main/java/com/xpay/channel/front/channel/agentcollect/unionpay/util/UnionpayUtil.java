package com.xpay.channel.front.channel.agentcollect.unionpay.util;

import com.xpay.channel.front.channel.agentcollect.unionpay.Unionpay_Config;
import com.xpay.common.utils.jce.DigestUtil;
import com.xpay.common.utils.jce.KeyStoreUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by suxinxin on 16/3/29.
 */
public class UnionpayUtil {

    /**
     * 加密卡号
     * @param cardNo
     * @param channelConfig
     * @return
     * @throws Exception
     */
    public static String encryptCardNo(String cardNo, Unionpay_Config channelConfig)
            throws Exception {
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(channelConfig.getEncCerPath());
        PublicKey key = keyStoreUtil.getPublicKey();
        byte[] cardNoBytes = cardNo.getBytes(channelConfig.getCharset());
        byte[] data = encryptedPin(key, cardNoBytes);
        String encryptDate = new String(Base64.encodeBase64(data), channelConfig.getCharset());
        return encryptDate;
    }

    /**
     * 加密敏感信息
     * @param map
     * @param accNo
     * @param charset
     * @param cerPath
     * @return
     * @throws Exception
     */
    public static String encryptData(Map<String, String> map, String accNo,
                                     Unionpay_Config channelConfig) throws Exception {
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuffer builder = new StringBuffer("{");
        //敏感信息加密域
        StringBuffer encryptedInfoSb = new StringBuffer("");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals("phoneNo") || key.equals("cvn2") || key.equals("expired")) {
                encryptedInfoSb.append(key).append("=").append(value).append("&");
            } else {
                if (key.equals("pin")) {
                    if (null == accNo || "".equals(accNo.trim())) {
                        return "{}";
                    } else {
                        value = encryptPin(accNo, value, channelConfig);
                    }
                }
                builder.append(key).append("=").append(value).append("&");
            }
        }

        if (!encryptedInfoSb.toString().equals("")) {
            encryptedInfoSb.setLength(encryptedInfoSb.length() - 1);//去掉最后一个&符号
            builder.append("encryptedInfo").append("=")
                .append(encryptCardNo(encryptedInfoSb.toString(), channelConfig));
        } else {
            builder.setLength(builder.length() - 1);
        }

        String customerInfo = builder.append("}").toString();
        return new String(Base64.encodeBase64(builder.toString().getBytes(
            channelConfig.getCharset())), channelConfig.getCharset());
    }

    /**
     *
     * @param channelConfig
     * @return
     */
    public static String getCertId(Unionpay_Config channelConfig, boolean encryCer) throws Exception {
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        if (encryCer) {
            keyStoreUtil.loadCer(channelConfig.getEncCerPath());
            return  keyStoreUtil.getCerId();
        } else {
            keyStoreUtil.loadStore(channelConfig.getPfxPath(), "PKCS12", channelConfig.getPfxPwd());
            return keyStoreUtil.getCerId();
        }
    }

    /**
     * 签名
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String sign(Map<String, String> data, Unionpay_Config channelConfig)
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
     * 将map排序拼接成字符串
     *
     * @param dataMap
     * @return
     */
    private static String coverMap2String(Map<String, String> dataMap) {
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
     *
     * @param publicKey
     * @param plainPin
     * @return
     * @throws Exception
     */
    private static byte[] encryptedPin(PublicKey publicKey, byte[] plainPin) throws Exception {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int blockSize = cipher.getBlockSize();
            int outputSize = cipher.getOutputSize(plainPin.length);
            int leavedSize = plainPin.length % blockSize;
            int blocksSize = leavedSize != 0 ? plainPin.length / blockSize + 1 : plainPin.length
                                                                                 / blockSize;
            byte[] raw = new byte[outputSize * blocksSize];
            int i = 0;
            while (plainPin.length - i * blockSize > 0) {
                if (plainPin.length - i * blockSize > blockSize) {
                    cipher.doFinal(plainPin, i * blockSize, blockSize, raw, i * outputSize);
                } else {
                    cipher.doFinal(plainPin, i * blockSize, plainPin.length - i * blockSize, raw,
                        i * outputSize);
                }
                i++;
            }
            return raw;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     *
     * @param accNo
     * @param pin
     * @param channelConfig
     * @return
     * @throws Exception
     */
    private static String encryptPin(String accNo, String pin, Unionpay_Config config)
            throws Exception {
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(config.getEncCerPath());
        PublicKey key = keyStoreUtil.getPublicKey();
        byte[] tPinByte = pin2PinBlock(pin);
        if (accNo.length() == 11) {
            accNo = "00" + accNo;
        } else if (accNo.length() == 12) {
            accNo = "0" + accNo;
        }
        byte[] tPanByte = formatPan(accNo);
        byte[] pinBlock = new byte[8];
        for (int i = 0; i < 8; i++) {
            pinBlock[i] = (byte) (tPinByte[i] ^ tPanByte[i]);
        }
        byte[] data = encryptedPin(key, pinBlock);
        return new String(Base64.encodeBase64(data), config.getCharset());
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

    /**
     * 加密
     * @param aPin
     * @return
     */
    private static byte[] pin2PinBlock(String aPin) {
        int tTemp = 1;
        int tPinLen = aPin.length();

        byte[] tByte = new byte[8];
        /*******************************************************************
         * if (tPinLen > 9) { tByte[0] = (byte) Integer.parseInt(new
         * Integer(tPinLen) .toString(), 16); } else { tByte[0] = (byte)
         * Integer.parseInt(new Integer(tPinLen) .toString(), 10); }
         ******************************************************************/
        //			tByte[0] = (byte) Integer.parseInt(new Integer(tPinLen).toString(),
        //					10);
        tByte[0] = (byte) Integer.parseInt(Integer.toString(tPinLen), 10);
        if (tPinLen % 2 == 0) {
            for (int i = 0; i < tPinLen;) {
                String a = aPin.substring(i, i + 2);
                tByte[tTemp] = (byte) Integer.parseInt(a, 16);
                if (i == (tPinLen - 2)) {
                    if (tTemp < 7) {
                        for (int x = (tTemp + 1); x < 8; x++) {
                            tByte[x] = (byte) 0xff;
                        }
                    }
                }
                tTemp++;
                i = i + 2;
            }
        } else {
            for (int i = 0; i < tPinLen - 1;) {
                String a;
                a = aPin.substring(i, i + 2);
                tByte[tTemp] = (byte) Integer.parseInt(a, 16);
                if (i == (tPinLen - 3)) {
                    String b = aPin.substring(tPinLen - 1) + "F";
                    tByte[tTemp + 1] = (byte) Integer.parseInt(b, 16);
                    if ((tTemp + 1) < 7) {
                        for (int x = (tTemp + 2); x < 8; x++) {
                            tByte[x] = (byte) 0xff;
                        }
                    }
                }
                tTemp++;
                i = i + 2;
            }
        }
        return tByte;
    }

    /**
     *
     * @param aPan
     * @return
     */
    private static byte[] formatPan(String aPan) {
        int tPanLen = aPan.length();
        byte[] tByte = new byte[8];
        ;
        int temp = tPanLen - 13;
        try {
            tByte[0] = (byte) 0x00;
            tByte[1] = (byte) 0x00;
            for (int i = 2; i < 8; i++) {
                String a = aPan.substring(temp, temp + 2);
                tByte[i] = (byte) Integer.parseInt(a, 16);
                temp = temp + 2;
            }
        } catch (Exception e) {
        }
        return tByte;
    }

    public static void main(String[] args) {

    }
}
