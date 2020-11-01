package com.example.demo.chap04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.constructor.Construct;

@DisplayName("@DisplayName 테스트")
public class LifecycleTest {
    
    public LifecycleTest() {
        System.out.println("new LifecycleTest");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @DisplayName("@BeforeEach, @AfterEach가 작동하는지 테스트1")
    @Test
    void a() {
        System.out.println("A");
    }

    @Disabled
    @DisplayName("@BeforeEach, @AfterEach가 작동하는지 테스트2")
    @Test
    void b() {
        System.out.println("B");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

}
