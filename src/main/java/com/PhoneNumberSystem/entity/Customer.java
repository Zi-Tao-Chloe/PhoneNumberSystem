package com.PhoneNumberSystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id; //each customer has a unique and none 0 id

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @OneToMany
   // @JoinColumn(name = "customerId")
    @JsonProperty("phoneNumbers")
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

}
