package com.retailer.reward.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "item", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private String item;

    @Column(name = "unit_price", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Double unitPrice;


    @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactions;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

}