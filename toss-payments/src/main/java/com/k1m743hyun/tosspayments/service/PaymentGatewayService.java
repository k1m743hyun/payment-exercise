package com.k1m743hyun.tosspayments.service;

import com.k1m743hyun.tosspayments.client.PaymentGatewayClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentGatewayService {

    private final PaymentGatewayClient client;

    public String getPaymentsByPaymentKey(String paymentKey) throws Exception {
        return client.getPaymentsByPaymentKey(paymentKey);
    }

    public String getPaymentsByOrderId(String orderId) throws Exception {
        return client.getPaymentsByOrderId(orderId);
    }

    public String getTransactions(String startDate, String endDate) throws Exception {
        return client.getTransactions(startDate, endDate);
    }

    public String getSettlements(String startDate, String endDate) throws Exception {
        return client.getSettlements(startDate, endDate);
    }
}
