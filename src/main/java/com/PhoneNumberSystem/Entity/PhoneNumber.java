package com.PhoneNumberSystem.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("customerId")
    private Long customerId;

    @JsonProperty("isActivated")
    private boolean isActivated;

}
