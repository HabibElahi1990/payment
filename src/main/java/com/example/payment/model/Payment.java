package com.example.payment.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
@Data
public class Payment  {
    @Id
    @GeneratedValue
    private Long id;
    private Integer personId;
    private Integer draftId;
    private Long payableAmount;
    private String iban;

}
