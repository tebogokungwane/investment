package com.investment.service;

import com.investment.entity.Investor;
import com.investment.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvestorService{

    @Autowired
    private InvestorRepository investorRepository;

    public Investor saveInvestor(Investor investor){
        return investorRepository.save(investor);
    }

    public List<Investor> getAllInvestors(){
        return investorRepository.findAll();
    }

    public List<Investor> getInvestorByName(){
        return (List<Investor>) investorRepository.listOfProductByInvestor();
    }
}
