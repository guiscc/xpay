package com.xpay.common.utils.jce;

import java.io.FileInputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * Created by suxinxin on 16/3/24.
 */
public class KeyStoreUtil {

    public static final String PKCS12 = "PKCS12";

    public static final String JKS = "JKS";

    /**
     * 证书
     */
    private Certificate certificate;

    /**
     * 公钥
     */
    private PublicKey publicKey = null;

    /**
     * 私钥
     */
    private PrivateKey privateKey = null;

    /**
     * 秘钥库
     */
    private KeyStore keyStore = null;

    /**
     * 加载秘钥库
     *
     * @param keyStorePath
     * @param keyStoreType
     * @param password
     * @throws Exception
     */
    public KeyStore loadStore(String keyStorePath, String keyStoreType, String password) throws Exception {
        keyStore = KeyStore.getInstance(keyStoreType);
        FileInputStream fileInputStream = new FileInputStream(keyStorePath);
        keyStore.load(fileInputStream, password.toCharArray());
        Enumeration<String> aliases = keyStore.aliases();
        String align = "";
        while (aliases.hasMoreElements()) {
            align = aliases.nextElement();
            break;
        }
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(align, password.toCharArray());
        this.privateKey = privateKey;
        this.certificate = keyStore.getCertificate(align);
        return keyStore;
    }

    /**
     * 加载秘钥库
     *
     * @param keyStorePath
     * @param keyStoreType
     * @param password
     * @throws Exception
     */
    public KeyStore loadStore(String keyStorePath, String keyStoreType, String alias, String password) throws Exception {
        keyStore = KeyStore.getInstance(keyStoreType);
        FileInputStream fileInputStream = new FileInputStream(keyStorePath);
        keyStore.load(fileInputStream, password.toCharArray());
        Certificate certificate = keyStore.getCertificate(alias);
        this.certificate = certificate;
        this.privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
        if (certificate != null) {
            this.publicKey = certificate.getPublicKey();
        }
        System.out.println(keyStore.getKey(alias, password.toCharArray()));
        return keyStore;
    }

    /**
     * 获取证书alias
     *
     * @return
     * @throws Exception
     */
    public List<String> getCerAlias() throws Exception {
        Enumeration<String> aliases = keyStore.aliases();
        List<String> list = new ArrayList<>();
        while (aliases.hasMoreElements()) {
            list.add(aliases.nextElement());
        }
        return list;
    }

    /**
     * 获取证书id
     * @return
     */
    public String getCerId(){
        X509Certificate x509Certificate = (X509Certificate) this.certificate;
        return x509Certificate.getSerialNumber().toString();
    }



    /**
     * 获取证书
     *
     * @param cerPath
     * @return
     * @throws Exception
     */
    public X509Certificate loadCer(String cerPath) throws Exception {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Collection colletc = cf.generateCertificates(new FileInputStream(cerPath));
        Iterator iterator = colletc.iterator();
        X509Certificate cer = null;
        while (iterator.hasNext()) {
            cer = (X509Certificate) iterator.next();
        }
        if (cer != null) {
            this.publicKey = cer.getPublicKey();
        }
        this.certificate = cer;
        return cer;
    }

    /**
     * 根据证书验证签名
     * @param oriData
     * @param signData
     */
    public boolean verify(byte[] oriData, byte[] signData) {
        X509Certificate x509cer = (X509Certificate) this.certificate;
        Signature sa = null;
        try {
            sa = Signature.getInstance(x509cer.getSigAlgName());
            sa.initVerify(x509cer);
            sa.update(oriData);
            return sa.verify(signData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public KeyStore getKeyStore() {
        return keyStore;
    }

    public void setKeyStore(KeyStore keyStore) {
        this.keyStore = keyStore;
    }

    public static void main(String[] args) throws Exception {
//        KeyStoreUtil keyStoreUtil = new KeyStoreUtil(); //加载证书
//        keyStoreUtil.loadStore("/export/safefile/applepay/applepayTest.p12", KeyStoreUtil.PKCS12, "wendale_merchant", "");
//
//        Security.addProvider(new BouncyCastleProvider());
//        Cipher c = Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding", BouncyCastleProvider.PROVIDER_NAME);
//        c.init(Cipher.DECRYPT_MODE, keyStoreUtil.privateKey);
//        AppleTokenDTO3 appleTokenDTO3 = new AppleTokenDTO3();
//        byte[] wrapped = Base64.decode(appleTokenDTO3.header.wrappedKey);
//        byte[] data = Base64.decode(appleTokenDTO3.data);
//        byte[] sessionKey = c.doFinal(wrapped); //解密公钥
//
//        SecretKeySpec skeySpec = new SecretKeySpec(sessionKey, "AES"); //构建AES对称会话秘钥
//        byte[] IV = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
//
//        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
//        cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(IV));
//        byte[] original = cipher.doFinal(data); //解密
//
//        System.out.println(new String(original));
    }
}
