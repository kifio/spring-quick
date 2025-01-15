package me.kifio.demo.controller;

import me.kifio.demo.model.NotEnoughMoneyException;
import me.kifio.demo.model.dto.Payment;
import me.kifio.demo.model.dto.PaymentDetails;
import me.kifio.demo.model.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private final static Logger logger = Logger.getLogger(PaymentController.class.getName());

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestHeader String requestId
    ) {

        logger.info(
                String.format("Received request with requestId: %s",
                        requestId
                )
        );

        return ResponseEntity
                    .ok(new PaymentDetails("Успешный платеж"));

    }
}
