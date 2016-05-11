package com.xpay.channel.front.utils;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.pkcs.ContentInfo;
import sun.security.pkcs.PKCS7;
import sun.security.pkcs.PKCS9Attributes;
import sun.security.pkcs.SignerInfo;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;


/**
 * PKCS7Tool.java
 * pkcs7格式签名工具
 *
 * @version 1.0
 * @author SUNY
 * Written Date: 2008-9-23
 * Modified Date 2010-6-12 update for IBM JDK
 */
public class Pkcs7Tool {
    /**签名*/
    private static final int SIGNER = 1;
    /**验证*/
    private static final int VERIFIER = 2;
    /**用途*/
    private int mode = 0;
    /**摘要算法*/
    private String digestAlgorithm = "SHA1";
    /**签名算法*/
    private String signingAlgorithm = "SHA1withRSA";
    /**签名证书链*/
    private X509Certificate[] certificates = null;
    /**签名私钥*/
    private PrivateKey privateKey = null;
    /**根证书*/
    private Certificate rootCertificate = null;
    /**JVM 提供商*/
    private static char jvm = 0;
    private static Class algorithmId = null;
    private static Class derValue = null;
    private static Class objectIdentifier = null;
    private static Class x500Name = null;
    private static boolean debug = false;

    /**
     * 私有构造方法
     */
    private Pkcs7Tool(int mode) {
        this.mode = mode;
    }

    /**
     * 取得签名工具
     * 加载证书库, 取得签名证书链和私钥
     * @param keyStorePath 证书库路径
     * @param keyStorePassword 证书库口令
     * @throws java.security.GeneralSecurityException
     * @throws java.io.IOException
     */
    public static Pkcs7Tool getSigner(String keyStorePath, String keyStorePassword, String keyPassword)
            throws GeneralSecurityException, IOException {
        init();
        //加载证书库
        KeyStore keyStore = null;
        if (keyStorePath.toLowerCase().endsWith(".pfx"))
            keyStore = KeyStore.getInstance("PKCS12");
        else
            keyStore = KeyStore.getInstance("JKS");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(keyStorePath);
            keyStore.load(fis, keyStorePassword.toCharArray());
        } finally {
            if (fis != null)
                fis.close();
        }
        //在证书库中找到签名私钥
        Enumeration aliases = keyStore.aliases();
        String keyAlias = null;
        if (aliases != null) {
            while (aliases.hasMoreElements()) {
                keyAlias = (String) aliases.nextElement();
                Certificate[] certs = keyStore.getCertificateChain(keyAlias);
                if (certs == null || certs.length == 0)
                    continue;
                X509Certificate cert = (X509Certificate)certs[0];
                if (matchUsage(cert.getKeyUsage(), 1)) {
                    try {
                        cert.checkValidity();
                    } catch (CertificateException e) {
                        continue;
                    }
                    break;
                }
            }
        }
        //没有找到可用签名私钥
        if (keyAlias == null)
            throw new GeneralSecurityException("None certificate for sign in this keystore");

        if (debug)
            System.out.println(keyAlias);
        X509Certificate[] certificates = null;
        if (keyStore.isKeyEntry(keyAlias)) {
            //检查证书链
            Certificate[] certs = keyStore.getCertificateChain(keyAlias);
            for (int i = 0; i < certs.length; i ++) {
                if (!(certs[i] instanceof X509Certificate))
                    throw new GeneralSecurityException("Certificate[" + i + "] in chain '" + keyAlias + "' is not a X509Certificate.");
            }
            //转换证书链
            certificates = new X509Certificate[certs.length];
            for (int i = 0; i < certs.length; i ++)
                certificates[i] = (X509Certificate) certs[i];
        } else if (keyStore.isCertificateEntry(keyAlias)) {
            //只有单张证书
            Certificate cert = keyStore.getCertificate(keyAlias);
            if (cert instanceof X509Certificate) {
                certificates = new X509Certificate[] {(X509Certificate) cert};
            }
        } else {
            throw new GeneralSecurityException(keyAlias + " is unknown to this keystore");
        }

        PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, keyPassword.toCharArray());
        //没有私钥抛异常
        if (privateKey == null) {
            throw new GeneralSecurityException(keyAlias + " could not be accessed");
        }

        Pkcs7Tool tool = new Pkcs7Tool(SIGNER);
        tool.certificates = certificates;
        tool.privateKey = privateKey;
        return tool;
    }

    /**
     * 取得验签名工具
     * 加载信任根证书
     * @param rootCertificatePath 根证书路径
     * @throws java.security.GeneralSecurityException
     * @throws java.io.IOException
     */
    public static Pkcs7Tool getVerifier(String rootCertificatePath)
            throws GeneralSecurityException, IOException {
//        init();
        //加载根证书
        FileInputStream fis = null;
        Certificate rootCertificate = null;
        try {
            fis = new FileInputStream(rootCertificatePath);
            CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
            try {
                rootCertificate = certificatefactory.generateCertificate(fis);
            }
            catch(Exception exception) {
                InputStream is = new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(fis));
                rootCertificate = certificatefactory.generateCertificate(is);
            }
        } finally {
            if (fis != null)
                fis.close();
        }

        Pkcs7Tool tool = new Pkcs7Tool(VERIFIER);
        tool.rootCertificate = rootCertificate;
        return tool;
    }

    /**
     * 签名
     * @param data 数据
     * @return signature 签名结果
     * @throws java.security.GeneralSecurityException
     * @throws java.io.IOException
     * @throws IllegalArgumentException
     */
    public String sign(byte[] data) throws Exception {
        if (mode != SIGNER)
            throw new IllegalStateException("call a PKCS7Tool instance not for signature.");

        Signature signer = Signature.getInstance(signingAlgorithm);
        signer.initSign(privateKey);
        signer.update(data, 0, data.length);
        byte[] signedAttributes = signer.sign();

        ContentInfo contentInfo = null;
        Field data_oidField = ContentInfo.class.getField("DATA_OID");
        Object data_oid = data_oidField.get(null);
        Constructor contentInfoConstructor = ContentInfo.class.getConstructor(new Class[]{data_oid.getClass(), derValue});
        contentInfo = (ContentInfo) contentInfoConstructor.newInstance(new Object[]{data_oid, null});
        //根证书
        X509Certificate x509 = certificates[certificates.length - 1];
        BigInteger serial = x509.getSerialNumber();
        //X500Name
        Constructor x500NameConstructor = x500Name.getConstructor(new Class[]{String.class});
        Object x500NameObject = x500NameConstructor.newInstance(new Object[]{x509.getIssuerDN().getName()});
        //AlgorithmId
        Method algorithmIdGet = algorithmId.getMethod("get", new Class[]{String.class});
        Object digestAlgorithmId = algorithmIdGet.invoke(null, new Object[]{digestAlgorithm});
        Field algorithmIdfield = algorithmId.getField("RSAEncryption_oid");
        Object rsaOid = algorithmIdfield.get(null);
        Constructor algorithmConstructor = algorithmId.getConstructor(new Class[]{objectIdentifier});
        Object algorithmRsaOid = algorithmConstructor.newInstance(new Object[]{rsaOid});
        //SignerInfo
        Constructor signerInfoConstructor = SignerInfo.class.getConstructor(
                new Class[]{
                        x500Name,
                        BigInteger.class,
                        algorithmId,
                        PKCS9Attributes.class,
                        algorithmId,
                        byte[].class,
                        PKCS9Attributes.class
                }
        );
        //签名信息
        SignerInfo si = (SignerInfo) signerInfoConstructor.newInstance(
                new Object[]{
                        x500NameObject,// X500Name, issuerName,
                        serial, // x509.getSerialNumber(), BigInteger serial,
                        digestAlgorithmId, // AlgorithmId, digestAlgorithmId,
                        null, // PKCS9Attributes, authenticatedAttributes,
                        algorithmRsaOid, // AlgorithmId, digestEncryptionAlgorithmId,
                        signedAttributes, // byte[] encryptedDigest,
                        null // PKCS9Attributes unauthenticatedAttributes)
                }
        );

        SignerInfo[] signerInfos = { si };

        // 构造PKCS7数据
        Object digestAlgorithmIds = Array.newInstance(algorithmId, 1);
        Array.set(digestAlgorithmIds, 0, digestAlgorithmId);
        //PKCS7
        Constructor pkcs7Constructor = PKCS7.class.getConstructor(new Class[]{
                digestAlgorithmIds.getClass(), ContentInfo.class, X509Certificate[].class, signerInfos.getClass()});
        PKCS7 p7 = (PKCS7) pkcs7Constructor.newInstance(new Object[]{
                digestAlgorithmIds, contentInfo, certificates, signerInfos});
//      PKCS7 p7 = new PKCS7(digestAlgorithmIds, contentInfo, certificates, signerInfos);
//      public PKCS7(com.ibm.security.x509.AlgorithmId[] arg0, sun.security.pkcs.ContentInfo arg1, java.security.cert.X509Certificate[] arg2, sun.security.pkcs.SignerInfo[] arg3);
//        public PKCS7(sun.security.x509.AlgorithmId[] arg0, sun.security.pkcs.ContentInfo arg1, java.security.cert.X509Certificate[] arg2, sun.security.pkcs.SignerInfo[] arg3);

        ByteArrayOutputStream baout = new ByteArrayOutputStream();
        p7.encodeSignedData(baout);
        //Base64编码
        return (new BASE64Encoder()).encode(baout.toByteArray());
    }

    /**
     * 验证签名(无CRL)
     * @param signature 签名签名结果
     * @param data 被签名数据
     * @param dn 签名证书dn, 如果为空则不做匹配验证
     * @throws java.io.IOException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.SignatureException
     * @throws java.security.InvalidKeyException
     * @throws java.security.cert.CertificateException
     * @throws java.security.NoSuchProviderException
     */
    public boolean verify(String signature) throws IOException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException, CertPathValidatorException, KeyStoreException {
        KeyStore keyStore  = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null);//Make an empty store
        InputStream fis =new FileInputStream("/export/safefile/applepay/AppleRootCA-G3.cer");
        BufferedInputStream bis = new BufferedInputStream(fis);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        while (bis.available() > 0) {
            Certificate cert = cf.generateCertificate(bis);
            keyStore.setCertificateEntry("fiddler"+bis.available(), cert);
        }
        //在证书库中找
        byte[] sign = new BASE64Decoder().decodeBuffer(signature);
        ByteArrayInputStream ins = new ByteArrayInputStream(sign);

        PKCS7 p7 = new PKCS7(sign);
        X509Certificate[] certs = p7.getCertificates();
        List certList = Arrays.asList(certs);
        CertPath certPath = cf.generateCertPath(certList);
        CertPathValidator validator = CertPathValidator.getInstance("PKIX");
//        Set<TrustAnchor> trustAnchors = new HashSet<TrustAnchor>();
//        for(X509Certificate certIt:certs){
//            trustAnchors.add(new TrustAnchor(certIt, null));
//        }
        //构建证书验证设置
        PKIXParameters parameters = new PKIXParameters(keyStore);
        parameters.setRevocationEnabled(false);
        PKIXCertPathValidatorResult result = (PKIXCertPathValidatorResult) validator.validate(certPath, parameters);
        TrustAnchor trustAnchor = result.getTrustAnchor();
        PolicyNode policyNode = result.getPolicyTree();
        PublicKey publicKey = result.getPublicKey();
        Certificate issuer = trustAnchor.getTrustedCert();
        if(result==null){
           return false;
        }
        return true;
    }

    /**
     * 匹配私钥用法
     * @param keyUsage
     * @param usage
     * @return
     */
    private static boolean matchUsage(boolean[] keyUsage, int usage) {
        if (usage == 0 || keyUsage == null)
            return true;
        for (int i = 0; i < Math.min(keyUsage.length, 32); i ++) {
            if ((usage & (1 << i)) != 0 && !keyUsage[i])
                return false;
        }
        return true;
    }

    private static void init() {
        if (jvm != 0)
            return;
        String vendor = System.getProperty("java.vm.vendor");
        if (vendor == null)
            vendor = "";
        String vendorUC = vendor.toUpperCase();
        try {
            if (vendorUC.indexOf("SUN") >= 0) {
                jvm = 'S';
                algorithmId = Class.forName("sun.security.x509.AlgorithmId");
                derValue = Class.forName("sun.security.utils.DerValue");
                objectIdentifier = Class.forName("sun.security.utils.ObjectIdentifier");
                x500Name = Class.forName("sun.security.x509.X500Name");
            }
            else if (vendorUC.indexOf("IBM") >= 0){
                jvm = 'I';
                algorithmId = Class.forName("com.ibm.security.x509.AlgorithmId");
                derValue = Class.forName("com.ibm.security.utils.DerValue");
                objectIdentifier = Class.forName("com.ibm.security.utils.ObjectIdentifier");
                x500Name = Class.forName("com.ibm.security.x509.X500Name");
            }
            else {
                System.out.println("Not support JRE: " + vendor);
                System.exit(-1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * @return 返回 digestAlgorithm。
     */
    public final String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    /**
     * @param digestAlgorithm 要设置的 digestAlgorithm。
     */
    public final void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    /**
     * @return 返回 signingAlgorithm。
     */
    public final String getSigningAlgorithm() {
        return signingAlgorithm;
    }

    /**
     * @param signingAlgorithm 要设置的 signingAlgorithm。
     */
    public final void setSigningAlgorithm(String signingAlgorithm) {
        this.signingAlgorithm = signingAlgorithm;
    }

    public static void setDebug(boolean debug) {
        Pkcs7Tool.debug = debug;
    }

    /**
     * 验证Certificate
     *
     * @param certificatePath
     * @return
     */
    public static boolean verifyCertificate(String certificatePath) {
        return verifyCertificate(new Date(), certificatePath);
    }

    /**
     * 验证Certificate是否过期或无效
     *
     * @param date
     * @param certificatePath
     * @return
     */
    public static boolean verifyCertificate(Date date, String certificatePath) {
        boolean status = true;
        try {
            // 取得证书
            Certificate certificate = getCertificate(certificatePath);
            // 验证证书是否过期或无效
            status = verifyCertificate(date, certificate);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }
    /**
     * 验证证书是否过期或无效
     *
     * @param date
     * @param certificate
     * @return
     */
    private static boolean verifyCertificate(Date date, Certificate certificate) {
        boolean status = true;
        try {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            x509Certificate.checkValidity(date);
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    /**
     * 获得Certificate
     *
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String certificatePath)
            throws Exception {
        CertificateFactory certificateFactory = CertificateFactory
                .getInstance("X.509");
        FileInputStream in = new FileInputStream(certificatePath);

        Certificate certificate = certificateFactory.generateCertificate(in);
        in.close();

        return certificate;
    }

    /**
     * 获得Certificate
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String keyStorePath,
                                              String alias, String password) throws Exception {
        KeyStore ks = getKeyStore(keyStorePath, password);
        Certificate certificate = ks.getCertificate(alias);

        return certificate;
    }
    /**
     * 获得KeyStore
     *
     * @param keyStorePath
     * @param password
     * @return
     * @throws Exception
     */
    private static KeyStore getKeyStore(String keyStorePath, String password)
            throws Exception {
        FileInputStream is = new FileInputStream(keyStorePath);
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(is, password.toCharArray());
        is.close();
        return ks;
    }

}