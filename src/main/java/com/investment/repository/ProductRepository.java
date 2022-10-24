package com.investment.repository;

import com.investment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    Product findByInvestor_InvestorIdAndProductKey(Long product_id , String productKey);
}
