package com.xpay.common.utils;

import org.dom4j.*;
import org.dom4j.xpath.DefaultXPath;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: suxx
 * Date: 13-9-22
 * Time: 下午2:09
 * To change this template use File | Settings | File Templates.
 */
public class XMLUtils {

    private Document document;

    public XMLUtils(String xml) throws DocumentException {
        try {
            document = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            throw new DocumentException("xml内容加载失败");
        }
    }

    /**
     * 通过xpath获取标签内容
     *
     * @param xpath
     * @return
     */
    public String getValueByXpath(String xpath) {
        return getValueByXpath(xpath, null);
    }

    /**
     * 通过xpath和xml的命名空间获取标签内容
     *
     * @param xpath
     * @param map
     * @return
     */
    public String getValueByXpath(String xpath, Map<String, String> map) {
        XPath xPathObj = new DefaultXPath(xpath);
        if (map != null) {
            xPathObj.setNamespaceURIs(map);
        }
        Node node = xPathObj.selectSingleNode(document);
        if (node != null) {
            return node.getText();
        }
        return "";
    }

    public String setValueByXpath(String xpath, String value) {
        //解析xml字符串报文
        List<Element> commonList = document.selectNodes(xpath);    //通过xpath找到节点
        for (Element element : commonList) {
            element.setTextContent(null);
            return document.asXML();
        }
        return "";
    }

    public String setValueByXpath(String xpath, Map<String, String> map, String value) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        String msg1 = "<?xml version=\"1.0\" encoding=\"GB2312\"?>\n" +
                "<bocb2e>\n" +
                "    <head>\n" +
                "    <termid>E010045255007</termid>\n" +
                "<trnid>200730729</trnid>\n" +
                "<custid>25372371</custid>\n" +
                "<cusopr>25971180</cusopr>\n" +
                "<trncod>b2e0035</trncod>\n" +
                "<token>123123</token>    </head>\n" +
                "    <trans>\n" +
                "        <trn-b2e0035-rq>\n" +
                "            <b2e0035-rq>\n" +
                "                    <ibknum>40142</ibknum>\n" +
                "                    <actacn>328556082330</actacn>\n" +
                "                    <type>2002</type>\n" +
                "                <datescope>\n" +
                "                    <from>20130917</from>\n" +
                "                    <to>20130917</to>\n" +
                "                </datescope>\n" +
                "                <amountscope>\n" +
                "                    <from></from>\n" +
                "                    <to></to>\n" +
                "                </amountscope>\n" +
                "                <begnum>2</begnum>\n" +
                "                <recnum>01</recnum>\n" +
                "                <direction>0</direction>\n" +
                "            </b2e0035-rq>\n" +
                "        </trn-b2e0035-rq>\n" +
                "    </trans>\n" +
                "</bocb2e>";

        String msg = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<MasMessage xmlns=\"http://www.99bill.com/mas_cnp_merchant_interface\">\n" +
                "  <version>1.0</version>\n" +
                "  <QryTxnMsgContent>\n" +
                "    <externalRefNumber>12001160113164414013194</externalRefNumber>\n" +
                "    <txnType>PUR</txnType>\n" +
                "    <merchantId>812310060110178</merchantId>\n" +
                "    <terminalId>01800875</terminalId>\n" +
                "  </QryTxnMsgContent>\n" +
                "  <TxnMsgContent>\n" +
                "    <txnType>PUR</txnType>\n" +
                "    <amount>1</amount>\n" +
                "    <merchantId>812310060110178</merchantId>\n" +
                "    <terminalId>01800875</terminalId>\n" +
                "    <entryTime>20160113164414</entryTime>\n" +
                "    <externalRefNumber>12001160113164414013194</externalRefNumber>\n" +
                "    <customerId>1201601131643254701</customerId>\n" +
                "    <transTime>20160113164415</transTime>\n" +
                "    <voidFlag>0</voidFlag>\n" +
                "    <refNumber>001415077061</refNumber>\n" +
                "    <responseCode>00</responseCode>\n" +
                "    <responseTextMessage/>\n" +
                "    <cardOrg>CU</cardOrg>\n" +
                "    <issuer>招商银行</issuer>\n" +
                "    <storableCardNo>6214851022</storableCardNo>\n" +
                "    <txnStatus>S</txnStatus>\n" +
                "  </TxnMsgContent>\n" +
                "</MasMessage>";
        XMLUtils xmlUtils = new XMLUtils(msg);

        Map<String, String> map = new HashMap<String, String>();
        map.put("ns", "http://www.99bill.com/mas_cnp_merchant_interface");
        System.out.println("^^^^^^^^^^" + xmlUtils.getValueByXpath("//ns:MasMessage//ns:TxnMsgContent//ns:responseCode",map));

        XMLUtils xmlUtils1 = new XMLUtils(msg1);
        System.out.println(xmlUtils1.getValueByXpath("/bocb2e/head/termid"));
    }
}
