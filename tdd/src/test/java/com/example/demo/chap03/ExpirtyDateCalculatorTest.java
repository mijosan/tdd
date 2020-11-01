package com.example.demo.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ExpirtyDateCalculatorTest {
    
    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(PayDate.builder()
                                .billingDate(LocalDate.of(2019, 3, 1))
                                .payAmount(10_000)
                                .build()
                                , LocalDate.of(2019, 4, 1));

        assertExpiryDate(PayDate.builder()
                                .billingDate(LocalDate.of(2019, 5, 5))
                                .payAmount(10_000)
                                .build()
                                , LocalDate.of(2019, 6, 5));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(PayDate.builder()
                                .billingDate(LocalDate.of(2019, 1, 31))
                                .payAmount(10_000)
                                .build()
                                , LocalDate.of(2019, 2, 28));

        assertExpiryDate(PayDate.builder()
                                .billingDate(LocalDate.of(2019, 5, 31))
                                .payAmount(10_000)
                                .build()
                                , LocalDate.of(2019, 6, 30));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        PayDate payDate = PayDate.builder()
                                .firstBillingDate(LocalDate.of(2019, 1, 31))
                                .billingDate(LocalDate.of(2019, 2, 28))
                                .payAmount(10_000)
                                .build();
        
        assertExpiryDate(payDate, LocalDate.of(2019, 3, 31));

        PayDate payDate2 = PayDate.builder()
                                .firstBillingDate(LocalDate.of(2019, 1, 30))
                                .billingDate(LocalDate.of(2019, 2, 28))
                                .payAmount(10_000)
                                .build();
        
        assertExpiryDate(payDate2, LocalDate.of(2019, 3, 30));
    }

    private void assertExpiryDate(PayDate payDate, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payDate);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }

}
