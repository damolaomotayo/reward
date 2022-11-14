package com.retailer.reward.repositiry;

import com.retailer.reward.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepositoryI extends JpaRepository<Customer,Long> {
}
