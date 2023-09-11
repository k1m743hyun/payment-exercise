package com.k1m743hyun.tosspayments.client;

public interface PaymentGatewayClient {

    public String getPaymentsByPaymentKey(String paymentKey) throws Exception;

    public String getPaymentsByOrderId(String orderId) throws Exception;

    public String getTransactions(String startDate, String endDate) throws Exception;

    public String getSettlements(String startDate, String endDate) throws Exception;
}
