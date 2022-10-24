package com.investment.service;

import com.investment.entity.Investor;
import com.investment.entity.Product;
import com.investment.repository.InvestorRepository;
import com.investment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestorService{


    private final InvestorRepository investorRepository;
    private final ProductRepository productRepository;

    @Autowired
    public InvestorService(InvestorRepository investorRepository, ProductRepository productRepository) {
        this.investorRepository = investorRepository;
        this.productRepository = productRepository;
    }


    public Investor saveInvestor(Investor investor){
        return investorRepository.save(investor);
    }

    public List<Investor> getAllInvestors(){
        return investorRepository.findAll();
    }


    public List<InvestorDetails> getInvestorInformation(){

        List<InvestorDetails> investorDetailsList = new ArrayList<>();

        List<Product> productList = productRepository.findAll();
        for(Product products : productList ){
            InvestorDetails investorDetails = new InvestorDetails();
            investorDetails.setName(products.getInvestor().getName());
            investorDetails.setBalance(products.getBalance());

            investorDetailsList.add(investorDetails);

        }
        return investorDetailsList;
    }
    public Product updateInvestorById(Long productId, Product product){
        Product byIdAndProductKey = productRepository.findByInvestor_InvestorIdAndProductKey(productId, product.getProductKey());

        double balance = byIdAndProductKey.getBalance() - product.getBalance();

        double amountToWithdraw = byIdAndProductKey.getBalance() * 90 /100;


        LocalDate dateOfBirthFromDB = byIdAndProductKey.getInvestor().getDateOfBirth();
        int dayOfYear = dateOfBirthFromDB.getYear();
        LocalDate currentYear = LocalDate.now();

        int year = currentYear.getYear() - dayOfYear;

        if((year < 65) && (byIdAndProductKey.getProductKey().equals("RETIREMENT"))){
             throw  new RuntimeException("You too young to with draw from retirement");
        }
        if(product.getBalance() > byIdAndProductKey.getBalance()){
            throw new RuntimeException("Balance is less than withdrawal");
        }
        if(product.getBalance() > amountToWithdraw){
            throw new RuntimeException("Cannot withdraw an amount more than 90% of the current balance");
        }
        else {
            byIdAndProductKey.setBalance(balance);
            return productRepository.save(byIdAndProductKey);
        }
    }
}
