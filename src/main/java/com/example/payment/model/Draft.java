package com.example.payment.model;

import lombok.Data;

@Data
public class Draft {
    private Integer id;
    private Long totalAmount;
    private Long franchiseAmount;
    private Long firstInsuredAmount;
    private Long nonInsuredAmount;
    private Long payableAMount;
    private Integer personId;
    private Integer status;

}
