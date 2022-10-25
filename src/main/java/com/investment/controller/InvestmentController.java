package com.investment.controller;

import com.investment.entity.Investor;
import com.investment.entity.Product;
import com.investment.service.InvestorDetails;
import com.investment.service.InvestorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class InvestmentController {

    @Autowired
    private InvestorService investorService;

    @PostMapping("/investor/v1")
    public Investor saveInvestor(@RequestBody Investor investor){

        return investorService.saveInvestor(investor);
    }

    @GetMapping("/investors/v1")
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }


    @GetMapping("/investor/v1")
    public List<InvestorDetails> getInvestorDetails(){
        List<InvestorDetails> investorInformation = investorService.getInvestorInformation();
        return investorInformation;
    }

    @PutMapping("/withdrawal/{id}")
    public Product updateDepartmentById(@PathVariable("id") Long productId, @RequestBody Product product) throws Throwable {

        return investorService.updateInvestorById(productId,product);
    }
}
