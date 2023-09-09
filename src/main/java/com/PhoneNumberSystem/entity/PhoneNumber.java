package com.PhoneNumberSystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("phoneNumber")
    @Column(unique = true)
    private String phoneNumber;

    @JsonProperty("customerId")
    private Long customerId;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

    @JsonProperty("isActivated")
    private boolean isActivated = false;

}
