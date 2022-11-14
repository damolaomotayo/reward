package com.retailer.reward.repositiry;

import com.retailer.reward.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionJpaRepositoryI extends JpaRepository<Transaction,Long> {
}
