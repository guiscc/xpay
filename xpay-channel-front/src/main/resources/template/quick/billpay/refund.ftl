<?xml version="1.0" encoding="UTF-8"?>
<MasMessage xmlns="http://www.99bill.com/mas_cnp_merchant_interface">
    <version>${version!''}</version>
    <TxnMsgContent>
        <txnType>${txnType!''}</txnType>
        <interactiveStatus>TR1</interactiveStatus>
        <amount>${amount!''}</amount>
        <merchantId>${merchantId!''}</merchantId>
        <terminalId>${terminalId!''}</terminalId>
        <entryTime>${entryTime!''}</entryTime>
        <externalRefNumber>${refundId!''}</externalRefNumber>
        <origRefNumber>${servRefundId!''}</origRefNumber>
    </TxnMsgContent>
</MasMessage>