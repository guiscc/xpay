package com.xpay.channel.front.test.applepay;

import com.xpay.channel.front.test.BaseTest;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.cms.*;
import org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.Security;
import java.security.cert.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by suxinxin on 16/3/23.
 */
public class ApplePaySign1_Test extends BaseTest {
    @Test
    public void payTokenJson() throws Exception {
        Security.addProvider(new BouncyCastleProvider());   //加入bc实现

        AppleTokenDTO token = new AppleTokenDTO();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] wrappedKey = Base64.decodeBase64(token.header.wrappedKey);
        String transactionId = token.header.transactionId;
        String pkh = token.header.publicKeyHash;
        byte[] data = Base64.decodeBase64(token.data);
        byte[] signData = Base64.decodeBase64(token.signature);
        out.write(wrappedKey);
        out.write(data);
        out.write(Hex.decode(transactionId));
        byte[] toVerify = out.toByteArray();

        CMSSignedData ss = null;
        ss = new CMSSignedData(new CMSProcessableByteArray(toVerify), signData);

        CertStore certStore = ss.getCertificatesAndCRLs("Collection", "BC");
        SignerInformationStore signers = ss.getSignerInfos();

        Collection c = signers.getSigners();
        Iterator it = c.iterator();
        boolean bresult = true;
        SignerInformation signerInfo = (SignerInformation) signers.getSigners().iterator().next();

        SignerId signerConstraints = signerInfo.getSID();
        //root-cert 文件目录
        FileInputStream fis = new FileInputStream("/export/safefile/applepay/AppleRootCA-G3.cer");
        CertificateFactory cf = CertificateFactory.getInstance("X.509", new BouncyCastleProvider());


        X509Certificate rootCert = (X509Certificate) cf.generateCertificates(fis).iterator().next();
//        System.out.println(rootCert);

        CertPathBuilder builder = CertPathBuilder.getInstance("PKIX", "BC");
        PKIXBuilderParameters buildParams = new PKIXBuilderParameters(
                Collections.singleton(new TrustAnchor(rootCert, null)),
                (CertSelector) signerConstraints);

        buildParams.addCertStore(certStore);
        buildParams.setRevocationEnabled(false);
        PKIXCertPathBuilderResult builderResult = (PKIXCertPathBuilderResult) builder.build(buildParams);

        boolean result = signerInfo.verify(new JcaSimpleSignerInfoVerifierBuilder().setProvider("BC").build(builderResult.getPublicKey()));
        System.out.println("苹果支付签名验证结果:" + result);
    }
}