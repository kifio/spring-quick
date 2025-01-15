package me.kifio.demo.model.service;

import me.kifio.demo.model.NotEnoughMoneyException;
import me.kifio.demo.model.dto.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
