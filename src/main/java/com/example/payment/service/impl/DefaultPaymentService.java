package com.example.payment.service.impl;

import com.example.payment.model.Draft;
import com.example.payment.model.DraftRequest;
import com.example.payment.model.Payment;
import com.example.payment.model.PaymentDto;
import com.example.payment.repository.PaymentRepository;
import com.example.payment.service.api.GatewayService;
import com.example.payment.service.api.PaymentService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DefaultPaymentService  implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    private final GatewayService gatewayService;

    public DefaultPaymentService(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }


    private Integer getPersonIdByNationalCode(String nationalCode){
        return gatewayService.findByNationalCode(nationalCode).getId();
    }

    private List<Draft> getDraftByPersonId(Integer personId){
       return gatewayService.findDraftListByPersonId(personId);
    }

    private void updateDraftStatus(List<Draft> draftList){
        DraftRequest draftRequest= DraftRequest.builder().draftList(draftList).build();
        gatewayService.updateDraftStatus(draftRequest);
    }
    public List<Payment> paymentDraftList(PaymentDto paymentDto) throws ServiceException {
        //todo add list for payment
        Integer personId=getPersonIdByNationalCode(paymentDto.getNationalCode());
        List<Draft> draftList=getDraftByPersonId(personId);
        List<Payment> payments=new ArrayList<>();
        for (Draft d:draftList){
            Payment payment=new Payment();
            payment.setPayableAmount(d.getPayableAMount());
            payment.setDraftId(d.getId());
            payment.setPersonId(personId);
            payment.setIban(paymentDto.getIban());
            payment=paymentRepository.save(payment);
            payments.add(payment);
        }

        updateDraftStatus(draftList);

        return payments;

    }


}
