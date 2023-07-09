package com.PhoneNumberSystem.Entity;

import com.PhoneNumberSystem.controller.CustomerController;
import jakarta.persistence.Id;

public class PhoneNumber {
    @Id
    private Long id;

    private String number;

    private Long customerId;

    private boolean isActivated;

    public PhoneNumber(Long id, Long customerId, String number, boolean isActivated) {
        this.id = id;
        this.customerId = customerId;
        this.number = number;
        this.isActivated = isActivated;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPhoneNumber() {
        return number;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

}
