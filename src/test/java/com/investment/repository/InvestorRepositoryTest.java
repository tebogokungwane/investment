package com.investment.repository;

import com.investment.entity.Investor;
import com.investment.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class InvestorRepositoryTest {

    @Autowired
    private InvestorRepository investorRepository;

    @Test
    public void saveInvestor(){

        Date date = new Date(1991,02,22);

        Product product1 = Product
                .builder()
                .productKey("SAVING")
                .balance(10000)
                .build();
        Product product2 = Product
                .builder()
                .productKey("Retirement")
                .balance(30000)
                .build();

        Investor investor = Investor
                .builder()
                .name("Manqoba")
                .surname("Hlatsuayo")
                .dateOfBirth(date)
                .address("Omonde view")
                .mobileNumber("0711382940")
                .emailAddress("manqoba@gmail.com")
                .products(List.of(product1,product2))
                .build();

        investorRepository.save(investor);
    }

    @Test
    public void findAllInvestors(){
        List<Investor> investorList = investorRepository.findAll();
        System.out.println("Get all investors "+ investorList);
    }



}
