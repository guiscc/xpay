<?xml version="1.0" encoding="utf-8"?>
<MasMessage xmlns="http://www.99bill.com/mas_cnp_merchant_interface">
  <version>${version !""}</version>
  <indAuthContent>
    <merchantId>${merchantNo}</merchantId>
    <terminalId>${terminalId}</terminalId>
    <customerId>${userId}</customerId>
    <externalRefNumber>${channelSignNo}</externalRefNumber>
    <pan>${cardNo}</pan>
    <cardHolderName>${holderName}</cardHolderName>
    <idType>${idType}</idType>
    <cardHolderId>${certCode}</cardHolderId>
    <#if expireDate ??>
    	<expiredDate>${expireDate}</expiredDate>
    </#if>
    <#if cvv2 ??>
    	<cvv2>${cvv2}</cvv2>
    </#if>
    <phoneNO>${mobileNo}</phoneNO>
  </indAuthContent>
</MasMessage>
