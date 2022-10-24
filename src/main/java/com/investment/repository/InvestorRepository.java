package com.investment.repository;

import com.investment.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InvestorRepository extends JpaRepository<Investor,Long> {

}
