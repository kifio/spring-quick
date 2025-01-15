package me.kifio.demo.controller;

import me.kifio.demo.model.NotEnoughMoneyException;
import me.kifio.demo.model.dto.PaymentDetails;
import me.kifio.demo.model.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        return ResponseEntity
                    .ok(paymentService.processPayment());

    }
}
