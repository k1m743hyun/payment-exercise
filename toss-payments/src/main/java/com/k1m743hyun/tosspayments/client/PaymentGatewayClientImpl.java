package com.k1m743hyun.tosspayments.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

@Component
public class PaymentGatewayClientImpl implements PaymentGatewayClient {

    @Value("${payments.toss.secretKey}")
    private String secretKey;

    @Override
    public String getPaymentsByPaymentKey(String paymentKey) throws Exception {

        String uri = "https://api.tosspayments.com/v1/payments/" + paymentKey;
        String result = getResult(uri);
        System.out.println(result);

        return "success";
    }

    @Override
    public String getPaymentsByOrderId(String orderId) throws Exception {

        String uri = "https://api.tosspayments.com/v1/payments/orders/" + orderId;
        String result = getResult(uri);
        System.out.println(result);

        return "success";
    }

    @Override
    public String getTransactions(String startDate, String endDate) throws Exception {

        String uri = "https://api.tosspayments.com/v1/transactions?startDate=" + startDate + "&endDate=" + endDate;
        String result = getResult(uri);
        System.out.println(result);

        return "success";
    }

    @Override
    public String getSettlements(String startDate, String endDate) throws Exception {

        String uri = "https://api.tosspayments.com/v1/settlements?startDate=" + startDate + "&endDate=" + endDate;
        String result = getResult(uri);
        System.out.println(result);

        return "success";
    }

    private String getResult(String uri) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Authorization", getAuthorization(secretKey))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private String getAuthorization(String secretKey) throws Exception {

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(secretKey.getBytes("UTF-8"));
        String authorization = "Basic " + new String(encodedBytes, 0, encodedBytes.length);

        return authorization;
    }
}
