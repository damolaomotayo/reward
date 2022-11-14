package com.retailer.reward.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reward")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(
        name="customer.transaction.reward",
        attributeNodes = {
                @NamedAttributeNode(value = "transaction",subgraph = "transaction.stock"),
                @NamedAttributeNode(value = "customer")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "transaction.stock",
                        attributeNodes = {
                                @NamedAttributeNode(value = "stock")
                        }
                )
        }
)
public class Reward implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Long id;

    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Column(name = "per_1_dollar", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Integer rewardPer1Dollar;

    @Column(name = "per_50_dollar")
    @Basic(fetch = FetchType.EAGER)
    private Integer rewardPer50Dollar;

    @Column(name="total_reward", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Integer totalReward;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "transaction_id")
    @Basic(fetch = FetchType.LAZY)
    private Transaction transaction;

}
