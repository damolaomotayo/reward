package com.retailer.reward.repositiry;

import com.retailer.reward.entity.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardJpaRepositoryI extends JpaRepository<Reward,Long> {
}
