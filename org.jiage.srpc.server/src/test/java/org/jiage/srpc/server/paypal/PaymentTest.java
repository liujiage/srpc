package org.jiage.srpc.server.paypal;

import org.junit.Test;
import paypal.payflow.*;

import java.util.UUID;

public class PaymentTest {

    @Test
    public void pay(){
        // Payflow Pro Host Name. This is the host name for the PayPal Payment Gateway.
        // For testing: 	pilot-payflowpro.paypal.com
        // For production:  payflowpro.paypal.com
        // DO NOT use payflow.verisign.com or test-payflow.verisign.com!
        SDKProperties.setHostAddress("pilot-payflowpro.paypal.com");
        SDKProperties.setHostPort(443);
        SDKProperties.setTimeOut(45);
        // Logging is by default off. To turn logging on uncomment the following lines:
        SDKProperties.setLogFileName("payflow_java.log");
        SDKProperties.setLoggingLevel(PayflowConstants.SEVERITY_DEBUG);
        SDKProperties.setMaxLogFileSize(1000000);
        // Create the Data Objects.
        // Create the User data object with the required user details.
        UserInfo user = new UserInfo(UserInfoContext.USER, UserInfoContext.VENDOR,
                UserInfoContext.PARTNER, UserInfoContext.PWD);
        // Create the Payflow Connection data object with the required connection details.
        PayflowConnectionData connection = new PayflowConnectionData();
        // Create a new Invoice data object with the Amount, Billing Address etc. details.
        Invoice inv = new Invoice();
        // Set Amount.
        Currency amt = new Currency(new Double(99.12));
        inv.setAmt(amt);
        inv.setPoNum("PO12345");
        inv.setInvNum("INV12345");
        // Set the Billing Address details.
        BillTo bill = new BillTo();
        bill.setStreet("123 Main St.");
        bill.setZip("12345");
        inv.setBillTo(bill);
        // Create a new Payment Device - Credit Card data object.
        // The input parameters are Credit Card No. and Expiry Date for the Credit Card.
        CreditCard cc = new CreditCard(UserInfoContext.CREDIT_CARD, UserInfoContext.CREDIT_CARD_EXPIRE);
        // cc.setCvv2(UserInfoContext.CREDIT_CARD_CVV2);
        // Create a new Tender - Card Tender data object.
        CardTender card = new CardTender(cc);
        // Create a new Sale Transaction.
        SaleTransaction trans = new SaleTransaction(
                user, connection, inv, card, PayflowUtility.getRequestId());
        trans.setCreateSecureToken("Y");
        String payId = UUID.randomUUID().toString();
        trans.setSecureTokenId(payId);
        System.out.println(payId);
        // Submit the Transaction
        Response resp = trans.submitTransaction();
        if(resp == null) return ;
        // Display the transaction response parameters.
        // Get the Transaction Response parameters.
        TransactionResponse trxnResponse = resp.getTransactionResponse();
        if (trxnResponse != null) {

            System.out.println("RESULT = " + trxnResponse.getResult());
            System.out.println("RESPMSG = " + trxnResponse.getRespMsg());
            System.out.println("SECURETOKEN = "+ trxnResponse.getSecureToken());
            System.out.println("SECURETOKENID ="+ trxnResponse.getSecureTokenId());
            System.out.println(trxnResponse.getStatus());
        }
        // Get the Transaction Context and check for any contained SDK specific errors (optional code).
        Context transCtx = resp.getContext();
        if (transCtx != null && transCtx.getErrorCount() > 0) {
            System.out.println("\nTransaction Errors = " + transCtx.toString());
        }
    }
}
