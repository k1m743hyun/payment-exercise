package com.k1m743hyun.tosspayments.controller;

import com.k1m743hyun.tosspayments.service.PaymentGatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/payment")
@RequiredArgsConstructor
@RestController
public class PaymentGatewayController {

    private final PaymentGatewayService service;

    @GetMapping("/payments/{paymentKey}")
    public String getPaymentsByPaymentKey(@PathVariable String paymentKey) throws Exception {
        return service.getPaymentsByPaymentKey(paymentKey);
    }

    @GetMapping("/payments/orders/{orderId}")
    public String getPaymentsByOrderId(@PathVariable String orderId) throws Exception {
        return service.getPaymentsByOrderId(orderId);
    }

    @GetMapping("/transactions")
    public String getTransactions(@RequestParam String startDate, @RequestParam String endDate) throws Exception {
        return service.getTransactions(startDate, endDate);
    }

    @GetMapping("/settlements")
    public String getSettlements(@RequestParam String startDate, @RequestParam String endDate) throws Exception {
        return service.getSettlements(startDate, endDate);
    }
}
