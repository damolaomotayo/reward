package com.retailer.reward.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Long id;

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "name", nullable = false)
    private String name;

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "The string has to be a well-formed email address. Exact semantics of what makes up a valid email")
    private String email;

    @Basic(fetch = FetchType.EAGER)
    @Column(name = "shipping_address", nullable = false)
    private String shippingAddress;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactions;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Reward> rewards;

}