package com.retailer.reward.repositiry;

import com.retailer.reward.entity.Customer;
import com.retailer.reward.entity.Reward;
import com.retailer.reward.records.reqest.GetCustomerRewardParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RewardRepositoryImpl implements RewardRepositoryI{
    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<Reward> getCustomerReward(GetCustomerRewardParam param) {
        var graph = entityManager.getEntityGraph("customer.transaction.reward");
        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(Reward.class);
        var root = cq.from(Reward.class);
        var transaction = root.join("transaction", JoinType.LEFT);
        var customer = (Join)root.fetch("customer",JoinType.LEFT);
        var emailExpression = customer.<String>get("email");
        var transactionDate = transaction.<LocalDateTime>get("timestamp");
        var threeMonthAgo = LocalDateTime.now().minusMonths(3);

        cq.select(root).where(cb.and(
                cb.equal(emailExpression,param.customerEmail()),
                cb.greaterThanOrEqualTo(transactionDate, threeMonthAgo)
                )).distinct(true);

        var result = entityManager.createQuery(cq).setHint("javax.persistence.fetchgraph",graph).getResultList();
        return result!=null? result:new ArrayList<>();
    }
}
