package com.retailer.reward.repositiry;

import com.retailer.reward.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockJpaRepositoryI extends JpaRepository<Stock,Long> {
}
