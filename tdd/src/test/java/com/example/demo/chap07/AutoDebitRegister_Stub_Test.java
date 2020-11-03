package com.example.demo.chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoDebitRegister_Stub_Test {
    
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private StubAutoDebitInfoRepository stubRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        stubRepository = new StubAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, stubRepository);
    }

    @Test
    void invalidCard() {
        stubValidator.setInvalidNo("111122223333");

        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);

        assertEquals(CardValidity.INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        stubValidator.setTheftNo("123412341234");

        AutoDebitReq req = new AutoDebitReq("user2", "123412341234");
        RegisterResult result = register.regiser(req);

        assertEquals(CardValidity.THEFT, result.getValidity());
    }

}
