<?xml version="1.0" encoding="utf-8"?>
<MasMessage xmlns="http://www.99bill.com/mas_cnp_merchant_interface">
  <version>${version !""}</version>
  <indAuthDynVerifyContent>
    <merchantId>${merchantNo}</merchantId>
    <customerId>${userId}</customerId>
    <externalRefNumber>${orderNo}</externalRefNumber>
    <pan>${cardNo}</pan>
    <phoneNO>${mobileNo}</phoneNO>
    <validCode>${vaildCode}</validCode>
    <token>${token}</token>
  </indAuthDynVerifyContent>
</MasMessage>

