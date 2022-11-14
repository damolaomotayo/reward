package com.retailer.reward.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "stock_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Stock stock;

    @Column(name = "quantity",nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Integer quantity;

    @JoinColumn(name = "customer_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;

    @Column(name = "total_price")
    @Basic(fetch = FetchType.EAGER)
    private Double totalPrice;

    @OneToOne(mappedBy = "transaction", fetch = FetchType.LAZY)
    @JsonIgnore
    private Reward reward;

    @Column(name = "timestamp", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private LocalDateTime timestamp;

}