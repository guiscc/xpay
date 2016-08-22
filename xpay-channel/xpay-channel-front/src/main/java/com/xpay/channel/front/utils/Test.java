package com.xpay.channel.front.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * Created by suxinxin on 16/2/18.
 */
public class Test {
    public static void main(String[] args)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("/export/safefile/billpay/81231006011017890.jks"), "vpos123".toCharArray());
        Certificate certificate = keyStore.getCertificate("81231006011017890");
//        System.out.println(certificate);
        Key key = keyStore.getKey("keyStore", "vpos123".toCharArray());
        System.out.println(key);
    }
}
