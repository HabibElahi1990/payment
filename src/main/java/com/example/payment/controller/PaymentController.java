package com.example.payment.controller;

import com.example.payment.model.Payment;
import com.example.payment.model.PaymentDto;
import com.example.payment.service.api.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public List<Payment> savePayment(@RequestBody PaymentDto paymentDto){
        return paymentService.paymentDraftList(paymentDto);
    }

}
