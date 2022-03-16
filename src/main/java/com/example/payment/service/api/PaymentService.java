package com.example.payment.service.api;

import com.example.payment.model.Draft;
import com.example.payment.model.Payment;
import com.example.payment.model.PaymentDto;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface PaymentService  {
    List<Payment> paymentDraftList(PaymentDto paymentDto) throws ServiceException;
}
