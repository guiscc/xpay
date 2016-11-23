package com.xpay.channel.front.test.unionpay;

import com.xpay.channel.front.test.utils.KeyStoreUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.Security;
import java.util.Iterator;
import java.util.Map;

/**
 * @Remark see class name
 * @Author pangyiyang
 * @Date 16/5/21 下午4:11
 */
public class UnionpayEncryptUtil {

    private static final String cerPath = "/export/safefile/unionpay/acp_test_enc.cer" ;
    private static final Logger logger = LoggerFactory.getLogger(UnionpayEncryptUtil.class) ;

    /**
     * 获取证书ID
     * @return
     * @throws Exception
     */
    public static String getCertId() throws Exception{
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(cerPath);
        return keyStoreUtil.getCerId() ;
    }

    public static void main(String [] args) throws Exception{
        System.err.println(getCertId());
        System.err.println(encryptData("6216261000000000018" , "UTF-8"));
        System.err.println(encryptPin("6216261000000000018","123456","UTF-8")) ;
//        Map<String , String> map = new HashMap<String, String>() ;
//        map.put("certifTp", "01");						//证件类型
//        map.put("certifId", "341126197709218366");		//证件号码
//        map.put("customerNm", "全渠道");					//姓名
//        map.put("phoneNo", "13552535506");			    //手机号
//        map.put("pin" , "881010");
//        System.err.println(encryptData(map, "UTF-8" , "6216261000000000018"));
    }

    //加密卡号
    public static String encryptData(String cardNo , String charset) throws Exception {
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(cerPath);
        PublicKey key = keyStoreUtil.getPublicKey() ;
        byte [] cardNoBytes = cardNo.getBytes(charset) ;
        byte [] data = encryptedPin(key , cardNoBytes) ;
        String encryptDate = new String(Base64.encodeBase64(data), charset);
        return encryptDate ;
    }

    //加密参数
    public static String encryptData(Map<String , String> map , String accNo , String charset) throws Exception {

        if(map.isEmpty()) {
            return "{}";
        }
        StringBuffer builder = new StringBuffer("{");
        //敏感信息加密域
        StringBuffer encryptedInfoSb = new StringBuffer("");

        for(Iterator<String> it = map.keySet().iterator(); it.hasNext();){
            String key = it.next();
            String value = map.get(key);
            if(key.equals("phoneNo") || key.equals("cvn2") || key.equals("expired")){
                encryptedInfoSb.append(key).append("=").append(value).append("&");
            }else{
                if(key.equals("pin")){
                    if(null == accNo || "".equals(accNo.trim())){
                        logger.info("送了密码（PIN），必须在getCustomerInfoWithEncrypt参数中上传卡号");
                        return "{}";
                    }else{
                        value = encryptPin(accNo,value,charset);
                    }
                }
                builder.append(key).append("=").append(value).append("&");
            }
        }

        if(!encryptedInfoSb.toString().equals("")){
            encryptedInfoSb.setLength(encryptedInfoSb.length()-1);//去掉最后一个&符号
            logger.info("组装的customerInfo encryptedInfo明文："+ encryptedInfoSb.toString());
            builder.append("encryptedInfo").append("=").append(encryptData(encryptedInfoSb.toString(), charset));
        }else{
            builder.setLength(builder.length()-1);
        }

        String customerInfo = builder.append("}").toString();
        logger.info("组装的customerInfo明文："+customerInfo);
        try {
            return new String(Base64.encodeBase64(builder.toString().getBytes(charset)),charset);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
           logger.error(e.getMessage(), e);
        }
        return customerInfo;

    }

    public static String encryptPin(String accNo,String pin ,String charset) throws Exception{
        KeyStoreUtil keyStoreUtil = new KeyStoreUtil();
        keyStoreUtil.loadCer(cerPath);
        PublicKey key = keyStoreUtil.getPublicKey() ;
        byte [] tPinByte = pin2PinBlock(pin) ;
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
        return new String(Base64.encodeBase64(data), charset);
    }
    private static byte[] pin2PinBlock(String aPin) {
        int tTemp = 1;
        int tPinLen = aPin.length();

        byte[] tByte = new byte[8];
        try {
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
        } catch (Exception e) {
        }

        return tByte;
    }
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


    public static byte[] encryptedPin(PublicKey publicKey, byte[] plainPin)
            throws Exception {
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int blockSize = cipher.getBlockSize();
            int outputSize = cipher.getOutputSize(plainPin.length);
            int leavedSize = plainPin.length % blockSize;
            int blocksSize = leavedSize != 0 ? plainPin.length / blockSize + 1
                    : plainPin.length / blockSize;
            byte[] raw = new byte[outputSize * blocksSize];
            int i = 0;
            while (plainPin.length - i * blockSize > 0) {
                if (plainPin.length - i * blockSize > blockSize) {
                    cipher.doFinal(plainPin, i * blockSize, blockSize, raw, i
                            * outputSize);
                } else {
                    cipher.doFinal(plainPin, i * blockSize, plainPin.length - i
                            * blockSize, raw, i * outputSize);
                }
                i++;
            }
            return raw;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
