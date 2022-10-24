package com.investment.service;

import lombok.Data;

import java.util.Date;

@Data
public class InvestorDetails {

    private String name;
    private String surname;
    private String productKey;
    private double balance;
}
