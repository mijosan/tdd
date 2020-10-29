package com.example.demo.chap03;

import java.time.LocalDate;

public class PayDate {
    
    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;
    
    private PayDate() {}

    public PayDate(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        
        private PayDate date = new PayDate();

        public Builder firstBillingDate(LocalDate firstBillingDate) {
            date.firstBillingDate = firstBillingDate;
            return this;
        }

        public Builder billingDate(LocalDate billingDate) {
            date.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            date.payAmount = payAmount;
            return this;
        }

        public PayDate build() {
            return date;
        }

    }

}
