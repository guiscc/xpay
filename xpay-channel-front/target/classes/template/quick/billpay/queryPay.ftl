<@compress single_line=true>
<?xml version="1.0" encoding="UTF-8"?>
<MasMessage xmlns="http://www.99bill.com/mas_cnp_merchant_interface">
    <version>${(cfg.version) !""}</version>
    <QryTxnMsgContent>
        <externalRefNumber>${req.payOrderNo}</externalRefNumber>
        <txnType>PUR</txnType>
        <merchantId>${req.merchantNo!''}</merchantId>
        <terminalId>${(cfg.terminalId)!''}</terminalId>
    </QryTxnMsgContent>
</MasMessage>
</@compress>