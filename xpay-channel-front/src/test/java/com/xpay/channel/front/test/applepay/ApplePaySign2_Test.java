package com.xpay.channel.front.test.applepay;

import com.xpay.channel.front.test.BaseTest;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import sun.security.pkcs.PKCS7;

import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by suxinxin on 16/3/23.
 */
public class ApplePaySign2_Test extends BaseTest {

    @Test
    public void verfySign() throws Exception {
        AppleTokenDTO3 token = new AppleTokenDTO3();

        byte[] wrappedKey = Base64.decodeBase64(token.header.wrappedKey);
        String transactionId = token.header.transactionId;
        String pkh = token.header.publicKeyHash;
        byte[] data = Base64.decodeBase64(token.data);
        byte[] signData = Base64.decodeBase64(token.signature);

        boolean vflag = this.verify(signData, "/export/safefile/applepay/AppleRootCA-G3.cer", "PKCS12");
        System.out.println("applePay验证签名结果:" + vflag);
    }

    public boolean verify(byte[] signData, String path, String keystoreType) throws IOException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException, CertPathValidatorException, KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance(keystoreType);
        keyStore.load(null);//Make an empty store
        InputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate rootCert = (X509Certificate) cf.generateCertificates(fis).iterator().next();
        keyStore.setCertificateEntry("fiddler" + bis.available(), rootCert);


        PKCS7 p7 = new PKCS7(signData);
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
        if (result == null) {
            return false;
        }
        return true;
    }
}
