package org.jiage.srpc.server.paypal.dataobjects.misc;

import paypal.payflow.*;

// This class uses the Payflow SDK Data Objects to do a simple TeleCheck - Authorization transaction.
// The request is sent as a Data Object and the response received is also a Data Object.

public class DOAuthorization_TeleCheck {
    public DOAuthorization_TeleCheck() {
    }

    public static void main(String args[]) {
        System.out.println("------------------------------------------------------");
        System.out.println("Executing Sample from File: DOAuthorization_TeleCheck.java");
        System.out.println("------------------------------------------------------");

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
        SDKProperties.setMaxLogFileSize(100000);

        // Uncomment the lines below and set the proxy address and port, if a proxy has to be used.
        //SDKProperties.setProxyAddress("");
        //SDKProperties.setProxyPort(0);

        // Create the Data Objects.
        // Create the User data object with the required user details.
        UserInfo user = new UserInfo("<user>", "<vendor>", "<partner>", "<password>");

        // Create the Payflow Connection data object with the required connection details.
        PayflowConnectionData connection = new PayflowConnectionData();

        // Create a new Invoice data object with the Amount, Billing Address etc. details.
        Invoice inv = new Invoice();

        // Set Amount.
        Currency amt = new Currency(new Double(25.12));
        inv.setAmt(amt);
        inv.setPoNum("PO12345");
        inv.setInvNum("INV12345");

        // Set the Billing Address details.
        BillTo bill = new BillTo();
        bill.setStreet("123 Main St.");
        bill.setZip("12345");
        bill.setCity("New York");
        bill.setState("PA");
        bill.setEmail("ivan@test.com");
        bill.setBillToCountry("US");
        bill.setPhoneNum("123-123-1234");
        inv.setBillTo(bill);

        // Set the IP address of the customer
        CustomerInfo custInfo = new CustomerInfo();
        custInfo.setCustIP("111.11.11.111");
        inv.setCustomerInfo(custInfo);

        // Create a new Payment Device - Check Payment data object.
        // The input parameters is MICR. Magnetic Ink Check Reader. This is the entire line
        // of numbers at the bottom of all checks. It includes the transit number, account 
        // number, and check number.
        CheckPayment ChkPayment = new CheckPayment("1234567804390850001001");
        // Name property needs to be set for the Check Payment.
        ChkPayment.setName("Ivan Smith");
        // Create a new Tender - Check Tender data object.
        CheckTender chkTender = new CheckTender(ChkPayment);
        // Account holder�s next unused (available) check number. Up to 7 characters.
        chkTender.setChkNum("1234");
        // DL or SS is required for a TeleCheck transaction.
        // If CHKTYPE=P, a value for either DL or SS must be passed as an identifier.
        // If CHKTYPE=C, the Federal Tax ID must be passed as the SS value.
        chkTender.setChkType("P");
        // Driver�s License number. If CHKTYPE=P, a value for either DL or SS must be passed as an identifier.
        // Format: XXnnnnnnnn
        // XX = State Code
        // nnnnnnnn = DL Number - up to 31 characters.
        chkTender.setDL("CAN85452345");
        // Social Security number.
        //ChkTender.setSS("456765833");
        // set the type of the Check transaction
        chkTender.setAuthType("I");

        ///////////////////////////////////////////////////////////////////

        // Create a new Telecheck - Authorization Transaction.
        AuthorizationTransaction trans = new AuthorizationTransaction(user, connection, inv, chkTender, PayflowUtility.getRequestId());

        // Submit the Transaction
        Response resp = trans.submitTransaction();

        // Display the transaction response parameters.
        if (resp != null) {
            // Get the Transaction Response parameters.
            TransactionResponse trxnResponse = resp.getTransactionResponse();

            // Create a new Client Information data object.
            ClientInfo clInfo = new ClientInfo();

            // Set the ClientInfo object of the transaction object.
            trans.setClientInfo(clInfo);


            if (trxnResponse != null) {
                System.out.println("RESULT = " + trxnResponse.getResult());
                System.out.println("PNREF = " + trxnResponse.getPnref());
                System.out.println("RESPMSG = " + trxnResponse.getRespMsg());
                System.out.println("AUTHCODE = " + trxnResponse.getAuthCode());
                System.out.println("HOSTCODE = " + trxnResponse.getHostCode());
                System.out.println("TRACEID = " + trxnResponse.getTraceId());
                System.out.println("ACHSTATUS = " + trxnResponse.getAchStatus());
                System.out.println("TRANSTIME = " + trxnResponse.getTransTime());
            }

            // Display the response.
            System.out.println("\n" + PayflowUtility.getStatus(resp));

            // Get the Transaction Context and check for any contained SDK specific errors (optional code).
            Context transCtx = resp.getContext();
            if (transCtx != null && transCtx.getErrorCount() > 0) {
                System.out.println("\nTransaction Errors = " + transCtx.toString());
            }

        }
    }
}
