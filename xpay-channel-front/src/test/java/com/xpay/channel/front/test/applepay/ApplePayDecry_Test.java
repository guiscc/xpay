package com.xpay.channel.front.test.applepay;

import com.xpay.channel.front.test.BaseTest;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;

/**
 * Created by suxinxin on 16/3/23.
 */
public class ApplePayDecry_Test extends BaseTest {

    AppleTokenDTO token = new AppleTokenDTO();

    @Test
    public void decry() throws Exception {
        AppleTokenDTO3 token = new AppleTokenDTO3();
        byte[] data = Base64.decode(token.data);
        byte[] privatemodelus = this.hexStringToBytes(token.priExponent);
        byte[] modelus = this.hexStringToBytes(token.modulus);

        BigInteger privateModelus1 = new BigInteger(1, privatemodelus);
        System.out.println(privateModelus1);
        BigInteger modelus1 = new BigInteger(1, modelus);
        System.out.println(modelus1);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");   //构建RSA秘钥
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(modelus1, privateModelus1);
        RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec); //构建rsa私钥
        byte[] wk = Base64.decode(token.header.wrappedKey);

        Security.addProvider(new BouncyCastleProvider());
        Cipher c = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", BouncyCastleProvider.PROVIDER_NAME);

//        Cipher c = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
//        OAEPParameterSpec oaepParams = new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT);
//        c.init(Cipher.DECRYPT_MODE, privateKey, oaepParams);

        c.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] keyBytes = c.doFinal(wk);
        System.out.println(Hex.encodeHex(keyBytes));


        SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
        byte[] IV = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(IV));
        byte[] original = cipher.doFinal(data);
        System.out.println(new String(original));
    }


    public byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
