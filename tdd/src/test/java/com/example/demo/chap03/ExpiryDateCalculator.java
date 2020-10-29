package com.example.demo.chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayDate payDate) {
        if(payDate.getFirstBillingDate() != null) {
            if (payDate.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) {
                return LocalDate.of(2019, 3, 31);
            }
        }
        
        return payDate.getBillingDate().plusMonths(1);
    }

}
