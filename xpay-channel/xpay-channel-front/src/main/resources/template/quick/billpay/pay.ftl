<?xml version="1.0" encoding="utf-8"?>
<MasMessage xmlns="http://www.99bill.com/mas_cnp_merchant_interface">
  <version>${version !""}</version>
  <TxnMsgContent>
    <txnType>PUR</txnType>
    <interactiveStatus>TR1</interactiveStatus>
    <#if cardNo ??>
    	<cardNo>${cardNo}</cardNo>
    </#if>
    <amount>${amount}</amount>
    <merchantId>${merchantNo}</merchantId>
    <terminalId>${terminalId}</terminalId>
    <entryTime>${reqTime}</entryTime>
    <externalRefNumber>${channelPayNo}</externalRefNumber>
    <customerId>${useId}</customerId>
    <spFlag>${spFlag}</spFlag>
    <extMap>
      <extDate>
        <key>phone</key>
        <value/>
      </extDate>
      <extDate>
        <key>validCode</key>
        <value/>
      </extDate>
      <extDate>
        <key>savePciFlag</key>
        <value>0</value>
      </extDate>
      <extDate>
        <key>token</key>
        <value/>
      </extDate>
      <extDate>
        <key>payBatch</key>
        <value>${payBatch}</value>
      </extDate>
    </extMap>
    <storableCardNo>${oriBankSignNo}</storableCardNo>
  </TxnMsgContent>
</MasMessage>
