package com.investment.controller;

import com.investment.entity.Investor;
import com.investment.entity.Product;
import com.investment.service.InvestorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class InvestmentController {

    @Autowired
    private InvestorService investorService;

    @PostMapping("/investor/v1")
    public Investor saveInvestor(@RequestBody Investor investor){

        System.out.println("Investor values --------"+ investor);
        return investorService.saveInvestor(investor);
    }

    @GetMapping("/investors/v1")
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @GetMapping("/investmentByName/v1")
    public List<Investor> getInvestorByName(){
        return investorService.getInvestorByName();
    }
}
