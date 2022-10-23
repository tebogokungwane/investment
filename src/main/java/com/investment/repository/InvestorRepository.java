package com.investment.repository;

import com.investment.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InvestorRepository extends JpaRepository<Investor,Long> {

    @Query(
            value = "SELECT * FROM product where investor_id = (SELECT investor_id from investor where name = 'Smith')",
            nativeQuery = true)
    Collection<Investor> listOfProductByInvestor();
}
